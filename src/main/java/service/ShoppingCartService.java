package service;

import model.*;
import repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ShoppingCartService {

    @Autowired private ShoppingCartRepository cartRepo;
    @Autowired private ProductRepository productRepo;

    public ShoppingCart getOrCreateCart(String id) {
        return cartRepo.findById(id).orElseGet(() -> {
            ShoppingCart cart = new ShoppingCart(id);
            return cartRepo.save(cart);
        });
    }

    public void addProduct(String cartId, Long productId, int quantity) {
        Product product = productRepo.findById(productId).orElseThrow();
        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock");
        }

        ShoppingCart cart = getOrCreateCart(cartId);
        cart.getItems().add(new ShoppingCartItem(product, quantity));
        product.setQuantity(product.getQuantity() - quantity);

        productRepo.save(product);
        cartRepo.save(cart);
    }

    public void emptyCart(String cartId) {
        ShoppingCart cart = cartRepo.findById(cartId).orElseThrow();
        cart.getItems().clear();
        cartRepo.save(cart);
    }

    public double calculateTotal(String cartId) {
        ShoppingCart cart = cartRepo.findById(cartId).orElseThrow();
        return cart.getItems().stream()
            .mapToDouble(item -> (item.getProduct().getPrice() + item.getProduct().getTax()) * item.getQuantity())
            .sum();
    }
}


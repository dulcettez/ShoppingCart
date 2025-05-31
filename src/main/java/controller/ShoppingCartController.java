package controller;

import model.ShoppingCart;
import service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService cartService;

    @PostMapping("/{cartId}/add")
    public String addToCart(@PathVariable String cartId, @RequestParam Long productId, @RequestParam int quantity) {
        cartService.addProduct(cartId, productId, quantity);
        return "Product added to cart.";
    }

    @GetMapping("/{cartId}")
    public ShoppingCart getCart(@PathVariable String cartId) {
        return cartService.getOrCreateCart(cartId);
    }

    @DeleteMapping("/{cartId}/empty")
    public String emptyCart(@PathVariable String cartId) {
        cartService.emptyCart(cartId);
        return "Cart emptied.";
    }

    @GetMapping("/{cartId}/total")
    public double getTotal(@PathVariable String cartId) {
        return cartService.calculateTotal(cartId);
    }

    @GetMapping("/new")
    public String createNewCart() {
        return UUID.randomUUID().toString();
    }
}



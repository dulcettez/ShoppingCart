package model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "haton_alkhaldi_cart")
public class ShoppingCart {
    @Id
    private String id; // use UUID

    @OneToMany(cascade = CascadeType.ALL)
    private List<ShoppingCartItem> items = new ArrayList<>();

    public ShoppingCart() {}

    public ShoppingCart(String id) {
        this.id = id;
    }

    // Getters and setters
}


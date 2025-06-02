package model;

import jakarta.persistence.*;

@Entity
@Table(name = "haton_alkhaldi_cart_item")

public class ShoppingCartItem {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    private Product product;

	    private int quantity;

	    public ShoppingCartItem() {}

	    public ShoppingCartItem(Product product, int quantity) {
	        this.product = product;
	        this.quantity = quantity;
	    }

	    // Getters and setters
	}



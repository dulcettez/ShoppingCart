package model;
import jakarta.persistence.*;

@Entity
@Table(name = "haton_alkhaldi_product")


public class Product {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String description;
	    private double price;
	    private double tax;
	    private int quantity;

	    public Product() {}

	    public Product(String name, String description, double price, double tax, int quantity) {
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.tax = tax;
	        this.quantity = quantity;
	    }

	    // Getters and Setters
	}



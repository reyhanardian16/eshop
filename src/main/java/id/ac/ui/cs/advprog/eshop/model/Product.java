package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Product {
    private String productName;
    private String productId;
    private int productQuantity;

    public Product () {
        productId = UUID.randomUUID().toString();
    }
}

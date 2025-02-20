package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

@Getter @Setter
public class Product {

    @NotBlank(message = "Product name must not be empty")
    private String productName;

    private String productId;

    @Min(value = 0, message = "Product quantity must not be negative")
    private Integer productQuantity;

    public Product () {
        productId = UUID.randomUUID().toString();
    }

    public void setProductQuantity(int productQuantity) {
        if (productQuantity < 0) {
            throw new IllegalArgumentException("Product quantity must not be negative");
        }
        this.productQuantity = productQuantity;
    }
}

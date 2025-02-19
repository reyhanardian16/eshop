package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Repository
public class ProductRepository {
    private final List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public void edit(Product product) {
        for (Product existingProduct : productData) {
            if (existingProduct.getProductId().equals(product.getProductId())) {
                existingProduct.setProductName(product.getProductName());
                existingProduct.setProductQuantity(product.getProductQuantity());
            }
        }
    }

    public void delete(Product product) {
        productData.remove(product);
    }
}

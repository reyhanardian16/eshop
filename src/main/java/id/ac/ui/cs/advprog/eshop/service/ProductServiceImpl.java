package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    protected ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public Product findById(String id) {
        List<Product> allProduct = findAll();
        for (Product product : allProduct) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }
}

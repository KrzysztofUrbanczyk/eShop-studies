package pl.ecommerce.sales.product;

import pl.ecommerce.sales.basket.Product;

import java.util.List;

public interface ProductStore {
    void addProduct(Product product);
    Product get(String productId);

    public List<Product> findAll();
}

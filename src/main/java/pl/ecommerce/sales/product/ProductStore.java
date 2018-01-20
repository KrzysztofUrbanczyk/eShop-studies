package pl.ecommerce.sales.product;

import pl.ecommerce.sales.basket.Product;

public interface ProductStore {
    void addProduct(Product product);

    Product get(String productId);
}

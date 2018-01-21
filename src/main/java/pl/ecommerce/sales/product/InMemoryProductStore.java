package pl.ecommerce.sales.product;

import pl.ecommerce.sales.basket.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryProductStore implements ProductStore {

    private Map<String, Product> products;

    public InMemoryProductStore() {
        this.products = new HashMap<String, Product>();
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Product get(String productId) {
        return products.get(productId);
    }

    @Override
    public List<Product> findAll() {
            return new ArrayList<Product>(products.values());
    }
}

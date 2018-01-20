package pl.ecommerce.sales.basket;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<String, Integer> products;

    public Basket() {
        this.products = new HashMap<String, Integer>();
    }

    public void add(Product product) {
        if(!product.isInStock()) {
            throw new NotEnoughQuantityOnStock();
        }

        if (isInBasket(product)) {
            IncrementQty(product);
        }
        else {
            createBasketRow(product);
        }
    }

    private void createBasketRow(Product product) {
        products.put(product.getId(), 1);
    }

    private void IncrementQty(Product product) {
        products.put(product.getId(), products.get(product.getId()) + 1);
    }

    private boolean isInBasket(Product product) {
        return products.containsKey(product.getId());
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public Integer productsCount() {
        return products.size();
    }

    public Integer countOfProduct(String symbol) {
        return products.get(symbol);
    }
}

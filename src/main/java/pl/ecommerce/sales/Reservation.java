package pl.ecommerce.sales;


import java.util.HashMap;
import java.util.Map;

class Reservation {
    private Map<String, Integer> products;

    Reservation() {
        this.products = new HashMap<String, Integer>();
    }

    void add(Product product) {
        if(!product.isInStock())
            throw new NotEnoughQuantityOnStock();

        if (isInBasket(product))
        {
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

    boolean isEmpty() {
        return products.isEmpty();
    }

    Integer productsCount() {
        return products.size();
    }

    Integer countOfProduct(String symbol) {
        return products.get(symbol);
    }
}

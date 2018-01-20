package pl.ecommerce.sales.basket;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class InMemoryBasketRepository implements BasketRepository{
    private Map<String, Basket> baskets;

    public InMemoryBasketRepository() {
        this.baskets = new ConcurrentHashMap<String, Basket>();
    }

    public Basket getCustomerBasket(String userId) {
        if(!baskets.containsKey(userId)) {
            Basket basket = new Basket();
            baskets.put(userId, basket);

            return basket;
        }
        return baskets.get(userId);
    }
}

package pl.ecommerce.sales.basket;

public interface BasketRepository {

    Basket getCustomerBasket(String userId);
}

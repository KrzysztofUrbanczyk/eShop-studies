package pl.ecommerce.sales;

import org.junit.Assert;
import org.junit.Test;
import pl.ecommerce.sales.basket.Basket;
import pl.ecommerce.sales.basket.BasketRepository;
import pl.ecommerce.sales.basket.InMemoryBasketRepository;

public class InMemoryBasketRepositoryTest {

    @Test
    public void itCreateNewBasketForCustomerWhereNotExists() {
        BasketRepository basketRepository = new InMemoryBasketRepository();

        Basket basket = basketRepository.getCustomerBasket("new_customer");

        Assert.assertNotNull(basket);
    }

    @Test
    public void itCreateUniqueBasketsForCustomers() {
        BasketRepository basketRepository = new InMemoryBasketRepository();

        Basket basket1 = basketRepository.getCustomerBasket("new_customer");
        Basket basket2 = basketRepository.getCustomerBasket("next_customer");

        Assert.assertNotEquals(basket1, basket2);
    }

    @Test
    public void itGivesSameBasketForSameCustomer() {
        BasketRepository basketRepository = new InMemoryBasketRepository();

        Basket basker1 = basketRepository.getCustomerBasket("same_customer");
        Basket basker2 = basketRepository.getCustomerBasket("same_customer");

        Assert.assertEquals(basker1, basker2);

    }
}

package pl.ecommerce.sales;

import org.junit.Assert;
import org.junit.Test;
import pl.ecommerce.sales.basket.Basket;
import pl.ecommerce.sales.basket.BasketRepository;
import pl.ecommerce.sales.basket.InMemoryBasketRepository;
import pl.ecommerce.system.CurrentUser;
import pl.ecommerce.system.InMemoryUserContext;
import pl.ecommerce.system.UserContext;

public class InMemorySystemUserContextTest {
    @Test
    public void itAllowObtainCurrentUserWhenAuthenticated() {
        UserContext userContext = new InMemoryUserContext();

        userContext.authorize("user_1");
        CurrentUser currentUser = userContext.getCurrentUser();

        Assert.assertNotNull(currentUser);
        Assert.assertTrue(currentUser.getId().equals("user_1"));

    }

    @Test
    public void itGivesSameBasketForSameCustomer() {
        BasketRepository basketRepository = new InMemoryBasketRepository();

        Basket basker1 = basketRepository.getCustomerBasket("same_customer");
        Basket basker2 = basketRepository.getCustomerBasket("same_customer");

        Assert.assertEquals(basker1, basker2);

    }

}

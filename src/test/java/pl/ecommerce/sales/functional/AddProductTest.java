package pl.ecommerce.sales.functional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.ecommerce.sales.application.AddProductHandler;
import pl.ecommerce.sales.basket.*;
import pl.ecommerce.sales.product.InMemoryProductStore;
import pl.ecommerce.sales.product.ProductStore;
import pl.ecommerce.system.InMemoryUserContext;
import pl.ecommerce.system.UserContext;

public class AddProductTest {

    BasketRepository basketRepository;
    ProductStore productStore;
    UserContext userContext;

    @Before
    public void setUp(){
        this.userContext = new InMemoryUserContext();
        this.productStore = new InMemoryProductStore();
        this.basketRepository = new InMemoryBasketRepository();
    }

    @Test
    public void addingProductByCurrentCustomer() {
        //arrange // given
        thereIsProduct("lego-1234",10.00,  7 );
        thereIsCustomerIdentifiedWith("urbanczykkr");

        //act // when
        (new AddProductHandler(basketRepository, productStore, userContext)).handle("lego-1234");

        //assert // then
        customersBasketContainsProducts("urbanczykkr", 1);
    }


    private void customersBasketContainsProducts(String userId, Integer productCount) {
        Basket basket = basketRepository.getCustomerBasket(userId);

        Assert.assertTrue(basket.productsCount() == productCount);
    }

    private void thereIsCustomerIdentifiedWith(String userId) {
        userContext.authorize(userId);
    }

    private void thereIsProduct(String productId, double price, int stockQty) {
        productStore.addProduct(new Product(productId, stockQty, price));
    }
}

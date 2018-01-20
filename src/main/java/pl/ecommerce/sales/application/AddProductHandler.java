package pl.ecommerce.sales.application;

import pl.ecommerce.sales.basket.Basket;
import pl.ecommerce.sales.basket.BasketRepository;
import pl.ecommerce.sales.basket.Product;
import pl.ecommerce.sales.product.ProductStore;
import pl.ecommerce.system.CurrentUser;
import pl.ecommerce.system.UserContext;

public class AddProductHandler {
    private BasketRepository basketRepository;
    private ProductStore productStore;
    private UserContext userContext;

    public AddProductHandler(BasketRepository basketRepository, ProductStore productStore, UserContext userContext) {
        this.basketRepository = basketRepository;
        this.productStore = productStore;
        this.userContext = userContext;
    }

    public void handle(String productId) {
        CurrentUser user = userContext.getCurrentUser();
        Basket basket = basketRepository.getCustomerBasket(user.getId());

        Product product = productStore.get(productId);

        basket.add(product);


    }
}

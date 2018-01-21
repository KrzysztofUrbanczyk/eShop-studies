package pl.webcommerce.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.ecommerce.sales.application.AddProductHandler;
import pl.ecommerce.sales.basket.BasketRepository;
import pl.ecommerce.sales.basket.InMemoryBasketRepository;
import pl.ecommerce.sales.basket.Product;
import pl.ecommerce.sales.product.InMemoryProductStore;
import pl.ecommerce.sales.product.ProductStore;
import pl.ecommerce.system.UserContext;

@Component
public class SalesComponents {

    @Autowired
    UserContext userContext;

    @Bean
    public ProductStore inMemoryProductStore() {
        ProductStore productStore = new InMemoryProductStore();

        productStore.addProduct(new Product("lego-1", 10, 10.00));
        productStore.addProduct(new Product("lego-2", 11, 11.00));

        return productStore;
    }

    @Bean
    public AddProductHandler addProductHandler() {
        return new AddProductHandler(basketRepository(), inMemoryProductStore(), userContext);
    }

    @Bean
    public BasketRepository basketRepository() {
        return new InMemoryBasketRepository();
    }

}

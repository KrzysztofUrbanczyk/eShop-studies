package pl.ecommerce.sales;

import org.junit.Test;
import pl.ecommerce.sales.basket.Product;
import pl.ecommerce.sales.product.InMemoryProductStore;
import pl.ecommerce.sales.product.ProductStore;

public class InMemoryProductStoreTest {
    @Test
    public void itAllowStoreProduct() {
        ProductStore productStore = new InMemoryProductStore();

        productStore.addProduct(new Product("lego-1", 1, 10.00));
        productStore.addProduct(new Product("lego-2", 1, 10.00));
    }
}

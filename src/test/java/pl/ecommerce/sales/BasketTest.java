package pl.ecommerce.sales;

import org.junit.Assert;
import org.junit.Test;
import pl.ecommerce.sales.basket.Basket;
import pl.ecommerce.sales.basket.NotEnoughQuantityOnStock;
import pl.ecommerce.sales.basket.Product;

public class BasketTest {

    @Test
    public void itIsEmptyWhenNew() {
        Basket basket = new Basket();

        Assert.assertTrue(basket.isEmpty());
    }
    @Test
    public void itAllowAddProductToBasket() {
        // arrange
        Product product = new Product("lego-1234", 10);
        Basket basket = new Basket();
        // act
        basket.add(product);
        //assert
        Assert.assertFalse(basket.isEmpty());
    }

    @Test
    public void itIncreaseQuantityWhenSameProduct() {
        Basket basket = new Basket();
        Product p1 = new Product("lego-1234", 10);
        Product p2 = new Product("lego-9876", 10);

        basket.add(p1);
        basket.add(p2);
        basket.add(p2);

        Assert.assertTrue(
                "Should consider product qty-ies",
                2 == basket.productsCount()
        );

        Assert.assertTrue(basket.countOfProduct("lego-9876") == 2);

        Assert.assertTrue(basket.countOfProduct("lego-1234") == 1);
    }

    @Test
    public void cantAddProductWithStockEquals0(){
        Basket basket = new Basket();
        Product p1 = new Product("lego-1234", 0);

        try {
            basket.add(p1);
            Assert.fail("Should throw exception: NotEnoughQuantityOnStock");
        }
        catch (NotEnoughQuantityOnStock ex) {
            Assert.assertTrue(true);
        }

    }
}

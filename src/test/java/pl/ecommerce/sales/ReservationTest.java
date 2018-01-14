package pl.ecommerce.sales;

import org.junit.Assert;
import org.junit.Test;

public class ReservationTest {

    @Test
    public void itIsEmptyWhenNew() {
        Reservation reservation = new Reservation();

        Assert.assertTrue(reservation.isEmpty());
    }
    @Test
    public void itAllowAddProductToBasket() {
        // arrange
        Product product = new Product("lego-1234", 10);
        Reservation reservation = new Reservation();
        // act
        reservation.add(product);
        //assert
        Assert.assertFalse(reservation.isEmpty());
    }

    @Test
    public void itIncreaseQuantityWhenSameProduct() {
        Reservation reservation = new Reservation();
        Product p1 = new Product("lego-1234", 10);
        Product p2 = new Product("lego-9876", 10);

        reservation.add(p1);
        reservation.add(p2);
        reservation.add(p2);

        Assert.assertTrue(
                "Should consider product qty-ies",
                2 == reservation.productsCount()
        );

        Assert.assertTrue(reservation.countOfProduct("lego-9876") == 2);

        Assert.assertTrue(reservation.countOfProduct("lego-1234") == 1);
    }

    @Test
    public void cantAddProductWithStockEquals0(){
        Reservation reservation = new Reservation();
        Product p1 = new Product("lego-1234", 0);

        try {
            reservation.add(p1);
            Assert.fail("Should throw exception: NotEnoughQuantityOnStock");
        }
        catch (NotEnoughQuantityOnStock ex) {
            Assert.assertTrue(true);
        }

    }
}

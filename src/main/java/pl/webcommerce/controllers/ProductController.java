package pl.webcommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ecommerce.sales.application.AddProductHandler;
import pl.ecommerce.sales.basket.NotEnoughQuantityOnStock;
import pl.ecommerce.sales.basket.Product;
import pl.ecommerce.sales.product.ProductStore;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductStore productStore;

    @Autowired
    AddProductHandler addProductHandler;

    @RequestMapping("/products")
    @ResponseBody
    public List<Product> productList() {
        return productStore.findAll();
    }

    @RequestMapping("/add-to-basket/{id}")
    public String addToBasket(@PathVariable(value="id") String productId) {
        try {
            addProductHandler.handle(productId);
            return "Yes";
        } catch (NotEnoughQuantityOnStock ex) {
            return "Something is not Yes!";
        }
    }
}

package pl.ecommerce.sales.basket;

public class Product {
    private String symbol;
    private Integer stockQuantity;
    private Double price;

    public Product(String symbol, Integer stockQuantity) {
        this.symbol = symbol;
        this.stockQuantity = stockQuantity;
        this.price = 0.0;
    }


    public Product(String symbol, Integer stockQuantity, Double price) {
        this.symbol = symbol;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    String getId() {
        return symbol;
    }

    Boolean isInStock() {
        return stockQuantity > 0;
    }
}
package pl.ecommerce.sales;

public class Product {
    private String symbol;
    private Integer stockQuantity;
    public Product(String symbol, Integer stockQuantity) {
        this.symbol = symbol;
        this.stockQuantity = stockQuantity;
    }

    public String getId() {
        return symbol;
    }

    public Boolean isInStock() {
        return stockQuantity > 0;
    }
}

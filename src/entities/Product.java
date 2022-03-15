package entities;

public class Product {
    private String name;
    private Integer quantity;
    private Double price;

    public Product(String name,Double price,Integer quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return name + ","+String.format("%.2f",price) + "," + quantity;
    }

    public Double getTotal(){
        return this.price * this.quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}

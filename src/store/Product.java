package store;

public class Product{
    private String name;
    private float price;
    private float quantity;

    public Product(String name, float price, float quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=" + name +
                ", price=" + price +
                ", quantity=" + quantity ;
    }
}

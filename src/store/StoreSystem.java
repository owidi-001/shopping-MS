package store;

import users.Client;

import java.util.ArrayList;

public class StoreSystem {
    private String name;

    public ArrayList<Product> products=new ArrayList<Product>();

    public StoreSystem(String name) {
        this.name = name;
    }


    // New product
    public void new_product(Product product){
        products.add(product);
    }

    // Delete products
    public void delete_product(int id){
        products.remove(id);
    }

    //    Modify product profile
    public void update_product(Product product,int index){
        products.set(index, product);
    }


    // accessors
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name=" + name;
    }
}

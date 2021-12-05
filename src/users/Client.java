package users;

import store.Product;
import store.StoreSystem;

import java.util.Scanner;

public class Client extends User{
    private float credit=1000;

    Scanner scanner=new Scanner(System.in);
    private boolean logged=false;

//    StoreSystem store=new StoreSystem("Store");

    public Client(String f_name, String l_name, String email) {
        super(f_name, l_name, email);
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    //  Can view products
    public void view_products(){
        for (Product product :
           Admin.store.products) {
        System.out.println(product);
    }
}
    //    Can buy & pay
    public void buy_product(int index){
        System.out.println("Enter quantity to buy");
        float quantity=scanner.nextFloat();
        if(Admin.store.products.size()>index){
            Product product=Admin.store.products.get(index);
            if(product.getQuantity()> quantity){
                if (getCredit()> product.getPrice()) {

                    // Confirm purchase
                    if (confirm_purchase(product,quantity)){
                        product.setQuantity(product.getQuantity() - quantity);
                        Admin.store.products.set(index,product);
                        setCredit(getCredit()-product.getPrice());
                        System.out.println("You have bought "+product.getName());
                    }
                    else {
                        System.out.println("You have cancelled the purchase.");
                    }

                }
                else System.out.printf("You don't have enough cash to buy this product.");
            }
            else System.out.println("Your quantity request exceeds availability");

        }
    }

    //    Confirm purchasing
    public boolean confirm_purchase(Product product,float quantity){
        System.out.println("Are you sure you want to buy " + quantity + " of" + product.getName() + " at " + product.getPrice() + " ?\n 1:Yes\n 2:No\n >> ");
        int confirm=scanner.nextInt();
        if (confirm==1){
            return true;
        }
        return false;
    }

    //    Can view its profile
    public void view_product(int index){
        System.out.println(Admin.store.products.get(index));
    }


    //    Manage the system
    public void manage_system(){
            int choice=menu();
            while (! isLogged()){
                System.out.println("Have an account?\n 1:Yes\n 2:No \n");
                int log=scanner.nextInt();
                if (log==1){
                    login();
                }
                else if(log==2){
                    signup();
                }
            }
            switch (choice){
                case 1:
                    view_products();
                    break;
                case 2:
                    System.out.println("Enter index");
                    int index=scanner.nextInt();
                    if (Admin.store.products.size() > index){
                        view_product(index);
                    }
                    else {
                        System.out.println("Product not in products");
                    }
                    break;
                case 3:
                    System.out.println("Enter Product to Buy");
                    int id=scanner.nextInt();
                    if (Admin.store.products.size() > id){
                        buy_product(id);
                    }
                    else {
                        System.out.println("Product not in products");
                    }
                    break;
                case 4:
                    logout();
                    break;
            }

    }

    public int menu(){
        int choice;

        String MENU="" +
                "ADMIN MENU \n" +
                "------------------ \n" +
                "1: view all products \n" +
                "2: view product \n" +
                "3: Buy Product \n" +
                "4: Log out \n" +
                ">>> ";
        System.out.println(MENU);
        choice=scanner.nextInt();
        return choice;
    }
}

package users;

import store.Product;
import store.StoreSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User{
    ArrayList<Client> clients=new ArrayList<Client>(); //    Can add clients à Hashmap or ArrayList
    private boolean logged=false;
    Scanner scanner=new Scanner(System.in);

    public static StoreSystem store=new StoreSystem("Store");

    public Admin(String f_name, String l_name, String email) {
        super(f_name, l_name, email);
    }

    //    Can add clients
    public void add_clients(Client client){
        clients.add(client);
    }

    //    Can add product
    public void add_products(Product product){
        store.new_product(product);
        System.out.println("Product added");
    }

    //  Can view products
    public void view_products(){
        for (Product product :
                store.products) {
            System.out.println(product);
        }
    }

    //    Can delete products
    public void delete_product(int id){
        store.delete_product(id);
        System.out.println("Product deleted");
    }

    //    Modify product profile
    public void modify_product(int index){
        String name;
        float price,quantity;
        System.out.println("Product name");
        name=scanner.next();
        System.out.println("Price");
        price=scanner.nextFloat();
        System.out.println("Quantity");
        quantity=scanner.nextFloat();

        Product product=new Product(name,price,quantity);
        store.update_product(product,index);
        System.out.println("Product updated");
    }

    //    Manage the system
    public void manage_system(){
            int choice=menu();
            while (! isLogged()){
                System.out.println("User not logged in");
                System.out.println("Have an account?\n 1:Yes\n 2:No \n >>>");
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
                    System.out.println("Client details");
                    System.out.println("---------------------");
                    System.out.println("First Name");
                    String first_name=scanner.next();

                    System.out.println("Last Name");
                    String last_name=scanner.next();
                    System.out.println("Email");
                    String client_email=scanner.next();

                    Client client=new Client(first_name,last_name,client_email);
                    add_clients(client);
                    System.out.println("Client added");
                    break;
                case 2:
                    String product_name;
                    float product_price,product_quantity;
                    System.out.println("Product name");

                    product_name=scanner.next();
                    System.out.println("Price");
                    product_price=scanner.nextFloat();
                    System.out.println("Quantity");
                    product_quantity=scanner.nextFloat();

                    Product product=new Product(product_name,product_price,product_quantity);
                    add_products(product);
                    break;
                case 3:
                    System.out.println("Enter index");
                    int index=scanner.nextInt();
                    if (store.products.size() > index){
                        modify_product(index);
                    }
                    else {
                        System.out.println("Product not in products");
                    }
                    break;
                case 4:
                    System.out.println("Enter Product to index");
                    int id=scanner.nextInt();
                    if (store.products.size() > id){
                        delete_product(id);
                    }
                    else {
                        System.out.println("Product not in products");
                    }
                    break;
                case 5:
                    view_products();
                    break;
                case 6:
                    logout();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
    }

    public int menu(){
        int choice;
        String MENU="" +
                "ADMIN MENU \n" +
                "------------------ \n" +
                "1: Add Client \n" +
                "2: Add Product \n" +
                "3: Modify Product \n" +
                "4: Delete product \n" +
                "5: View Products \n" +
                "6: Log out \n" +
                "7: Exit \n" +
                ">>> ";
        System.out.println(MENU);
        choice=scanner.nextInt();
        return choice;
    }


}

package com.company;

import store.Product;
import users.Admin;
import users.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

    //	Create admin
        Admin admin=new Admin("admin","user","admin@mails.com");

    //	Create client
        Client client=new Client("client","user","client@mails.com");

    // Create dummy products
        Product product1=new Product("flour",10,535);
        Product product2=new Product("soap",20,243);
        Product product3=new Product("sugar",100,535);
        Product product4=new Product("salt",40,42);
        Product product5=new Product("ginger",340,100);

    // Log admin
        System.out.println(" Login dummy admin: (email: admin@mails.com,password:Pass)");
        admin.login();

    // Add Products to store
        admin.add_products(product1);
        admin.add_products(product2);
        admin.add_products(product3);
        admin.add_products(product4);
        admin.add_products(product5);

    // Logout dummy admin
        admin.logout();


        int choice;
        String MENU="" +
                "USER MENU \n" +
                "------------------ \n" +
                "1: Admin Portal\n" +
                "2: Client Portal \n" +
                "3: Exit \n" +

                ">>> ";

        System.out.println(MENU);
        choice=scanner.nextInt();

        switch (choice){
            case 1:
                while (true){
                    admin.manage_system();
                }
            case 2:
                while (true){
                    client.manage_system();
                }
            case 3:
                System.exit(0);

        }


    }
}

package users;

import java.util.Scanner;

public class User {
    private String f_name,l_name,email,password;
    private boolean logged=false;

    Scanner scanner=new Scanner(System.in);


//    Constructor
    public User(String f_name, String l_name, String email) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.password = "";
    }

//    Accessors
    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

//    class methods
//    Can signup
public void signup(){
    System.out.println("First name: ");
    String f_name=scanner.nextLine();
    System.out.println("Last name: ");
    String l_name=scanner.nextLine();
    System.out.println("email: ");
    String username=scanner.nextLine();
    System.out.println("Password: ");
    String password=scanner.nextLine();
}
    //    Can log in
    public void login(){
        System.out.println("Email: ");
        String username=scanner.nextLine();
        System.out.println("Password: ");
        String password=scanner.nextLine();
        setLogged(true);
    }
    //    Can log out
    public void logout(){
        setLogged(false);
        System.out.println("User logged out.");
    }


}

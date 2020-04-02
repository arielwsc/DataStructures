package arielcarvalhoassignment2;

import java.util.Scanner;
/**
 *
 * @author ariel
 */
public class Contact {
    private String name;
    private String address;
    private int phone;
    private String email;
    
    public Contact(String userName, String userAddress, int userPhone,
    String userEmail){
    name = userName;
    address = userAddress;
    phone = userPhone;
    email = userEmail;
    }
    
    public void input(){
        Scanner keyboard = new Scanner(System.in);
        
        name = keyboard.nextLine();
        keyboard.nextLine();
        address = keyboard.nextLine();
        keyboard.nextLine();
        phone = keyboard.nextInt();
        keyboard.nextLine();
        email = keyboard.nextLine();
    }   
    
    public void output(){
        System.out.println(name + " " + " " + address + " " + phone + " " + email);
    }
    
    public String toString(){
        return "NAME=" + name + ", ADDRESS=" + address + ", PHONE="
                + phone + ", EMAIL=" + email;
    }
    
    public Contact deepCopy(){
        Contact obj2 = new Contact(name, address, phone, email);
        return obj2;
    }
    
    public boolean compare(String obj2){
        if (name == obj2)
            return true;
            else
            return false;
    }
    public void update(String userName, String userAddress, int userPhone,
    String userEmail){
        name = userName;
        address = userAddress;
        phone = userPhone;
        email = userEmail;
    }
}

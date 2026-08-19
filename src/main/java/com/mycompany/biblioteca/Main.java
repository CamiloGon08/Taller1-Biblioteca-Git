
package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
 static ArrayList<Client>clients=new ArrayList<>();
 static Scanner sc = new Scanner(System.in);
 
    public static void main(String[] args) {
        
    }
    
    public static void createClient(){
        System.out.println("\n   REGISTER CLIENT   ");
        System.out.print("Enter ID: ");
        String id=sc.nextLine();
        
        System.out.print("Enter nName: ");
        String name =sc.nextLine();
        
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        
        Client newClient = new Client(id,name,phone,email);
        clients.add(newClient);
        
        System.out.println("Client registered successfully");
    }
    
    
}

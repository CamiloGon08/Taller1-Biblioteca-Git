
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
    
    //READ(List)
    public static void listClients(){
        System.out.println("\n   CLIENT LIST   ");
        if(clients.isEmpty()){
            System.out.println("No clients registered");
        }else{
            for(Client c:clients){
                System.out.println(c);
            }
        }
    }
    
    //READ(search)
    public static Client searchClient(String id){
        for (Client c:clients){
            if(c.getId().equalsIgnoreCase(id)){
                return c;
            }
        }
        return null;
    }
}

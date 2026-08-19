
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
    
    //UPDATE
    public static void updateClient(){
        System.out.println("\n   UPDATE CLIENT  ");
        System.out.print("Enter the ID of the client to update: ");
        String id=sc.nextLine();
        
        Client c = searchClient(id);
        if (c!=null){
            System.out.print("New name (current: "+c.getName()+ "): ");
            c.setName(sc.nextLine());
            
            System.out.print("New phone (current: "+ c.getPhone()+"): ");
            c.setPhone(sc.nextLine());
            
            System.out.print("New Email (current: "+c.getEmail()+ "): ");
            c.setEmail(sc.nextLine());
            
            System.out.print("Client Upddate Successfully");
        }else{
            System.out.println ("Client not found");
        }
    }
    
    //DELETE
    public static void deleteClient(){
        System.out.println("\n   DELETE CLIENT   ");
        System.out.print("Enter the IDof the Client to delete: ");
        String id=sc.nextLine();
        
        Client c = searchClient(id);
        if(c!=null){
            clients.remove(c);
            System.out.println("Client deleted successfully");
        }else{
            System.out.println("Client not found");
        }
    }
    
    static ArrayList<Book> books = new ArrayList<>();
    
    
    public static void createBook(){
        System.out.println("\n  REGISTER BOOK   ");
        System.out.print("Enter Book Code: ");
        String code = sc.nextLine();
        
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        
        System.out.print("Enter Publication Year: ");
        String publicationYear = sc.nextLine();
        
        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        Book newBook = new Book(code, title, publicationYear, author, true);
        books.add(newBook);
        
        System.out.println("Book registered successfully.");
    }
}

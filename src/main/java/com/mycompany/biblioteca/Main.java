
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
    
    
    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Create client");
            System.out.println("2. List clients");
            System.out.println("3. Search client");
            System.out.println("4. Update client");
            System.out.println("5. Delete client");
            System.out.println("6. Create book");
            System.out.println("7. List books");
            System.out.println("8. Search book");
            System.out.println("9. Update book");
            System.out.println("10. Delete book");
            System.out.println("11. Register loan");
            System.out.println("12. Register return");
            System.out.println("13. List active loans");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    createClient();
                    break;
                case 2:
                    listClients();
                    break;
                case 3:
                    searchClient(promptId());
                    break;
                case 4:
                    updateClient();
                    break;
                case 5:
                    deleteClient();
                    break;
                case 6:
                    createBook();
                    break;
                case 7:
                    listBooks();
                    break;
                case 8:
                    searchBook(promptId());
                    break;
                case 9:
                    updateBook();
                    break;
                case 10:
                    deleteBook();
                    break;
                case 11:
                    createLoan();
                    break;
                case 12:
                    returnLoan();
                    break;
                case 13:
                    listActiveLoans();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (option != 0);
    }

    private static String promptId() {
        System.out.print("Enter ID: ");
        return sc.nextLine();
    }
}

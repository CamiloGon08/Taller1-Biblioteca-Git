
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
    
        public static void listBooks(){
        System.out.println("\n  BOOK LIST    ");
        if(books.isEmpty()){
            System.out.println("No books registered");
            
        }else{
            for(Book b : books){
                System.out.println(b);
            }
        }
    }
    
    public static Book searchBook(String code) {
        for (Book b : books) {
            if (b.getCode().equalsIgnoreCase(code)) {
                return b;
            }
        }
        return null;
    }
    
    public static void searchBookConsole() {
        System.out.println("\n   SEARCH BOOK    ");
        System.out.print("Enter Code to search: ");
        String code = sc.nextLine();
        
        Book b = searchBook(code);
        if (b != null) {
            System.out.println("Book found: " + b);
        } else {
            System.out.println(" Book not found.");
        }
    }
    
    public static void updateBook(){
        System.out.println("\n   UPDATE BOOK    ");
        System.out.print("Enter the code of the book to update: ");
        String code = sc.nextLine();
        
        Book b = searchBook(code);
        if (b != null) {
            System.out.print("New Title (current: " + b.getTitle() + "): ");
            b.setTitle(sc.nextLine());
            
            System.out.print("New Publication Year (current: " + b.getPublicationYear() + "): ");
            b.setPublicationYear(sc.nextLine());
            
            System.out.print("New Author (current: " + b.getAuthor() + "): ");
            b.setAuthor(sc.nextLine());
            
            System.out.println(" Book updated successfully.");
        } else {
            System.out.println(" Book not found.");
        }
    }
    
    public static void deleteBook() {
        System.out.println("    DELETE BOOK   ");
        System.out.print("Enter the Code of the book to delete: ");
        String code = sc.nextLine();
        
        Book b = searchBook(code);
        if (b != null) {
            books.remove(b);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
    
    static ArrayList<Loan> loans = new ArrayList<>();
    
    // REGISTER LOAN
    public static void createLoan() {
        System.out.println("\n   REGISTER LOAN    ");
        
        System.out.print("Enter Client ID: ");
        String clientId = sc.nextLine();
        Client client = searchClient(clientId);
        
        if (client == null) {
            System.out.println("Client not found. Cannot process loan.");
            return;
        }

        System.out.print("Enter Book Code: ");
        String bookCode = sc.nextLine();
        Book book = searchBook(bookCode);

        if (book == null) {
            System.out.println("Book not found. Cannot process loan.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("The book is currently not available for loan.");
            return;
        }

        System.out.print("Enter Loan ID: ");
        String loanId = sc.nextLine();

        book.setAvailable(false);
        Loan newLoan = new Loan(loanId, client, book, LocalDate.now(), "Active");
        loans.add(newLoan);

        System.out.println("Loan registered successfully.");
    }
    
    public static void returnLoan() {
        System.out.println("\n   RETURN LOAN     ");
        System.out.print("Enter Loan ID: ");
        String loanId = sc.nextLine();

        Loan targetLoan = null;
        for (Loan l : loans) {
            if (l.getLoanId().equalsIgnoreCase(loanId) && l.getStatus().equalsIgnoreCase("Active")) {
                targetLoan = l;
                break;
            }
        }

        if (targetLoan != null) {
            targetLoan.setStatus("Returned");
            targetLoan.getBook().setAvailable(true);
            System.out.println("Loan returned successfully. Book is now available.");
        } else {
            System.out.println("Active loan not found with the provided ID.");
        }
    }
    
    public static void listActiveLoans() {
        System.out.println("\nACTIVE LOANS LIST");
        boolean hasActive = false;
        
        for (Loan l : loans) {
            if (l.getStatus().equalsIgnoreCase("Active")) {
                System.out.println(l);
                hasActive = true;
            }
        }

        if (!hasActive) {
            System.out.println("No active loans found.");
        }
    }
    
}


package com.mycompany.biblioteca;

public class Book extends Material{
    private String author;
    private boolean available;
    
    public Book(String code, String title, String publicationYear, String author, boolean available) {
        super(code, title, publicationYear);
        this.author = author;
        this.available = available;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return super.toString() + " , Author: " + author + " , Available: " + (available ? "Yes" : "No");
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
}

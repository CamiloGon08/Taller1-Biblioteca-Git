
package com.mycompany.biblioteca;
import java.time.LocalDate;

public class Loan {
    private String loanId;
    private Client client;
    private Book book;
    private LocalDate loanDate;
    private String status;
    
    public Loan(String loanId, Client client, Book book, LocalDate loanDate, String status) {
        this.loanId = loanId;
        this.client = client;
        this.book = book;
        this.loanDate = loanDate;
        this.status = status;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Loan ID: " + loanId + " , Client: " + client.getName() + " (ID: " + client.getId() + ")" +
               " , Book: " + book.getTitle() + " , Date: " + loanDate + " , Status: " + status;
    }
}

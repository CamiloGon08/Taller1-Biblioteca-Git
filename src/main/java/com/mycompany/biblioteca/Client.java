
package com.mycompany.biblioteca;

public class Client extends Person {
    
   private String email;
   
   public Client(String id, String nombre, String telefono, String email){
       super(id,nombre,telefono);
       this.email=email;
   }
   
   public String getEmail(){
       return email;
   }
   
   public void setEmail(String email){
       this.email=email;
   }
   
   @override 
   public String toString(){
       return super.toString()+ ", Email: "+email;
   }
    
}

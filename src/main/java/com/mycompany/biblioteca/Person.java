
package com.mycompany.biblioteca;


public abstract class Person {
    
    protected String id;
    protected String name;
    protected String phone;
    
    public Person(String id, String name, String phone){
        this.id=id;
        this.name=name;
        this.phone=phone;
    }
    
    public String getId(){
        return id;
    }
    
    
    public void setId(String id){
        this.id=id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setNombre(String name){
        this.name=name;
    }
    
    public String getTelefono(){
        return phone;
    }
    
    public void setTelefono(String phone){
        this.phone=phone;
    }
    
    @Override
    public String toString(){
        return "ID: "+id+", Name: "+name + ", Phone Number: "+ phone;
    }
    
}

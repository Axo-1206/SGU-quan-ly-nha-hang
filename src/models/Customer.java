package models;

import base.*;

public class Customer extends Human {

    public Customer(String name, int age, String gender) { super(name, age, gender); }

    @Override
    public void display() {
        System.out.println("Name: "+name+"\nAge: "+age+"\nGender: "+gender);
    }
}

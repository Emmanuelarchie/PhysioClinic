/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.physioapp;
import java.util.UUID;
/**
 *
 * @author emman
 */
public class Patient {
    
   
    private final String id;
    private String name;
    private String phone_number;
    private String address;
    
    public Patient (String name, String phone_number, String address) {
        this.name = name;
        this.id = UUID.randomUUID().toString();// assign current counter and increment
        this.phone_number = phone_number;
        this.address = address;
        
    }
    
    public String getId() {
        return this.id;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phone_number;
    }
    public String getAddress() {
        return address;
    }
    public void setName (String name) {
        this.name = name;
    }
    
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }
    public void setAddress(String address) {
            this.address = address;
}
} 


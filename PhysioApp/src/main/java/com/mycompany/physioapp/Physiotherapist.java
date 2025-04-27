/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.physioapp;
/**
 *
 * @author emman
 */
public class Physiotherapist {
    public static int idcounter = 1; // shared across all physiotherapist instances
    public final int id; // unique id for each physiotherapist
    
            
            
    String name;
    String expertise;
    Timetable timetable;
    
    public Physiotherapist(String name, String expertise) {
        this.name = name;
        this.expertise = expertise;
        this.timetable = new Timetable();
        this.id = idcounter++;
    }
    
}

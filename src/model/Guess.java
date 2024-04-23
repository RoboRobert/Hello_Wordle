/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 * This class will handle guess data storage
 * @author nathan
 */
public class Guess {
    private String name;
    private String typing;
    private int paradigmID; // 1 = procedural, 2 = structured, 3 = object oriented, 4 = functional, 5 = logic
    private String paradigmName;
    private String level;
    private int year; 
    
    /**
     * Unparameterized constructor for setting all the values at once
     */
    public Guess() {
        name = "";
        typing = "";
        paradigmID = 0;
        paradigmName = "";
        level = "";
        year = 0;
    }
    
    /**
     * Parameterized constructor for setting all the values at once
     * @param nameIn
     * @param typingIn
     * @param paradigmNameIn
     * @param levelIn
     * @param yearIn 
     */
    public Guess(String nameIn, String typingIn, String paradigmNameIn, String levelIn, int yearIn) {
        name = nameIn;
        typing = typingIn;
        paradigmName = paradigmNameIn;
        paradigmID = findParadigmID();
        level = levelIn;
        year = yearIn;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getTyping()
    {
        return typing;
    }
    
    private int findParadigmID() {
        int return_id = 0;
        
        switch(paradigmName)
        {
            case "PROCEDURAL": 
                return_id = 1;
                break;
                
            case "STRUCTURED": 
                return_id = 2;
                break;
                
            case "OBJECT ORIENTED": 
                return_id = 3;
                break;
                
            case "FUNCTIONAL":
                return_id = 4;
                break;
                
            case "LOGIC":
                return_id = 5;
                break;
        }
        
        return return_id;
    }
    
    public int getParadigmID()
    {
        return paradigmID;
    }
    
    public String getParadigmName()
    {
        return paradigmName;
    }
    
    public String getLevel()
    {
        return level;
    }
    
    public int getYear()
    {
        return year;
    }
    
    
    /**
     * Returns whether two guesses are equal
     * @param other the guess to compare the current guess to
     * @return a boolean representing equality
     */
    public boolean equals(Guess other) {
        if(name == other.name) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Returns a string for pretty printing the data in a guess object. Used mostly for testing JSON persistence
     */
    public String print_guess() {
        String return_string = "";
        
        return_string += "Name: " + name + "\n";
        return_string += "Typing: " + typing + "\n";
        return_string += "Paradigm: " + paradigmName + "\n";
        return_string += "Level: " + level + "\n";
        return_string += "Year: " + year;
        
        return return_string;
    }
}

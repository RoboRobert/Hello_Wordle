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
     * Default constructor if you want to assemble the Guess object later
     */
    public Guess() {
        name = "";
        typing = "";
        paradigm = "";
        level = "";
        year = 1970;
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
        level = levelIn;
        year = yearIn;
    }
    
    /**
     * Returns whether two guesses are equal
     * @param other the guess to compare the current guess to
     * @return a boolean representing equality
     */
    public String getName()
    {
        return name;
    }
    
    public String getTyping()
    {
        return typing;
    }
    
    public int getParadigmID()
    {
        switch(paradigmName)
        {
            case "PROCEDURAL" -> paradigmID = 1;
            case "STRUCTURED" -> paradigmID = 2;
            case "OBJECT ORIENTED" -> paradigmID = 3;
            case "FUNCTIONAL" -> paradigmID = 4;
            case "LOGIC" -> paradigmID = 5;
        }
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
        return_string += "Paradigm: " + paradigm + "\n";
        return_string += "Level: " + level + "\n";
        return_string += "Year: " + year;
        
        return return_string;
    }
}

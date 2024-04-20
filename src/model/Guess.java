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
    public String name;
    public String typing;
    public String paradigm;
    public String level;
    public int year;
    
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
     * @param paradigmIn
     * @param levelIn
     * @param yearIn 
     */
    public Guess(String nameIn, String typingIn, String paradigmIn, String levelIn, int yearIn) {
        name = nameIn;
        typing = typingIn;
        paradigm = paradigmIn;
        level = levelIn;
        year = yearIn;
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
        return_string += "Paradigm: " + paradigm + "\n";
        return_string += "Level: " + level + "\n";
        return_string += "Year: " + year;
        
        return return_string;
    }
}

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
}

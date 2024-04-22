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
    private int year; 
    
    /**
     * Parameterized constructor for setting all the values at once
     * @param nameIn
     * @param typingIn
     * @param paradigmIDIn
     * @param levelIn
     * @param yearIn 
     */
    public Guess(String nameIn, String typingIn, int paradigmIDIn, String levelIn, int yearIn) {
        name = nameIn;
        typing = typingIn;
        paradigmID = paradigmIDIn;
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
        return paradigmID;
    }
    
    public String getParadigmName()
    {
        switch(paradigmID)
        {
            case 1 -> paradigmName = "PROCEDURAL";
            case 2 -> paradigmName = "STRUCTURED";
            case 3 -> paradigmName = "OBJECT ORIENTED";
            case 4 -> paradigmName = "FUNCTIONAL";
            case 5 -> paradigmName = "LOGIC";
        }
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
}

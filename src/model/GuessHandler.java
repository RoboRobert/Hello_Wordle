/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;

/**
 * This class will handle guess generation and matching
 * @author nathan
 */
public class GuessHandler {
    /**
     * These are the colors for incorrect, correct and close guesses
     */
//    Feel free to play with these colors if you think they can be improved
    private static Color MY_GRAY = new Color(51,51,51);
    private static Color MY_GREEN = new Color(0, 153, 0);
    private static Color MY_YELLOW = new Color(218, 205, 56);
    /**
     * Randomly picks a possible programming language from the database
     * @return Returns a String representing the name of the guess generated
     */
    public static String generateGuess() {
//        TODO Add implementation
        return "";
    }
    
    
    /**
     * Returns the Guess object that corresponds to the name queried (currently only returns java)
     * @param name
     * @return 
     */
    public static Guess getGuess(String name) {
//        TODO Add implementation
        Guess returnGuess = new Guess("Java", "STATIC", "OO", "HIGH", 1995);

        return returnGuess;
    }
    
    /**
     * 
     * @return Returns a Color used to change the color of the name guess slot
     */
    public static Color matchName(String name1, String name2) {
        if(name1 == name2)
            return MY_GREEN;
        
        return MY_GRAY;
    }
    
    /**
     * 
     * @return Returns a Color used to change the color of the typing guess slot
     */
    public static Color matchTyping(String typing1, String typing2) {
        if(typing1 == typing2)
            return MY_GREEN;
        
        return MY_GRAY;
    }
    
    /**
     * 
     * @return Returns a Color used to change the color of the paradigm guess slot
     */
    public static Color matchParadigm(String paradigm1, String paradigm2) {
        if(paradigm1 == paradigm2)
            return MY_GREEN;
        
        return MY_GRAY;
    }
    
    /**
     * 
     * @return Returns a Color used to change the color of the level guess slot
     */
    public static Color matchLevel(String level1, String level2) {
        if(level1 == level2)
            return MY_GREEN;
        
        return MY_GRAY;
    }
    
    /**
     * 
     * @return Returns a Color used to change the color of the year guess slot
     */
    public static Color matchYear(int year1, int year2) {
        if(year1 == year2)
            return MY_GREEN;
        
        return MY_GRAY;
    }
}

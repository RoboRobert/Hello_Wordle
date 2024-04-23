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
    private static final Color MY_GRAY = new Color(51,51,51);
    private static final Color MY_GREEN = new Color(0, 153, 0);
    private static final Color MY_YELLOW = new Color(218, 205, 56);
    
    /**
     * Returns the Guess object that corresponds to the name queried
     * @param name
     * @return a Guess object from LanguageArray
     */
    public static Guess getGuess(String name) {
//      Grabs a matching guess object from the language array
        Guess returnGuess = LanguageArray.fetchLanguage(name);

        return returnGuess;
    }    
    
    /**
     * Returns true if two guesses match, false if not
     */
    public static boolean matchGuess(Guess guess1, Guess guess2){
        return guess1.getName().equals(guess2.getName());
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
    public static Color matchParadigm(int paradigm1, int paradigm2) 
    {
        if(paradigm1 == paradigm2)
        {
            return MY_GREEN;
        }
        else if(paradigm1 <= 3 && paradigm2 <=3)
        {
            return MY_YELLOW;
        }
        else if(paradigm1 >= 4 && paradigm2 >= 4)
        {
            return MY_YELLOW;
        }
        else
        {
            return MY_GRAY;
        }
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
     * Updated 4/20/24 to have it show yellow instead of default gray when incorrect year
     */
    public static Color matchYear(int year1, int year2) {
        if(year1 == year2)
            return MY_GREEN;
        
        return MY_YELLOW;
    }
}

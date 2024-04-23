/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import resources.resourceHandler;

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
     * 
     * @return Returns a Color used to change the color of the name guess slot
     */
    public static Color matchName(String name1, String name2) {
       
        if(name1.equals(name2))
            return MY_GREEN;
        
        return MY_GRAY;
    }
    
    /**
     * 
     * @return Returns a Color used to change the color of the typing guess slot
     */
    public static Color matchTyping(String typing1, String typing2) {
        if(typing1.equals(typing2))
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
        if(level1.equals(level2))
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
        
        return MY_YELLOW;
    }
    
        /**
     *  Takes in 2 years and returns an up arrow or down arrow depending on which one is higher.
     *  Returns null if the years are equal.
     */
    public static ImageIcon getArrow(int year1, int year2) {
        URL iconURL;
        ImageIcon arrowIcon;
        
        resourceHandler handler = new resourceHandler();
//        If the second year is greater, return an up arrow
        if(year1 < year2) {
            return handler.retrieveIcon("/resources/upArrow.png");
        }
        
//        If the second year is lower, return a down arrow
        else if (year1 > year2) {
            return handler.retrieveIcon("/resources/downArrow.png");
        }
        
        else return null;
    }
}

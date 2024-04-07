/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 * This class serves as the model for the game. Essentially, it's just a bunch of data.
 * @author nathan
 */
public class GameData {
    public long num_guesses;
    
    public ArrayList<String> guesses_list;

    /**
     * Unparameterized Constructor
     */
    public GameData() {
        num_guesses = 0;
        guesses_list = new ArrayList<String>();
    }
    
    /**
     * Method to print all of the game state cleanly
     */
    public void print_data() {
        
        System.out.println("Number of guesses: " + num_guesses);
        
        int current_guess = 1;
        for(String guess : guesses_list) {
            
            System.out.println("Guess #" + current_guess + ": " + guess);
            current_guess++;
        }
        
        return;
    }
    
    public void addToList(String input) {
        guesses_list.add(input);
    }
    
    public void addGuess() {
        num_guesses++;
    }
    
//    public void setList()
    
    public ArrayList<String> getGuessList() {
        return guesses_list;
    }
    
    public long getNumGuesses() {
        return num_guesses;
    }
}

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
    public ArrayList<Guess> guesses_list;

    /**
     * Unparameterized Constructor
     */
    public GameData() {
        guesses_list = new ArrayList<Guess>();
    }
    
    /**
     * Parameterized constructor
     * @param previous_state any previous game state we're loading in
     */
    public GameData(ArrayList<Guess> previous_state) {
        guesses_list = previous_state;
    }
    
    /**
     * Method to print all of the game state cleanly
     */
    public void print_data() {
        for(Guess guess : guesses_list) {
            System.out.println(guess.print_guess() + "\n");
        }
        
        return;
    }
}

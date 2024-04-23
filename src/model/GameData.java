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
    public Guess correct_guess;
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
     * @param previous_correct The correct guess for the previous session
     */
    public GameData(Guess previous_correct, ArrayList<Guess> previous_state) {
        correct_guess = previous_correct;
        guesses_list = previous_state;
    }
    
    /**
     * Checks if a Guess has already been guessed in the game state
     * @param input The guess being checked
     * @return true or false if the guess has already been guessed
     */
    public boolean alreadyGuessed(Guess input) {
        boolean return_value = false;
        
        for(Guess current : guesses_list) {
            if(current.equals(input)) {
                return_value = true;
            }
        }
        
        return return_value;
    }
    
    /**
     * Checks if the game is over
     */
    public boolean gameOver() {
        boolean return_value = false;
        
//        If there are 6 guesses, return true.
        if(guesses_list.size() > 5)
           return true;
        
//        If the most recent guess was correct, return true.
        if(guesses_list.getLast().equals(correct_guess))
            return true;
        
        return return_value;
    }
    
    /**
     * Method to print all of the game state cleanly
     */
    public void print_data() {
        System.out.println("Correct guess: " + correct_guess.print_guess() + "\n");
        for(Guess guess : guesses_list) {
            System.out.println(guess.print_guess() + "\n");
        }
        
        return;
    }
}

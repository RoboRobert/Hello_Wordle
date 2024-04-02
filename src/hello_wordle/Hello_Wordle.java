/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hello_wordle;

import gui.Menu;
import persistence.JsonTest;
import model.GameData;

/**
 * This class is the controller for the game. It loads from persistence, updates the model from user input, and uses the model to inform the GUI.
 * @author nathan
 */
public class Hello_Wordle {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //    Variable to store the model of the game state.
        Menu main_menu = new Menu(null, true);
        
        main_menu.setVisible(true);
    }
    
}

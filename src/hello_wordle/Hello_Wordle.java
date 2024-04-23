/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hello_wordle;

import gui.GameFrame;
import java.awt.Color;
import persistence.JSONHandler;
import model.GameData;

/**
 * This class is the entrypoint for the game and handles passing persistent data to the application.
 * @author nathan
 */
public class Hello_Wordle {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameData data;
        GameFrame main_menu;
        
//        Tries to load from a persistent session. If possible, creates a new GameFrame with the stored data.
        if(JSONHandler.canLoad()) {
//            Load the stored data.
            data = JSONHandler.load_game();
            
//            Initialize the frame
//            main_menu = new GameFrame(data);
            main_menu = new GameFrame();
            
//            Then set the frame to be visible
            main_menu.setVisible(true);
            
        }
        
//        If there is no persistent data, just make a default GameFrame.
        else {
//            Initialize the frame
            main_menu = new GameFrame();
            
//            Then set the frame to be visible
            main_menu.setVisible(true);
        }
    }
}

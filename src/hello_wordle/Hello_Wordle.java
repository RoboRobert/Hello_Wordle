/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hello_wordle;

import gui.GameFrame;
import java.awt.Color;
import persistence.JsonTest;
import model.GameData;

/**
 * This class is the entrypoint for the game.
 * @author nathan
 */
public class Hello_Wordle {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Main JFrame for the game
        GameFrame main_menu = new GameFrame();

//        Then set the frame to be visible
        main_menu.setVisible(true);
    }
}

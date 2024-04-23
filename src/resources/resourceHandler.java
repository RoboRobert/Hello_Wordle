/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 * The purpose of this class is to standardize resource retrieval. This class can be instantiated and used to keep class paths consistent.
 * @author nathan
 */
public class resourceHandler {
    /**
     * This function takes in a path and returns an ImageIcon from it.
     */
    public ImageIcon retrieveIcon(String path) {
        ImageIcon retrieveIcon;
        URL iconURL = getClass().getResource(path);
        
        retrieveIcon = new ImageIcon(iconURL);
        
        return retrieveIcon;
    }
}

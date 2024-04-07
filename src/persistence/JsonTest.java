/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.File;
import model.GameData;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author nathan
 */
public class JsonTest {
    
    /**
     * Stores the game state out into a JSON file
     * @param data is a GameData object, representing the game state.
     */
    public static void store_data(GameData data) {
//        Creates a file in user.home, since that's the only place we're allowed to put persistence data
        
        JSONObject data_object = new JSONObject();
        data_object.put("num_guesses", data.num_guesses);
        data_object.put("guesses_list", data.guesses_list);

        String path = System.getProperty("user.home") + File.separator + "HelloWordleData.json";
        
        try {
            FileWriter output_file = new FileWriter(path);
            output_file.write("" + data_object.toJSONString());
            output_file.close();
        }
        catch(Exception e) {
            System.out.println("Error storing data: \n" + e);
        }
    }
    
    /**
     * Used to load the JSON persistence file into a GameData object for use as the model
     * @return a GameData object for use as the model
     */
    public static GameData load_data() {
        GameData return_data = new GameData();
        
        String path = System.getProperty("user.home") + File.separator + "HelloWordleData.json";
        try {
//            Creates a JSON parser object
            JSONParser parser = new JSONParser();

//            Reads in the file            
            FileReader input_file = new FileReader(path);
//            Parses it using the JSON parser
            Object parsedObject = parser.parse(input_file);

//            Cassts the parsed data into a JSON Object
            JSONObject jsonObject = (JSONObject) parsedObject;
            
//            Sets the fields of the returned GameData object based on the read data
            return_data.num_guesses = (long) jsonObject.get("num_guesses");
            return_data.guesses_list = (ArrayList<String>) jsonObject.get("guesses_list");
            
        } catch (Exception e) {
            System.out.println("Error loading data: \n" + e);
        }
        
        return return_data;
    }
    
    public static void main(String[] args) {
        GameData test_data = new GameData();
        
        test_data.guesses_list.add("test guess");
        test_data.num_guesses++;
        
        store_data(test_data);
        
        GameData new_data = load_data();
        
        System.out.println("testing object \n");
        new_data.print_data();
    }
}

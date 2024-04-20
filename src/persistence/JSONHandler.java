/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.File;
import model.GameData;

import java.io.FileReader;
import java.io.FileWriter;
import model.Guess;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


/**
 * The purpose of this class is to provide functions to parse JSON data from persistent files
 * @author nathan
 */
public class JSONHandler {
    
    /**
     * Stores the game state out into a JSON file
     * @param data is a GameData object, representing the game state as an array of Guesses
     */
    public static void store_data(GameData data) {
//        Creates a JSON object to store all the data in
        JSONObject data_object = new JSONObject();
//        Creates a JSON array to store the Guess objects in
        JSONArray guesses_array = new JSONArray();
        
//        Loops through each guesse in guesses_list and adds it to an object to store in the guesses_array
        for(Guess guess : data.guesses_list) {
            JSONObject guess_object = new JSONObject();
            guess_object.put("name", guess.name);
            guess_object.put("typing", guess.typing);
            guess_object.put("paradigm", guess.paradigm);
            guess_object.put("level", guess.level);
            guess_object.put("year", Integer.toString(guess.year));
            
            guesses_array.add(guess_object);
        }
        
//        Puts the JSON array into the main JSON object
        data_object.put("guesses_list", guesses_array);

        // user.home is the base of the path as specified in class
        String path = System.getProperty("user.home") + File.separator + "HelloWordleData.json";
        
//        Attempt to write out the JSON object to a file in the home directory
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
        
//      user.home is the base of the path as specified in class
        String path = System.getProperty("user.home") + File.separator + "HelloWordleData.json";
        try {
//            Creates a JSON parser object
            JSONParser parser = new JSONParser();

//            Reads in the file            
            FileReader input_file = new FileReader(path);
            
//            Parses it into an object using the JSON parser
            Object parsedObject = parser.parse(input_file);

//            Casts the parsed data into a JSON Object
            JSONObject jsonObject = (JSONObject) parsedObject;
            
//            Retrieves the list of JSON guesses from the main object
            JSONArray json_guesses = (JSONArray) jsonObject.get("guesses_list");
            
//            Go through the array of objects stored in JSON and convert them to Guess objects
            for(Object obj : json_guesses) {
//                Casts each Object in the JSONArray to a JSONObject
                JSONObject guess_obj = (JSONObject)obj;
                
//                New guess object to store data in
                Guess current_guess = new Guess();
                
//                Puts data from corresponding keys in the JSON into the guess object
                current_guess.name = guess_obj.get("name").toString();
                current_guess.typing = guess_obj.get("typing").toString();
                current_guess.paradigm = guess_obj.get("paradigm").toString();
                current_guess.level = guess_obj.get("level").toString();
                current_guess.year = Integer.parseInt(guess_obj.get("year").toString());
                
                return_data.guesses_list.add(current_guess);
            }
            
//            Close the input file
            input_file.close();
            
        } catch (Exception e) {
            System.out.println("Error loading data: \n" + e);
        }
        
//        Return the retrieved gameData information
        return return_data;
    }
    
    /**
     * This main is just used for testing the JSON behavior
     * @param args 
     */
    public static void main(String[] args) {
        GameData test_data = new GameData();
        
        test_data.guesses_list.add(new Guess("Java", "STATIC", "OO", "HIGH", 1995));
        
        store_data(test_data);
        
        GameData new_data = load_data();
        
        System.out.println("Testing object: \n");
        new_data.print_data();
    }
}

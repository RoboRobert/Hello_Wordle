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
    public static void store_game(GameData data) {
//        Creates a JSON object to store all the data in
        JSONObject data_object = new JSONObject();
//        Creates a JSON array to store the Guess objects in
        JSONArray guesses_array = new JSONArray();
        
//        Puts the previous correct guess into the data object
        data_object.put("correct_guess", convertToJSON(data.correct_guess));
        
//        Loops through each guesse in guesses_list and adds it to an object to store in the guesses_array
        for(Guess guess : data.guesses_list) {
            JSONObject guess_object = convertToJSON(guess);
            
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
    public static GameData load_game() {
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
                
//                Takes the JSON and converts it into a Guess object
                Guess current_guess = convertToGuess(guess_obj);
                
//                Add the guess to the returned GameData object
                return_data.guesses_list.add(current_guess);
            }
            
//            Read the previous correct guess from the stored data
            return_data.correct_guess = convertToGuess((JSONObject)jsonObject.get("correct_guess"));
            
//            Close the input file
            input_file.close();
            
        } catch (Exception e) {
            System.out.println("Error loading data: \n" + e);
        }
        
//        Return the retrieved gameData information
        return return_data;
    }
    
    
    /**
     * Converts a JSONobject to a Guess object
     */
    private static Guess convertToGuess(JSONObject object) {
//                Puts data from corresponding keys in the JSON into the guess object
                String temp_name = object.get("name").toString();
                String temp_typing = object.get("typing").toString();
                String temp_paradigm = object.get("paradigm").toString();
                String temp_level = object.get("level").toString();
                int temp_year = Integer.parseInt(object.get("year").toString());
                
//                New guess object to store data in
                Guess return_guess = new Guess(temp_name, temp_typing, temp_paradigm, temp_level, temp_year);
                
                return return_guess;
    }
    
    /**
     * Converts a Guess object to a JSONObject for output into a JSON file
     */
    private static JSONObject convertToJSON(Guess guessObject) {
//            The JSONObject to return
            JSONObject return_object = new JSONObject();
            
            return_object.put("name", guessObject.getName());
            return_object.put("typing", guessObject.getTyping());
            return_object.put("paradigm", guessObject.getParadigmName());
            return_object.put("level", guessObject.getLevel());
            return_object.put("year", Integer.toString(guessObject.getYear()));
            
            return return_object;
    }
    
    /**
     * Function used to check if there is data to load
     * @return a boolean based on whether there is persistent data to load or not
     */
    public static boolean canLoad() {
//      user.home is the base of the path as specified in class
        String path = System.getProperty("user.home") + File.separator + "HelloWordleData.json";
        
//        If the file doesn't exist or has no data, return false.
        File jsonInput = new File(path);
        if(!jsonInput.isFile() || jsonInput.length() < 10) { 
            return false;
        }
        
//        If all checks pass, then return true.
        return true;
    }
    
    /**
     * This main is just used for testing the JSON behavior
     * @param args 
     */
    public static void main(String[] args) {
        GameData test_data = new GameData();
        
        test_data.correct_guess = new Guess("C++", "STATIC", "OO", "HIGH", 1995);
        
        test_data.guesses_list.add(new Guess("Java", "STATIC", "OO", "HIGH", 1995));
        
        store_game(test_data);
        
        GameData new_data = load_game();
        
        System.out.println("Testing object: \n");
        new_data.print_data();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;
/**
 *
 * @author tessm
 */
public class SelectLanguage 
{
    private ChoiceData[] languages;
    private Random random;
    private ChoiceData correctAnswer;
    
    public SelectLanguage()
    {
        LanguageArray languageArray = new LanguageArray();
        this.languages = languageArray.getLanguages();
        this.random = new Random();
        int arrayIndex = random.nextInt(languages.length);
        
        this.correctAnswer = languages[arrayIndex];
    }
    
    /* Was used for testing, but leaving it in for reference in the Win Detection section @Patrick
    public void print_data() 
    {
        String test = correctAnswer.getName();
        System.out.println("Selected languge: " + test);
    }
    */
}



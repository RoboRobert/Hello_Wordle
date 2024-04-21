/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tessm
 */
public class ChoiceData 
{
    private String name;
    private String typing;
    private int paradigm; // 1 = procedural, 2 = structured, 3 = object oriented, 4 = functional, 5 = logic
    private String level;
    private int year; 
    
    public ChoiceData (String name, String typing, int paradigm, String level, int year)
    {
        this.name = name;
        this.typing = typing;
        this.paradigm = paradigm;
        this.level = level;
        this.year = year;
    }
    
    /**
     * The section below contains all of the Getters for this class
     * @return 
     */
    public String getName()
    {
        return name;
    }
    
    public String getTyping()
    {
        return typing;
    }
    
    public int getParadigm()
    {
        return paradigm;
    }
    
    public String getLevel()
    {
        return level;
    }
    
    public int getYear()
    {
        return year;
    }
}

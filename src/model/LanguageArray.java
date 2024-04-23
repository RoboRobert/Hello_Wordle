/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author tessm
 */
public class LanguageArray
{
    /*
    Reminder: For Paradigms we are using integers to help with similarity comparisons in the game.
    * 1 = Procedural
    * 2 = Structured
    * 3 = Object Oriented
    * 4 = Functional
    * 5 = Logic
    */
    
    private static final Guess Assembly = new Guess("ASSEMBLY", "STATIC", "PROCEDURAL", "LOW", 1949);
    private static final Guess C = new Guess("C", "STATIC", "PROCEDURAL", "INTERMEDIATE", 1972);
    private static final Guess CSharp = new Guess("C#", "STATIC", "OBJECT ORIENTED", "HIGH", 2001);
    private static final Guess CPlusPlus = new Guess("C++", "STATIC", "OBJECT ORIENTED", "INTERMEDIATE", 1985);
    private static final Guess Fortran = new Guess("FORTRAN", "STATIC", "STRUCTURED", "HIGH", 1957);
    private static final Guess Go = new Guess("GO", "STATIC", "PROCEDURAL", "HIGH", 2012);
    private static final Guess Java = new Guess("JAVA", "STATIC", "OBJECT ORIENTED", "HIGH", 1995);
    private static final Guess JavaScript = new Guess("JAVASCRIPT", "DYNAMIC", "OBJECT ORIENTED", "HIGH", 1995);
    private static final Guess Matlab = new Guess("MATLAB", "DYNAMIC", "FUNCTIONAL", "HIGH", 1984);
    private static final Guess Pascal = new Guess("PASCAL", "STATIC", "PROCEDURAL", "HIGH", 1970);
    private static final Guess Perl = new Guess("PERL", "DYNAMIC", "PROCEDURAL", "HIGH", 1987);
    private static final Guess Prolog = new Guess("PROLOG", "DYNAMIC", "LOGIC", "HIGH", 1972);
    private static final Guess Python = new Guess("PYTHON", "DYNAMIC", "OBJECT ORIENTED", "HIGH", 1991);
    private static final Guess Ruby = new Guess("RUBY", "DYNAMIC", "OBJECT ORIENTED", "HIGH", 1995);
    private static final Guess Rust = new Guess("RUST", "STATIC", "FUNCTIONAL", "LOW", 2010);
    private static final Guess Scala = new Guess("SCALA", "STATIC", "FUNCTIONAL", "HIGH", 2004);
    private static final Guess SQL = new Guess("SQL", "STATIC", "LOGIC", "HIGH", 1974);
    private static final Guess Swift = new Guess("SWIFT", "STATIC", "OBJECT ORIENTED", "HIGH", 2014);
    private static final Guess TypeScript = new Guess("TYPESCRIPT", "STATIC", "OBJECT ORIENTED", "HIGH", 2012);
    private static final Guess VisualBasic = new Guess("VISUAL BASIC", "STATIC", "OBJECT ORIENTED", "HIGH", 1991);

    private static Guess[] languageArray = {Assembly, C, CSharp, CPlusPlus, Fortran, Go, Java, JavaScript, Matlab, Pascal, Perl, Prolog, Python, Ruby, Rust, Scala, SQL, Swift, TypeScript, VisualBasic};

    public static Guess[] getLanguages()
    {
        return languageArray;
    }
    
    public static String[] getNames()
    {
        String[] return_array = new String[languageArray.length];
        
        for(int i = 0; i < languageArray.length; i++) {
            return_array[i] = languageArray[i].getName();
        }
        
        return return_array;
    }
    
    public static Guess fetchLanguage(String searchName) {
        
        // searches language array for an object with a matching name
        Guess[] guesses = getLanguages();
        searchName = searchName.toUpperCase();
        
         for (Guess guess : guesses) {
            if (guess.getName().equals(searchName)) {
                return guess;
            }
        }
        return null;
    }
}

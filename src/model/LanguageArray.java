/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
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
    
    private static final Guess Assembly = new Guess("ASSEMBLY", "STATIC", 1, "LOW", 1949);
    private static final Guess C = new Guess("C", "STATIC", 1, "INTERMEDIATE", 1972);
    private static final Guess CSharp = new Guess("C#", "STATIC", 2, "HIGH", 2001);
    private static final Guess CPlusPlus = new Guess("C++", "STATIC", 1, "INTERMEDIATE", 1985);
    private static final Guess Fortran = new Guess("FORTRAN", "STATIC", 2, "HIGH", 1957);
    private static final Guess Go = new Guess("GO", "STATIC", 1, "HIGH", 2012);
    private static final Guess Java = new Guess("JAVA", "STATIC", 3, "HIGH", 1995);
    private static final Guess JavaScript = new Guess("JAVASCRIPT", "DYNAMIC", 3, "HIGH", 1995);
    private static final Guess Matlab = new Guess("MATLAB", "DYNAMIC", 4, "HIGH", 1984);
    private static final Guess Pascal = new Guess("PASCAL", "STATIC", 1, "HIGH", 1970);
    private static final Guess Perl = new Guess("PERL", "DYNAMIC", 4, "HIGH", 1987);
    private static final Guess Prolog = new Guess("PROLOG", "DYNAMIC", 5, "HIGH", 1972);
    private static final Guess Python = new Guess("PYTHON", "DYNAMIC", 4, "HIGH", 1991);
    private static final Guess Ruby = new Guess("RUBY", "DYNAMIC", 4, "HIGH", 1995);
    private static final Guess Rust = new Guess("RUST", "STATIC", 4, "LOW", 2010);
    private static final Guess Scala = new Guess("SCALA", "STATIC", 4, "HIGH", 2004);
    private static final Guess SQL = new Guess("SQL", "STATIC", 5, "HIGH", 1974);
    private static final Guess Swift = new Guess("SWIFT", "STATIC", 4, "HIGH", 2014);
    private static final Guess TypeScript = new Guess("TYPESCRIPT", "STATIC", 4, "HIGH", 2012);
    private static final Guess VisualBasic = new Guess("VISUAL BASIC", "STATIC", 2, "HIGH", 1991);

    private ChoiceData[] languageArray = {Assembly, C, CSharp, CPlusPlus, Fortran, Go, Java, JavaScript, Matlab, Pascal, Perl, Prolog, Ruby, Rust, Scala, SQL, Swift, TypeScript, VisualBasic};

    public ChoiceData[] getLanguages()
    {
        return languageArray;
    }
}

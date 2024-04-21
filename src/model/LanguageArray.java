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
    
    private ChoiceData Assembly = new ChoiceData("ASSEMBLY", "STATIC", 1, "LOW", 1949);
    private ChoiceData C = new ChoiceData("C", "STATIC", 1, "INTERMEDIATE", 1972);
    private ChoiceData CSharp = new ChoiceData("C#", "STATIC", 2, "HIGH", 2001);
    private ChoiceData CPlusPlus = new ChoiceData("C++", "STATIC", 1, "INTERMEDIATE", 1985);
    private ChoiceData Fortran = new ChoiceData("FORTRAN", "STATIC", 2, "HIGH", 1957);
    private ChoiceData Go = new ChoiceData("GO", "STATIC", 1, "HIGH", 2012);
    private ChoiceData Java = new ChoiceData("JAVA", "STATIC", 3, "HIGH", 1995);
    private ChoiceData JavaScript = new ChoiceData("JAVASCRIPT", "DYNAMIC", 3, "HIGH", 1995);
    private ChoiceData Matlab = new ChoiceData("MATLAB", "DYNAMIC", 4, "HIGH", 1984);
    private ChoiceData Pascal = new ChoiceData("PASCAL", "STATIC", 1, "HIGH", 1970);
    private ChoiceData Perl = new ChoiceData("PERL", "DYNAMIC", 4, "HIGH", 1987);
    private ChoiceData Prolog = new ChoiceData("PROLOG", "DYNAMIC", 5, "HIGH", 1972);
    private ChoiceData Python = new ChoiceData("PYTHON", "DYNAMIC", 4, "HIGH", 1991);
    private ChoiceData Ruby = new ChoiceData("RUBY", "DYNAMIC", 4, "HIGH", 1995);
    private ChoiceData Rust = new ChoiceData("RUST", "STATIC", 4, "LOW", 2010);
    private ChoiceData Scala = new ChoiceData("SCALA", "STATIC", 4, "HIGH", 2004);
    private ChoiceData SQL = new ChoiceData("SQL", "STATIC", 5, "HIGH", 1974);
    private ChoiceData Swift = new ChoiceData("SWIFT", "STATIC", 4, "HIGH", 2014);
    private ChoiceData TypeScript = new ChoiceData("TYPESCRIPT", "STATIC", 4, "HIGH", 2012);
    private ChoiceData VisualBasic = new ChoiceData("VISUAL BASIC", "STATIC", 2, "HIGH", 1991);

    private ChoiceData[] languageArray = {Assembly, C, CSharp, CPlusPlus, Fortran, Go, Java, JavaScript, Matlab, Pascal, Perl, Prolog, Ruby, Rust, Scala, SQL, Swift, TypeScript, VisualBasic};

    public ChoiceData[] getLanguages()
    {
        return languageArray;
    }
}

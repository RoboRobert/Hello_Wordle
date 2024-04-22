/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.util.ArrayList;
import javax.swing.JLabel;
import model.Guess;
import model.GuessHandler;

/**
 * This class will serve as both the view and controller of the game in one. It will use the model to process its inputs, then it will display the model to the screen
 * @author annalise
 * @author thomas
 * @author patrick
 * @author nathan
 */
public class GameFrame extends javax.swing.JFrame {
    //    Global variables used for guesses
    javax.swing.JLabel[] guessRow0;
    javax.swing.JLabel[] guessRow1;
    javax.swing.JLabel[] guessRow2;
    javax.swing.JLabel[] guessRow3;
    javax.swing.JLabel[] guessRow4;
    javax.swing.JLabel[] guessRow5;
    
    ArrayList<JLabel[]> guesses_arr;
    int guessCount;
    
    Guess correctGuess;
    
    /**
     * Creates new GameFrame 
     */
    public GameFrame() {
        initComponents();
        
        //        Set the correct guess to C++ as a default for now
        correctGuess = new Guess("C++", "STATIC", 3, "HIGH", 1985);

        
        guessCount = 0;
        
         /**
          * initializes arrays containing rows of guess labels 
          * sets visibility of these rows to false
          * Then adds each array to an ArrayList of arrays
          */
        guesses_arr = new ArrayList<JLabel[]>();
        
        guessRow0 = new javax.swing.JLabel[]{guess0, typing0, paradigm0, level0, test0, year0};
        guesses_arr.add(guessRow0);
        guessRow1 = new javax.swing.JLabel[]{guess1, typing1, paradigm1, level1, test1, year1};
        guesses_arr.add(guessRow1);
        guessRow2 = new javax.swing.JLabel[]{guess2, typing2, paradigm2, level2, test2, year2};
        guesses_arr.add(guessRow2);
        guessRow3 = new javax.swing.JLabel[]{guess3, typing3, paradigm3, level3, test3, year3};
        guesses_arr.add(guessRow3);
        guessRow4 = new javax.swing.JLabel[]{guess4, typing4, paradigm4, level4, test4, year4};
        guesses_arr.add(guessRow4);
        guessRow5 = new javax.swing.JLabel[]{guess5, typing5, paradigm5, level5, test5, year5};
        guesses_arr.add(guessRow5);
        
//        Set all the guess rows to be invisible at the start
        for(javax.swing.JLabel[] guessRow : guesses_arr) {
            guessVisibility(false, guessRow);
        }
        
//        Makes the main menu the only visible panel at the start
        gamePanel.setVisible(false);
        winPanel.setVisible(false);
        menuPanel.setVisible(true);
        
        //        Make sure the size takes from the preferred size, then move to the middle of the screen
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
     /** 
      * This sets the visibility of an array of JLabels
      */
    private void guessVisibility(boolean isVisible, javax.swing.JLabel[] labels) {
        for (javax.swing.JLabel label : labels) {
            label.setVisible(isVisible);
        }
    }
    
    /**
     * Handles setting name, typing, paradigm, level, test and year of a guess
     */
    private void setGuess(JLabel[] guessRow, Guess guess) {
        guessRow[0].setText(guess.getName()); 
        guessRow[1].setText(guess.getTyping());
        guessRow[2].setText(guess.getParadigmName());
        guessRow[3].setText(guess.getLevel());
        guessRow[4].setText("test");
        String yearString = Integer.toString(guess.getYear());
        guessRow[5].setText(yearString);
    }
    
    /**
     * Handles setting the colors of rows based on the input guess and the correct guess.
     */
    private void setColors(JLabel[] guessRow, Guess guess) {
        guessRow[0].setBackground(GuessHandler.matchName(correctGuess.getName(), guess.getName()));
        guessRow[1].setBackground(GuessHandler.matchTyping(correctGuess.getTyping(), guess.getTyping()));
        guessRow[2].setBackground(GuessHandler.matchParadigm(correctGuess.getParadigm(), guess.getParadigm()));
        guessRow[3].setBackground(GuessHandler.matchLevel(correctGuess.getLevel(), guess.getLevel()));
//      Skip 4 for now because I don't know what to do with it
        guessRow[5].setBackground(GuessHandler.matchYear(correctGuess.getYear(), guess.getYear()));
    }
    
    
    /**
     * Sets the gamePanel view to visible
     */
    private void selectGameView() {
        //Change to game view
        gamePanel.setVisible(true);
        menuPanel.setVisible(false);
        this.pack();
    }
    
    /**
     * Sets the main menu view to visible
     */
    private void selectMainView() {
        //Switch to the main menu
        winPanel.setVisible(false);
        menuPanel.setVisible(true);
        this.pack();
    }
    
    /**
     * Sets the win menu view to visible
     */
    private void selectWinView() {
        //Change to the win menu
        winPanel.setVisible(true);
        gamePanel.setVisible(false);
        this.pack();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        promptLabel1 = new javax.swing.JLabel();
        gamePanel = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        guessButton = new javax.swing.JButton();
        winButton = new javax.swing.JButton();
        promptLabel = new javax.swing.JLabel();
        testPanel = new javax.swing.JPanel();
        guess = new javax.swing.JLabel();
        typing = new javax.swing.JLabel();
        paradigm = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        test = new javax.swing.JLabel();
        yearCreated = new javax.swing.JLabel();
        guess0 = new javax.swing.JLabel();
        typing0 = new javax.swing.JLabel();
        paradigm0 = new javax.swing.JLabel();
        level0 = new javax.swing.JLabel();
        test0 = new javax.swing.JLabel();
        year0 = new javax.swing.JLabel();
        guess1 = new javax.swing.JLabel();
        typing1 = new javax.swing.JLabel();
        paradigm1 = new javax.swing.JLabel();
        level1 = new javax.swing.JLabel();
        test1 = new javax.swing.JLabel();
        year1 = new javax.swing.JLabel();
        guess2 = new javax.swing.JLabel();
        typing2 = new javax.swing.JLabel();
        paradigm2 = new javax.swing.JLabel();
        level2 = new javax.swing.JLabel();
        test2 = new javax.swing.JLabel();
        year2 = new javax.swing.JLabel();
        guess3 = new javax.swing.JLabel();
        typing3 = new javax.swing.JLabel();
        paradigm3 = new javax.swing.JLabel();
        level3 = new javax.swing.JLabel();
        test3 = new javax.swing.JLabel();
        year3 = new javax.swing.JLabel();
        guess4 = new javax.swing.JLabel();
        typing4 = new javax.swing.JLabel();
        paradigm4 = new javax.swing.JLabel();
        level4 = new javax.swing.JLabel();
        test4 = new javax.swing.JLabel();
        year4 = new javax.swing.JLabel();
        guess5 = new javax.swing.JLabel();
        typing5 = new javax.swing.JLabel();
        paradigm5 = new javax.swing.JLabel();
        level5 = new javax.swing.JLabel();
        test5 = new javax.swing.JLabel();
        year5 = new javax.swing.JLabel();
        winPanel = new javax.swing.JPanel();
        winLabel = new javax.swing.JLabel();
        mainMenuButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hello Wordle");

        menuPanel.setBackground(new java.awt.Color(51, 51, 51));

        startButton.setBackground(new java.awt.Color(102, 102, 102));
        startButton.setForeground(java.awt.Color.white);
        startButton.setText("Classic");
        startButton.setRolloverEnabled(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(102, 102, 102));
        exitButton.setForeground(java.awt.Color.white);
        exitButton.setText("Exit");
        exitButton.setRolloverEnabled(false);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        promptLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        promptLabel1.setForeground(new java.awt.Color(255, 255, 255));
        promptLabel1.setText("Hello Wordle");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap(452, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(exitButton)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(promptLabel1))
                .addGap(447, 447, 447))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(promptLabel1)
                .addGap(18, 18, 18)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        gamePanel.setBackground(new java.awt.Color(51, 51, 51));

        jComboBox1.setBackground(new java.awt.Color(102, 102, 102));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "html", "Python", "C++", "Java" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        guessButton.setBackground(new java.awt.Color(102, 102, 102));
        guessButton.setForeground(new java.awt.Color(255, 255, 255));
        guessButton.setText("Guess");
        guessButton.setRolloverEnabled(false);
        guessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessButtonActionPerformed(evt);
            }
        });

        winButton.setBackground(new java.awt.Color(102, 102, 102));
        winButton.setForeground(new java.awt.Color(255, 255, 255));
        winButton.setText("To Win");
        winButton.setRolloverEnabled(false);
        winButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                winButtonActionPerformed(evt);
            }
        });

        promptLabel.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        promptLabel.setForeground(new java.awt.Color(255, 255, 255));
        promptLabel.setText("Hello Wordle");

        testPanel.setBackground(new java.awt.Color(51, 51, 51));
        testPanel.setLayout(new java.awt.GridLayout(8, 6, 4, 4));

        guess.setBackground(new java.awt.Color(153, 153, 153));
        guess.setForeground(new java.awt.Color(255, 255, 255));
        guess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess.setText("Guess");
        guess.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess.setOpaque(true);
        testPanel.add(guess);

        typing.setBackground(new java.awt.Color(153, 153, 153));
        typing.setForeground(new java.awt.Color(255, 255, 255));
        typing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing.setText("Typing");
        typing.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing.setOpaque(true);
        testPanel.add(typing);

        paradigm.setBackground(new java.awt.Color(153, 153, 153));
        paradigm.setForeground(new java.awt.Color(255, 255, 255));
        paradigm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm.setText("Paradigm");
        paradigm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm.setOpaque(true);
        testPanel.add(paradigm);

        level.setBackground(new java.awt.Color(153, 153, 153));
        level.setForeground(new java.awt.Color(255, 255, 255));
        level.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level.setText("High/Low Level");
        level.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level.setOpaque(true);
        testPanel.add(level);

        test.setBackground(new java.awt.Color(153, 153, 153));
        test.setForeground(new java.awt.Color(255, 255, 255));
        test.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        test.setText("test");
        test.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        test.setOpaque(true);
        testPanel.add(test);

        yearCreated.setBackground(new java.awt.Color(153, 153, 153));
        yearCreated.setForeground(new java.awt.Color(255, 255, 255));
        yearCreated.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearCreated.setText("Year Created");
        yearCreated.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        yearCreated.setOpaque(true);
        testPanel.add(yearCreated);

        guess0.setBackground(new java.awt.Color(51, 51, 51));
        guess0.setForeground(new java.awt.Color(255, 255, 255));
        guess0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess0.setText("guess0");
        guess0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess0.setOpaque(true);
        testPanel.add(guess0);

        typing0.setBackground(new java.awt.Color(51, 51, 51));
        typing0.setForeground(new java.awt.Color(255, 255, 255));
        typing0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing0.setText("typing0");
        typing0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing0.setOpaque(true);
        testPanel.add(typing0);

        paradigm0.setBackground(new java.awt.Color(51, 51, 51));
        paradigm0.setForeground(new java.awt.Color(255, 255, 255));
        paradigm0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm0.setText("paradigm0");
        paradigm0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm0.setOpaque(true);
        testPanel.add(paradigm0);

        level0.setBackground(new java.awt.Color(51, 51, 51));
        level0.setForeground(new java.awt.Color(255, 255, 255));
        level0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level0.setText("level0");
        level0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level0.setOpaque(true);
        testPanel.add(level0);

        test0.setBackground(new java.awt.Color(51, 51, 51));
        test0.setForeground(new java.awt.Color(255, 255, 255));
        test0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        test0.setText("test0");
        test0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        test0.setOpaque(true);
        testPanel.add(test0);

        year0.setBackground(new java.awt.Color(51, 51, 51));
        year0.setForeground(new java.awt.Color(255, 255, 255));
        year0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year0.setText("year0");
        year0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year0.setOpaque(true);
        testPanel.add(year0);

        guess1.setBackground(new java.awt.Color(51, 51, 51));
        guess1.setForeground(new java.awt.Color(255, 255, 255));
        guess1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess1.setText("guess1");
        guess1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess1.setOpaque(true);
        testPanel.add(guess1);

        typing1.setBackground(new java.awt.Color(51, 51, 51));
        typing1.setForeground(new java.awt.Color(255, 255, 255));
        typing1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing1.setText("typing1");
        typing1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing1.setOpaque(true);
        testPanel.add(typing1);

        paradigm1.setBackground(new java.awt.Color(51, 51, 51));
        paradigm1.setForeground(new java.awt.Color(255, 255, 255));
        paradigm1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm1.setText("paradigm1");
        paradigm1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm1.setOpaque(true);
        testPanel.add(paradigm1);

        level1.setBackground(new java.awt.Color(51, 51, 51));
        level1.setForeground(new java.awt.Color(255, 255, 255));
        level1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level1.setText("level1");
        level1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level1.setOpaque(true);
        testPanel.add(level1);

        test1.setBackground(new java.awt.Color(51, 51, 51));
        test1.setForeground(new java.awt.Color(255, 255, 255));
        test1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        test1.setText("test1");
        test1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        test1.setOpaque(true);
        testPanel.add(test1);

        year1.setBackground(new java.awt.Color(51, 51, 51));
        year1.setForeground(new java.awt.Color(255, 255, 255));
        year1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year1.setText("year1");
        year1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year1.setOpaque(true);
        testPanel.add(year1);

        guess2.setBackground(new java.awt.Color(51, 51, 51));
        guess2.setForeground(new java.awt.Color(255, 255, 255));
        guess2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess2.setText("guess2");
        guess2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess2.setOpaque(true);
        testPanel.add(guess2);

        typing2.setBackground(new java.awt.Color(51, 51, 51));
        typing2.setForeground(new java.awt.Color(255, 255, 255));
        typing2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing2.setText("typing2");
        typing2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing2.setOpaque(true);
        testPanel.add(typing2);

        paradigm2.setBackground(new java.awt.Color(51, 51, 51));
        paradigm2.setForeground(new java.awt.Color(255, 255, 255));
        paradigm2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm2.setText("paradigm2");
        paradigm2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm2.setOpaque(true);
        testPanel.add(paradigm2);

        level2.setBackground(new java.awt.Color(51, 51, 51));
        level2.setForeground(new java.awt.Color(255, 255, 255));
        level2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level2.setText("level2");
        level2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level2.setOpaque(true);
        testPanel.add(level2);

        test2.setBackground(new java.awt.Color(51, 51, 51));
        test2.setForeground(new java.awt.Color(255, 255, 255));
        test2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        test2.setText("test2");
        test2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        test2.setOpaque(true);
        testPanel.add(test2);

        year2.setBackground(new java.awt.Color(51, 51, 51));
        year2.setForeground(new java.awt.Color(255, 255, 255));
        year2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year2.setText("year2");
        year2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year2.setOpaque(true);
        testPanel.add(year2);

        guess3.setBackground(new java.awt.Color(51, 51, 51));
        guess3.setForeground(new java.awt.Color(255, 255, 255));
        guess3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess3.setText("guess3");
        guess3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess3.setOpaque(true);
        testPanel.add(guess3);

        typing3.setBackground(new java.awt.Color(51, 51, 51));
        typing3.setForeground(new java.awt.Color(255, 255, 255));
        typing3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing3.setText("typing3");
        typing3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing3.setOpaque(true);
        testPanel.add(typing3);

        paradigm3.setBackground(new java.awt.Color(51, 51, 51));
        paradigm3.setForeground(new java.awt.Color(255, 255, 255));
        paradigm3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm3.setText("paradigm3");
        paradigm3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm3.setOpaque(true);
        testPanel.add(paradigm3);

        level3.setBackground(new java.awt.Color(51, 51, 51));
        level3.setForeground(new java.awt.Color(255, 255, 255));
        level3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level3.setText("level3");
        level3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level3.setOpaque(true);
        testPanel.add(level3);

        test3.setBackground(new java.awt.Color(51, 51, 51));
        test3.setForeground(new java.awt.Color(255, 255, 255));
        test3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        test3.setText("test3");
        test3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        test3.setOpaque(true);
        testPanel.add(test3);

        year3.setBackground(new java.awt.Color(51, 51, 51));
        year3.setForeground(new java.awt.Color(255, 255, 255));
        year3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year3.setText("year3");
        year3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year3.setOpaque(true);
        testPanel.add(year3);

        guess4.setBackground(new java.awt.Color(51, 51, 51));
        guess4.setForeground(new java.awt.Color(255, 255, 255));
        guess4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess4.setText("guess4");
        guess4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess4.setOpaque(true);
        testPanel.add(guess4);

        typing4.setBackground(new java.awt.Color(51, 51, 51));
        typing4.setForeground(new java.awt.Color(255, 255, 255));
        typing4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing4.setText("typing4");
        typing4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing4.setOpaque(true);
        testPanel.add(typing4);

        paradigm4.setBackground(new java.awt.Color(51, 51, 51));
        paradigm4.setForeground(new java.awt.Color(255, 255, 255));
        paradigm4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm4.setText("paradigm4");
        paradigm4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm4.setOpaque(true);
        testPanel.add(paradigm4);

        level4.setBackground(new java.awt.Color(51, 51, 51));
        level4.setForeground(new java.awt.Color(255, 255, 255));
        level4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level4.setText("level4");
        level4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level4.setOpaque(true);
        testPanel.add(level4);

        test4.setBackground(new java.awt.Color(51, 51, 51));
        test4.setForeground(new java.awt.Color(255, 255, 255));
        test4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        test4.setText("test4");
        test4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        test4.setOpaque(true);
        testPanel.add(test4);

        year4.setBackground(new java.awt.Color(51, 51, 51));
        year4.setForeground(new java.awt.Color(255, 255, 255));
        year4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year4.setText("year4");
        year4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year4.setOpaque(true);
        testPanel.add(year4);

        guess5.setBackground(new java.awt.Color(51, 51, 51));
        guess5.setForeground(new java.awt.Color(255, 255, 255));
        guess5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess5.setText("guess5");
        guess5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess5.setOpaque(true);
        testPanel.add(guess5);

        typing5.setBackground(new java.awt.Color(51, 51, 51));
        typing5.setForeground(new java.awt.Color(255, 255, 255));
        typing5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing5.setText("typing5");
        typing5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing5.setOpaque(true);
        testPanel.add(typing5);

        paradigm5.setBackground(new java.awt.Color(51, 51, 51));
        paradigm5.setForeground(new java.awt.Color(255, 255, 255));
        paradigm5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm5.setText("paradigm5");
        paradigm5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm5.setOpaque(true);
        testPanel.add(paradigm5);

        level5.setBackground(new java.awt.Color(51, 51, 51));
        level5.setForeground(new java.awt.Color(255, 255, 255));
        level5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level5.setText("level5");
        level5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level5.setOpaque(true);
        testPanel.add(level5);

        test5.setBackground(new java.awt.Color(51, 51, 51));
        test5.setForeground(new java.awt.Color(255, 255, 255));
        test5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        test5.setText("test5");
        test5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        test5.setOpaque(true);
        testPanel.add(test5);

        year5.setBackground(new java.awt.Color(51, 51, 51));
        year5.setForeground(new java.awt.Color(255, 255, 255));
        year5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year5.setText("year5");
        year5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year5.setOpaque(true);
        testPanel.add(year5);

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(winButton)
                .addGap(497, 497, 497))
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(testPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(promptLabel)
                            .addGroup(gamePanelLayout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guessButton)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(promptLabel)
                .addGap(18, 18, 18)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guessButton))
                .addGap(18, 18, 18)
                .addComponent(testPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(winButton)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jComboBox1.getAccessibleContext().setAccessibleDescription("");

        winPanel.setBackground(new java.awt.Color(51, 51, 51));

        winLabel.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        winLabel.setForeground(new java.awt.Color(255, 255, 255));
        winLabel.setText("You Win!");
        winLabel.setAlignmentX(0.5F);

        mainMenuButton.setBackground(new java.awt.Color(102, 102, 102));
        mainMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        mainMenuButton.setText("Main Menu");
        mainMenuButton.setAlignmentX(0.5F);
        mainMenuButton.setRolloverEnabled(false);
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButtonActionPerformed(evt);
            }
        });

        quitButton.setBackground(new java.awt.Color(102, 102, 102));
        quitButton.setForeground(new java.awt.Color(255, 255, 255));
        quitButton.setText("Quit");
        quitButton.setAlignmentX(0.5F);
        quitButton.setRolloverEnabled(false);
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout winPanelLayout = new javax.swing.GroupLayout(winPanel);
        winPanel.setLayout(winPanelLayout);
        winPanelLayout.setHorizontalGroup(
            winPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, winPanelLayout.createSequentialGroup()
                .addContainerGap(475, Short.MAX_VALUE)
                .addGroup(winPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(winLabel))
                .addGap(473, 473, 473))
        );
        winPanelLayout.setVerticalGroup(
            winPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winPanelLayout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(winLabel)
                .addGap(29, 29, 29)
                .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gamePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(winPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(12, 12, 12)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(winPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleDescription("Hi Mr. Rochowiak o7");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
//        Select the game view
        selectGameView();
    }//GEN-LAST:event_startButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
//        This button also exits the program
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButtonActionPerformed
//        Select the main menu
        selectMainView();
    }//GEN-LAST:event_mainMenuButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
//        Quit the program
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void winButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_winButtonActionPerformed
//        Select the win menu
        selectWinView();
    }//GEN-LAST:event_winButtonActionPerformed

    /**
     * This function activates when the user inputs a guess. It  will update the model with the data, then update the view with the model's output
     */
    private void guessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessButtonActionPerformed
        //this part should call the guessing method
        String guess = (String) jComboBox1.getSelectedItem();
        
//        Gets the full Guess data from GuessHandler
//        NOTE: CURRENTLY ONLY RETURNS DATA FOR JAVA, fix soon :)
        Guess userGuess = GuessHandler.getGuess(guess);

//        Sets the guess strings appropriately based on the user's input
        setGuess(guesses_arr.get(guessCount), userGuess);

//        Sets the colors appropriately based on correct guesses
        setColors(guesses_arr.get(guessCount), userGuess);

        //        Makes the next guess row visible.
        guessVisibility(true, guesses_arr.get(guessCount));

        //        Adds 1 to the guesscount
        guessCount+=1;

        //        If there have been 6 guesses, then make the guess button unclickable.
        if(guessCount > 5) {
            guessButton.setEnabled(false);
        }

    }//GEN-LAST:event_guessButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GameFrame gui = new GameFrame();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel guess;
    private javax.swing.JLabel guess0;
    private javax.swing.JLabel guess1;
    private javax.swing.JLabel guess2;
    private javax.swing.JLabel guess3;
    private javax.swing.JLabel guess4;
    private javax.swing.JLabel guess5;
    private javax.swing.JButton guessButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel level;
    private javax.swing.JLabel level0;
    private javax.swing.JLabel level1;
    private javax.swing.JLabel level2;
    private javax.swing.JLabel level3;
    private javax.swing.JLabel level4;
    private javax.swing.JLabel level5;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel paradigm;
    private javax.swing.JLabel paradigm0;
    private javax.swing.JLabel paradigm1;
    private javax.swing.JLabel paradigm2;
    private javax.swing.JLabel paradigm3;
    private javax.swing.JLabel paradigm4;
    private javax.swing.JLabel paradigm5;
    private javax.swing.JLabel promptLabel;
    private javax.swing.JLabel promptLabel1;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel test;
    private javax.swing.JLabel test0;
    private javax.swing.JLabel test1;
    private javax.swing.JLabel test2;
    private javax.swing.JLabel test3;
    private javax.swing.JLabel test4;
    private javax.swing.JLabel test5;
    private javax.swing.JPanel testPanel;
    private javax.swing.JLabel typing;
    private javax.swing.JLabel typing0;
    private javax.swing.JLabel typing1;
    private javax.swing.JLabel typing2;
    private javax.swing.JLabel typing3;
    private javax.swing.JLabel typing4;
    private javax.swing.JLabel typing5;
    private javax.swing.JButton winButton;
    private javax.swing.JLabel winLabel;
    private javax.swing.JPanel winPanel;
    private javax.swing.JLabel year0;
    private javax.swing.JLabel year1;
    private javax.swing.JLabel year2;
    private javax.swing.JLabel year3;
    private javax.swing.JLabel year4;
    private javax.swing.JLabel year5;
    private javax.swing.JLabel yearCreated;
    // End of variables declaration//GEN-END:variables
}

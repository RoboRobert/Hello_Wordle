/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.GameData;
import model.Guess;
import model.GuessHandler;
import model.LanguageArray;
import model.SelectLanguage;
import persistence.JSONHandler;

/**
 * This class will serve as both the view and controller of the game in one. It will use the model to process its inputs, then it will display the model to the screen
 * @author annalise
 * @author thomas
 * @author patrick
 * @author nathan
 */
public class GameFrame extends javax.swing.JFrame {
//    Variable used for resetting color back to default
    private static final Color MY_GRAY = new Color(51,51,51);
    
    //    Global variables used for guesses
    javax.swing.JLabel[] guessRow0;
    javax.swing.JLabel[] guessRow1;
    javax.swing.JLabel[] guessRow2;
    javax.swing.JLabel[] guessRow3;
    javax.swing.JLabel[] guessRow4;
    javax.swing.JLabel[] guessRow5;
    
    ArrayList<JLabel[]> guesses_arr;

//    Variable used to store the current game state.
    GameData gameState;

    /**
     * Unparameterized constructor.
     * Creates new GameFrame with no prior data
     */
    public GameFrame() {
//        Initialize everything properly
        initializeGameFrame();
        
//        Since we have no previous state, disable the continue button
        continueButton.setEnabled(false);
        
//        Resets the game to generate a random guess
        resetGame();
        
//        Syncs the view with the game state
        syncGame();
    }
    
    /**
     * Parameterized constructor.
     * Creates new GameFrame using persistent data
     */
    public GameFrame(GameData previousState) {
//        Sets the game state based on the persistent data
        gameState = previousState;
        
//        Initialize everything properly
        initializeGameFrame();
        
//        Syncs the view with the game state
        syncGame();
    }
    
    /**
     * Used for any custom component initializations I do
     */
    private void customInit() {
//        Adds a window listener that checks if the window is closing, then stores the game state out to a file if so
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                handleExit();
            }
        });
        
//        Sets the background color of JDialog boxes because the form editor doesn't let me
        repeatGuessWindow.getContentPane().setBackground(MY_GRAY);
        winDialog.getContentPane().setBackground(MY_GRAY);
        loseDialog.getContentPane().setBackground(MY_GRAY);
        
        
//        Sets the options in the combo box from the LanguageArray's list of names
        jComboBox1.setModel(new DefaultComboBoxModel(LanguageArray.getNames()));
    }
    
    /**
     * This function is shared between the parameterized and unparameterized constructors for a GameFrame object.
     * Its use is to initialize several parts of the GameFrame to work properly
     */
    private void initializeGameFrame() {
//        Call default initComponents
        initComponents();
        
//        Call custom component initializer
        customInit();

//          initializes arrays containing rows of guess labels 
//          sets visibility of these rows to false
//          Then adds each array to an ArrayList of arrays
        guesses_arr = new ArrayList<JLabel[]>();
        
        guessRow0 = new javax.swing.JLabel[]{guess0, typing0, paradigm0, level0, year0, direction0,};
        guesses_arr.add(guessRow0);
        guessRow1 = new javax.swing.JLabel[]{guess1, typing1, paradigm1, level1, year1, direction1};
        guesses_arr.add(guessRow1);
        guessRow2 = new javax.swing.JLabel[]{guess2, typing2, paradigm2, level2, year2, direction2};
        guesses_arr.add(guessRow2);
        guessRow3 = new javax.swing.JLabel[]{guess3, typing3, paradigm3, level3, year3, direction3};
        guesses_arr.add(guessRow3);
        guessRow4 = new javax.swing.JLabel[]{guess4, typing4, paradigm4, level4, year4, direction4};
        guesses_arr.add(guessRow4);
        guessRow5 = new javax.swing.JLabel[]{guess5, typing5, paradigm5, level5, year5, direction5};
        guesses_arr.add(guessRow5);
        
//        Makes the main menu the only visible panel at the start
        gamePanel.setVisible(false);
        menuPanel.setVisible(true);
        
        //        Make sure the size takes from the preferred size, then move to the middle of the screen
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
    
    /**
     * This function syncs the game view with the stored gameState
     */
    private void syncGame() {
        for(int i = 0; i < 6; i++) {
//            If we're within the bounds of the current user's guesses, then set the row based on that.
            if(i < gameState.guesses_list.size()) {
//                Sets the guess text for the current row
                setRowText(guesses_arr.get(i), gameState.guesses_list.get(i));
//                Sets the colors for the current row
                setRowColors(guesses_arr.get(i), gameState.guesses_list.get(i));
            }
            
//            Otherwise, the row must be reset to default state.
            else {
                resetRow(guesses_arr.get(i));
            }
        }
        
//        If the game is over, disable the guess button.
        if(gameState.gameOver()) {
            guessButton.setEnabled(false);
        }
//        If the game is not over, then make sure it's enabled.
        else {
            guessButton.setEnabled(true);
        }
        
//        Sets the text for the lose menu based on the correct guess.
        correctLanguageText.setText(gameState.correct_guess.getName());
    }
    
    /**
     * Resets the game state to default, then calls syncGame() to sync the view with the model
     */
    private void resetGame() {
//        Used for getting a random language from the list
        SelectLanguage randomLanguage = new SelectLanguage();
        
//        Create a default game state.
        gameState = new GameData(randomLanguage.getCorrectAnswer(), new ArrayList<Guess>());
        
//        Set the guessButton to be enabled
        guessButton.setEnabled(true);
        
//        Then sync the game with the default game state, effectively resetting it
        syncGame();
    }
    
//    This resets a row to default state
    private void resetRow(javax.swing.JLabel[] guess_row) {
        for(JLabel label : guess_row) {
//            Reset the text
            label.setText("");
            
//            Reset the color
            label.setBackground(MY_GRAY);
        }
        
        guess_row[5].setIcon(null);
    }
    
    /**
     * Handles setting name, typing, paradigm, level, test and year of a guess row
     */
    private void setRowText(JLabel[] guessRow, Guess guess) {
        guessRow[0].setText(guess.getName()); 
        guessRow[1].setText(guess.getTyping());
        guessRow[2].setText(guess.getParadigmName());
        guessRow[3].setText(guess.getLevel());
        String yearString = Integer.toString(guess.getYear());
        guessRow[4].setText(yearString);
        
//        Compares the current guess's year with the correct year, puts an arrow based on that.
        guessRow[5].setIcon(GuessHandler.getArrow(guess.getYear(), gameState.correct_guess.getYear()));
    }
    
    /**
     * Handles setting the colors of rows based on the input guess and the correct guess.
     */
    private void setRowColors(JLabel[] guessRow, Guess guess) {
        guessRow[0].setBackground(GuessHandler.matchName(gameState.correct_guess.getName(), guess.getName()));
        guessRow[1].setBackground(GuessHandler.matchTyping(gameState.correct_guess.getTyping(), guess.getTyping()));
        guessRow[2].setBackground(GuessHandler.matchParadigm(gameState.correct_guess.getParadigmID(), guess.getParadigmID()));
        guessRow[3].setBackground(GuessHandler.matchLevel(gameState.correct_guess.getLevel(), guess.getLevel()));
        guessRow[4].setBackground(GuessHandler.matchYear(gameState.correct_guess.getYear(), guess.getYear()));
        guessRow[5].setBackground(GuessHandler.matchYear(gameState.correct_guess.getYear(), guess.getYear()));
        
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
        gamePanel.setVisible(false);
        menuPanel.setVisible(true);
        this.pack();
    }
    
    /**
     * Shows the repeated guess error dialog
     */
    private void showGuessError() {
//        Sets the repeat guess window to default size at the center of the screen.
            repeatGuessWindow.pack();
            repeatGuessWindow.setLocationRelativeTo(null);
            
//            Makes it visible
            repeatGuessWindow.setVisible(true);
    }
    
    /**
     * Shows the win dialog
     */
    private void showWinDialog() {
//        Sets the win dialog to default size at the center of the screen.
            winDialog.pack();
            winDialog.setLocationRelativeTo(null);
            
//            Makes it visible
            winDialog.setVisible(true);
    }
    
    /**
     * Shows the lose dialog
     */
    private void showLoseDialog() {
//        Sets the lose dialog to default size at the center of the screen.
            loseDialog.pack();
            loseDialog.setLocationRelativeTo(null);
            
//            Makes it visible
            loseDialog.setVisible(true);
    }
    
    /**
     * Code to gracefully exit the program, and store out any persistent data.
     */
    private void handleExit() {
        JSONHandler.store_game(gameState);
        System.exit(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        repeatGuessWindow = new javax.swing.JDialog();
        guessErrorText = new javax.swing.JTextField();
        winDialog = new javax.swing.JDialog();
        winText = new javax.swing.JTextField();
        winToMainMenu = new javax.swing.JButton();
        playAgainButton = new javax.swing.JButton();
        loseDialog = new javax.swing.JDialog();
        loseText = new javax.swing.JTextField();
        loseToMainMenu = new javax.swing.JButton();
        playAgainButton1 = new javax.swing.JButton();
        correctLanguageText = new javax.swing.JTextField();
        loseText1 = new javax.swing.JTextField();
        menuPanel = new javax.swing.JPanel();
        newGameButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        promptLabel1 = new javax.swing.JLabel();
        continueButton = new javax.swing.JButton();
        gamePanel = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        guessButton = new javax.swing.JButton();
        promptLabel = new javax.swing.JLabel();
        guessPanel = new javax.swing.JPanel();
        guess = new javax.swing.JLabel();
        typing = new javax.swing.JLabel();
        paradigm = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        yearCreated = new javax.swing.JLabel();
        direction = new javax.swing.JLabel();
        guess0 = new javax.swing.JLabel();
        typing0 = new javax.swing.JLabel();
        paradigm0 = new javax.swing.JLabel();
        level0 = new javax.swing.JLabel();
        year0 = new javax.swing.JLabel();
        direction0 = new javax.swing.JLabel();
        guess1 = new javax.swing.JLabel();
        typing1 = new javax.swing.JLabel();
        paradigm1 = new javax.swing.JLabel();
        level1 = new javax.swing.JLabel();
        year1 = new javax.swing.JLabel();
        direction1 = new javax.swing.JLabel();
        guess2 = new javax.swing.JLabel();
        typing2 = new javax.swing.JLabel();
        paradigm2 = new javax.swing.JLabel();
        level2 = new javax.swing.JLabel();
        year2 = new javax.swing.JLabel();
        direction2 = new javax.swing.JLabel();
        guess3 = new javax.swing.JLabel();
        typing3 = new javax.swing.JLabel();
        paradigm3 = new javax.swing.JLabel();
        level3 = new javax.swing.JLabel();
        year3 = new javax.swing.JLabel();
        direction3 = new javax.swing.JLabel();
        guess4 = new javax.swing.JLabel();
        typing4 = new javax.swing.JLabel();
        paradigm4 = new javax.swing.JLabel();
        level4 = new javax.swing.JLabel();
        year4 = new javax.swing.JLabel();
        direction4 = new javax.swing.JLabel();
        guess5 = new javax.swing.JLabel();
        typing5 = new javax.swing.JLabel();
        paradigm5 = new javax.swing.JLabel();
        level5 = new javax.swing.JLabel();
        year5 = new javax.swing.JLabel();
        direction5 = new javax.swing.JLabel();
        gameToMainMenu = new javax.swing.JButton();

        repeatGuessWindow.setTitle("No repeat guesses!");
        repeatGuessWindow.setAlwaysOnTop(true);
        repeatGuessWindow.setBackground(new java.awt.Color(51, 51, 51));
        repeatGuessWindow.setForeground(new java.awt.Color(255, 255, 255));
        repeatGuessWindow.setModal(true);
        repeatGuessWindow.setType(java.awt.Window.Type.POPUP);

        guessErrorText.setEditable(false);
        guessErrorText.setBackground(new java.awt.Color(51, 51, 51));
        guessErrorText.setForeground(new java.awt.Color(255, 255, 255));
        guessErrorText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        guessErrorText.setText("You can't enter the same guess twice!");
        guessErrorText.setActionCommand("<Not Set>");
        guessErrorText.setBorder(null);
        guessErrorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessErrorTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout repeatGuessWindowLayout = new javax.swing.GroupLayout(repeatGuessWindow.getContentPane());
        repeatGuessWindow.getContentPane().setLayout(repeatGuessWindowLayout);
        repeatGuessWindowLayout.setHorizontalGroup(
            repeatGuessWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(repeatGuessWindowLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(guessErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        repeatGuessWindowLayout.setVerticalGroup(
            repeatGuessWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(repeatGuessWindowLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(guessErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        winDialog.setTitle("A winner is you!");
        winDialog.setAlwaysOnTop(true);
        winDialog.setModal(true);

        winText.setEditable(false);
        winText.setBackground(new java.awt.Color(51, 51, 51));
        winText.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        winText.setForeground(new java.awt.Color(255, 255, 255));
        winText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        winText.setText("You Won!");
        winText.setBorder(null);
        winText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                winTextActionPerformed(evt);
            }
        });

        winToMainMenu.setBackground(new java.awt.Color(102, 102, 102));
        winToMainMenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        winToMainMenu.setForeground(new java.awt.Color(255, 255, 255));
        winToMainMenu.setText("Main Menu");
        winToMainMenu.setRolloverEnabled(false);
        winToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                winToMainMenuActionPerformed(evt);
            }
        });

        playAgainButton.setBackground(new java.awt.Color(102, 102, 102));
        playAgainButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        playAgainButton.setForeground(new java.awt.Color(255, 255, 255));
        playAgainButton.setText("Play Again");
        playAgainButton.setRolloverEnabled(false);
        playAgainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgainButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout winDialogLayout = new javax.swing.GroupLayout(winDialog.getContentPane());
        winDialog.getContentPane().setLayout(winDialogLayout);
        winDialogLayout.setHorizontalGroup(
            winDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winDialogLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(winDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, winDialogLayout.createSequentialGroup()
                        .addGroup(winDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(winToMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playAgainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addComponent(winText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );
        winDialogLayout.setVerticalGroup(
            winDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winDialogLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(winText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playAgainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(winToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        loseDialog.setTitle("A loser is you!");
        loseDialog.setAlwaysOnTop(true);
        loseDialog.setModal(true);

        loseText.setEditable(false);
        loseText.setBackground(new java.awt.Color(51, 51, 51));
        loseText.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        loseText.setForeground(new java.awt.Color(255, 255, 255));
        loseText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loseText.setText("You failed to guess the programming language.");
        loseText.setBorder(null);
        loseText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loseTextActionPerformed(evt);
            }
        });

        loseToMainMenu.setBackground(new java.awt.Color(102, 102, 102));
        loseToMainMenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loseToMainMenu.setForeground(new java.awt.Color(255, 255, 255));
        loseToMainMenu.setText("Main Menu");
        loseToMainMenu.setRolloverEnabled(false);
        loseToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loseToMainMenuActionPerformed(evt);
            }
        });

        playAgainButton1.setBackground(new java.awt.Color(102, 102, 102));
        playAgainButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        playAgainButton1.setForeground(new java.awt.Color(255, 255, 255));
        playAgainButton1.setText("Play Again");
        playAgainButton1.setRolloverEnabled(false);
        playAgainButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgainButton1ActionPerformed(evt);
            }
        });

        correctLanguageText.setEditable(false);
        correctLanguageText.setBackground(new java.awt.Color(51, 51, 51));
        correctLanguageText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        correctLanguageText.setForeground(new java.awt.Color(255, 255, 255));
        correctLanguageText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        correctLanguageText.setBorder(null);
        correctLanguageText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correctLanguageTextActionPerformed(evt);
            }
        });

        loseText1.setEditable(false);
        loseText1.setBackground(new java.awt.Color(51, 51, 51));
        loseText1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        loseText1.setForeground(new java.awt.Color(255, 255, 255));
        loseText1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loseText1.setText("The correct language was");
        loseText1.setBorder(null);
        loseText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loseText1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loseDialogLayout = new javax.swing.GroupLayout(loseDialog.getContentPane());
        loseDialog.getContentPane().setLayout(loseDialogLayout);
        loseDialogLayout.setHorizontalGroup(
            loseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loseDialogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(loseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(loseToMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playAgainButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                .addGap(121, 121, 121))
            .addGroup(loseDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loseText, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(loseDialogLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(loseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(correctLanguageText)
                    .addComponent(loseText1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loseDialogLayout.setVerticalGroup(
            loseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loseDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loseText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loseText1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(correctLanguageText, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(playAgainButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loseToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hello Wordle");

        menuPanel.setBackground(new java.awt.Color(51, 51, 51));

        newGameButton.setBackground(new java.awt.Color(102, 102, 102));
        newGameButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        newGameButton.setForeground(java.awt.Color.white);
        newGameButton.setText("New Game");
        newGameButton.setDefaultCapable(false);
        newGameButton.setRolloverEnabled(false);
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(102, 102, 102));
        exitButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exitButton.setForeground(java.awt.Color.white);
        exitButton.setText("Exit");
        exitButton.setRolloverEnabled(false);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        promptLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        promptLabel1.setForeground(new java.awt.Color(255, 255, 255));
        promptLabel1.setText("Hello Wordle");

        continueButton.setBackground(new java.awt.Color(102, 102, 102));
        continueButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        continueButton.setForeground(java.awt.Color.white);
        continueButton.setText("Continue");
        continueButton.setRolloverEnabled(false);
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(promptLabel1)
                    .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(423, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(promptLabel1)
                .addGap(18, 18, 18)
                .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        gamePanel.setBackground(new java.awt.Color(51, 51, 51));

        jComboBox1.setBackground(new java.awt.Color(102, 102, 102));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Python", "C++", "Java" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        guessButton.setBackground(new java.awt.Color(102, 102, 102));
        guessButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        guessButton.setForeground(new java.awt.Color(255, 255, 255));
        guessButton.setText("Guess");
        guessButton.setRolloverEnabled(false);
        guessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessButtonActionPerformed(evt);
            }
        });

        promptLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        promptLabel.setForeground(new java.awt.Color(255, 255, 255));
        promptLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        promptLabel.setText("Hello Wordle");

        guessPanel.setBackground(new java.awt.Color(51, 51, 51));
        guessPanel.setLayout(new java.awt.GridLayout(7, 6, 4, 4));

        guess.setBackground(new java.awt.Color(153, 153, 153));
        guess.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        guess.setForeground(new java.awt.Color(255, 255, 255));
        guess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess.setText("Guess");
        guess.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess.setOpaque(true);
        guessPanel.add(guess);

        typing.setBackground(new java.awt.Color(153, 153, 153));
        typing.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        typing.setForeground(new java.awt.Color(255, 255, 255));
        typing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing.setText("Typing");
        typing.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing.setOpaque(true);
        guessPanel.add(typing);

        paradigm.setBackground(new java.awt.Color(153, 153, 153));
        paradigm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        paradigm.setForeground(new java.awt.Color(255, 255, 255));
        paradigm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm.setText("Paradigm");
        paradigm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm.setOpaque(true);
        guessPanel.add(paradigm);

        level.setBackground(new java.awt.Color(153, 153, 153));
        level.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        level.setForeground(new java.awt.Color(255, 255, 255));
        level.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level.setText("Level");
        level.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level.setOpaque(true);
        guessPanel.add(level);

        yearCreated.setBackground(new java.awt.Color(153, 153, 153));
        yearCreated.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        yearCreated.setForeground(new java.awt.Color(255, 255, 255));
        yearCreated.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearCreated.setText("Year Created");
        yearCreated.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        yearCreated.setOpaque(true);
        guessPanel.add(yearCreated);

        direction.setBackground(new java.awt.Color(153, 153, 153));
        direction.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        direction.setForeground(new java.awt.Color(255, 255, 255));
        direction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        direction.setText("Year Direction");
        direction.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        direction.setOpaque(true);
        guessPanel.add(direction);

        guess0.setBackground(new java.awt.Color(51, 51, 51));
        guess0.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        guess0.setForeground(new java.awt.Color(255, 255, 255));
        guess0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess0.setOpaque(true);
        guessPanel.add(guess0);

        typing0.setBackground(new java.awt.Color(51, 51, 51));
        typing0.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        typing0.setForeground(new java.awt.Color(255, 255, 255));
        typing0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing0.setOpaque(true);
        guessPanel.add(typing0);

        paradigm0.setBackground(new java.awt.Color(51, 51, 51));
        paradigm0.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paradigm0.setForeground(new java.awt.Color(255, 255, 255));
        paradigm0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm0.setOpaque(true);
        guessPanel.add(paradigm0);

        level0.setBackground(new java.awt.Color(51, 51, 51));
        level0.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        level0.setForeground(new java.awt.Color(255, 255, 255));
        level0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level0.setOpaque(true);
        guessPanel.add(level0);

        year0.setBackground(new java.awt.Color(51, 51, 51));
        year0.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        year0.setForeground(new java.awt.Color(255, 255, 255));
        year0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year0.setOpaque(true);
        guessPanel.add(year0);

        direction0.setBackground(new java.awt.Color(51, 51, 51));
        direction0.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        direction0.setForeground(new java.awt.Color(255, 255, 255));
        direction0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        direction0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        direction0.setOpaque(true);
        guessPanel.add(direction0);

        guess1.setBackground(new java.awt.Color(51, 51, 51));
        guess1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        guess1.setForeground(new java.awt.Color(255, 255, 255));
        guess1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess1.setOpaque(true);
        guessPanel.add(guess1);

        typing1.setBackground(new java.awt.Color(51, 51, 51));
        typing1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        typing1.setForeground(new java.awt.Color(255, 255, 255));
        typing1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing1.setOpaque(true);
        guessPanel.add(typing1);

        paradigm1.setBackground(new java.awt.Color(51, 51, 51));
        paradigm1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paradigm1.setForeground(new java.awt.Color(255, 255, 255));
        paradigm1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm1.setOpaque(true);
        guessPanel.add(paradigm1);

        level1.setBackground(new java.awt.Color(51, 51, 51));
        level1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        level1.setForeground(new java.awt.Color(255, 255, 255));
        level1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level1.setOpaque(true);
        guessPanel.add(level1);

        year1.setBackground(new java.awt.Color(51, 51, 51));
        year1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        year1.setForeground(new java.awt.Color(255, 255, 255));
        year1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year1.setOpaque(true);
        guessPanel.add(year1);

        direction1.setBackground(new java.awt.Color(51, 51, 51));
        direction1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        direction1.setForeground(new java.awt.Color(255, 255, 255));
        direction1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        direction1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        direction1.setOpaque(true);
        guessPanel.add(direction1);

        guess2.setBackground(new java.awt.Color(51, 51, 51));
        guess2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        guess2.setForeground(new java.awt.Color(255, 255, 255));
        guess2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess2.setOpaque(true);
        guessPanel.add(guess2);

        typing2.setBackground(new java.awt.Color(51, 51, 51));
        typing2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        typing2.setForeground(new java.awt.Color(255, 255, 255));
        typing2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing2.setOpaque(true);
        guessPanel.add(typing2);

        paradigm2.setBackground(new java.awt.Color(51, 51, 51));
        paradigm2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paradigm2.setForeground(new java.awt.Color(255, 255, 255));
        paradigm2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm2.setOpaque(true);
        guessPanel.add(paradigm2);

        level2.setBackground(new java.awt.Color(51, 51, 51));
        level2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        level2.setForeground(new java.awt.Color(255, 255, 255));
        level2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level2.setOpaque(true);
        guessPanel.add(level2);

        year2.setBackground(new java.awt.Color(51, 51, 51));
        year2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        year2.setForeground(new java.awt.Color(255, 255, 255));
        year2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year2.setOpaque(true);
        guessPanel.add(year2);

        direction2.setBackground(new java.awt.Color(51, 51, 51));
        direction2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        direction2.setForeground(new java.awt.Color(255, 255, 255));
        direction2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        direction2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        direction2.setOpaque(true);
        guessPanel.add(direction2);

        guess3.setBackground(new java.awt.Color(51, 51, 51));
        guess3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        guess3.setForeground(new java.awt.Color(255, 255, 255));
        guess3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess3.setOpaque(true);
        guessPanel.add(guess3);

        typing3.setBackground(new java.awt.Color(51, 51, 51));
        typing3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        typing3.setForeground(new java.awt.Color(255, 255, 255));
        typing3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing3.setOpaque(true);
        guessPanel.add(typing3);

        paradigm3.setBackground(new java.awt.Color(51, 51, 51));
        paradigm3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paradigm3.setForeground(new java.awt.Color(255, 255, 255));
        paradigm3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm3.setOpaque(true);
        guessPanel.add(paradigm3);

        level3.setBackground(new java.awt.Color(51, 51, 51));
        level3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        level3.setForeground(new java.awt.Color(255, 255, 255));
        level3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level3.setOpaque(true);
        guessPanel.add(level3);

        year3.setBackground(new java.awt.Color(51, 51, 51));
        year3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        year3.setForeground(new java.awt.Color(255, 255, 255));
        year3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year3.setOpaque(true);
        guessPanel.add(year3);

        direction3.setBackground(new java.awt.Color(51, 51, 51));
        direction3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        direction3.setForeground(new java.awt.Color(255, 255, 255));
        direction3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        direction3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        direction3.setOpaque(true);
        guessPanel.add(direction3);

        guess4.setBackground(new java.awt.Color(51, 51, 51));
        guess4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        guess4.setForeground(new java.awt.Color(255, 255, 255));
        guess4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess4.setOpaque(true);
        guessPanel.add(guess4);

        typing4.setBackground(new java.awt.Color(51, 51, 51));
        typing4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        typing4.setForeground(new java.awt.Color(255, 255, 255));
        typing4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing4.setOpaque(true);
        guessPanel.add(typing4);

        paradigm4.setBackground(new java.awt.Color(51, 51, 51));
        paradigm4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paradigm4.setForeground(new java.awt.Color(255, 255, 255));
        paradigm4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm4.setOpaque(true);
        guessPanel.add(paradigm4);

        level4.setBackground(new java.awt.Color(51, 51, 51));
        level4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        level4.setForeground(new java.awt.Color(255, 255, 255));
        level4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level4.setOpaque(true);
        guessPanel.add(level4);

        year4.setBackground(new java.awt.Color(51, 51, 51));
        year4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        year4.setForeground(new java.awt.Color(255, 255, 255));
        year4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year4.setOpaque(true);
        guessPanel.add(year4);

        direction4.setBackground(new java.awt.Color(51, 51, 51));
        direction4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        direction4.setForeground(new java.awt.Color(255, 255, 255));
        direction4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        direction4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        direction4.setOpaque(true);
        guessPanel.add(direction4);

        guess5.setBackground(new java.awt.Color(51, 51, 51));
        guess5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        guess5.setForeground(new java.awt.Color(255, 255, 255));
        guess5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guess5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        guess5.setOpaque(true);
        guessPanel.add(guess5);

        typing5.setBackground(new java.awt.Color(51, 51, 51));
        typing5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        typing5.setForeground(new java.awt.Color(255, 255, 255));
        typing5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typing5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        typing5.setOpaque(true);
        guessPanel.add(typing5);

        paradigm5.setBackground(new java.awt.Color(51, 51, 51));
        paradigm5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paradigm5.setForeground(new java.awt.Color(255, 255, 255));
        paradigm5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paradigm5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        paradigm5.setOpaque(true);
        guessPanel.add(paradigm5);

        level5.setBackground(new java.awt.Color(51, 51, 51));
        level5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        level5.setForeground(new java.awt.Color(255, 255, 255));
        level5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        level5.setOpaque(true);
        guessPanel.add(level5);

        year5.setBackground(new java.awt.Color(51, 51, 51));
        year5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        year5.setForeground(new java.awt.Color(255, 255, 255));
        year5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        year5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        year5.setOpaque(true);
        guessPanel.add(year5);

        direction5.setBackground(new java.awt.Color(51, 51, 51));
        direction5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        direction5.setForeground(new java.awt.Color(255, 255, 255));
        direction5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        direction5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 4));
        direction5.setOpaque(true);
        guessPanel.add(direction5);

        gameToMainMenu.setBackground(new java.awt.Color(102, 102, 102));
        gameToMainMenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gameToMainMenu.setForeground(new java.awt.Color(255, 255, 255));
        gameToMainMenu.setText("Main Menu");
        gameToMainMenu.setRolloverEnabled(false);
        gameToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameToMainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(guessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addGap(459, 459, 459)
                        .addComponent(gameToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guessButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(promptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(promptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(guessButton, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(guessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gameToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jComboBox1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gamePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(12, 12, 12)))
        );

        getAccessibleContext().setAccessibleDescription("Hi Mr. Rochowiak o7");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
//        Reset the game
        resetGame();

//        Select the game view
        selectGameView();
    }//GEN-LAST:event_newGameButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
//        This button also exits the program
        handleExit();
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * This function activates when the user inputs a guess. It  will update the model with the data, then update the view with the model's output
     */
    private void guessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessButtonActionPerformed

//        Gets the guess from the combo box
        String guess = (String) jComboBox1.getSelectedItem();
        
//        Gets the full Guess data from GuessHandler
        Guess userGuess = GuessHandler.getGuess(guess);
        
//        If the guess has already been entered, then output an error window and stop the user from entering it
        if(gameState.alreadyGuessed(userGuess)) {
            showGuessError();
            
//            Stop here, since nothing else needs to be done
            return;
        }
        
//        Boolean to track if the user has won the game at this point.
        boolean gameWon = userGuess.equals(gameState.correct_guess);
        
//        Add the user's guess to the game state 
        gameState.guesses_list.add(userGuess);
        
//        Then sync the view with the game model
        syncGame();
        
//        Check if the game is over. If so, check if the user won or lost
       if(gameState.gameOver()) {
//           If the game is over, check if the user has won and display win menu if so.
           if(gameWon) {
               showWinDialog();
           }
//           If the user has lost, then display the lose menu
           if(!gameWon) {
               showLoseDialog();
           }
       }
    }//GEN-LAST:event_guessButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void guessErrorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessErrorTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guessErrorTextActionPerformed

    /**
     * The continue button will simply put the user in the game menu to continue their previous session
     */
    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
        selectGameView();
    }//GEN-LAST:event_continueButtonActionPerformed
    
    /**
     * This button takes the user from the game menu to the main menu
     */
    private void gameToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameToMainMenuActionPerformed
        selectMainView();
        continueButton.setEnabled(true);
    }//GEN-LAST:event_gameToMainMenuActionPerformed

    private void winTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_winTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_winTextActionPerformed

    /**
     * Hides the win menu and sends the user to the main menu
     */
    private void winToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_winToMainMenuActionPerformed
        selectMainView();
        
        winDialog.setVisible(false);
    }//GEN-LAST:event_winToMainMenuActionPerformed

    /**
     * Resets the game and hides the win menu
     */
    private void playAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgainButtonActionPerformed
        resetGame();
        
        winDialog.setVisible(false);
    }//GEN-LAST:event_playAgainButtonActionPerformed

    private void loseTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loseTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loseTextActionPerformed

    /**
     * Hides the lose menu and sends the user to the main menu
     */
    private void loseToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loseToMainMenuActionPerformed
        selectMainView();
        
        loseDialog.setVisible(false);
    }//GEN-LAST:event_loseToMainMenuActionPerformed

    /**
     * Resets the game and hides the lose menu
     */
    private void playAgainButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgainButton1ActionPerformed
        resetGame();
        
        loseDialog.setVisible(false);
    }//GEN-LAST:event_playAgainButton1ActionPerformed

    private void correctLanguageTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correctLanguageTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correctLanguageTextActionPerformed

    private void loseText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loseText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loseText1ActionPerformed

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
    private javax.swing.JButton continueButton;
    private javax.swing.JTextField correctLanguageText;
    private javax.swing.JLabel direction;
    private javax.swing.JLabel direction0;
    private javax.swing.JLabel direction1;
    private javax.swing.JLabel direction2;
    private javax.swing.JLabel direction3;
    private javax.swing.JLabel direction4;
    private javax.swing.JLabel direction5;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JButton gameToMainMenu;
    private javax.swing.JLabel guess;
    private javax.swing.JLabel guess0;
    private javax.swing.JLabel guess1;
    private javax.swing.JLabel guess2;
    private javax.swing.JLabel guess3;
    private javax.swing.JLabel guess4;
    private javax.swing.JLabel guess5;
    private javax.swing.JButton guessButton;
    private javax.swing.JTextField guessErrorText;
    private javax.swing.JPanel guessPanel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel level;
    private javax.swing.JLabel level0;
    private javax.swing.JLabel level1;
    private javax.swing.JLabel level2;
    private javax.swing.JLabel level3;
    private javax.swing.JLabel level4;
    private javax.swing.JLabel level5;
    private javax.swing.JDialog loseDialog;
    private javax.swing.JTextField loseText;
    private javax.swing.JTextField loseText1;
    private javax.swing.JButton loseToMainMenu;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton newGameButton;
    private javax.swing.JLabel paradigm;
    private javax.swing.JLabel paradigm0;
    private javax.swing.JLabel paradigm1;
    private javax.swing.JLabel paradigm2;
    private javax.swing.JLabel paradigm3;
    private javax.swing.JLabel paradigm4;
    private javax.swing.JLabel paradigm5;
    private javax.swing.JButton playAgainButton;
    private javax.swing.JButton playAgainButton1;
    private javax.swing.JLabel promptLabel;
    private javax.swing.JLabel promptLabel1;
    private javax.swing.JDialog repeatGuessWindow;
    private javax.swing.JLabel typing;
    private javax.swing.JLabel typing0;
    private javax.swing.JLabel typing1;
    private javax.swing.JLabel typing2;
    private javax.swing.JLabel typing3;
    private javax.swing.JLabel typing4;
    private javax.swing.JLabel typing5;
    private javax.swing.JDialog winDialog;
    private javax.swing.JTextField winText;
    private javax.swing.JButton winToMainMenu;
    private javax.swing.JLabel year0;
    private javax.swing.JLabel year1;
    private javax.swing.JLabel year2;
    private javax.swing.JLabel year3;
    private javax.swing.JLabel year4;
    private javax.swing.JLabel year5;
    private javax.swing.JLabel yearCreated;
    // End of variables declaration//GEN-END:variables
}

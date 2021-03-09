import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Toolkit;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author TonyDiaz stans
 */
public class Sudoku extends javax.swing.JFrame implements KeyListener {
    
    int sudokuScore = 540; 
    int finalScore;
    int score;
    int correctBoxes = 54;
    
    // 2d array = [[name of the textfield][input of the textfield]];
    /*["A5"][], ["A6"][], ["A7"][], ["A9"][],
                             ["B2"][], ["B3"][], ["B4"[], ["B5"][], ["B6"][], ["B7"][], ["B8"][], ["B9"][],
                             ["C1"][], ["C2"][], ["C5"][], ["C6"][], ["C9"][],
                             ["D2"][], ["D4"][], ["D5"][], ["D6"][], ["D7"][],
                             ["E1"][], ["E3"][], ["E4"][], ["E6"][], ["E7"][], ["E9"][],
                             ["F3"][], ["F4"][], ["F5"][], ["F6"][], ["F8"[],
                             ["G1"][], ["G4"][], ["G5"][], ["G8"][], ["G9"][],
                             ["H1"][], ["H2"][], ["H3"[], ["H4"][], ["H5"][],["H6"][], ["H8"][],
                             ["I1"][], ["I3"][], ["I4"][], ["I5"][], ["I6"][], ["I7"][], ["I8"][] */
    
    public String[][] tdArray = {{"A2","3"},{"A3","5"},{"A4","2"}};
    
    public String[] array = {"A2",  "A3" , "A4", "A5", "A6", "A7", "A9",
                             "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9",
                             "C1", "C2", "C5", "C6", "C9",
                             "D2", "D4", "D5", "D6", "D7",
                             "E1", "E3", "E4", "E6", "E7", "E9",
                             "F3", "F4", "F5", "F6", "F8",
                             "G1", "G4", "G5", "G8", "G9",
                             "H1", "H2", "H3", "H4", "H5","H6", "H8",
                             "I1", "I3", "I4", "I5", "I6", "I7", "I8"};
        
    public int[] error = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    
    Timer timer; 
    public Sudoku() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(250, 250, 250));
        setLocationRelativeTo(null);
        startTimer(); 
        addKeyListener(this); 
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);  
        checkGame();
    }
    
    public Sudoku(int s){
        initComponents();
        getContentPane().setBackground(new java.awt.Color(250, 250, 250));
        setLocationRelativeTo(null);
        startTimer(); 
        addKeyListener(this); 
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        checkGame(); 
        score = s; 
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key typed"); 
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_F1){
            JOptionPane.showMessageDialog(this, "Vicnent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
                    "Nhi Nguyen #013925392 \n" + "Term: Spring 2021", "Swing Project", JOptionPane.PLAIN_MESSAGE);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) { 
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_F1){
            JOptionPane.showMessageDialog(this, "Vicnent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
                    "Nhi Nguyen #013925392 \n" + "Term: Spring 2021", "Swing Project", JOptionPane.PLAIN_MESSAGE);
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_F1){
            JOptionPane.showMessageDialog(this, "Vicnent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
                    "Nhi Nguyen #013925392 \n" + "Term: Spring 2021", "Swing Project", JOptionPane.PLAIN_MESSAGE);
        }
        throw new UnsupportedOperationException("Not supported yet.");
        
    } 
    
    public void startTimer() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); 
                String time = timeFormat.format(date); 
                
                Date date2 = new Date(); 
                DateFormat timeFormat2 = new SimpleDateFormat("dd/MM/yyyy"); 
                String time2 = timeFormat2.format(date2); 
                time_dateLabel.setText(time2 + "   " + time);
            }
        }; 
        timer = new Timer(1000, actionListener); 
        timer.setInitialDelay(0); 
        timer.start();
    }

    public void wrongScore(){
        sudokuScore -= 10;
        System.out.println(sudokuScore);
    }
    
    public void rightScore() throws IOException {
        correctBoxes--; 
        if(correctBoxes == 0){
            score += sudokuScore;  
            setVisible(false);
            new EndScreen(score).setVisible(true);
            setVisible(false);
            this.dispose();
        }
    }
    
    public void checkGame(){
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // A Panel 
                int a2value = Integer.parseInt(A2.getText());
                /*int i = 0;
                int j = 0;

                if ( (tdArray[i][j].equals(A2.getName())) && !(A2.getText().equals(tdArray[i][j+1]))) {
                    if (error[i] != 1) {
                        wrongScore();
                        A2.setForeground(Color.RED);
                        error[i] = 1;
                        System.out.println(A2.getText());
                                
                        System.out.println(tdArray[i][j]);
                    } else {
                        System.out.println("no more subtracting points");
                    } 
                }
                else {
                    System.out.println("correct!");    
                }
                if ( (tdArray[i+1][j+1].equals(A3.getName())) && !(A3.getText().equals(tdArray[i+1][j+2]))) {
                    if (error[i+1] != 1) {
                        wrongScore();
                        A3.setForeground(Color.RED);
                        error[i+1] = 1;
                        System.out.println(A3.getText());
                                
                        System.out.println(tdArray[i+1][j+1]);
                    } else {
                        System.out.println("no more subtracting points");
                    } 
                }
                else {
                    System.out.println("correct!");    
                }
                */    
                
                if(!(a2value == 3)){
                for (int i = 0; i < array.length; i++) {
                        if (A2.getName().equals(array[i])) {
                                if (error[i] != 1) {
                                    wrongScore();
                                    A2.setForeground(Color.RED);
                                    error[i] = 1;
                                } else {
                                    System.out.println("no more subtracting points");
                                } 
                        }                      
                } }
                else{
                    try {
                        rightScore();
                        A2.setForeground(Color.BLACK);
                        A2.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int a3value = Integer.parseInt(A3.getText());
                if (!(a3value == 5)){
                   for (int i = 0; i < array.length; i++) {
                        if (A3.getName().equals(array[i])) {
                                if (error[i] != 1) {
                                    wrongScore();
                                    A3.setForeground(Color.RED);
                                    error[i] = 1;
                                } else {
                                    System.out.println("no more subtracting points");
                                } 
                        }                      
                }
                }
                else{
                    try {
                        rightScore();
                        A3.setForeground(Color.BLACK);
                        A3.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int a4value = Integer.parseInt(A4.getText());
                if(!(a4value == 2)){
                    for (int i = 0; i < array.length; i++) {
                        if (A4.getName().equals(array[i])) {
                                if (error[i] != 1) {
                                    wrongScore();
                                    A4.setForeground(Color.RED);
                                    error[i] = 1;
                                } else {
                                    System.out.println("no more subtracting points");
                                } 
                        }                      
                }
                }
                else{
                    try {
                        rightScore();
                        A4.setForeground(Color.BLACK);
                        A4.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int a5value = Integer.parseInt(A5.getText());
                if(!(a5value == 9)){
                    for (int i = 0; i < array.length; i++) {
                        if (A5.getName().equals(array[i])) {
                                if (error[i] != 1) {
                                    wrongScore();
                                    A5.setForeground(Color.RED);
                                    error[i] = 1;
                                } else {
                                    System.out.println("no more subtracting points");
                                } 
                        }                      
                }
                }
                else{
                    try {
                        rightScore();
                        A5.setForeground(Color.BLACK);
                        A5.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int a6value = Integer.parseInt(A6.getText());
                if(!(a6value == 6)){
                    for (int i = 0; i < array.length; i++) {
                        if (A6.getName().equals(array[i])) {
                                if (error[i] != 1) {
                                    wrongScore();
                                    A6.setForeground(Color.RED);
                                    error[i] = 1;
                                } else {
                                    System.out.println("no more subtracting points");
                                } 
                        }                      
                }
                }
                else{
                    try {
                        rightScore();
                        A6.setForeground(Color.BLACK);
                        A6.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int a7value = Integer.parseInt(A7.getText());
                if(!(a7value == 4)){
                    for (int i = 0; i < array.length; i++) {
                        if (A7.getName().equals(array[i])) {
                                if (error[i] != 1) {
                                    wrongScore();
                                    A7.setForeground(Color.RED);
                                    error[i] = 1;
                                } else {
                                    System.out.println("no more subtracting points");
                                } 
                        }                      
                }
                }
                else{
                    try {
                        rightScore();
                        A7.setForeground(Color.BLACK);
                        A7.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int a9value = Integer.parseInt(A9.getText());
                if(!(a9value == 7)){
                    for (int i = 0; i < array.length; i++) {
                        if (A9.getName().equals(array[i])) {
                                if (error[i] != 1) {
                                    wrongScore();
                                    A9.setForeground(Color.RED);
                                    error[i] = 1;
                                } else {
                                    System.out.println("no more subtracting points");
                                } 
                        }                      
                }
                }
                else{
                    try {
                        rightScore();
                        A9.setForeground(Color.BLACK);
                        A9.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                // B Panel
                int b2value = Integer.parseInt(B2.getText());
                if(!(b2value == 1)){
                    wrongScore(); 
                    B2.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        B2.setForeground(Color.BLACK);
                        B2.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int b4value = Integer.parseInt(B4.getText());
                if(!(b4value == 8)){
                    wrongScore();
                    B4.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        B4.setForeground(Color.BLACK);
                        B4.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int b5value = Integer.parseInt(B5.getText());
                if(!(b5value == 5)){
                    wrongScore();
                    B5.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        B5.setForeground(Color.BLACK);
                        B5.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int b6value = Integer.parseInt(B6.getText());
                if(!(b6value == 7)){
                    wrongScore();
                    B6.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        B6.setForeground(Color.BLACK);
                        B6.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int b7value = Integer.parseInt(B7.getText());
                if(!(b7value == 2)){
                    wrongScore(); 
                    B7.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        B7.setForeground(Color.BLACK);
                        B7.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int b8value = Integer.parseInt(B8.getText());
                if(!(b8value == 9)){
                    wrongScore();
                    B8.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        B8.setForeground(Color.BLACK);
                        B8.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int b9value = Integer.parseInt(B9.getText());
                if(!(b9value == 3)){
                    wrongScore(); 
                    B9.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        B9.setForeground(Color.BLACK);
                        B9.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                // C Panel
                int c1value = Integer.parseInt(C1.getText());
                if(!(c1value == 9)){
                    wrongScore(); 
                    C1.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        C1.setForeground(Color.BLACK);
                        C1.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int c2value = Integer.parseInt(C2.getText());
                if(!(c2value == 2)){
                    wrongScore(); 
                    C2.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        C2.setForeground(Color.BLACK);
                        C2.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int c5value = Integer.parseInt(C5.getText());
                if(!(c5value == 3)){
                    wrongScore(); 
                    C5.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        C5.setForeground(Color.BLACK);
                        C5.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int c6value = Integer.parseInt(C6.getText());
                if(!(c6value == 1)){
                    wrongScore(); 
                    C6.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        C6.setForeground(Color.BLACK);
                        C6.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int c9value = Integer.parseInt(C9.getText());
                if(!(c9value == 8)){
                    wrongScore();
                    C9.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        C9.setForeground(Color.BLACK);
                        C9.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                // D Panel
                int d2value = Integer.parseInt(D2.getText());
                if(!(d2value == 6)){
                    wrongScore(); 
                    D2.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        D2.setForeground(Color.BLACK);
                        D2.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int d4value = Integer.parseInt(D4.getText());
                if(!(d4value == 1)){
                    wrongScore();
                    D4.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        D4.setForeground(Color.BLACK);
                        D4.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int d5value = Integer.parseInt(D5.getText());
                if(!(d5value == 2)){
                    wrongScore(); 
                    D5.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        D5.setForeground(Color.BLACK);
                        D5.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int d6value = Integer.parseInt(D6.getText());
                if(!(d6value == 3)){
                    wrongScore();
                    D6.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        D6.setForeground(Color.BLACK);
                        D6.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int d7value = Integer.parseInt(D7.getText());
                if(!(d7value == 7)){
                    wrongScore(); 
                    D7.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        D7.setForeground(Color.BLACK);
                        D7.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                 // PANEL E
                int e1value = Integer.parseInt(E1.getText());
                if(!(e1value == 1)){
                    wrongScore();
                    E1.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        E1.setForeground(Color.BLACK);
                        E1.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int e3value = Integer.parseInt(E3.getText());
                if(!(e3value == 4)){
                    wrongScore();
                    E3.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        E3.setForeground(Color.BLACK);
                        E3.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int e4value = Integer.parseInt(E4.getText());
                if(!(e4value == 6)){
                   wrongScore();
                   E4.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        E4.setForeground(Color.BLACK);
                        E4.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int e6value = Integer.parseInt(E6.getText());
                if(!(e6value == 8)){
                   wrongScore();
                   E6.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        E6.setForeground(Color.BLACK);
                        E6.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int e7value = Integer.parseInt(E7.getText());
                if(!(e7value == 5)){
                   wrongScore();
                   E7.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        E7.setForeground(Color.BLACK);
                        E7.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int e9value = Integer.parseInt(E9.getText());
                if(!(e9value == 9)){
                   wrongScore();
                   E9.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        E9.setForeground(Color.BLACK);
                        E9.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                // PANEL F
                int f3value = Integer.parseInt(F3.getText());
                if(!(f3value == 2)){
                   wrongScore();
                   F3.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        F3.setForeground(Color.BLACK);
                        F3.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int f4value = Integer.parseInt(F4.getText());
                if(!(f4value == 5)){
                   wrongScore();
                   F4.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        F4.setForeground(Color.BLACK);
                        F4.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int f5value = Integer.parseInt(F5.getText());
                if(!(f5value == 4)){
                   wrongScore();
                   F5.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        F5.setForeground(Color.BLACK);
                        F5.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int f6value = Integer.parseInt(F6.getText());
                if(!(f6value == 9)){
                   wrongScore();
                   F6.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        F6.setForeground(Color.BLACK);
                        F6.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int f8value = Integer.parseInt(F8.getText());
                if(!(f8value == 6)){
                   wrongScore(); 
                   F8.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        F8.setForeground(Color.BLACK);
                        F8.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                // PANEL G
                int g1value = Integer.parseInt(G1.getText());
                if(!(g1value == 6)){
                   wrongScore();
                   G1.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        G1.setForeground(Color.BLACK);
                        G1.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int g4value = Integer.parseInt(G4.getText());
                if(!(g4value == 9)){
                   wrongScore();
                   G4.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        G4.setForeground(Color.BLACK);
                        G4.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int g5value = Integer.parseInt(G5.getText());
                if(!(g5value == 8)){
                   wrongScore();
                   G5.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        G5.setForeground(Color.BLACK);
                        G5.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int g8value = Integer.parseInt(G8.getText());
                if(!(g8value == 7)){
                   wrongScore();
                   G8.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        G8.setForeground(Color.BLACK);
                        G8.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int g9value = Integer.parseInt(G9.getText());
                if(!(g9value == 4)){
                   wrongScore();
                   G9.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        G9.setForeground(Color.BLACK);
                        G9.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                // PANEL H
                int h1value = Integer.parseInt(H1.getText());
                if(!(h1value == 7)){
                   wrongScore();
                   H1.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        H1.setForeground(Color.BLACK);
                        H1.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int h2value = Integer.parseInt(H2.getText());
                if(!(h2value == 8)){
                   wrongScore();
                   H2.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        H2.setForeground(Color.BLACK);
                        H2.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int h3value = Integer.parseInt(H3.getText());
                if(!(h3value == 1)){
                   wrongScore();
                   H3.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        H3.setForeground(Color.BLACK);
                        H3.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int h4value = Integer.parseInt(H4.getText());
                if(!(h4value == 3)){
                   wrongScore();
                   H4.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        H4.setForeground(Color.BLACK);
                        H4.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int h5value = Integer.parseInt(H5.getText());
                if(!(h5value == 4)){
                   wrongScore();
                   H5.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        H5.setForeground(Color.BLACK);
                        H5.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int h6value = Integer.parseInt(H6.getText());
                if(!(h6value == 5)){
                   wrongScore();
                   H6.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        H6.setForeground(Color.BLACK);
                        H6.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int h8value = Integer.parseInt(H8.getText());
                if(!(h8value == 6)){
                   wrongScore();
                   H8.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        H8.setForeground(Color.BLACK);
                        H8.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                // I Panel 
                int i1value = Integer.parseInt(I1.getText());
                if(!(i1value == 3)){
                    wrongScore();
                    I1.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        I1.setForeground(Color.BLACK);
                        I1.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int i3value = Integer.parseInt(I3.getText());
                if(!(i3value == 4)){
                    wrongScore();
                    I3.setForeground(Color.RED);
                }else{
                    try {
                        rightScore();
                        I3.setForeground(Color.BLACK);
                        I3.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int i4value = Integer.parseInt(I4.getText());
                if(!(i4value == 2)){
                    wrongScore();
                    I4.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        I4.setForeground(Color.BLACK);
                        I4.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int i5value = Integer.parseInt(I5.getText());
                if(!(i5value == 7)){
                    wrongScore(); 
                    I5.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        I5.setForeground(Color.BLACK);
                        I5.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int i6value = Integer.parseInt(I6.getText());
                if(!(i6value == 6)){
                    wrongScore();
                    I6.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        I6.setForeground(Color.BLACK);
                        I6.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int i7value = Integer.parseInt(I7.getText());
                if(!(i7value == 8)){
                    wrongScore();
                    I7.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        I7.setForeground(Color.BLACK);
                        I7.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int i8value = Integer.parseInt(I8.getText());
                if(!(i8value == 1)){
                    wrongScore(); 
                    I8.setForeground(Color.RED);
                }
                else{
                    try {
                        rightScore();
                        I8.setForeground(Color.BLACK);
                        I8.setEnabled(false);
                    } catch (IOException ex) {
                        Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
            }
        }); 
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        time_dateLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        A1 = new javax.swing.JLabel();
        A2 = new javax.swing.JTextField();
        A3 = new javax.swing.JTextField();
        A5 = new javax.swing.JTextField();
        A4 = new javax.swing.JTextField();
        A6 = new javax.swing.JTextField();
        A7 = new javax.swing.JTextField();
        A9 = new javax.swing.JTextField();
        A8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        I3 = new javax.swing.JTextField();
        I5 = new javax.swing.JTextField();
        I4 = new javax.swing.JTextField();
        I6 = new javax.swing.JTextField();
        I7 = new javax.swing.JTextField();
        I8 = new javax.swing.JTextField();
        I1 = new javax.swing.JTextField();
        I2 = new javax.swing.JLabel();
        I9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        B1 = new javax.swing.JLabel();
        B2 = new javax.swing.JTextField();
        B5 = new javax.swing.JTextField();
        B4 = new javax.swing.JTextField();
        B6 = new javax.swing.JTextField();
        B7 = new javax.swing.JTextField();
        B8 = new javax.swing.JTextField();
        B9 = new javax.swing.JTextField();
        B3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        C2 = new javax.swing.JTextField();
        C5 = new javax.swing.JTextField();
        C6 = new javax.swing.JTextField();
        C9 = new javax.swing.JTextField();
        C1 = new javax.swing.JTextField();
        C4 = new javax.swing.JLabel();
        C7 = new javax.swing.JLabel();
        C8 = new javax.swing.JLabel();
        C3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        E3 = new javax.swing.JTextField();
        E4 = new javax.swing.JTextField();
        E6 = new javax.swing.JTextField();
        E7 = new javax.swing.JTextField();
        E9 = new javax.swing.JTextField();
        E1 = new javax.swing.JTextField();
        E2 = new javax.swing.JLabel();
        E5 = new javax.swing.JLabel();
        E8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        F1 = new javax.swing.JLabel();
        F3 = new javax.swing.JTextField();
        F5 = new javax.swing.JTextField();
        F4 = new javax.swing.JTextField();
        F6 = new javax.swing.JTextField();
        F8 = new javax.swing.JTextField();
        F2 = new javax.swing.JLabel();
        F7 = new javax.swing.JLabel();
        F9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        D1 = new javax.swing.JLabel();
        D2 = new javax.swing.JTextField();
        D5 = new javax.swing.JTextField();
        D4 = new javax.swing.JTextField();
        D6 = new javax.swing.JTextField();
        D7 = new javax.swing.JTextField();
        D3 = new javax.swing.JLabel();
        D8 = new javax.swing.JLabel();
        D9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        G5 = new javax.swing.JTextField();
        G4 = new javax.swing.JTextField();
        G8 = new javax.swing.JTextField();
        G9 = new javax.swing.JTextField();
        G1 = new javax.swing.JTextField();
        G2 = new javax.swing.JLabel();
        G3 = new javax.swing.JLabel();
        G6 = new javax.swing.JLabel();
        G7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        H2 = new javax.swing.JTextField();
        H3 = new javax.swing.JTextField();
        H5 = new javax.swing.JTextField();
        H4 = new javax.swing.JTextField();
        H6 = new javax.swing.JTextField();
        H8 = new javax.swing.JTextField();
        H1 = new javax.swing.JTextField();
        H9 = new javax.swing.JLabel();
        H7 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        time_dateLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 8)); // NOI18N
        time_dateLabel.setText("Time and Date");
        time_dateLabel.setMaximumSize(null);
        time_dateLabel.setMinimumSize(null);
        time_dateLabel.setPreferredSize(new java.awt.Dimension(131, 121));

        jPanel1.setMaximumSize(null);
        jPanel1.setPreferredSize(new java.awt.Dimension(151, 121));

        A1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        A1.setText("8");
        A1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        A2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A2.setToolTipText("");
        A2.setActionCommand("<Not Set>");
        A2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A2.setName("A2"); // NOI18N
        A2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A2KeyTyped(evt);
            }
        });

        A3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A3.setName("A3"); // NOI18N
        A3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A3KeyTyped(evt);
            }
        });

        A5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A5.setName("A5"); // NOI18N
        A5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A5KeyTyped(evt);
            }
        });

        A4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A4.setName("A4"); // NOI18N
        A4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A4KeyTyped(evt);
            }
        });

        A6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A6.setName("A6"); // NOI18N
        A6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A6KeyTyped(evt);
            }
        });

        A7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A7.setName("A7"); // NOI18N
        A7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A7KeyTyped(evt);
            }
        });

        A9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A9.setName("A9"); // NOI18N
        A9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A9KeyTyped(evt);
            }
        });

        A8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        A8.setText("1");
        A8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(A7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(A8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(A9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setMaximumSize(null);
        jPanel2.setPreferredSize(new java.awt.Dimension(151, 121));

        I3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I3.setName("I3"); // NOI18N
        I3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I3KeyTyped(evt);
            }
        });

        I5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I5.setName("I5"); // NOI18N
        I5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I5KeyTyped(evt);
            }
        });

        I4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I4.setName("I4"); // NOI18N
        I4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I4KeyTyped(evt);
            }
        });

        I6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I6.setName("I6"); // NOI18N
        I6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I6KeyTyped(evt);
            }
        });

        I7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I7.setName("I7"); // NOI18N
        I7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I7KeyTyped(evt);
            }
        });

        I8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I8.setName("I8"); // NOI18N
        I8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I8KeyTyped(evt);
            }
        });

        I1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I1.setName("I1"); // NOI18N
        I1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I1KeyTyped(evt);
            }
        });

        I2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        I2.setText("9");
        I2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        I9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        I9.setText("5");
        I9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(I4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(I5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(I1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(I2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(I3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(I7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(I8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(I9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(I3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(I1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(I2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(I5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(I4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(I6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(I7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(I8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(I9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setMaximumSize(null);
        jPanel3.setPreferredSize(new java.awt.Dimension(151, 121));

        B1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        B1.setText("4");
        B1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        B2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B2.setName("B2"); // NOI18N
        B2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B2KeyTyped(evt);
            }
        });

        B5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B5.setName("B5"); // NOI18N
        B5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B5KeyTyped(evt);
            }
        });

        B4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B4.setName("B4"); // NOI18N
        B4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B4KeyTyped(evt);
            }
        });

        B6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B6.setName("B6"); // NOI18N
        B6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B6KeyTyped(evt);
            }
        });

        B7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B7.setName("B7"); // NOI18N
        B7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B7KeyTyped(evt);
            }
        });

        B8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B8.setName("B8"); // NOI18N
        B8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B8KeyTyped(evt);
            }
        });

        B9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B9.setName("B9"); // NOI18N
        B9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B9KeyTyped(evt);
            }
        });

        B3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        B3.setText("6");
        B3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel4.setMaximumSize(null);
        jPanel4.setPreferredSize(new java.awt.Dimension(151, 121));

        C2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C2.setName("C2"); // NOI18N
        C2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C2KeyTyped(evt);
            }
        });

        C5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C5.setName("C5"); // NOI18N
        C5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C5KeyTyped(evt);
            }
        });

        C6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C6.setName("C6"); // NOI18N
        C6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C6KeyTyped(evt);
            }
        });

        C9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C9.setName("C9"); // NOI18N
        C9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C9KeyTyped(evt);
            }
        });

        C1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C1.setName("C1"); // NOI18N
        C1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C1KeyTyped(evt);
            }
        });

        C4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C4.setText("4");
        C4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        C7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C7.setText("6");
        C7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        C8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C8.setText("5");
        C8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        C3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        C3.setText("7");
        C3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(C7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setMaximumSize(null);
        jPanel5.setPreferredSize(new java.awt.Dimension(151, 121));

        E3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E3.setName("E3"); // NOI18N
        E3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E3KeyTyped(evt);
            }
        });

        E4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E4.setName("E4"); // NOI18N
        E4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E4KeyTyped(evt);
            }
        });

        E6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E6.setName("E6"); // NOI18N
        E6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E6KeyTyped(evt);
            }
        });

        E7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E7.setName("E7"); // NOI18N
        E7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E7KeyTyped(evt);
            }
        });

        E9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E9.setName("E9"); // NOI18N
        E9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E9KeyTyped(evt);
            }
        });

        E1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E1.setName("E1"); // NOI18N
        E1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E1KeyTyped(evt);
            }
        });

        E2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        E2.setText("3");
        E2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        E5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        E5.setText("7");
        E5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        E8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        E8.setText("2");
        E8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(E4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(E6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(E7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(E9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(E4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(E7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jPanel6.setMaximumSize(null);
        jPanel6.setPreferredSize(new java.awt.Dimension(151, 121));

        F1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F1.setText("7");
        F1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        F3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F3.setName("F3"); // NOI18N
        F3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                F3KeyTyped(evt);
            }
        });

        F5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F5.setName("F5"); // NOI18N
        F5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                F5KeyTyped(evt);
            }
        });

        F4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F4.setName("F4"); // NOI18N
        F4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                F4KeyTyped(evt);
            }
        });

        F6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F6.setName("F6"); // NOI18N
        F6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                F6KeyTyped(evt);
            }
        });

        F8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F8.setName("F8"); // NOI18N
        F8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                F8KeyTyped(evt);
            }
        });

        F2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F2.setText("8");
        F2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        F7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F7.setText("1");
        F7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        F9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F9.setText("3");
        F9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(F9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setMaximumSize(null);
        jPanel7.setPreferredSize(new java.awt.Dimension(151, 121));

        D1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D1.setText("5");
        D1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        D2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D2.setName("D2"); // NOI18N
        D2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                D2KeyTyped(evt);
            }
        });

        D5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D5.setName("D5"); // NOI18N
        D5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                D5KeyTyped(evt);
            }
        });

        D4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D4.setName("D4"); // NOI18N
        D4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                D4KeyTyped(evt);
            }
        });

        D6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D6.setName("D6"); // NOI18N
        D6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                D6KeyTyped(evt);
            }
        });

        D7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D7.setName("D7"); // NOI18N
        D7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                D7KeyTyped(evt);
            }
        });

        D3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D3.setText("9");
        D3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        D8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D8.setText("4");
        D8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        D9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D9.setText("8");
        D9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(D6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(D7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(D8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(D9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(D7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel8.setMaximumSize(null);
        jPanel8.setPreferredSize(new java.awt.Dimension(151, 121));

        G5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G5.setName("G5"); // NOI18N
        G5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                G5KeyTyped(evt);
            }
        });

        G4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G4.setName("G4"); // NOI18N
        G4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                G4KeyTyped(evt);
            }
        });

        G8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G8.setName("G8"); // NOI18N
        G8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                G8KeyTyped(evt);
            }
        });

        G9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G9.setName("G9"); // NOI18N
        G9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                G9KeyTyped(evt);
            }
        });

        G1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G1.setName("G1"); // NOI18N
        G1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                G1KeyTyped(evt);
            }
        });

        G2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G2.setText("5");
        G2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        G3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G3.setText("2");
        G3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        G6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G6.setText("1");
        G6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        G7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G7.setText("3");
        G7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(G7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(G8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(G9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(G6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(G8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel9.setMaximumSize(null);
        jPanel9.setPreferredSize(new java.awt.Dimension(151, 121));

        H2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H2.setName("H2"); // NOI18N
        H2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H2KeyTyped(evt);
            }
        });

        H3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H3.setName("H3"); // NOI18N
        H3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H3KeyTyped(evt);
            }
        });

        H5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H5.setName("H5"); // NOI18N
        H5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H5KeyTyped(evt);
            }
        });

        H4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H4.setName("H4"); // NOI18N
        H4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H4KeyTyped(evt);
            }
        });

        H6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H6.setName("H6"); // NOI18N
        H6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H6KeyTyped(evt);
            }
        });

        H8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H8.setName("H8"); // NOI18N
        H8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H8KeyTyped(evt);
            }
        });

        H1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H1.setName("H1"); // NOI18N
        H1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H1KeyTyped(evt);
            }
        });

        H9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        H9.setText("2");
        H9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        H7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        H7.setText("9");
        H7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(H3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(H8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(H9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(H8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quitButton)
                            .addComponent(submitButton))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(time_dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(time_dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(submitButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitButton))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

    }//GEN-LAST:event_submitButtonActionPerformed

    private void A2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A2KeyTyped
        int c = evt.getKeyChar(); 
        if(A2.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_A2KeyTyped

    private void A3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A3KeyTyped
        int c = evt.getKeyChar(); 
        if(A3.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_A3KeyTyped

    private void A4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A4KeyTyped
        int c = evt.getKeyChar(); 
        if(A4.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_A4KeyTyped

    private void A5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A5KeyTyped
        int c = evt.getKeyChar(); 
        if(A5.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_A5KeyTyped

    private void A6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A6KeyTyped
        int c = evt.getKeyChar(); 
        if(A6.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_A6KeyTyped

    private void A7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A7KeyTyped
        int c = evt.getKeyChar(); 
        if(A7.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_A7KeyTyped

    private void A9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A9KeyTyped
        int c = evt.getKeyChar(); 
        if(A9.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_A9KeyTyped

    // B Panel
    private void B2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B2KeyTyped
        int c = evt.getKeyChar(); 
        if(B2.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_B2KeyTyped

    private void B4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B4KeyTyped
        int c = evt.getKeyChar(); 
        if(B4.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_B4KeyTyped

    private void B5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B5KeyTyped
        int c = evt.getKeyChar(); 
        if(B5.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_B5KeyTyped

    private void B6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B6KeyTyped
        int c = evt.getKeyChar(); 
        if(B6.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_B6KeyTyped

    private void B7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B7KeyTyped
        int c = evt.getKeyChar(); 
        if(B7.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_B7KeyTyped

    private void B8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B8KeyTyped
        int c = evt.getKeyChar(); 
        if(B8.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_B8KeyTyped

    private void B9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B9KeyTyped
        int c = evt.getKeyChar(); 
        if(B9.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_B9KeyTyped

    // C Panel
    private void C1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C1KeyTyped
        int c = evt.getKeyChar(); 
        if(C1.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_C1KeyTyped

    private void C2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C2KeyTyped
        int c = evt.getKeyChar(); 
        if(C2.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_C2KeyTyped

    private void C5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C5KeyTyped
        int c = evt.getKeyChar(); 
        if(C5.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_C5KeyTyped

    private void C6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C6KeyTyped
        int c = evt.getKeyChar(); 
        if(C6.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_C6KeyTyped

    private void C9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C9KeyTyped
        int c = evt.getKeyChar(); 
        if(C9.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_C9KeyTyped

    // D Panel
    private void D2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D2KeyTyped
        int c = evt.getKeyChar(); 
        if(D2.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_D2KeyTyped

    private void D4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D4KeyTyped
        int c = evt.getKeyChar(); 
        if(D4.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_D4KeyTyped

    private void D5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D5KeyTyped
        int c = evt.getKeyChar(); 
        if(D5.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_D5KeyTyped

    private void D6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D6KeyTyped
        int c = evt.getKeyChar(); 
        if(D6.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_D6KeyTyped

    private void D7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D7KeyTyped
        int c = evt.getKeyChar(); 
        if(D7.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_D7KeyTyped

    // E Panel
    private void E1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E1KeyTyped
        int c = evt.getKeyChar(); 
        if(E1.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_E1KeyTyped

    private void E3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E3KeyTyped
        int c = evt.getKeyChar(); 
        if(E3.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_E3KeyTyped

    private void E4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E4KeyTyped
        int c = evt.getKeyChar(); 
        if(E4.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_E4KeyTyped

    private void E6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E6KeyTyped
        int c = evt.getKeyChar(); 
        if(E6.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_E6KeyTyped

    private void E7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E7KeyTyped
        int c = evt.getKeyChar(); 
        if(E7.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_E7KeyTyped

    private void E9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E9KeyTyped
        int c = evt.getKeyChar(); 
        if(E9.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_E9KeyTyped

    // F Panel
    private void F3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F3KeyTyped
        int c = evt.getKeyChar(); 
        if(F3.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_F3KeyTyped

    private void F4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F4KeyTyped
        int c = evt.getKeyChar(); 
        if(F4.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_F4KeyTyped

    private void F5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F5KeyTyped
        int c = evt.getKeyChar(); 
        if(F5.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_F5KeyTyped

    private void F6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F6KeyTyped
        int c = evt.getKeyChar(); 
        if(F6.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_F6KeyTyped

    private void F8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F8KeyTyped
        int c = evt.getKeyChar(); 
        if(F8.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_F8KeyTyped

    // G Panel
    private void G1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G1KeyTyped
        int c = evt.getKeyChar(); 
        if(G1.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_G1KeyTyped

    private void G4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G4KeyTyped
        int c = evt.getKeyChar(); 
        if(G4.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_G4KeyTyped

    private void G5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G5KeyTyped
        int c = evt.getKeyChar(); 
        if(G5.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_G5KeyTyped

    private void G8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G8KeyTyped
        int c = evt.getKeyChar(); 
        if(G8.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_G8KeyTyped

    private void G9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G9KeyTyped
        int c = evt.getKeyChar(); 
        if(G9.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_G9KeyTyped

    // H Panel
    private void H1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H1KeyTyped
        int c = evt.getKeyChar(); 
        if(H1.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_H1KeyTyped

    private void H2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H2KeyTyped
        int c = evt.getKeyChar(); 
        if(H2.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_H2KeyTyped

    private void H3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H3KeyTyped
        int c = evt.getKeyChar(); 
        if(H3.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_H3KeyTyped

    private void H4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H4KeyTyped
        int c = evt.getKeyChar(); 
        if(H4.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_H4KeyTyped

    private void H5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H5KeyTyped
        int c = evt.getKeyChar(); 
        if(H5.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_H5KeyTyped

    private void H6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H6KeyTyped
        int c = evt.getKeyChar(); 
        if(H6.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_H6KeyTyped

    private void H8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H8KeyTyped
        int c = evt.getKeyChar(); 
        if(H8.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_H8KeyTyped

    // I Panel
    private void I1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I1KeyTyped
        int c = evt.getKeyChar(); 
        if(I1.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_I1KeyTyped

    private void I3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I3KeyTyped
        int c = evt.getKeyChar(); 
        if(I3.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_I3KeyTyped

    private void I4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I4KeyTyped
        int c = evt.getKeyChar(); 
        if(I4.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_I4KeyTyped

    private void I5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I5KeyTyped
        int c = evt.getKeyChar(); 
        if(I5.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_I5KeyTyped

    private void I6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I6KeyTyped
        int c = evt.getKeyChar(); 
        if(I6.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_I6KeyTyped

    private void I7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I7KeyTyped
        int c = evt.getKeyChar(); 
        if(I7.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
       }
    }//GEN-LAST:event_I7KeyTyped

    private void I8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I8KeyTyped
        int c = evt.getKeyChar(); 
        if(I8.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {        
       }
    }//GEN-LAST:event_I8KeyTyped

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        try {
            setVisible(false);
            new EndScreen(score).setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_quitButtonActionPerformed
 
    /* * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sudoku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A1;
    private javax.swing.JTextField A2;
    private javax.swing.JTextField A3;
    private javax.swing.JTextField A4;
    private javax.swing.JTextField A5;
    private javax.swing.JTextField A6;
    private javax.swing.JTextField A7;
    private javax.swing.JLabel A8;
    private javax.swing.JTextField A9;
    private javax.swing.JLabel B1;
    private javax.swing.JTextField B2;
    private javax.swing.JLabel B3;
    private javax.swing.JTextField B4;
    private javax.swing.JTextField B5;
    private javax.swing.JTextField B6;
    private javax.swing.JTextField B7;
    private javax.swing.JTextField B8;
    private javax.swing.JTextField B9;
    private javax.swing.JTextField C1;
    private javax.swing.JTextField C2;
    private javax.swing.JLabel C3;
    private javax.swing.JLabel C4;
    private javax.swing.JTextField C5;
    private javax.swing.JTextField C6;
    private javax.swing.JLabel C7;
    private javax.swing.JLabel C8;
    private javax.swing.JTextField C9;
    private javax.swing.JLabel D1;
    private javax.swing.JTextField D2;
    private javax.swing.JLabel D3;
    private javax.swing.JTextField D4;
    private javax.swing.JTextField D5;
    private javax.swing.JTextField D6;
    private javax.swing.JTextField D7;
    private javax.swing.JLabel D8;
    private javax.swing.JLabel D9;
    private javax.swing.JTextField E1;
    private javax.swing.JLabel E2;
    private javax.swing.JTextField E3;
    private javax.swing.JTextField E4;
    private javax.swing.JLabel E5;
    private javax.swing.JTextField E6;
    private javax.swing.JTextField E7;
    private javax.swing.JLabel E8;
    private javax.swing.JTextField E9;
    private javax.swing.JLabel F1;
    private javax.swing.JLabel F2;
    private javax.swing.JTextField F3;
    private javax.swing.JTextField F4;
    private javax.swing.JTextField F5;
    private javax.swing.JTextField F6;
    private javax.swing.JLabel F7;
    private javax.swing.JTextField F8;
    private javax.swing.JLabel F9;
    private javax.swing.JTextField G1;
    private javax.swing.JLabel G2;
    private javax.swing.JLabel G3;
    private javax.swing.JTextField G4;
    private javax.swing.JTextField G5;
    private javax.swing.JLabel G6;
    private javax.swing.JLabel G7;
    private javax.swing.JTextField G8;
    private javax.swing.JTextField G9;
    private javax.swing.JTextField H1;
    private javax.swing.JTextField H2;
    private javax.swing.JTextField H3;
    private javax.swing.JTextField H4;
    private javax.swing.JTextField H5;
    private javax.swing.JTextField H6;
    private javax.swing.JLabel H7;
    private javax.swing.JTextField H8;
    private javax.swing.JLabel H9;
    private javax.swing.JTextField I1;
    private javax.swing.JLabel I2;
    private javax.swing.JTextField I3;
    private javax.swing.JTextField I4;
    private javax.swing.JTextField I5;
    private javax.swing.JTextField I6;
    private javax.swing.JTextField I7;
    private javax.swing.JTextField I8;
    private javax.swing.JLabel I9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel time_dateLabel;
    // End of variables declaration//GEN-END:variables
}

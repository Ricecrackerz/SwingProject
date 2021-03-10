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
/**
 * @author TonyDiaz stans
 */
public class Sudoku extends javax.swing.JFrame implements KeyListener {
    
    int sudokuScore = 540; 
    int finalScore;
    int score;
    int correctBoxes = 54;
        
    public int[] error = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public int[] error1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    
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
        System.out.println("hi");
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
            JOptionPane.showMessageDialog(this, "Vincent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
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
            JOptionPane.showMessageDialog(this, "Vincent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
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
            JOptionPane.showMessageDialog(this, "Vincent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
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
                if (!(A2.getText().isEmpty())) {
                    if (A2.getName().equals("A2")) {
                        if (!(Integer.parseInt(A2.getText()) == 3)){
                            A2.setForeground(Color.RED);
                            if (error[0] != 1) {
                                wrongScore();
                                error[0] = 1;
                            } 
                        } else {   
                            try {
                                A2.setForeground(Color.BLACK);
                                A2.setEnabled(false);
                                if (error1[0] != 1) {
                                rightScore();                               
                                error1[0] = 1;
                                }                                
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(A3.getText().isEmpty())) {
                    if (A3.getName().equals("A3")) {
                        if (!(Integer.parseInt(A3.getText()) == 5)){
                            A3.setForeground(Color.RED);
                            if (error[1] != 1) {
                                wrongScore();
                                error[1] = 1;
                            } 
                        } else {   
                            try {
                                A3.setForeground(Color.BLACK);
                                A3.setEnabled(false);
                                if (error1[1] != 1) {
                                rightScore();                               
                                error1[1] = 1;
                                }   
                                else{
                                    A2.setForeground(Color.BLACK);
                                    A2.setEnabled(false);
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                    }
                }
                if (!(A4.getText().isEmpty())) {
                    if (A4.getName().equals("A4")) {
                        if (!(Integer.parseInt(A4.getText()) == 2)){
                            A4.setForeground(Color.RED);
                            if (error[2] != 1) {
                                wrongScore();
                                error[2] = 1;
                            } 
                        } else {   
                            try {
                                A4.setForeground(Color.BLACK);
                                A4.setEnabled(false); 
                                if (error1[2] != 1) {
                                rightScore();                               
                                error1[2] = 1;
                                } 
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(A5.getText().isEmpty())) {
                    if (A5.getName().equals("A5")) {
                        if (!(Integer.parseInt(A5.getText()) == 9)){
                            A5.setForeground(Color.RED);
                            if (error[3] != 1) {
                                wrongScore();
                                error[3] = 1;
                            } 
                        } else {   
                            try {
                                A5.setForeground(Color.BLACK);
                                A5.setEnabled(false); 
                                if (error1[3] != 1) {
                                rightScore();                               
                                error1[3] = 1;
                                } 
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(A6.getText().isEmpty())) {
                    if (A6.getName().equals("A6")) {
                        if (!(Integer.parseInt(A6.getText()) == 6)){
                            A6.setForeground(Color.RED);
                            if (error[4] != 1) {
                                wrongScore();
                                error[4] = 1;
                            } 
                        } else {   
                            try {
                                A6.setForeground(Color.BLACK);
                                A6.setEnabled(false);
                                if (error1[4] != 1) {
                                rightScore();                               
                                error1[4] = 1;
                                } 
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(A7.getText().isEmpty())) {
                    if (A7.getName().equals("A7")) {
                        if (!(Integer.parseInt(A7.getText()) == 4)){
                            A7.setForeground(Color.RED);
                            if (error[5] != 1) {
                                wrongScore();
                                error[5] = 1;
                            } 
                        } else {   
                            try {
                                A7.setForeground(Color.BLACK);
                                A7.setEnabled(false);  
                                if (error1[5] != 1) {
                                rightScore();                               
                                error1[5] = 1;
                                } 
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(A9.getText().isEmpty())) {
                    if (A9.getName().equals("A9")) {
                        if (!(Integer.parseInt(A9.getText()) == 7)){
                            A9.setForeground(Color.RED);
                            if (error[6] != 1) {
                                wrongScore();
                                error[6] = 1;
                            } 
                        } else {   
                            try {
                                A9.setForeground(Color.BLACK);
                                A9.setEnabled(false);  
                                if (error1[6] != 1) {
                                rightScore();                               
                                error1[6] = 1;
                                } 
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                // PANEL B
                
                if (!(B2.getText().isEmpty())) {
                    if (B2.getName().equals("B2")) {
                        if (!(Integer.parseInt(B2.getText()) == 1)){
                            B2.setForeground(Color.RED);
                            if (error[7] != 1) {
                                wrongScore();
                                error[7] = 1;
                            } 
                        } else {   
                            try {
                                B2.setForeground(Color.BLACK);
                                B2.setEnabled(false);  
                                if (error1[7] != 1) {
                                rightScore();                               
                                error1[7] = 1;
                                } 
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                if (!(B4.getText().isEmpty())) {
                    if (B4.getName().equals("B4")) {
                        if (!(Integer.parseInt(B4.getText()) == 8)){
                            B4.setForeground(Color.RED);
                            if (error[8] != 1) {
                                wrongScore();
                                error[8] = 1;
                            } 
                        } else {   
                            try {
                                B4.setForeground(Color.BLACK);
                                B4.setEnabled(false);  
                                if (error1[8] != 1) {
                                rightScore();                               
                                error1[8] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                if (!(B5.getText().isEmpty())) {
                    if (B5.getName().equals("B5")) {
                        if (!(Integer.parseInt(B5.getText()) == 5)){
                            B5.setForeground(Color.RED);
                            if (error[9] != 1) {
                                wrongScore();
                                error[9] = 1;
                            } 
                        } else {   
                            try {
                                B5.setForeground(Color.BLACK);
                                B5.setEnabled(false);
                                if (error1[9] != 1) {
                                rightScore();                               
                                error1[9] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(B6.getText().isEmpty())) {
                    if (B6.getName().equals("B6")) {
                        if (!(Integer.parseInt(B6.getText()) == 7)){
                            B6.setForeground(Color.RED);
                            if (error[10] != 1) {
                                wrongScore();
                                error[10] = 1;
                            } 
                        } else {   
                            try {
                                B6.setForeground(Color.BLACK);
                                B6.setEnabled(false);
                                if (error1[10] != 1) {
                                rightScore();                               
                                error1[10] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(B7.getText().isEmpty())) {
                    if (B7.getName().equals("B7")) {
                        if (!(Integer.parseInt(B7.getText()) == 2)){
                            B7.setForeground(Color.RED);
                            if (error[11] != 1) {
                                wrongScore();
                                error[11] = 1;
                            } 
                        } else {   
                            try {
                                B7.setForeground(Color.BLACK);
                                B7.setEnabled(false); 
                                if (error1[11] != 1) {
                                rightScore();                               
                                error1[11] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(B8.getText().isEmpty())) {
                    if (B8.getName().equals("B8")) {
                        if (!(Integer.parseInt(B8.getText()) == 9)){
                            B8.setForeground(Color.RED);
                            if (error[12] != 1) {
                                wrongScore();
                                error[12] = 1;
                            } 
                        } else {   
                            try {
                                B8.setForeground(Color.BLACK);
                                B8.setEnabled(false);
                                if (error1[12] != 1) {
                                rightScore();                               
                                error1[12] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(B9.getText().isEmpty())) {
                    if (B9.getName().equals("B9")) {
                        if (!(Integer.parseInt(B9.getText()) == 3)){
                            B9.setForeground(Color.RED);
                            if (error[13] != 1) {
                                wrongScore();
                                error[13] = 1;
                            } 
                        } else {   
                            try {
                                B9.setForeground(Color.BLACK);
                                B9.setEnabled(false);
                                if (error1[13] != 1) {
                                rightScore();                               
                                error1[13] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                //PANEL C
                if (!(C1.getText().isEmpty())) {
                    if (C1.getName().equals("C1")) {
                        if (!(Integer.parseInt(C1.getText()) == 9)){
                            C1.setForeground(Color.RED);
                            if (error[14] != 1) {
                                wrongScore();
                                error[14] = 1;
                            } 
                        } else {   
                            try {
                                C1.setForeground(Color.BLACK);
                                C1.setEnabled(false);
                                if (error1[14] != 1) {
                                rightScore();                               
                                error1[14] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(C2.getText().isEmpty())) {
                    if (C2.getName().equals("C2")) {
                        if (!(Integer.parseInt(C2.getText()) == 2)){
                            C2.setForeground(Color.RED);
                            if (error[15] != 1) {
                                wrongScore();
                                error[15] = 1;
                            } 
                        } else {   
                            try {
                                C2.setForeground(Color.BLACK);
                                C2.setEnabled(false);
                                if (error1[15] != 1) {
                                rightScore();                               
                                error1[15] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(C5.getText().isEmpty())) {
                    if (C5.getName().equals("C5")) {
                        if (!(Integer.parseInt(C5.getText()) == 3)){
                            C5.setForeground(Color.RED);
                            if (error[16] != 1) {
                                wrongScore();
                                error[16] = 1;
                            } 
                        } else {   
                            try {
                                C5.setForeground(Color.BLACK);
                                C5.setEnabled(false);
                                if (error1[16] != 1) {
                                rightScore();                               
                                error1[16] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(C6.getText().isEmpty())) {
                    if (C6.getName().equals("C6")) {
                        if (!(Integer.parseInt(C6.getText()) == 1)){
                            C6.setForeground(Color.RED);
                            if (error[17] != 1) {
                                wrongScore();
                                error[17] = 1;
                            } 
                        } else {   
                            try {
                                C6.setForeground(Color.BLACK);
                                C6.setEnabled(false);
                                if (error1[17] != 1) {
                                rightScore();                               
                                error1[17] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(C9.getText().isEmpty())) {
                    if (C9.getName().equals("C9")) {
                        if (!(Integer.parseInt(C9.getText()) == 8)){
                            C9.setForeground(Color.RED);
                            if (error[18] != 1) {
                                wrongScore();
                                error[18] = 1;
                            } 
                        } else {   
                            try {
                                C9.setForeground(Color.BLACK);
                                C9.setEnabled(false);
                                if (error1[18] != 1) {
                                rightScore();                               
                                error1[18] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                //PANEL D
                if (!(D2.getText().isEmpty())) {
                    if (D2.getName().equals("D2")) {
                        if (!(Integer.parseInt(D2.getText()) == 6)){
                            D2.setForeground(Color.RED);
                            if (error[19] != 1) {
                                wrongScore();
                                error[19] = 1;
                            } 
                        } else {   
                            try {
                                D2.setForeground(Color.BLACK);
                                D2.setEnabled(false);
                                if (error1[19] != 1) {
                                rightScore();                               
                                error1[19] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(D4.getText().isEmpty())) {
                    if (D4.getName().equals("D4")) {
                        if (!(Integer.parseInt(D4.getText()) == 1)){
                            D4.setForeground(Color.RED);
                            if (error[20] != 1) {
                                wrongScore();
                                error[20] = 1;
                            } 
                        } else {   
                            try {
                                D4.setForeground(Color.BLACK);
                                D4.setEnabled(false);
                                if (error1[20] != 1) {
                                rightScore();                               
                                error1[20] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(D5.getText().isEmpty())) {
                    if (D5.getName().equals("D5")) {
                        if (!(Integer.parseInt(D5.getText()) == 2)){
                            D5.setForeground(Color.RED);
                            if (error[21] != 1) {
                                wrongScore();
                                error[21] = 1;
                            } 
                        } else {   
                            try {
                                D5.setForeground(Color.BLACK);
                                D5.setEnabled(false);
                                if (error1[21] != 1) {
                                rightScore();                               
                                error1[21] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(D6.getText().isEmpty())) {
                    if (D6.getName().equals("D6")) {
                        if (!(Integer.parseInt(D6.getText()) == 3)){
                            D6.setForeground(Color.RED);
                            if (error[22] != 1) {
                                wrongScore();
                                error[22] = 1;
                            } 
                        } else {   
                            try {
                                D6.setForeground(Color.BLACK);
                                D6.setEnabled(false);
                                if (error1[22] != 1) {
                                rightScore();                               
                                error1[22] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(D7.getText().isEmpty())) {
                    if (D7.getName().equals("D7")) {
                        if (!(Integer.parseInt(D7.getText()) == 7)){
                            D7.setForeground(Color.RED);
                            if (error[23] != 1) {
                                wrongScore();
                                error[23] = 1;
                            } 
                        } else {   
                            try {
                                D7.setForeground(Color.BLACK);
                                D7.setEnabled(false);
                                if (error1[23] != 1) {
                                rightScore();                               
                                error1[23] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                // PANEL E
                if (!(E1.getText().isEmpty())) {
                    if (E1.getName().equals("E1")) {
                        if (!(Integer.parseInt(E1.getText()) == 1)){
                            E1.setForeground(Color.RED);
                            if (error[24] != 1) {
                                wrongScore();
                                error[24] = 1;
                            } 
                        } else {   
                            try {
                                E1.setForeground(Color.BLACK);
                                E1.setEnabled(false);
                                if (error1[24] != 1) {
                                rightScore();                               
                                error1[24] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(E3.getText().isEmpty())) {
                    if (E3.getName().equals("E3")) {
                        if (!(Integer.parseInt(E3.getText()) == 4)){
                            E3.setForeground(Color.RED);
                            if (error[25] != 1) {
                                wrongScore();
                                error[25] = 1;
                            } 
                        } else {   
                            try {
                                E3.setForeground(Color.BLACK);
                                E3.setEnabled(false);
                                if (error1[25] != 1) {
                                rightScore();                               
                                error1[25] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(E4.getText().isEmpty())) {
                    if (E4.getName().equals("E4")) {
                        if (!(Integer.parseInt(E4.getText()) == 6)){
                            E4.setForeground(Color.RED);
                            if (error[26] != 1) {
                                wrongScore();
                                error[26] = 1;
                            } 
                        } else {   
                            try {
                                E4.setForeground(Color.BLACK);
                                E4.setEnabled(false);
                                if (error1[26] != 1) {
                                rightScore();                               
                                error1[26] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(E6.getText().isEmpty())) {
                    if (E6.getName().equals("E6")) {
                        if (!(Integer.parseInt(E6.getText()) == 8)){
                            E6.setForeground(Color.RED);
                            if (error[27] != 1) {
                                wrongScore();
                                error[27] = 1;
                            } 
                        } else {   
                            try {
                                E6.setForeground(Color.BLACK);
                                E6.setEnabled(false);
                                if (error1[27] != 1) {
                                rightScore();                               
                                error1[27] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(E7.getText().isEmpty())) {
                    if (E7.getName().equals("E7")) {
                        if (!(Integer.parseInt(E7.getText()) == 5)){
                            E7.setForeground(Color.RED);
                            if (error[28] != 1) {
                                wrongScore();
                                error[28] = 1;
                            } 
                        } else {   
                            try {
                                E7.setForeground(Color.BLACK);
                                E7.setEnabled(false);
                                if (error1[28] != 1) {
                                rightScore();                               
                                error1[28] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(E9.getText().isEmpty())) {
                    if (E9.getName().equals("E9")) {
                        if (!(Integer.parseInt(E9.getText()) == 9)){
                            E9.setForeground(Color.RED);
                            if (error[29] != 1) {
                                wrongScore();
                                error[29] = 1;
                            } 
                        } else {   
                            try {
                                E9.setForeground(Color.BLACK);
                                E9.setEnabled(false);
                                if (error1[29] != 1) {
                                rightScore();                               
                                error1[29] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                //PANEL F
                if (!(F3.getText().isEmpty())) {
                    if (F3.getName().equals("F3")) {
                        if (!(Integer.parseInt(F3.getText()) == 2)){
                            F3.setForeground(Color.RED);
                            if (error[30] != 1) {
                                wrongScore();
                                error[30] = 1;
                            } 
                        } else {   
                            try {
                                F3.setForeground(Color.BLACK);
                                F3.setEnabled(false);
                                if (error1[30] != 1) {
                                rightScore();                               
                                error1[30] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(F4.getText().isEmpty())) {
                    if (F4.getName().equals("F4")) {
                        if (!(Integer.parseInt(F4.getText()) == 5)){
                            F4.setForeground(Color.RED);
                            if (error[31] != 1) {
                                wrongScore();
                                error[31] = 1;
                            } 
                        } else {   
                            try {
                                F4.setForeground(Color.BLACK);
                                F4.setEnabled(false);
                                if (error1[31] != 1) {
                                rightScore();                               
                                error1[31] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(F5.getText().isEmpty())) {
                    if (F5.getName().equals("F5")) {
                        if (!(Integer.parseInt(F5.getText()) == 4)){
                            F5.setForeground(Color.RED);
                            if (error[32] != 1) {
                                wrongScore();
                                error[32] = 1;
                            } 
                        } else {   
                            try {
                                F5.setForeground(Color.BLACK);
                                F5.setEnabled(false);
                                if (error1[32] != 1) {
                                rightScore();                               
                                error1[32] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(F6.getText().isEmpty())) {
                    if (F6.getName().equals("F6")) {
                        if (!(Integer.parseInt(F6.getText()) == 9)){
                            F6.setForeground(Color.RED);
                            if (error[33] != 1) {
                                wrongScore();
                                error[33] = 1;
                            } 
                        } else {   
                            try {
                                F6.setForeground(Color.BLACK);
                                F6.setEnabled(false);
                                if (error1[33] != 1) {
                                rightScore();                               
                                error1[33] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(F8.getText().isEmpty())) {
                    if (F8.getName().equals("F8")) {
                        if (!(Integer.parseInt(F8.getText()) == 6)){
                            F8.setForeground(Color.RED);
                            if (error[34] != 1) {
                                wrongScore();
                                error[34] = 1;
                            } 
                        } else {   
                            try {
                                F8.setForeground(Color.BLACK);
                                F8.setEnabled(false);
                                if (error1[34] != 1) {
                                rightScore();                               
                                error1[34] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                // PANEL G
                if (!(G1.getText().isEmpty())) {
                    if (G1.getName().equals("G1")) {
                        if (!(Integer.parseInt(G1.getText()) == 6)){
                            G1.setForeground(Color.RED);
                            if (error[35] != 1) {
                                wrongScore();
                                error[35] = 1;
                            } 
                        } else {   
                            try {
                                G1.setForeground(Color.BLACK);
                                G1.setEnabled(false);
                                if (error1[35] != 1) {
                                rightScore();                               
                                error1[35] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(G4.getText().isEmpty())) {
                    if (G4.getName().equals("G4")) {
                        if (!(Integer.parseInt(G4.getText()) == 9)){
                            G4.setForeground(Color.RED);
                            if (error[36] != 1) {
                                wrongScore();
                                error[36] = 1;
                            } 
                        } else {   
                            try {
                                G4.setForeground(Color.BLACK);
                                G4.setEnabled(false);
                                if (error1[36] != 1) {
                                rightScore();                               
                                error1[36] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(G5.getText().isEmpty())) {
                    if (G5.getName().equals("G5")) {
                        if (!(Integer.parseInt(G5.getText()) == 8)){
                            G5.setForeground(Color.RED);
                            if (error[37] != 1) {
                                wrongScore();
                                error[37] = 1;
                            } 
                        } else {   
                            try {
                                G5.setForeground(Color.BLACK);
                                G5.setEnabled(false);
                                if (error1[37] != 1) {
                                rightScore();                               
                                error1[37] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(G8.getText().isEmpty())) {
                    if (G8.getName().equals("G8")) {
                        if (!(Integer.parseInt(G8.getText()) == 7)){
                            G8.setForeground(Color.RED);
                            if (error[38] != 1) {
                                wrongScore();
                                error[38] = 1;
                            } 
                        } else {   
                            try {
                                G8.setForeground(Color.BLACK);
                                G8.setEnabled(false);
                                if (error1[38] != 1) {
                                rightScore();                               
                                error1[38] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(G9.getText().isEmpty())) {
                    if (G9.getName().equals("G9")) {
                        if (!(Integer.parseInt(G9.getText()) == 4)){
                            G9.setForeground(Color.RED);
                            if (error[39] != 1) {
                                wrongScore();
                                error[39] = 1;
                            } 
                        } else {   
                            try {
                                G9.setForeground(Color.BLACK);
                                G9.setEnabled(false);
                                if (error1[39] != 1) {
                                rightScore();                               
                                error1[39] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                // PANEL H
                if (!(H1.getText().isEmpty())) {
                    if (H1.getName().equals("H1")) {
                        if (!(Integer.parseInt(H1.getText()) == 7)){
                            H1.setForeground(Color.RED);
                            if (error[40] != 1) {
                                wrongScore();
                                error[40] = 1;
                            } 
                        } else {   
                            try {
                                H1.setForeground(Color.BLACK);
                                H1.setEnabled(false);
                                if (error1[40] != 1) {
                                rightScore();                               
                                error1[40] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(H2.getText().isEmpty())) {
                    if (H2.getName().equals("H2")) {
                        if (!(Integer.parseInt(H2.getText()) == 8)){
                            H2.setForeground(Color.RED);
                            if (error[41] != 1) {
                                wrongScore();
                                error[41] = 1;
                            } 
                        } else {   
                            try {
                                H2.setForeground(Color.BLACK);
                                H2.setEnabled(false);
                                if (error1[41] != 1) {
                                rightScore();                               
                                error1[41] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(H3.getText().isEmpty())) {
                    if (H3.getName().equals("H3")) {
                        if (!(Integer.parseInt(H3.getText()) == 1)){
                            H3.setForeground(Color.RED);
                            if (error[42] != 1) {
                                wrongScore();
                                error[42] = 1;
                            } 
                        } else {   
                            try {
                                H3.setForeground(Color.BLACK);
                                H3.setEnabled(false);
                                if (error1[42] != 1) {
                                rightScore();                               
                                error1[42] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(H4.getText().isEmpty())) {
                    if (H4.getName().equals("H4")) {
                        if (!(Integer.parseInt(H4.getText()) == 3)){
                            H4.setForeground(Color.RED);
                            if (error[43] != 1) {
                                wrongScore();
                                error[43] = 1;
                            } 
                        } else {   
                            try {
                                H4.setForeground(Color.BLACK);
                                H4.setEnabled(false);
                                if (error1[43] != 1) {
                                rightScore();                               
                                error1[43] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(H5.getText().isEmpty())) {
                    if (H5.getName().equals("H5")) {
                        if (!(Integer.parseInt(H5.getText()) == 4)){
                            H5.setForeground(Color.RED);
                            if (error[44] != 1) {
                                wrongScore();
                                error[44] = 1;
                            } 
                        } else {   
                            try {
                                H5.setForeground(Color.BLACK);
                                H5.setEnabled(false);
                                if (error1[44] != 1) {
                                rightScore();                               
                                error1[44] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(H6.getText().isEmpty())) {
                    if (H6.getName().equals("H6")) {
                        if (!(Integer.parseInt(H6.getText()) == 5)){
                            H6.setForeground(Color.RED);
                            if (error[45] != 1) {
                                wrongScore();
                                error[45] = 1;
                            } 
                        } else {   
                            try {
                                H6.setForeground(Color.BLACK);
                                H6.setEnabled(false);
                                if (error1[45] != 1) {
                                rightScore();                               
                                error1[45] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(H8.getText().isEmpty())) {
                    if (H8.getName().equals("H8")) {
                        if (!(Integer.parseInt(H8.getText()) == 6)){
                            H8.setForeground(Color.RED);
                            if (error[46] != 1) {
                                wrongScore();
                                error[46] = 1;
                            } 
                        } else {   
                            try {
                                H8.setForeground(Color.BLACK);
                                H8.setEnabled(false);
                                if (error1[46] != 1) {
                                rightScore();                               
                                error1[46] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                // PANEL I 
                if (!(I1.getText().isEmpty())) {
                    if (I1.getName().equals("I1")) {
                        if (!(Integer.parseInt(I1.getText()) == 3)){
                            I1.setForeground(Color.RED);
                            if (error[47] != 1) {
                                wrongScore();
                                error[47] = 1;
                            } 
                        } else {   
                            try {
                                I1.setForeground(Color.BLACK);
                                I1.setEnabled(false);
                                if (error1[47] != 1) {
                                rightScore();                               
                                error1[47] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(I3.getText().isEmpty())) {
                    if (I3.getName().equals("I3")) {
                        if (!(Integer.parseInt(I3.getText()) == 4)){
                            I3.setForeground(Color.RED);
                            if (error[48] != 1) {
                                wrongScore();
                                error[48] = 1;
                            } 
                        } else {   
                            try {
                                I3.setForeground(Color.BLACK);
                                I3.setEnabled(false);
                                if (error1[48] != 1) {
                                rightScore();                               
                                error1[48] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(I4.getText().isEmpty())) {
                    if (I4.getName().equals("I4")) {
                        if (!(Integer.parseInt(I4.getText()) == 2)){
                            I4.setForeground(Color.RED);
                            if (error[49] != 1) {
                                wrongScore();
                                error[49] = 1;
                            } 
                        } else {   
                            try {
                                I4.setForeground(Color.BLACK);
                                I4.setEnabled(false);
                                if (error1[49] != 1) {
                                rightScore();                               
                                error1[49] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(I5.getText().isEmpty())) {
                    if (I5.getName().equals("I5")) {
                        if (!(Integer.parseInt(I5.getText()) == 7)){
                            I5.setForeground(Color.RED);
                            if (error[50] != 1) {
                                wrongScore();
                                error[50] = 1;
                            } 
                        } else {   
                            try {
                                I5.setForeground(Color.BLACK);
                                I5.setEnabled(false);
                                if (error1[50] != 1) {
                                rightScore();                               
                                error1[50] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(I6.getText().isEmpty())) {
                    if (I6.getName().equals("I6")) {
                        if (!(Integer.parseInt(I6.getText()) == 6)){
                            I6.setForeground(Color.RED);
                            if (error[51] != 1) {
                                wrongScore();
                                error[51] = 1;
                            } 
                        } else {   
                            try {
                                I6.setForeground(Color.BLACK);
                                I6.setEnabled(false);
                                if (error1[51] != 1) {
                                rightScore();                               
                                error1[51] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(I7.getText().isEmpty())) {
                    if (I7.getName().equals("I7")) {
                        if (!(Integer.parseInt(I7.getText()) == 8)){
                            I7.setForeground(Color.RED);
                            if (error[52] != 1) {
                                wrongScore();
                                error[52] = 1;
                            } 
                        } else {   
                            try {
                                I7.setForeground(Color.BLACK);
                                I7.setEnabled(false);
                                if (error1[52] != 1) {
                                rightScore();                               
                                error1[52] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                if (!(I8.getText().isEmpty())) {
                    if (I8.getName().equals("I8")) {
                        if (!(Integer.parseInt(I8.getText()) == 1)){
                            I8.setForeground(Color.RED);
                            if (error[53] != 1) {
                                wrongScore();
                                error[53] = 1;
                            } 
                        } else {   
                            try {
                                I8.setForeground(Color.BLACK);
                                I8.setEnabled(false);
                                if (error1[53] != 1) {
                                rightScore();                               
                                error1[53] = 1;
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
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
        A2.setToolTipText("Insert a number in this box!");
        A2.setActionCommand("<Not Set>");
        A2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A2.setName("A2"); // NOI18N
        A2.setSelectionEnd(1);
        A2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A2KeyTyped(evt);
            }
        });

        A3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A3.setToolTipText("Insert a number in this box!");
        A3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A3.setName("A3"); // NOI18N
        A3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A3KeyTyped(evt);
            }
        });

        A5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A5.setToolTipText("Insert a number in this box!");
        A5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A5.setName("A5"); // NOI18N
        A5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A5KeyTyped(evt);
            }
        });

        A4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A4.setToolTipText("Insert a number in this box!");
        A4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A4.setName("A4"); // NOI18N
        A4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A4KeyTyped(evt);
            }
        });

        A6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A6.setToolTipText("Insert a number in this box!");
        A6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A6.setName("A6"); // NOI18N
        A6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A6KeyTyped(evt);
            }
        });

        A7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A7.setToolTipText("Insert a number in this box!");
        A7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A7.setName("A7"); // NOI18N
        A7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A7KeyTyped(evt);
            }
        });

        A9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A9.setToolTipText("Insert a number in this box!");
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
        I3.setToolTipText("Insert a number in this box!");
        I3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I3.setName("I3"); // NOI18N
        I3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I3KeyTyped(evt);
            }
        });

        I5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I5.setToolTipText("Insert a number in this box!");
        I5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I5.setName("I5"); // NOI18N
        I5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I5KeyTyped(evt);
            }
        });

        I4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I4.setToolTipText("Insert a number in this box!");
        I4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I4.setName("I4"); // NOI18N
        I4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I4KeyTyped(evt);
            }
        });

        I6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I6.setToolTipText("Insert a number in this box!");
        I6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I6.setName("I6"); // NOI18N
        I6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I6KeyTyped(evt);
            }
        });

        I7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I7.setToolTipText("Insert a number in this box!");
        I7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I7.setName("I7"); // NOI18N
        I7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I7KeyTyped(evt);
            }
        });

        I8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I8.setToolTipText("Insert a number in this box!");
        I8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I8.setName("I8"); // NOI18N
        I8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                I8KeyTyped(evt);
            }
        });

        I1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I1.setToolTipText("Insert a number in this box!");
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
        B2.setToolTipText("Insert a number in this box!");
        B2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B2.setName("B2"); // NOI18N
        B2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B2KeyTyped(evt);
            }
        });

        B5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B5.setToolTipText("Insert a number in this box!");
        B5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B5.setName("B5"); // NOI18N
        B5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B5KeyTyped(evt);
            }
        });

        B4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B4.setToolTipText("Insert a number in this box!");
        B4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B4.setName("B4"); // NOI18N
        B4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B4KeyTyped(evt);
            }
        });

        B6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B6.setToolTipText("Insert a number in this box!");
        B6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B6.setName("B6"); // NOI18N
        B6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B6KeyTyped(evt);
            }
        });

        B7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B7.setToolTipText("Insert a number in this box!");
        B7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B7.setName("B7"); // NOI18N
        B7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B7KeyTyped(evt);
            }
        });

        B8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B8.setToolTipText("Insert a number in this box!");
        B8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B8.setName("B8"); // NOI18N
        B8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                B8KeyTyped(evt);
            }
        });

        B9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B9.setToolTipText("Insert a number in this box!");
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
        C2.setToolTipText("Insert a number in this box!");
        C2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C2.setName("C2"); // NOI18N
        C2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C2KeyTyped(evt);
            }
        });

        C5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C5.setToolTipText("Insert a number in this box!");
        C5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C5.setName("C5"); // NOI18N
        C5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C5KeyTyped(evt);
            }
        });

        C6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C6.setToolTipText("Insert a number in this box!");
        C6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C6.setName("C6"); // NOI18N
        C6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C6KeyTyped(evt);
            }
        });

        C9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C9.setToolTipText("Insert a number in this box!");
        C9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C9.setName("C9"); // NOI18N
        C9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C9KeyTyped(evt);
            }
        });

        C1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C1.setToolTipText("Insert a number in this box!");
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
        E3.setToolTipText("Insert a number in this box!");
        E3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E3.setName("E3"); // NOI18N
        E3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E3KeyTyped(evt);
            }
        });

        E4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E4.setToolTipText("Insert a number in this box!");
        E4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E4.setName("E4"); // NOI18N
        E4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E4KeyTyped(evt);
            }
        });

        E6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E6.setToolTipText("Insert a number in this box!");
        E6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E6.setName("E6"); // NOI18N
        E6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E6KeyTyped(evt);
            }
        });

        E7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E7.setToolTipText("Insert a number in this box!");
        E7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E7.setName("E7"); // NOI18N
        E7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E7KeyTyped(evt);
            }
        });

        E9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E9.setToolTipText("Insert a number in this box!");
        E9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E9.setName("E9"); // NOI18N
        E9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E9KeyTyped(evt);
            }
        });

        E1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E1.setToolTipText("Insert a number in this box!");
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
        F3.setToolTipText("Insert a number in this box!");
        F3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F3.setName("F3"); // NOI18N
        F3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                F3KeyTyped(evt);
            }
        });

        F5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F5.setToolTipText("Insert a number in this box!");
        F5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F5.setName("F5"); // NOI18N
        F5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                F5KeyTyped(evt);
            }
        });

        F4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F4.setToolTipText("Insert a number in this box!");
        F4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F4.setName("F4"); // NOI18N
        F4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                F4KeyTyped(evt);
            }
        });

        F6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F6.setToolTipText("Insert a number in this box!");
        F6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F6.setName("F6"); // NOI18N
        F6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                F6KeyTyped(evt);
            }
        });

        F8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F8.setToolTipText("Insert a number in this box!");
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
        D2.setToolTipText("Insert a number in this box!");
        D2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D2.setName("D2"); // NOI18N
        D2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                D2KeyTyped(evt);
            }
        });

        D5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D5.setToolTipText("Insert a number in this box!");
        D5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D5.setName("D5"); // NOI18N
        D5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                D5KeyTyped(evt);
            }
        });

        D4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D4.setToolTipText("Insert a number in this box!");
        D4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D4.setName("D4"); // NOI18N
        D4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                D4KeyTyped(evt);
            }
        });

        D6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D6.setToolTipText("Insert a number in this box!");
        D6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D6.setName("D6"); // NOI18N
        D6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                D6KeyTyped(evt);
            }
        });

        D7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D7.setToolTipText("Insert a number in this box!");
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
        G5.setToolTipText("Insert a number in this box!");
        G5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G5.setName("G5"); // NOI18N
        G5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                G5KeyTyped(evt);
            }
        });

        G4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G4.setToolTipText("Insert a number in this box!");
        G4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G4.setName("G4"); // NOI18N
        G4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                G4KeyTyped(evt);
            }
        });

        G8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G8.setToolTipText("Insert a number in this box!");
        G8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G8.setName("G8"); // NOI18N
        G8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                G8KeyTyped(evt);
            }
        });

        G9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G9.setToolTipText("Insert a number in this box!");
        G9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G9.setName("G9"); // NOI18N
        G9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                G9KeyTyped(evt);
            }
        });

        G1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G1.setToolTipText("Insert a number in this box!");
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
        H2.setToolTipText("Insert a number in this box!");
        H2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H2.setName("H2"); // NOI18N
        H2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H2KeyTyped(evt);
            }
        });

        H3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H3.setToolTipText("Insert a number in this box!");
        H3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H3.setName("H3"); // NOI18N
        H3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H3KeyTyped(evt);
            }
        });

        H5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H5.setToolTipText("Insert a number in this box!");
        H5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H5.setName("H5"); // NOI18N
        H5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H5KeyTyped(evt);
            }
        });

        H4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H4.setToolTipText("Insert a number in this box!");
        H4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H4.setName("H4"); // NOI18N
        H4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H4KeyTyped(evt);
            }
        });

        H6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H6.setToolTipText("Insert a number in this box!");
        H6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H6.setName("H6"); // NOI18N
        H6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H6KeyTyped(evt);
            }
        });

        H8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H8.setToolTipText("Insert a number in this box!");
        H8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H8.setName("H8"); // NOI18N
        H8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                H8KeyTyped(evt);
            }
        });

        H1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H1.setToolTipText("Insert a number in this box!");
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
        submitButton.setToolTipText("Click this button to submit your answer!");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.setToolTipText("Click this button to quit the Sudoku game!");
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

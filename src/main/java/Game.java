/*
 * @author TonyDiaz Stans
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends javax.swing.JFrame {

    // Establishing variables
    Timer timer; 
    public static final String[] wordBank = {"nurse", "cemetery", "abstract", "pharmacy", "climbing"}; 
    public static final int MAX_ERRORS = 5; 
    private String wordToFind; 
    private char[] wordFound; 
    private int nbErrors;
    private ArrayList < String > letters = new ArrayList <>(); 
    public int SCORE = 100;
    private int COUNTER = 0; 
    
    // Main method to run the game
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() { 
            public void run() {
                new Game().setVisible(true);
            }
        });
    }
    
    // To run a brand new hangman game once Play button is clicked
    public Game() {
       
        // Get main game screen size
        initComponents();
        getContentPane().setBackground(new java.awt.Color(252, 248, 232));
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        timer();
        startGame(); 
        hangMan();
    }
    
    // To display current Date & Time
    public void timer() {
        ActionListener actionListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date();
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); 
                String time = timeFormat.format(date); 
                
                Date date2 = new Date(); 
                DateFormat timeFormat2 = new SimpleDateFormat("dd/MM/yyyy"); 
                String time2 = timeFormat2.format(date2); 
                jLabel1.setText(time2 + "   " + time);
            }
        }; 
        timer = new Timer(1000, actionListener); 
        timer.setInitialDelay(0); 
        timer.start();
    }
    
    // To set up interface of the Bronco hangman and lettering setups
    public void startGame(){
        
        //Make Billy Bronco Invisible
        bbHead.setVisible(false);
        bbBody.setVisible(false);
        bbLeftA.setVisible(false);
        bbRightA.setVisible(false);
        bbLeftL.setVisible(false);
        bbRightL.setVisible(false);
        
        //Make Letters Blank
        Letter1.setText("   ");
        Letter2.setText("   ");
        Letter3.setText("   ");
        Letter4.setText("   ");
        Letter5.setText("   ");
        Letter6.setText("   ");
        Letter7.setText("   ");
        Letter8.setText("   ");
    }
    
    // To run the logic of hangman game while registering each button to record points
    public void hangMan(){
        
        // To randomly generate a word for the player to guess
        Random random = new Random(); 
        int wordNumber = random.nextInt(wordBank.length);
        
        // Setting the alphabetical buttons to generate scores correctly depending on each case 
        // while each case represents one of the guess word from the wordBank List
        switch (wordNumber) { 
            
            // Word "nurse"
            case 0: 
                line6.setVisible(false);
                line7.setVisible(false);
                line8.setVisible(false);
 
                nButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter1.setText("N");
                        Letter1.setVisible(true);
                        nButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 5) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                uButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter2.setText("U");
                        Letter2.setVisible(true);
                        uButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 5) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                rButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter3.setText("R");
                        Letter3.setVisible(true);
                        rButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 5) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                sButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter4.setText("S");
                        Letter4.setVisible(true);
                        sButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 5) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                eButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter5.setText("E");
                        Letter5.setVisible(true);
                        eButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 5) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                // setting the rest of the alphabet as point deduction and disable the button
                aButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        aButton.setEnabled(false);
                    }
                });
                bButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        bButton.setEnabled(false);
                    }
                });
                cButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        cButton.setEnabled(false);
                    }
                });
                dButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        dButton.setEnabled(false);
                    }
                });
                fButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        fButton.setEnabled(false);
                    }
                });
                gButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        gButton.setEnabled(false);
                    }
                });
                hButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        hButton.setEnabled(false);
                    }
                });
                iButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        iButton.setEnabled(false);
                    }
                });
                jButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        jButton.setEnabled(false);
                    }
                });
                kButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        kButton.setEnabled(false);
                    }
                });
                lButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        lButton.setEnabled(false);
                    }
                });
                mButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        mButton.setEnabled(false);
                    }
                });
                oButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        oButton.setEnabled(false);
                    }
                });
                pButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        pButton.setEnabled(false);
                    }
                });
                qButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        qButton.setEnabled(false);
                    }
                });
                tButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        tButton.setEnabled(false);
                    }
                });
                vButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        vButton.setEnabled(false);
                    }
                });
                wButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        wButton.setEnabled(false);
                    }
                });
                xButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        xButton.setEnabled(false);
                    }
                });
                yButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        yButton.setEnabled(false);
                    }
                });
                zButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        zButton.setEnabled(false);
                    }
                });
                break; 
                
            // Word "cemetery"   
            case 1: 
                cButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter1.setText("C");
                        Letter1.setVisible(true);
                        cButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                eButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter2.setText("E");
                        Letter4.setText("E");
                        Letter6.setText("E");
                        Letter2.setVisible(true);
                        Letter4.setVisible(true);
                        Letter6.setVisible(true);
                        eButton.setEnabled(false);
                        COUNTER+= 3;
                        if(COUNTER == 8) {
                           try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                mButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter3.setText("M");
                        Letter3.setVisible(true);
                        mButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                tButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter5.setText("T");
                        Letter5.setVisible(true);
                        tButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                           try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                rButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter7.setText("R");
                        Letter7.setVisible(true);
                        rButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                yButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter8.setText("Y");
                        Letter8.setVisible(true);
                        yButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                
                aButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        aButton.setEnabled(false);
                    }
                });
                bButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        bButton.setEnabled(false);
                    }
                });
                dButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        dButton.setEnabled(false);
                    }
                });
                fButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        fButton.setEnabled(false);
                    }
                });
                gButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        gButton.setEnabled(false);
                    }
                });
                hButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        hButton.setEnabled(false);
                    }
                });
                iButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        iButton.setEnabled(false);
                    }
                });
                jButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        jButton.setEnabled(false);
                    }
                });
                kButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        kButton.setEnabled(false);
                    }
                });
                lButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        lButton.setEnabled(false);
                    }
                });
                nButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        nButton.setEnabled(false);
                    }
                });
                oButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        oButton.setEnabled(false);
                    }
                });
                pButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        pButton.setEnabled(false);
                    }
                });
                qButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        qButton.setEnabled(false);
                    }
                });
                sButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        sButton.setEnabled(false);
                    }
                });
                uButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        uButton.setEnabled(false);
                    }
                });
                vButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        vButton.setEnabled(false);
                    }
                });
                wButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        wButton.setEnabled(false);
                    }
                });
                xButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        xButton.setEnabled(false);
                    }
                });
                zButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        zButton.setEnabled(false);
                    }
                });
                break;
                
             // Word "abstract"
            case 2:
                aButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter1.setText("A");
                        Letter6.setText("A");
                        Letter1.setVisible(true);
                        Letter6.setVisible(true);
                        aButton.setEnabled(false);
                        COUNTER += 2;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                bButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter2.setText("B");
                        Letter2.setVisible(true);
                        bButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                sButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter3.setText("S");
                        Letter3.setVisible(true);
                        bButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                tButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter4.setText("T");
                        Letter8.setText("T");
                        Letter4.setVisible(true);
                        Letter8.setVisible(true);
                        tButton.setEnabled(false);
                        COUNTER+= 2;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
               
                rButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter5.setText("R");
                        Letter5.setVisible(true);
                        rButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                cButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter7.setText("C");
                        Letter7.setVisible(true);
                        cButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                
                dButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        dButton.setEnabled(false);
                    }
                });
                eButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        eButton.setEnabled(false);
                    }
                });
                fButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        fButton.setEnabled(false);
                    }
                });
                gButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        gButton.setEnabled(false);
                    }
                });
                hButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        hButton.setEnabled(false);
                    }
                });
                iButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        iButton.setEnabled(false);
                    }
                });
                jButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        jButton.setEnabled(false);
                    }
                });
                kButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        kButton.setEnabled(false);
                    }
                });
                lButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        lButton.setEnabled(false);
                    }
                });
                mButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        mButton.setEnabled(false);
                    }
                });
                nButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        nButton.setEnabled(false);
                    }
                });
                oButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        oButton.setEnabled(false);
                    }
                });
                pButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        pButton.setEnabled(false);
                    }
                });
                qButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        qButton.setEnabled(false);
                    }
                });
                uButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        uButton.setEnabled(false);
                    }
                });
                vButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        vButton.setEnabled(false);
                    }
                });
                wButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        wButton.setEnabled(false);
                    }
                });
                xButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        xButton.setEnabled(false);
                    }
                });
                yButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        yButton.setEnabled(false);
                    }
                });
                zButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        zButton.setEnabled(false);
                    }
                });
                break;
                
            // Word "pharmacy"
            case 3: 
                pButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter1.setText("P");
                        Letter1.setVisible(true);
                        pButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                hButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter2.setText("H");
                        Letter2.setVisible(true);
                        hButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                aButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter3.setText("A");
                        Letter6.setText("A");
                        Letter3.setVisible(true);
                        Letter6.setVisible(true);
                        aButton.setEnabled(false);
                        COUNTER+= 2;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                mButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter5.setText("M");
                        Letter5.setVisible(true);
                        mButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                rButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter4.setText("R");
                        Letter4.setVisible(true);
                        rButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                cButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter7.setText("C");
                        Letter7.setVisible(true);
                        cButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                yButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter8.setText("Y");
                        Letter8.setVisible(true);
                        yButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                
                bButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        bButton.setEnabled(false);
                    }
                });
                dButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        dButton.setEnabled(false);
                    }
                });
                eButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        eButton.setEnabled(false);
                    }
                });
                fButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        fButton.setEnabled(false);
                    }
                });
                gButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        gButton.setEnabled(false);
                    }
                });
                iButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        iButton.setEnabled(false);
                    }
                });
                jButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        jButton.setEnabled(false);
                    }
                });
                kButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        kButton.setEnabled(false);
                    }
                });
                lButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        lButton.setEnabled(false);
                    }
                });
                nButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        nButton.setEnabled(false);
                    }
                });
                oButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        oButton.setEnabled(false);
                    }
                });
                qButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        qButton.setEnabled(false);
                    }
                });
                sButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        sButton.setEnabled(false);
                    }
                });
                tButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        tButton.setEnabled(false);
                    }
                });
                uButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        uButton.setEnabled(false);
                    }
                });
                vButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        vButton.setEnabled(false);
                    }
                });
                wButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        wButton.setEnabled(false);
                    }
                });
                xButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        xButton.setEnabled(false);
                    }
                });
                zButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        zButton.setEnabled(false);
                    }
                });
                break;
                
            // Word "climbing"
            case 4: 
                // these are the correct letters hence increasing scores and are disabled after being pressed
                cButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter1.setText("C");
                        Letter1.setVisible(true);
                        cButton.setEnabled(false);
                        COUNTER++;
                        if(COUNTER == 8) {
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                lButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Letter2.setText("L"); 
                        Letter2.setVisible(true);
                        lButton.setEnabled(false);
                        COUNTER++; 
                        if(COUNTER == 8){
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                }); 
                iButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Letter3.setText("I"); 
                        Letter6.setText("I");
                        Letter3.setVisible(true);
                        Letter6.setVisible(true); 
                        iButton.setEnabled(false);
                        COUNTER+= 2; 
                        if(COUNTER == 8){
                           try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                mButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Letter4.setText("M"); 
                        Letter4.setVisible(true);
                        mButton.setEnabled(false);
                        COUNTER++; 
                        if(COUNTER == 8){
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                bButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Letter5.setText("B"); 
                        Letter5.setVisible(true);
                        bButton.setEnabled(false);
                        COUNTER++; 
                        if(COUNTER == 8){
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                nButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Letter7.setText("N"); 
                        Letter7.setVisible(true);
                        nButton.setEnabled(false);
                        COUNTER++; 
                        if(COUNTER == 8){
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
                gButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Letter8.setText("G"); 
                        Letter8.setVisible(true);
                        gButton.setEnabled(false);
                        COUNTER++; 
                        if(COUNTER == 8){
                            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            setVisible(false);
                        }
                    }
                });
 
                aButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        aButton.setEnabled(false);
                    }
                });
                dButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        dButton.setEnabled(false);
                    }
                });
                eButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        eButton.setEnabled(false);
                    }
                });
                fButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        fButton.setEnabled(false);
                    }
                });
                hButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        hButton.setEnabled(false);
                    }
                });
                jButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        jButton.setEnabled(false);
                    }
                });
                kButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        kButton.setEnabled(false);
                    }
                });
                oButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        oButton.setEnabled(false);
                    }
                });
                pButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        pButton.setEnabled(false);
                    }
                });
                qButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        qButton.setEnabled(false);
                    }
                });
                rButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        rButton.setEnabled(false);
                    }
                });
                sButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        sButton.setEnabled(false);
                    }
                });
                tButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        tButton.setEnabled(false);
                    }
                });
                uButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        uButton.setEnabled(false);
                    }
                });
                vButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        vButton.setEnabled(false);
                    }
                });
                wButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        wButton.setEnabled(false);
                    }
                });
                xButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        xButton.setEnabled(false);
                    }
                });
                yButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        yButton.setEnabled(false);
                    }
                });
                zButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        wrongLetter();
                        zButton.setEnabled(false);
                    }
                });
                break;   
        }
    }
    
    // To calculate the score until EndScreen appear once the game is over
    public void wrongLetter(){
        SCORE-=10;
        if(SCORE == 90) {
            bbHead.setVisible(true);
        } else if(SCORE == 80) {
            bbLeftA.setVisible(true);
        } else if(SCORE == 70) {
            bbBody.setVisible(true);
        } else if(SCORE == 60) {
            bbLeftL.setVisible(true);
        } else if(SCORE == 50) {
            bbRightA.setVisible(true);
        } else if(SCORE == 40) {
            bbRightL.setVisible(true);
            
            //go to EndScreen
            setVisible(false);
            //new ColorGame(SCORE).setVisible(true);
            try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
            setVisible(false);
            this.dispose();
        }
        
        // Converts SCORE to String value since pointsLabel only accpets integer format
        String score = String.valueOf(SCORE);
        pointsLabel.setText(score);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        bButton = new javax.swing.JButton();
        cButton = new javax.swing.JButton();
        dButton = new javax.swing.JButton();
        eButton = new javax.swing.JButton();
        fButton = new javax.swing.JButton();
        iButton = new javax.swing.JButton();
        lButton = new javax.swing.JButton();
        gButton = new javax.swing.JButton();
        hButton = new javax.swing.JButton();
        qButton = new javax.swing.JButton();
        rButton = new javax.swing.JButton();
        nButton = new javax.swing.JButton();
        mButton = new javax.swing.JButton();
        oButton = new javax.swing.JButton();
        zButton = new javax.swing.JButton();
        yButton = new javax.swing.JButton();
        xButton = new javax.swing.JButton();
        wButton = new javax.swing.JButton();
        vButton = new javax.swing.JButton();
        uButton = new javax.swing.JButton();
        tButton = new javax.swing.JButton();
        sButton = new javax.swing.JButton();
        hmTop = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        skipButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        hmPole = new javax.swing.JLabel();
        hmBottom = new javax.swing.JLabel();
        hmHang = new javax.swing.JLabel();
        bbHead = new javax.swing.JLabel();
        bbBody = new javax.swing.JLabel();
        bbRightA = new javax.swing.JLabel();
        bbLeftA = new javax.swing.JLabel();
        bbLeftL = new javax.swing.JLabel();
        bbRightL = new javax.swing.JLabel();
        Letter1 = new javax.swing.JLabel();
        Letter2 = new javax.swing.JLabel();
        Letter3 = new javax.swing.JLabel();
        Letter4 = new javax.swing.JLabel();
        Letter5 = new javax.swing.JLabel();
        Letter6 = new javax.swing.JLabel();
        Letter7 = new javax.swing.JLabel();
        Letter8 = new javax.swing.JLabel();
        scLabel = new javax.swing.JLabel();
        pointsLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0));
        kButton = new javax.swing.JButton();
        pButton = new javax.swing.JButton();
        jButton = new javax.swing.JButton();
        aButton = new javax.swing.JButton();
        line1 = new javax.swing.JLabel();
        line2 = new javax.swing.JLabel();
        line3 = new javax.swing.JLabel();
        line4 = new javax.swing.JLabel();
        line5 = new javax.swing.JLabel();
        line6 = new javax.swing.JLabel();
        line7 = new javax.swing.JLabel();
        line8 = new javax.swing.JLabel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bblefta.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bButton.setBackground(new java.awt.Color(212, 226, 212));
        bButton.setText("B");
        bButton.setBorderPainted(false);
        bButton.setFocusPainted(false);
        getContentPane().add(bButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        cButton.setBackground(new java.awt.Color(212, 226, 212));
        cButton.setText("C");
        cButton.setBorderPainted(false);
        cButton.setFocusPainted(false);
        getContentPane().add(cButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        dButton.setBackground(new java.awt.Color(212, 226, 212));
        dButton.setText("D");
        dButton.setBorderPainted(false);
        dButton.setFocusPainted(false);
        getContentPane().add(dButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        eButton.setBackground(new java.awt.Color(212, 226, 212));
        eButton.setText("E");
        eButton.setBorderPainted(false);
        eButton.setFocusPainted(false);
        getContentPane().add(eButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        fButton.setBackground(new java.awt.Color(212, 226, 212));
        fButton.setText("F");
        fButton.setBorderPainted(false);
        fButton.setFocusPainted(false);
        getContentPane().add(fButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        iButton.setBackground(new java.awt.Color(212, 226, 212));
        iButton.setText("I");
        iButton.setBorderPainted(false);
        iButton.setFocusPainted(false);
        getContentPane().add(iButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 44, -1));

        lButton.setBackground(new java.awt.Color(212, 226, 212));
        lButton.setText("L");
        lButton.setBorderPainted(false);
        lButton.setFocusPainted(false);
        getContentPane().add(lButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        gButton.setBackground(new java.awt.Color(212, 226, 212));
        gButton.setText("G");
        gButton.setBorderPainted(false);
        gButton.setFocusPainted(false);
        getContentPane().add(gButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        hButton.setBackground(new java.awt.Color(212, 226, 212));
        hButton.setText("H");
        hButton.setBorderPainted(false);
        hButton.setFocusPainted(false);
        getContentPane().add(hButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        qButton.setBackground(new java.awt.Color(212, 226, 212));
        qButton.setText("Q");
        qButton.setBorderPainted(false);
        qButton.setFocusPainted(false);
        getContentPane().add(qButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, -1));

        rButton.setBackground(new java.awt.Color(212, 226, 212));
        rButton.setText("R");
        rButton.setBorderPainted(false);
        rButton.setFocusPainted(false);
        getContentPane().add(rButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        nButton.setBackground(new java.awt.Color(212, 226, 212));
        nButton.setText("N");
        nButton.setBorderPainted(false);
        nButton.setFocusPainted(false);
        getContentPane().add(nButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        mButton.setBackground(new java.awt.Color(212, 226, 212));
        mButton.setText("M");
        mButton.setBorderPainted(false);
        mButton.setFocusPainted(false);
        getContentPane().add(mButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        oButton.setBackground(new java.awt.Color(212, 226, 212));
        oButton.setText("O");
        oButton.setBorderPainted(false);
        oButton.setFocusPainted(false);
        getContentPane().add(oButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, -1));

        zButton.setBackground(new java.awt.Color(212, 226, 212));
        zButton.setText("Z");
        zButton.setBorderPainted(false);
        zButton.setFocusPainted(false);
        getContentPane().add(zButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        yButton.setBackground(new java.awt.Color(212, 226, 212));
        yButton.setText("Y");
        yButton.setBorderPainted(false);
        yButton.setFocusPainted(false);
        getContentPane().add(yButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, -1, -1));

        xButton.setBackground(new java.awt.Color(212, 226, 212));
        xButton.setText("X");
        xButton.setBorderPainted(false);
        xButton.setFocusPainted(false);
        getContentPane().add(xButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        wButton.setBackground(new java.awt.Color(212, 226, 212));
        wButton.setText("W");
        wButton.setBorderPainted(false);
        wButton.setFocusPainted(false);
        getContentPane().add(wButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        vButton.setBackground(new java.awt.Color(212, 226, 212));
        vButton.setText("V");
        vButton.setBorderPainted(false);
        vButton.setFocusPainted(false);
        getContentPane().add(vButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        uButton.setBackground(new java.awt.Color(212, 226, 212));
        uButton.setText("U");
        uButton.setBorderPainted(false);
        uButton.setFocusPainted(false);
        getContentPane().add(uButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        tButton.setBackground(new java.awt.Color(212, 226, 212));
        tButton.setText("T");
        tButton.setBorderPainted(false);
        tButton.setFocusPainted(false);
        getContentPane().add(tButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        sButton.setBackground(new java.awt.Color(212, 226, 212));
        sButton.setText("S");
        sButton.setBorderPainted(false);
        sButton.setFocusPainted(false);
        getContentPane().add(sButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        hmTop.setBackground(new java.awt.Color(252, 248, 232));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setText("Hangman");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel1.setText("Date and Time");

        skipButton.setBackground(new java.awt.Color(212, 226, 212));
        skipButton.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        skipButton.setText("Skip");
        skipButton.setBorderPainted(false);
        skipButton.setFocusPainted(false);
        skipButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                skipButtonMouseReleased(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hmtop.png"))); // NOI18N

        hmPole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hmpole.png"))); // NOI18N

        hmBottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hmbottom.png"))); // NOI18N

        hmHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hmhang.png"))); // NOI18N

        bbHead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bbhead.png"))); // NOI18N

        bbBody.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bbbody.png"))); // NOI18N

        bbRightA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bbrighta1.png"))); // NOI18N

        bbLeftA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bblefta1.png"))); // NOI18N

        bbLeftL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bbleftl.png"))); // NOI18N

        bbRightL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bbrightl1.png"))); // NOI18N

        Letter1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Letter1.setText("A");
        Letter1.setAlignmentX(10.0F);

        Letter2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Letter2.setText("A");

        Letter3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Letter3.setText("A");

        Letter4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Letter4.setText("A");

        Letter5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Letter5.setText("A");

        Letter6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Letter6.setText("A");

        Letter7.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Letter7.setText("A");

        Letter8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Letter8.setText("A");

        scLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        scLabel.setText("Score:");

        pointsLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pointsLabel.setText("100");
        pointsLabel.setToolTipText("");

        javax.swing.GroupLayout hmTopLayout = new javax.swing.GroupLayout(hmTop);
        hmTop.setLayout(hmTopLayout);
        hmTopLayout.setHorizontalGroup(
            hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hmTopLayout.createSequentialGroup()
                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hmTopLayout.createSequentialGroup()
                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(131, 131, 131)
                                        .addComponent(hmPole))
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hmBottom))))
                                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(hmHang))
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(hmTopLayout.createSequentialGroup()
                                                    .addComponent(bbLeftA)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(bbHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(bbBody)))
                                                .addGroup(hmTopLayout.createSequentialGroup()
                                                    .addComponent(bbLeftL)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(bbRightL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bbRightA))))
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel13))
                            .addComponent(jLabel2))
                        .addGap(65, 65, 65)
                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(filler10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addComponent(scLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pointsLabel))
                            .addComponent(skipButton)
                            .addComponent(jLabel1)))
                    .addGroup(hmTopLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addComponent(Letter1)
                                        .addGap(50, 50, 50)
                                        .addComponent(Letter2)
                                        .addGap(44, 44, 44)
                                        .addComponent(Letter3)
                                        .addGap(42, 42, 42)
                                        .addComponent(Letter4)
                                        .addGap(49, 49, 49)
                                        .addComponent(Letter5)
                                        .addGap(46, 46, 46)
                                        .addComponent(Letter6)
                                        .addGap(40, 40, 40)
                                        .addComponent(Letter7)
                                        .addGap(47, 47, 47)
                                        .addComponent(Letter8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filler14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(filler13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38)
                                .addComponent(filler15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(filler16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(filler17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(filler18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(filler19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(filler20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(88, 88, 88)
                                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(filler8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(hmTopLayout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(filler12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)
                                                .addComponent(filler11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(filler21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        hmTopLayout.setVerticalGroup(
            hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hmTopLayout.createSequentialGroup()
                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hmTopLayout.createSequentialGroup()
                        .addComponent(skipButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pointsLabel)
                            .addComponent(scLabel)))
                    .addGroup(hmTopLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addComponent(hmPole)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hmBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(bbRightA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(hmTopLayout.createSequentialGroup()
                                            .addComponent(bbHead)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(bbBody, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(bbLeftA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(hmHang))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bbLeftL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bbRightL, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hmTopLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(hmTopLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(filler14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8)
                                                .addComponent(filler13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(filler4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(13, 13, 13))
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(hmTopLayout.createSequentialGroup()
                                                .addComponent(filler21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14))
                                            .addGroup(hmTopLayout.createSequentialGroup()
                                                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15))
                                            .addGroup(hmTopLayout.createSequentialGroup()
                                                .addComponent(filler11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))))))
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(filler15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(filler16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hmTopLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))
                    .addGroup(hmTopLayout.createSequentialGroup()
                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(filler17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(filler18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(hmTopLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(filler19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hmTopLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Letter1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Letter5)
                                        .addComponent(Letter8)
                                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Letter2)
                                            .addComponent(Letter3)
                                            .addComponent(Letter4)
                                            .addComponent(Letter6)
                                            .addComponent(Letter7))))
                                .addGap(15, 15, 15)))
                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filler8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filler10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)))
                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(hmTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 500, 230));

        kButton.setBackground(new java.awt.Color(212, 226, 212));
        kButton.setText("K");
        kButton.setBorderPainted(false);
        kButton.setFocusPainted(false);
        getContentPane().add(kButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        pButton.setBackground(new java.awt.Color(212, 226, 212));
        pButton.setText("P");
        pButton.setBorderPainted(false);
        pButton.setFocusPainted(false);
        getContentPane().add(pButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        jButton.setBackground(new java.awt.Color(212, 226, 212));
        jButton.setText("J");
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        getContentPane().add(jButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        aButton.setBackground(new java.awt.Color(212, 226, 212));
        aButton.setText("A");
        aButton.setBorderPainted(false);
        aButton.setFocusPainted(false);
        getContentPane().add(aButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        line1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N
        getContentPane().add(line1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 2));

        line2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N
        getContentPane().add(line2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, 2));

        line3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N
        getContentPane().add(line3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, 2));

        line4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N
        getContentPane().add(line4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, 2));

        line5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N
        getContentPane().add(line5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, 2));

        line6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N
        getContentPane().add(line6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, 2));

        line7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N
        getContentPane().add(line7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, 2));

        line8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N
        getContentPane().add(line8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, 2));
        getContentPane().add(filler9, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 260, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // The skipButton is clicked to generate the EndScreen with SCORE = 0
    private void skipButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skipButtonMouseReleased
        SCORE = 0;
        //new ColorGame(SCORE).setVisible(true);
        try {
                                new ColorGame(SCORE).setVisible(true);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                            }
        setVisible(false);
        this.dispose();
    }//GEN-LAST:event_skipButtonMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Letter1;
    private javax.swing.JLabel Letter2;
    private javax.swing.JLabel Letter3;
    private javax.swing.JLabel Letter4;
    private javax.swing.JLabel Letter5;
    private javax.swing.JLabel Letter6;
    private javax.swing.JLabel Letter7;
    private javax.swing.JLabel Letter8;
    private javax.swing.JButton aButton;
    private javax.swing.JButton bButton;
    private javax.swing.JLabel bbBody;
    private javax.swing.JLabel bbHead;
    private javax.swing.JLabel bbLeftA;
    private javax.swing.JLabel bbLeftL;
    private javax.swing.JLabel bbRightA;
    private javax.swing.JLabel bbRightL;
    private javax.swing.JButton cButton;
    private javax.swing.JButton dButton;
    private javax.swing.JButton eButton;
    private javax.swing.JButton fButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler16;
    private javax.swing.Box.Filler filler17;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler20;
    private javax.swing.Box.Filler filler21;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JButton gButton;
    private javax.swing.JButton hButton;
    private javax.swing.JLabel hmBottom;
    private javax.swing.JLabel hmHang;
    private javax.swing.JLabel hmPole;
    private javax.swing.JPanel hmTop;
    private javax.swing.JButton iButton;
    private javax.swing.JButton jButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton kButton;
    private javax.swing.JButton lButton;
    private javax.swing.JLabel line1;
    private javax.swing.JLabel line2;
    private javax.swing.JLabel line3;
    private javax.swing.JLabel line4;
    private javax.swing.JLabel line5;
    private javax.swing.JLabel line6;
    private javax.swing.JLabel line7;
    private javax.swing.JLabel line8;
    private javax.swing.JButton mButton;
    private javax.swing.JButton nButton;
    private javax.swing.JButton oButton;
    private javax.swing.JButton pButton;
    private javax.swing.JLabel pointsLabel;
    private javax.swing.JButton qButton;
    private javax.swing.JButton rButton;
    private javax.swing.JButton sButton;
    private javax.swing.JLabel scLabel;
    private javax.swing.JButton skipButton;
    private javax.swing.JButton tButton;
    private javax.swing.JButton uButton;
    private javax.swing.JButton vButton;
    private javax.swing.JButton wButton;
    private javax.swing.JButton xButton;
    private javax.swing.JButton yButton;
    private javax.swing.JButton zButton;
    // End of variables declaration//GEN-END:variables
}

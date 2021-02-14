/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryant
 */
// please make this work
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import java.awt.Graphics; 
import java.awt.image.BufferedImage; 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;  
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends javax.swing.JFrame {

    /**
     * Creates new form Game
     */
    Timer timer; 
    public static final String[] wordBank = {"nurse", "cemetery", "abstract", "pharmacy", "climbing"}; 
    public static final int MAX_ERRORS = 5; 
    private String wordToFind; 
    private char[] wordFound; 
    private int nbErrors; 
    private ArrayList < String > letters = new ArrayList <>(); 
    
    public Game() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(252, 248, 232));
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        startGame();
       
        // this is for the clock (dont ask)
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
        
        hangMan();
        //idk if this works
    }
    public void startGame(){
        //Make Billy Bronco Invisible
        bbHead.setVisible(false);
        bbBody.setVisible(false);
        bbLeftA.setVisible(false);
        bbRightA.setVisible(false);
        bbLeftL.setVisible(false);
        bbRightL.setVisible(false);
        
        //Make Letters Invisible
        Letter1.setVisible(false);
        Letter2.setVisible(false);
        Letter3.setVisible(false);
        Letter4.setVisible(false);
        Letter5.setVisible(false);
        Letter6.setVisible(false);
        Letter7.setVisible(false);
        Letter8.setVisible(false);
    }
    public int SCORE = 100;
    private int COUNTER = 0; 
    public void hangMan(){
        Random random = new Random(); 
        int wordNumber = random.nextInt(wordBank.length);
        
        switch (wordNumber) { 
            case 0: //word "nurse"
                line6.setVisible(false);
                line7.setVisible(false);
                line8.setVisible(false);
                // loop (COUNTER < 5) {
                //     if each needed letter: n, u, r, s, e
                       // COUNTER++;
                       // repeat loop;
                    // else if enter letter not needed (rest of the alphabet) --> paste
                //exit loop when COUNTER == 5 to do this:
                    // String n = String.valueOf(SCORE) ; where n us just the string form of the score
                    // new EndScreen(n).setVisible(true);
                    // setVisible(false);
                    // this.dispose();
                //break; 
                nButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter1.setText("N");
                        Letter1.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 5) {
                            String n = String.valueOf(SCORE);
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                uButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter2.setText("U");
                        Letter2.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 5) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                rButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter3.setText("R");
                        Letter3.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 5) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                sButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter4.setText("S");
                        Letter4.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 5) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                eButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter5.setText("E");
                        Letter5.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 5) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
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
            case 1: // Cemetery
                cButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter1.setText("C");
                        Letter1.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
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
                        COUNTER+= 3;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                mButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter3.setText("M");
                        Letter3.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                tButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter5.setText("T");
                        Letter5.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                rButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter7.setText("R");
                        Letter7.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                yButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter8.setText("Y");
                        Letter8.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
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
            case 2: // word abstract
                aButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter1.setText("A");
                        Letter6.setText("A");
                        Letter1.setVisible(true);
                        Letter6.setVisible(true);
                        COUNTER += 2;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                bButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter2.setText("B");
                        Letter2.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                sButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter3.setText("S");
                        Letter3.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
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
                        COUNTER+= 2;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                sButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter3.setText("S");
                        Letter3.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                rButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter5.setText("R");
                        Letter5.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                cButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter7.setText("C");
                        Letter7.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
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
            case 3: //word "pharmacy"
                pButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter1.setText("P");
                        Letter1.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                hButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter2.setText("H");
                        Letter2.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
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
                        COUNTER+= 2;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                mButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter5.setText("M");
                        Letter5.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                rButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter4.setText("R");
                        Letter4.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                cButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter7.setText("C");
                        Letter7.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                yButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter8.setText("Y");
                        Letter8.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
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
            case 4: // word "climbing"
                cButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Letter1.setText("C");
                        Letter1.setVisible(true);
                        COUNTER++;
                        if(COUNTER == 8) {
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                
                lButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Letter2.setText("L"); 
                        Letter2.setVisible(true);
                        COUNTER++; 
                        if(COUNTER == 8){
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
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
                        COUNTER+= 2; 
                        if(COUNTER == 8){
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                }); 
                
                mButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Letter4.setText("M"); 
                        Letter4.setVisible(true);
                        COUNTER++; 
                        if(COUNTER == 8){
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                }); 
                
                bButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Letter5.setText("B"); 
                        Letter5.setVisible(true);
                        COUNTER++; 
                        if(COUNTER == 8){
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                
                nButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Letter7.setText("N"); 
                        Letter7.setVisible(true);
                        COUNTER++; 
                        if(COUNTER == 8){
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
                            setVisible(false);
                        }
                    }
                });
                
                gButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Letter8.setText("G"); 
                        Letter8.setVisible(true);
                        COUNTER++; 
                        if(COUNTER == 8){
                            String n = String.valueOf(SCORE); 
                            new EndScreen(n).setVisible(true);
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
    public void wrongLetter(){
        SCORE-=10;
        System.out.println(SCORE);
        if(SCORE == 90) {
            bbHead.setVisible(true);
        }
        else if(SCORE == 80) {
            bbLeftA.setVisible(true);
        }
        else if(SCORE == 70) {
            bbBody.setVisible(true);
        }
        else if(SCORE == 60) {
            bbLeftL.setVisible(true);
        }
        else if(SCORE == 50) {
            bbRightA.setVisible(true);
        }
        else if(SCORE == 40) {
            bbRightL.setVisible(true);
            //go to EndScreen
            String n = String.valueOf(SCORE) ;
            new EndScreen(n).setVisible(true);
            setVisible(false);
            this.dispose();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
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
        jButton27 = new javax.swing.JButton();
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

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bblefta.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        bButton.setBackground(new java.awt.Color(212, 226, 212));
        bButton.setText("B");
        bButton.setBorderPainted(false);
        bButton.setFocusPainted(false);

        cButton.setBackground(new java.awt.Color(212, 226, 212));
        cButton.setText("C");
        cButton.setBorderPainted(false);
        cButton.setFocusPainted(false);

        dButton.setBackground(new java.awt.Color(212, 226, 212));
        dButton.setText("D");
        dButton.setBorderPainted(false);
        dButton.setFocusPainted(false);

        eButton.setBackground(new java.awt.Color(212, 226, 212));
        eButton.setText("E");
        eButton.setBorderPainted(false);
        eButton.setFocusPainted(false);

        fButton.setBackground(new java.awt.Color(212, 226, 212));
        fButton.setText("F");
        fButton.setBorderPainted(false);
        fButton.setFocusPainted(false);

        iButton.setBackground(new java.awt.Color(212, 226, 212));
        iButton.setText("I");
        iButton.setBorderPainted(false);
        iButton.setFocusPainted(false);

        lButton.setBackground(new java.awt.Color(212, 226, 212));
        lButton.setText("L");
        lButton.setBorderPainted(false);
        lButton.setFocusPainted(false);

        gButton.setBackground(new java.awt.Color(212, 226, 212));
        gButton.setText("G");
        gButton.setBorderPainted(false);
        gButton.setFocusPainted(false);

        hButton.setBackground(new java.awt.Color(212, 226, 212));
        hButton.setText("H");
        hButton.setBorderPainted(false);
        hButton.setFocusPainted(false);

        qButton.setBackground(new java.awt.Color(212, 226, 212));
        qButton.setText("Q");
        qButton.setBorderPainted(false);
        qButton.setFocusPainted(false);

        rButton.setBackground(new java.awt.Color(212, 226, 212));
        rButton.setText("R");
        rButton.setBorderPainted(false);
        rButton.setFocusPainted(false);

        nButton.setBackground(new java.awt.Color(212, 226, 212));
        nButton.setText("N");
        nButton.setBorderPainted(false);
        nButton.setFocusPainted(false);
        nButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nButtonActionPerformed(evt);
            }
        });

        mButton.setBackground(new java.awt.Color(212, 226, 212));
        mButton.setText("M");
        mButton.setBorderPainted(false);
        mButton.setFocusPainted(false);

        oButton.setBackground(new java.awt.Color(212, 226, 212));
        oButton.setText("O");
        oButton.setBorderPainted(false);
        oButton.setFocusPainted(false);

        zButton.setBackground(new java.awt.Color(212, 226, 212));
        zButton.setText("Z");
        zButton.setBorderPainted(false);
        zButton.setFocusPainted(false);

        yButton.setBackground(new java.awt.Color(212, 226, 212));
        yButton.setText("Y");
        yButton.setBorderPainted(false);
        yButton.setFocusPainted(false);

        xButton.setBackground(new java.awt.Color(212, 226, 212));
        xButton.setText("X");
        xButton.setBorderPainted(false);
        xButton.setFocusPainted(false);

        wButton.setBackground(new java.awt.Color(212, 226, 212));
        wButton.setText("W");
        wButton.setBorderPainted(false);
        wButton.setFocusPainted(false);

        vButton.setBackground(new java.awt.Color(212, 226, 212));
        vButton.setText("V");
        vButton.setBorderPainted(false);
        vButton.setFocusPainted(false);

        uButton.setBackground(new java.awt.Color(212, 226, 212));
        uButton.setText("U");
        uButton.setBorderPainted(false);
        uButton.setFocusPainted(false);

        tButton.setBackground(new java.awt.Color(212, 226, 212));
        tButton.setText("T");
        tButton.setBorderPainted(false);
        tButton.setFocusPainted(false);

        sButton.setBackground(new java.awt.Color(212, 226, 212));
        sButton.setText("S");
        sButton.setBorderPainted(false);
        sButton.setFocusPainted(false);

        hmTop.setBackground(new java.awt.Color(252, 248, 232));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setText("Hangman");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel1.setText("Date and Time");

        jButton27.setBackground(new java.awt.Color(212, 226, 212));
        jButton27.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jButton27.setText("Skip");
        jButton27.setBorderPainted(false);
        jButton27.setFocusPainted(false);
        jButton27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton27MouseReleased(evt);
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

        Letter1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Letter1.setText("A");

        Letter2.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Letter2.setText("A");

        Letter3.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Letter3.setText("A");

        Letter4.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Letter4.setText("A");

        Letter5.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Letter5.setText("A");

        Letter6.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Letter6.setText("A");

        Letter7.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Letter7.setText("A");

        Letter8.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Letter8.setText("A");

        javax.swing.GroupLayout hmTopLayout = new javax.swing.GroupLayout(hmTop);
        hmTop.setLayout(hmTopLayout);
        hmTopLayout.setHorizontalGroup(
            hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hmTopLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(Letter1)
                .addGap(48, 48, 48)
                .addComponent(Letter2)
                .addGap(44, 44, 44)
                .addComponent(Letter3)
                .addGap(42, 42, 42)
                .addComponent(Letter4)
                .addGap(49, 49, 49)
                .addComponent(Letter5)
                .addGap(46, 46, 46)
                .addComponent(Letter6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(Letter7)
                .addGap(47, 47, 47)
                .addComponent(Letter8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hmTopLayout.createSequentialGroup()
                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hmTopLayout.createSequentialGroup()
                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(hmPole))
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(hmBottom)))
                        .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
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
                                        .addComponent(bbRightL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bbRightA))
                            .addGroup(hmTopLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(hmHang))))
                    .addGroup(hmTopLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel13))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton27))
                .addGap(17, 17, 17))
        );
        hmTopLayout.setVerticalGroup(
            hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hmTopLayout.createSequentialGroup()
                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton27)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(hmTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Letter1)
                    .addComponent(Letter2)
                    .addComponent(Letter3)
                    .addComponent(Letter4)
                    .addComponent(Letter5)
                    .addComponent(Letter6)
                    .addComponent(Letter7)
                    .addComponent(Letter8))
                .addContainerGap())
        );

        kButton.setBackground(new java.awt.Color(212, 226, 212));
        kButton.setText("K");
        kButton.setBorderPainted(false);
        kButton.setFocusPainted(false);

        pButton.setBackground(new java.awt.Color(212, 226, 212));
        pButton.setText("P");
        pButton.setBorderPainted(false);
        pButton.setFocusPainted(false);

        jButton.setBackground(new java.awt.Color(212, 226, 212));
        jButton.setText("J");
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);

        aButton.setBackground(new java.awt.Color(212, 226, 212));
        aButton.setText("A");
        aButton.setBorderPainted(false);
        aButton.setFocusPainted(false);

        line1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N

        line2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N

        line3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N

        line4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N

        line5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N

        line6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N

        line7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N

        line8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lines1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hmTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(kButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(oButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(qButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(aButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(eButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(gButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(hButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(iButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(line1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(line2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(line3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(line4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(line5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(line6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(line7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(line8)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hmTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 5, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(line3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(line2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(line6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(line5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(line4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(line8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(line7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iButton)
                    .addComponent(aButton)
                    .addComponent(bButton)
                    .addComponent(cButton)
                    .addComponent(dButton)
                    .addComponent(eButton)
                    .addComponent(fButton)
                    .addComponent(gButton)
                    .addComponent(hButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton)
                    .addComponent(kButton)
                    .addComponent(lButton)
                    .addComponent(mButton)
                    .addComponent(oButton)
                    .addComponent(nButton)
                    .addComponent(pButton)
                    .addComponent(qButton)
                    .addComponent(rButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sButton)
                    .addComponent(tButton)
                    .addComponent(uButton)
                    .addComponent(vButton)
                    .addComponent(wButton)
                    .addComponent(xButton)
                    .addComponent(yButton)
                    .addComponent(zButton))
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nButtonActionPerformed

    }//GEN-LAST:event_nButtonActionPerformed

    private void jButton27MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton27MouseReleased
        SCORE = 0;
        String n = String.valueOf(SCORE) ;
        new EndScreen(n).setVisible(true);
        setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton27MouseReleased

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() { 
            public void run() {
                new Game().setVisible(true);
            }
        });

    }

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
    private javax.swing.JButton gButton;
    private javax.swing.JButton hButton;
    private javax.swing.JLabel hmBottom;
    private javax.swing.JLabel hmHang;
    private javax.swing.JLabel hmPole;
    private javax.swing.JPanel hmTop;
    private javax.swing.JButton iButton;
    private javax.swing.JButton jButton;
    private javax.swing.JButton jButton27;
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
    private javax.swing.JButton qButton;
    private javax.swing.JButton rButton;
    private javax.swing.JButton sButton;
    private javax.swing.JButton tButton;
    private javax.swing.JButton uButton;
    private javax.swing.JButton vButton;
    private javax.swing.JButton wButton;
    private javax.swing.JButton xButton;
    private javax.swing.JButton yButton;
    private javax.swing.JButton zButton;
    // End of variables declaration//GEN-END:variables
}

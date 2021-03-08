import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Toolkit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryant
 */
public class Sudoku extends javax.swing.JFrame implements KeyListener {
    
    int sudokuScore = 540; 
    int finalScore; 
    int correctBoxes = 54; 
    /**
     * Creates new form Sudoku
     */
    Timer timer; 
    public Sudoku() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(250, 250, 250));
        setLocationRelativeTo(null);
        startTimer(); 
        addKeyListener(this); 
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);       
              
        //component.getInputMap().put(KeyStroke.getKeyStroke("ESC"), "esc");
        //JOptionPane.showMessageDialog(this, "hello", "A plain message", JOptionPane.PLAIN_MESSAGE); 
    }
    
    /*
    method (char input) 
        if input (<=48
    
    */
    
    public Sudoku(int score){
        initComponents();
        getContentPane().setBackground(new java.awt.Color(250, 250, 250));
        setLocationRelativeTo(null);
        startTimer(); 
        addKeyListener(this); 
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        checkGame(); 
        int finalScore = score; 
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key typed"); 
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
           // System.out.println("hello"); 
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
           // System.out.println("hello"); 
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_F1){
            JOptionPane.showMessageDialog(this, "Vicnent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
                    "Nhi Nguyen #013925392 \n" + "Term: Spring 2021", "Swing Project", JOptionPane.PLAIN_MESSAGE);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
           // System.out.println("hello"); 
            System.exit(0);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_F1){
            JOptionPane.showMessageDialog(this, "Vicnent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
                    "Nhi Nguyen #013925392 \n" + "Term: Spring 2021", "Swing Project", JOptionPane.PLAIN_MESSAGE);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
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
    
    public void checkCharacter(){
        String input = A2.getText();
        char input_char = input.charAt(1);
       if(!(input_char >= 49 && input_char <= 57 )){
           //errorLabel.setVisible(true);
           System.out.println("awkward");
       } 
       else{
           System.out.println("we good");
       }
    }

    public void wrongScore(){
        sudokuScore -= 10;
    }
    
    public void rightScore() throws IOException {
        correctBoxes--; 
        if(correctBoxes == 0){
            finalScore += sudokuScore;  
            setVisible(false);
            //new ColorGame(SCORE).setVisible(true);
            new EndScreen(finalScore).setVisible(true);
            setVisible(false);
            this.dispose();
        }
    }
    
    public void checkGame(){
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                // A Panel 
                int a2value = Integer.parseInt(A2.getText());
                int i = 0;
                if(!(a2value == 3) ){
                   
                   if (i < 0) {
                    wrongScore(); 
                    i++;
                   }
                   A2.setForeground(Color.RED); 
                   System.out.println(sudokuScore);
                }
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
                   wrongScore(); 
                   A3.setForeground(Color.RED);
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
                    wrongScore(); 
                    A4.setForeground(Color.RED);
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
                    wrongScore(); 
                    A5.setForeground(Color.RED);
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
                    wrongScore(); 
                    A6.setForeground(Color.RED);
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
                    wrongScore(); 
                    A7.setForeground(Color.RED);
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
                    wrongScore(); 
                    A9.setForeground(Color.RED);
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
                }
                int b4value = Integer.parseInt(B4.getText());
                if(!(b4value == 8)){
                    wrongScore(); 
                }
                int b5value = Integer.parseInt(B5.getText());
                if(!(b5value == 5)){
                    wrongScore(); 
                }
                int b6value = Integer.parseInt(B6.getText());
                if(!(b6value == 7)){
                    wrongScore(); 
                }
                int b7value = Integer.parseInt(B7.getText());
                if(!(b7value == 2)){
                    wrongScore(); 
                }
                int b8value = Integer.parseInt(B8.getText());
                if(!(b8value == 9)){
                    wrongScore(); 
                }
                int b9value = Integer.parseInt(B9.getText());
                if(!(b9value == 3)){
                    wrongScore(); 
                }
                
                // C Panel
                int c1value = Integer.parseInt(C1.getText());
                if(!(c1value == 9)){
                    wrongScore(); 
                }
                int c2value = Integer.parseInt(C2.getText());
                if(!(c2value == 2)){
                    wrongScore(); 
                }
                int c5value = Integer.parseInt(C5.getText());
                if(!(c5value == 3)){
                    wrongScore(); 
                }
                int c6value = Integer.parseInt(C6.getText());
                if(!(c6value == 1)){
                    wrongScore(); 
                }
                int c9value = Integer.parseInt(C9.getText());
                if(!(c9value == 8)){
                    wrongScore(); 
                }
                
                // D Panel
                int d2value = Integer.parseInt(D2.getText());
                if(!(d2value == 6)){
                    wrongScore(); 
                }
                int d4value = Integer.parseInt(D4.getText());
                if(!(d4value == 1)){
                    wrongScore(); 
                }
                int d5value = Integer.parseInt(D5.getText());
                if(!(d5value == 2)){
                    wrongScore(); 
                }
                int d6value = Integer.parseInt(D6.getText());
                if(!(d6value == 3)){
                    wrongScore(); 
                }
                int d7value = Integer.parseInt(D7.getText());
                if(!(d7value == 7)){
                    wrongScore(); 
                }
                
                // I Panel 
                int i1value = Integer.parseInt(I1.getText());
                if(!(i1value == 3)){
                    wrongScore(); 
                }
                int i3value = Integer.parseInt(I3.getText());
                if(!(i3value == 4)){
                    wrongScore(); 
                }
                int i4value = Integer.parseInt(I4.getText());
                if(!(i4value == 2)){
                    wrongScore(); 
                }
                int i5value = Integer.parseInt(I5.getText());
                if(!(i5value == 7)){
                    wrongScore(); 
                }
                int i6value = Integer.parseInt(I6.getText());
                if(!(i6value == 6)){
                    wrongScore(); 
                }
                int i7value = Integer.parseInt(I7.getText());
                if(!(i7value == 8)){
                    wrongScore(); 
                }
                int i8value = Integer.parseInt(I8.getText());
                if(!(i8value == 1)){
                    wrongScore(); 
                }
                
                 // PANEL E
                int e1value = Integer.parseInt(E1.getText());
                if(!(e1value == 1)){
                    wrongScore();
                }
                int e3value = Integer.parseInt(E3.getText());
                if(!(e3value == 4)){
                    wrongScore();
                }
                int e4value = Integer.parseInt(E4.getText());
                if(!(e4value == 6)){
                   wrongScore(); 
                }
                int e6value = Integer.parseInt(E6.getText());
                if(!(e6value == 8)){
                   wrongScore(); 
                }
                int e7value = Integer.parseInt(E7.getText());
                if(!(e7value == 5)){
                   wrongScore(); 
                }
                int e9value = Integer.parseInt(E9.getText());
                if(!(e9value == 9)){
                   wrongScore(); 
                }
                // PANEL F
                int f3value = Integer.parseInt(F3.getText());
                if(!(f3value == 2)){
                   wrongScore(); 
                }
                int f4value = Integer.parseInt(F4.getText());
                if(!(f4value == 5)){
                   wrongScore(); 
                }
                int f5value = Integer.parseInt(F5.getText());
                if(!(f5value == 4)){
                   wrongScore(); 
                }
                int f6value = Integer.parseInt(F6.getText());
                if(!(f6value == 9)){
                   wrongScore(); 
                }
                int f8value = Integer.parseInt(F8.getText());
                if(!(f8value == 6)){
                   wrongScore(); 
                }
                // PANEL G
                int g1value = Integer.parseInt(G1.getText());
                if(!(g1value == 6)){
                   wrongScore(); 
                }
                int g4value = Integer.parseInt(G4.getText());
                if(!(g4value == 9)){
                   wrongScore(); 
                }
                int g5value = Integer.parseInt(G5.getText());
                if(!(g5value == 8)){
                   wrongScore(); 
                }
                int g8value = Integer.parseInt(G8.getText());
                if(!(g8value == 7)){
                   wrongScore(); 
                }
                int g9value = Integer.parseInt(G9.getText());
                if(!(g9value == 4)){
                   wrongScore(); 
                }
                // PANEL H
                int h1value = Integer.parseInt(H1.getText());
                if(!(h1value == 7)){
                   wrongScore(); 
                }
                int h2value = Integer.parseInt(H2.getText());
                if(!(h2value == 8)){
                   wrongScore(); 
                }
                int h3value = Integer.parseInt(H3.getText());
                if(!(h3value == 1)){
                   wrongScore(); 
                }
                int h4value = Integer.parseInt(H4.getText());
                if(!(h4value == 3)){
                   wrongScore(); 
                }
                int h5value = Integer.parseInt(H5.getText());
                if(!(h5value == 4)){
                   wrongScore(); 
                }
                int h6value = Integer.parseInt(H6.getText());
                if(!(h6value == 5)){
                   wrongScore(); 
                }
                int h8value = Integer.parseInt(H8.getText());
                if(!(h8value == 6)){
                   wrongScore(); 
                }
                
                /*
                finalScore += sudokuScore;  
                EndScreen end; 
                try {
                    end = new EndScreen(finalScore);
                    end.setVisible(true); 
                } catch (IOException ex) {
                    Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
                }
                */
                
                    }
                }); 
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jPanel1.setMinimumSize(null);
        jPanel1.setPreferredSize(new java.awt.Dimension(151, 121));

        A1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        A1.setText("8");
        A1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        A2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A2ActionPerformed(evt);
            }
        });
        A2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                A2KeyTyped(evt);
            }
        });

        A3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A3ActionPerformed(evt);
            }
        });

        A5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A5ActionPerformed(evt);
            }
        });

        A4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A4ActionPerformed(evt);
            }
        });

        A6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A6ActionPerformed(evt);
            }
        });

        A7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A7ActionPerformed(evt);
            }
        });

        A9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        A9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A9ActionPerformed(evt);
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
        jPanel2.setMinimumSize(null);
        jPanel2.setPreferredSize(new java.awt.Dimension(151, 121));

        I3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I3ActionPerformed(evt);
            }
        });

        I5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I5ActionPerformed(evt);
            }
        });

        I4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I4ActionPerformed(evt);
            }
        });

        I6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I6ActionPerformed(evt);
            }
        });

        I7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I7ActionPerformed(evt);
            }
        });

        I8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        I8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        I8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I8ActionPerformed(evt);
            }
        });

        I1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jPanel3.setMinimumSize(null);
        jPanel3.setPreferredSize(new java.awt.Dimension(151, 121));

        B1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        B1.setText("4");
        B1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        B2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });

        B5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });

        B4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });

        B6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });

        B7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });

        B8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });

        B9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        B9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        B9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B9ActionPerformed(evt);
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
        jPanel4.setMinimumSize(null);
        jPanel4.setPreferredSize(new java.awt.Dimension(151, 121));

        C2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C2ActionPerformed(evt);
            }
        });

        C5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C5ActionPerformed(evt);
            }
        });

        C6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C6ActionPerformed(evt);
            }
        });

        C9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        C9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        C9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C9ActionPerformed(evt);
            }
        });

        C1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jPanel5.setMinimumSize(null);
        jPanel5.setPreferredSize(new java.awt.Dimension(151, 121));

        E3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E3ActionPerformed(evt);
            }
        });

        E4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E4ActionPerformed(evt);
            }
        });

        E6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E6ActionPerformed(evt);
            }
        });

        E7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E7ActionPerformed(evt);
            }
        });

        E9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E9ActionPerformed(evt);
            }
        });

        E1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        E1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        E1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E1ActionPerformed(evt);
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
        jPanel6.setMinimumSize(null);
        jPanel6.setPreferredSize(new java.awt.Dimension(151, 121));

        F1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F1.setText("7");
        F1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        F3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F3ActionPerformed(evt);
            }
        });

        F5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F5ActionPerformed(evt);
            }
        });

        F4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F4ActionPerformed(evt);
            }
        });

        F6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F6ActionPerformed(evt);
            }
        });

        F8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        F8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F8ActionPerformed(evt);
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
        jPanel7.setMinimumSize(null);
        jPanel7.setPreferredSize(new java.awt.Dimension(151, 121));

        D1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D1.setText("5");
        D1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        D2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D2ActionPerformed(evt);
            }
        });

        D5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D5ActionPerformed(evt);
            }
        });

        D4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D4ActionPerformed(evt);
            }
        });

        D6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D6ActionPerformed(evt);
            }
        });

        D7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        D7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        D7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D7ActionPerformed(evt);
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
        jPanel8.setMinimumSize(null);
        jPanel8.setPreferredSize(new java.awt.Dimension(151, 121));

        G5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G5ActionPerformed(evt);
            }
        });

        G4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G4ActionPerformed(evt);
            }
        });

        G8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G8ActionPerformed(evt);
            }
        });

        G9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        G9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        G9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G9ActionPerformed(evt);
            }
        });

        G1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jPanel9.setMinimumSize(null);
        jPanel9.setPreferredSize(new java.awt.Dimension(151, 121));

        H2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H2ActionPerformed(evt);
            }
        });

        H3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H3ActionPerformed(evt);
            }
        });

        H5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5ActionPerformed(evt);
            }
        });

        H4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4ActionPerformed(evt);
            }
        });

        H6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6ActionPerformed(evt);
            }
        });

        H8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H8ActionPerformed(evt);
            }
        });

        H1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        H1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        H1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H1ActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void A2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A2ActionPerformed

    private void A3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A3ActionPerformed

    private void A5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A5ActionPerformed

    private void A4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A4ActionPerformed

    private void A6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A6ActionPerformed

    private void A7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A7ActionPerformed

    private void A9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A9ActionPerformed

    private void I3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_I3ActionPerformed

    private void I5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_I5ActionPerformed

    private void I4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_I4ActionPerformed

    private void I6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_I6ActionPerformed

    private void I7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_I7ActionPerformed

    private void I8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_I8ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B2ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B5ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B4ActionPerformed

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B6ActionPerformed

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B7ActionPerformed

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B8ActionPerformed

    private void B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B9ActionPerformed

    private void C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C2ActionPerformed

    private void C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C5ActionPerformed

    private void C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C6ActionPerformed

    private void C9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_C9ActionPerformed

    private void E3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_E3ActionPerformed

    private void E4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_E4ActionPerformed

    private void E6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_E6ActionPerformed

    private void E7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_E7ActionPerformed

    private void E9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_E9ActionPerformed

    private void F3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_F3ActionPerformed

    private void F5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_F5ActionPerformed

    private void F4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_F4ActionPerformed

    private void F6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_F6ActionPerformed

    private void F8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_F8ActionPerformed

    private void D2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D2ActionPerformed

    private void D5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D5ActionPerformed

    private void D4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D4ActionPerformed

    private void D6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D6ActionPerformed

    private void D7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D7ActionPerformed

    private void G5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G5ActionPerformed

    private void G4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G4ActionPerformed

    private void G8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G8ActionPerformed

    private void G9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G9ActionPerformed

    private void H2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_H2ActionPerformed

    private void H3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_H3ActionPerformed

    private void H5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_H5ActionPerformed

    private void H4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_H4ActionPerformed

    private void H6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_H6ActionPerformed

    private void H8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_H8ActionPerformed

    private void E1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_E1ActionPerformed

    private void H1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_H1ActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonActionPerformed

    private void A2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A2KeyTyped
        int c = evt.getKeyChar(); 
        if(A2.getText().length() > 0 || c == KeyEvent.VK_0 || !(Character.isDigit(c))) { 
           System.out.println("awkward");
           Toolkit.getDefaultToolkit().beep(); 
           evt.consume();
       } else {
           System.out.println("we good");
       }
    }//GEN-LAST:event_A2KeyTyped
 
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

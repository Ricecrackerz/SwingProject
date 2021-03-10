/*
 * @author TonyDiaz Stans hi
 */

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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ColorGame extends javax.swing.JFrame implements KeyListener {
    
    // Creates new ColorGame
    Timer timer;
    String[] colorsList = {"Green", "Red", "Yellow", "Orange", "Blue"};
    int score = 0;
    String textColor; 
    int rounds = 5;
      
    public ColorGame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(250, 250, 250));
        setSize(600,400);
        setLocationRelativeTo(null);
        
        startTimer(); 
        setGameLabel(); 
        setButton();
        startGame();
    }
    
    public ColorGame(int s) throws FileNotFoundException{
        score = s;
        initComponents();
        getContentPane().setBackground(new java.awt.Color(250, 250, 250));
        setSize(600,400);
        setLocationRelativeTo(null);
        
        startTimer(); 
        setGameLabel(); 
        setButton();
        startGame();
        addKeyListener(this); 
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key typed"); 
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
           // System.out.println("hello"); 
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
           // System.out.println("hello"); 
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_F1){
            JOptionPane.showMessageDialog(this, "Vincent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
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
            JOptionPane.showMessageDialog(this, "Vincent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
                    "Nhi Nguyen #013925392 \n" + "Term: Spring 2021", "Swing Project", JOptionPane.PLAIN_MESSAGE);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    // To display current Date & Time
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
    
     // To randomly choose the color name and the color of the text
    public void setGameLabel(){
        
        Random random = new Random();
        
        // Randomize the text
        int text = random.nextInt(colorsList.length);
        if(text == 0){
            gameLabel.setText("Green");
        } else if (text == 1){
            gameLabel.setText("Red");
        } else if (text == 2){
            gameLabel.setText("Blue");
        } else if (text == 3){
            gameLabel.setText("Orange");
        } else if (text == 4){
            gameLabel.setText("Yellow");
        }
        
        // Randomize the text color       
        int textColor = random.nextInt(colorsList.length);         
        if(textColor == 0){
            gameLabel.setForeground(Color.GREEN);
        } else if (textColor == 1){
            gameLabel.setForeground(Color.RED);
        } else if (textColor == 2){
            gameLabel.setForeground(Color.BLUE);
        } else if (textColor == 3){
            gameLabel.setForeground(Color.ORANGE);
        } else if (textColor == 4){
            gameLabel.setForeground(Color.YELLOW);
        }
    }
    
    // To check if the game is still running or jump to EndScreen
    public void checkRounds() throws FileNotFoundException, IOException {
        rounds -= 1;
        if (rounds == 0) {
            setVisible(false); 
            Sudoku sudoku = new Sudoku(score);
            sudoku.setVisible(true); 
            this.dispose(); 
        }
    }
    
    // The logic of the ColorGame here to choose correct color for points
    public void startGame(){    
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(gameLabel.getForeground() == redButton.getForeground()){
                    score +=100;
                    setGameLabel();  
                    setButton(); 
                }       
                else{
                    setGameLabel(); 
                    setButton();
                }
                try {
                    checkRounds();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
        }); 
        greenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(gameLabel.getForeground() == greenButton.getForeground()){
                    score +=100;
                    setGameLabel(); 
                    setButton(); 
                }       
                else{
                    setGameLabel(); 
                    setButton(); 
                }
                try { 
                    checkRounds();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });    
        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(gameLabel.getForeground() == blueButton.getForeground()){
                    score +=100;
                    setGameLabel(); 
                    setButton(); 
                }       
                else{
                    setGameLabel(); 
                    setButton();  
                }
                try {
                    checkRounds();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
        yellowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(gameLabel.getForeground() == yellowButton.getForeground()){
                    score +=100;
                    setGameLabel(); 
                    setButton(); 
                }       
                else{
                    setGameLabel(); 
                    setButton(); 
                }
                try {
                    checkRounds();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }); 
        orangeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(gameLabel.getForeground() == orangeButton.getForeground()){
                    score +=100;
                    setGameLabel(); 
                    setButton(); 
                }       
                else{
                    setGameLabel(); 
                    setButton();  
                }
                try { 
                    checkRounds();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });               
    }
    
    // To randomize the positions of the buttons each time the game starts
    public void setButton(){
         
        Random random = new Random(); 
        int setPosition = random.nextInt(7);
         
        redButton.setForeground(Color.RED); 
        blueButton.setForeground(Color.BLUE); 
        yellowButton.setForeground(Color.YELLOW); 
        greenButton.setForeground(Color.GREEN); 
        orangeButton.setForeground(Color.ORANGE); 
         
        switch(setPosition) {
            case 0:
                redButton.setBounds(150, 150, 50, 50); 
                this.add(redButton);
                blueButton.setBounds(410, 225, 50, 50); 
                this.add(blueButton);
                yellowButton.setBounds(300, 100, 50, 50); 
                this.add(yellowButton);
                greenButton.setBounds(250, 250, 50, 50); 
                this.add(greenButton);
                orangeButton.setBounds(70, 280, 50, 50); 
                this.add(orangeButton);
                break;
             case 1:
                redButton.setBounds(250, 150, 50, 50); 
                this.add(redButton);
                blueButton.setBounds(150, 100, 50, 50); 
                this.add(blueButton);
                yellowButton.setBounds(400, 100, 50, 50); 
                this.add(yellowButton);
                greenButton.setBounds(350, 250, 50, 50); 
                this.add(greenButton);
                orangeButton.setBounds(170, 280, 50, 50); 
                this.add(orangeButton);
                break;
            case 2:
                redButton.setBounds(75, 100, 50, 50); 
                this.add(redButton);
                blueButton.setBounds(400, 150, 50, 50); 
                this.add(blueButton);
                yellowButton.setBounds(100, 260, 50, 50); 
                this.add(yellowButton);
                greenButton.setBounds(250, 150, 50, 50); 
                this.add(greenButton);
                orangeButton.setBounds(350, 235, 50, 50); 
                this.add(orangeButton);
                break;
            case 3:
                redButton.setBounds(450, 150, 50, 50); 
                this.add(redButton);
                blueButton.setBounds(300, 100, 50, 50); 
                this.add(blueButton);
                yellowButton.setBounds(125, 100, 50, 50); 
                this.add(yellowButton);
                greenButton.setBounds(100, 260, 50, 50); 
                this.add(greenButton);
                orangeButton.setBounds(350, 235, 50, 50); 
                this.add(orangeButton);
                break;
            case 4: 
                redButton.setBounds(230, 280, 50, 50); 
                this.add(redButton);
                blueButton.setBounds(300, 200, 50, 50); 
                this.add(blueButton);
                yellowButton.setBounds(400, 100, 50, 50); 
                this.add(yellowButton);
                greenButton.setBounds(100, 250, 50, 50); 
                this.add(greenButton);
                orangeButton.setBounds(100, 100, 50, 50); 
                this.add(orangeButton);
                break;
            case 5:
                redButton.setBounds(230, 100, 50, 50); 
                this.add(redButton);
                blueButton.setBounds(230, 260, 50, 50); 
                this.add(blueButton);
                yellowButton.setBounds(100, 150, 50, 50); 
                this.add(yellowButton);
                greenButton.setBounds(400, 150, 50, 50); 
                this.add(greenButton);
                orangeButton.setBounds(300, 250, 50, 50); 
                this.add(orangeButton);
                break;
         }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        time_dateLabel = new javax.swing.JLabel();
        gameLabel = new javax.swing.JLabel();
        redButton = new javax.swing.JButton();
        blueButton = new javax.swing.JButton();
        yellowButton = new javax.swing.JButton();
        greenButton = new javax.swing.JButton();
        orangeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        time_dateLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        time_dateLabel.setText("Time and Date");

        gameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        gameLabel.setText("Color ");

        redButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/redButton.png"))); // NOI18N
        redButton.setToolTipText("Click the red square to guess red!");
        redButton.setContentAreaFilled(false);
        redButton.setMaximumSize(new java.awt.Dimension(50, 50));
        redButton.setMinimumSize(new java.awt.Dimension(50, 50));
        redButton.setPreferredSize(new java.awt.Dimension(50, 50));

        blueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blueButton.png"))); // NOI18N
        blueButton.setToolTipText("Click the blue square to guess blue!");
        blueButton.setContentAreaFilled(false);
        blueButton.setMaximumSize(new java.awt.Dimension(50, 50));
        blueButton.setMinimumSize(new java.awt.Dimension(50, 50));
        blueButton.setPreferredSize(new java.awt.Dimension(50, 50));

        yellowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellowButton.png"))); // NOI18N
        yellowButton.setToolTipText("Click the yellow square to guess yellow!");
        yellowButton.setContentAreaFilled(false);
        yellowButton.setMaximumSize(new java.awt.Dimension(50, 50));
        yellowButton.setMinimumSize(new java.awt.Dimension(50, 50));
        yellowButton.setPreferredSize(new java.awt.Dimension(50, 50));

        greenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/greenButton.png"))); // NOI18N
        greenButton.setToolTipText("Click the green square to guess green!");
        greenButton.setContentAreaFilled(false);
        greenButton.setMaximumSize(new java.awt.Dimension(50, 50));
        greenButton.setMinimumSize(new java.awt.Dimension(50, 50));
        greenButton.setPreferredSize(new java.awt.Dimension(50, 50));

        orangeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/orangeButton.png"))); // NOI18N
        orangeButton.setToolTipText("Click the orange square to guess orange!");
        orangeButton.setContentAreaFilled(false);
        orangeButton.setMaximumSize(new java.awt.Dimension(50, 50));
        orangeButton.setMinimumSize(new java.awt.Dimension(50, 50));
        orangeButton.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time_dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(time_dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(gameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(orangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Main method to run the game
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColorGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blueButton;
    private javax.swing.JLabel gameLabel;
    private javax.swing.JButton greenButton;
    private javax.swing.JButton orangeButton;
    private javax.swing.JButton redButton;
    private javax.swing.JLabel time_dateLabel;
    private javax.swing.JButton yellowButton;
    // End of variables declaration//GEN-END:variables
}

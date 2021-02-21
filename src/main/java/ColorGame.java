
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.ColorModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TonyDiaz Stans
 */

/* 
* To Do List: 
        Score System/Displaying on screen
        Persist
        Button is highlighted when moused over
*/
public class ColorGame extends javax.swing.JFrame {
    
    /**
     * Creates new form ColorGame
     */
    Timer timer;
    String[] colorsList = {"Green", "Red", "Yellow", "Orange", "Blue"};
    int score = 0;
    String textColor; 
    int rounds = 6;
      
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
    
    public void startTimer(){
        // Date and Time 
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
                time_dateLabel.setText(time2 + "   " + time);
            }
        }; 
        timer = new Timer(1000, actionListener); 
        timer.setInitialDelay(0); 
        timer.start();
    }
    
    /**
     * This chooses the color name and the color of the text
     */
    public void setGameLabel(){
        
        Random random = new Random();
        // Randomize the text  
        int text = random.nextInt(colorsList.length);
        if(text == 0){
            gameLabel.setText("Green");
        }
        else if (text == 1){
            gameLabel.setText("Red");
        }
        else if (text == 2){
            gameLabel.setText("Blue");
        }
        else if (text == 3){
            gameLabel.setText("Orange");
        }
        else if (text == 4){
            gameLabel.setText("Yellow");
        }
        
        // Randomize the text color       
        int textColor = random.nextInt(colorsList.length);         
        if(textColor == 0){
            gameLabel.setForeground(Color.GREEN);
        }
        else if (textColor == 1){
            gameLabel.setForeground(Color.RED);
        }
        else if (textColor == 2){
            gameLabel.setForeground(Color.BLUE);
        }
        else if (textColor == 3){
            gameLabel.setForeground(Color.ORANGE);
        }
        else if (textColor == 4){
            gameLabel.setForeground(Color.YELLOW);
        }
        
    }
    
    public void checkRounds() {
        rounds -= 1;
        if (rounds == 0) {
            setVisible(false); 
            EndScreen end = new EndScreen(); 
            end.setVisible(true);
            this.dispose(); 
        }
    }
        
    public void startGame(){    
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(gameLabel.getForeground() == redButton.getForeground()){
                    score +=100;
                    System.out.println("Colors match"); 
                    setGameLabel();  
                    setButton(); 
                }       
                else{
                    setGameLabel(); 
                    setButton();
                    System.out.println("Wrong"); 
                }
                checkRounds();
                System.out.println(rounds);
            }
        }); 
            
        greenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(gameLabel.getForeground() == greenButton.getForeground()){
                    score +=100;
                    System.out.println("Colors match " + score); 
                    setGameLabel(); 
                    setButton(); 
                }       
                else{
                    setGameLabel(); 
                    setButton(); 
                    System.out.println("Wrong " + score); 
                }
                checkRounds(); 
                System.out.println(rounds);
            }
        }); 
            
        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(gameLabel.getForeground() == blueButton.getForeground()){
                    score +=100;
                    System.out.println("Colors match " + score); 
                    setGameLabel(); 
                    setButton(); 
                }       
                else{
                    setGameLabel(); 
                    setButton();  
                    System.out.println("Wrong " + score); 
                }
                checkRounds();
                System.out.println(rounds);
            }
        }); 
            
        yellowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(gameLabel.getForeground() == yellowButton.getForeground()){
                    score +=100;
                    System.out.println("Colors match " + score); 
                    setGameLabel(); 
                    setButton(); 
                }       
                else{
                    setGameLabel(); 
                    setButton(); 
                    System.out.println("Wrong " + score); 
                }
                checkRounds();
                System.out.println(rounds);
                }
            }); 
            
        orangeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(gameLabel.getForeground() == orangeButton.getForeground()){
                    score +=100;
                    System.out.println("Colors match " + score); 
                    setGameLabel(); 
                    setButton(); 
                }       
                else{
                    setGameLabel(); 
                    setButton();  
                    System.out.println("Wrong " + score); 
                }
                    checkRounds(); 
                    System.out.println(rounds);
            }
        });               
    }
    
    public void setButton(){
         
        Random random = new Random(); 
        int setPosition = random.nextInt(2);
         
        redButton.setForeground(Color.RED); 
        blueButton.setForeground(Color.BLUE); 
        yellowButton.setForeground(Color.YELLOW); 
        greenButton.setForeground(Color.GREEN); 
        orangeButton.setForeground(Color.ORANGE); 
         
        switch(setPosition) {
            case 0:
                redButton.setBounds(150, 150, 75, 75); 
                this.add(redButton);
                blueButton.setBounds(410, 225, 75, 75); 
                this.add(blueButton);
                yellowButton.setBounds(300, 100, 75, 75); 
                this.add(yellowButton);
                greenButton.setBounds(250, 250, 75, 75); 
                this.add(greenButton);
                orangeButton.setBounds(70, 280, 75, 75); 
                this.add(orangeButton);
                break;
            case 1:
                redButton.setBounds(250, 150, 75, 75); 
                this.add(redButton);
                blueButton.setBounds(310, 225, 75, 75); 
                this.add(blueButton);
                yellowButton.setBounds(400, 100, 75, 75); 
                this.add(yellowButton);
                greenButton.setBounds(350, 250, 75, 75); 
                this.add(greenButton);
                orangeButton.setBounds(170, 280, 75, 75); 
                this.add(orangeButton);
                break;
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

        time_dateLabel = new javax.swing.JLabel();
        gameLabel = new javax.swing.JLabel();
        redButton = new javax.swing.JButton();
        blueButton = new javax.swing.JButton();
        yellowButton = new javax.swing.JButton();
        greenButton = new javax.swing.JButton();
        orangeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        time_dateLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        time_dateLabel.setText("Time and Date");

        gameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        gameLabel.setText("Color ");

        redButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/redButton.png"))); // NOI18N
        redButton.setBorderPainted(false);
        redButton.setContentAreaFilled(false);

        blueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blueButton.png"))); // NOI18N
        blueButton.setContentAreaFilled(false);
        blueButton.setMaximumSize(new java.awt.Dimension(75, 75));
        blueButton.setMinimumSize(new java.awt.Dimension(75, 75));
        blueButton.setPreferredSize(new java.awt.Dimension(75, 75));

        yellowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellowButton.png"))); // NOI18N
        yellowButton.setContentAreaFilled(false);

        greenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/greenButton.png"))); // NOI18N
        greenButton.setContentAreaFilled(false);

        orangeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/orangeButton.png"))); // NOI18N
        orangeButton.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time_dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(orangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ColorGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColorGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColorGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColorGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
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

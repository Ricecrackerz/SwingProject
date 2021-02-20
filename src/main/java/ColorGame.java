
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
 * @author Bryant
 */
public class ColorGame extends javax.swing.JFrame {
    
    /**
     * Creates new form ColorGame
     */
    Timer timer;
    String[] colorsList = {"Green", "Red", "Yellow", "Orange", "Blue"};
    int correctColor = 0;
    int gameRound = 0;
    int score = 0;
    boolean gameOver = true;
    String textColor; 
    int rounds =  0;
   
    
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
        //timer 
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
        int color = random.nextInt(2);
//      gameLabel.setText(colorsList[color]); 
        if(color == 0){
            gameLabel.setText("Green");
            correctColor = 0;
        }
        else if (color == 1){
            gameLabel.setText("Red");
            correctColor = 1;
        }
        else if (color == 2){
            gameLabel.setText("Blue");
            correctColor = 2;
        }
        else if (color == 3){
            gameLabel.setText("Orange");
            correctColor = 3;
        }
        else if (color == 4){
            gameLabel.setText("Yellow");
            correctColor = 4;
        }
        
        
        int textColor = random.nextInt(colorsList.length); 
        /*
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat(); 
        
        Color randomColor = new Color(r, g, b);
        */ 
        
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
    /*
    *TO DO: adding score 
    */
    public void startGame(){
            {
                redButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameLabel.getForeground() == redButton.getForeground()){
                            System.out.println("Colors match"); 
                            setGameLabel();  
                            setButton(); 
                        }       
                        else{
                            setGameLabel(); 
                            setButton();
                            System.out.println("Wrong"); 
                        }
                        rounds++;
                        System.out.println(rounds);
                    }
            }); 
            
                greenButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameLabel.getForeground() == greenButton.getForeground()){
                            System.out.println("Colors match"); 
                            setGameLabel(); 
                            setButton(); 
                        }       
                        else{
                            setGameLabel(); 
                            setButton(); 
                            System.out.println("Wrong"); 
                        }
                        rounds++; 
                        System.out.println(rounds);
                    }
            }); 
            
            blueButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameLabel.getForeground() == blueButton.getForeground()){
                            System.out.println("Colors match"); 
                            setGameLabel(); 
                            setButton(); 
                        }       
                        else{
                            setGameLabel(); 
                            setButton();  
                            System.out.println("Wrong"); 
                        }
                        rounds++; 
                        System.out.println(rounds);
                    }
            }); 
            
            yellowButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameLabel.getForeground() == yellowButton.getForeground()){
                            System.out.println("Colors match"); 
                            setGameLabel(); 
                            setButton(); 
                        }       
                        else{
                            setGameLabel(); 
                            setButton(); 
                            System.out.println("Wrong"); 
                        }
                        rounds++; 
                        System.out.println(rounds);
                    }
            }); 
            
            orangeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameLabel.getForeground() == orangeButton.getForeground()){
                            System.out.println("Colors match"); 
                            setGameLabel(); 
                            setButton(); 
                        }       
                        else{
                            setGameLabel(); 
                            setButton();  
                            System.out.println("Wrong"); 
                        }
                        rounds++; 
                        System.out.println(rounds);
                    }
            }); 
            } 
                
                
            
            
            
            
            /*
            if(gameLabel.getForeground() == redButton.getForeground() ){
                System.out.println("Colors match"); 
                rounds++; 
            }
            else if(gameLabel.getForeground() == greenButton.getForeground() ){
                System.out.println("Colors match"); 
                rounds++; 
            }
            else if(gameLabel.getForeground() == blueButton.getForeground() ){
                System.out.println("Colors match"); 
                rounds++; 
            }
            else if(gameLabel.getForeground() == yellowButton.getForeground() ){
                System.out.println("Colors match"); 
                rounds++; 
            }
            else if(gameLabel.getForeground() == orangeButton.getForeground() ){
                System.out.println("Colors match"); 
                rounds++; 
            }
            */ 
            
        
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
    public void setGame() {
            switch(correctColor){
            case 0:
                greenButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Im in the green case!");
                        score += 100;
                        if(gameRound < 4){
                            gameRound++;
                            setGameLabel();
                            setButton();
                            System.out.println("score: " + score);
                            System.out.println(gameRound);
                        }else {
                            System.out.println("The End");
                            System.out.println(score);
                        }
                    }
                });
                
                redButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Im in the green case!");
                        if(gameRound < 4){
                            gameRound++;
                            setGameLabel();
                            setButton();
                            System.out.println("score: " + score);
                            System.out.println(gameRound);
                        }else {
                            System.out.println("The End");
                            System.out.println(score);
                        }
                    }
                });
                
                blueButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameRound < 4){
                            gameRound++;
                            setGameLabel();
                            setButton();
                            System.out.println("score: " + score);
                            System.out.println(gameRound);
                        }else {
                            System.out.println("The End");
                            System.out.println(score);
                        }
                    }
                });
                
                orangeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameRound < 4){
                            gameRound++;
                            setGameLabel();
                            setButton();
                            System.out.println("score: " + score);
                            System.out.println(gameRound);
                        }else {
                            System.out.println("The End");
                            System.out.println(score);
                        }
                    }
                });
                
                yellowButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameRound < 4){
                            gameRound++;
                            setGameLabel();
                            setButton();
                            System.out.println("score: " + score);
                            System.out.println(gameRound);
                        }else {
                            System.out.println("The End");
                            System.out.println(score);
                        }
                    }
                });
                break;
            case 1:
                redButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Im in the red case!");
                        score += 100;
                        if(gameRound < 4){
                            gameRound++;
                            setGameLabel();
                            setButton();
                            System.out.println("score: " + score);
                            System.out.println(gameRound);
                        }else {
                            System.out.println("The End");
                            System.out.println(score);
                        }
                    }
                });
                yellowButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameRound < 4){
                            gameRound++;
                            setGameLabel();
                            setButton();
                            System.out.println("score: " + score);
                            System.out.println(gameRound);
                        }else {
                            System.out.println("The End");
                            System.out.println(score);
                        }
                    }
                });
                greenButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Im in the red case!");
                        if(gameRound < 4){
                            gameRound++;
                            setGameLabel();
                            setButton();
                            System.out.println("score: " + score);
                            System.out.println(gameRound);
                        }else {
                            System.out.println("The End");
                            System.out.println(score);
                        }
                    }
                });
                orangeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameRound < 4){
                            gameRound++;
                            setGameLabel();
                            setButton();
                            System.out.println("score: " + score);
                            System.out.println(gameRound);
                        }else {
                            System.out.println("The End");
                            System.out.println(score);
                        }
                    }
                });
                blueButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(gameRound < 4){
                            gameRound++;
                            setGameLabel();
                            setButton();
                            System.out.println("score: " + score);
                            System.out.println(gameRound);
                        }else {
                            System.out.println("The End");
                            System.out.println(score);
                        }
                    }
                });
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
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });

        blueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blueButton.png"))); // NOI18N
        blueButton.setContentAreaFilled(false);
        blueButton.setMaximumSize(new java.awt.Dimension(75, 75));
        blueButton.setMinimumSize(new java.awt.Dimension(75, 75));
        blueButton.setPreferredSize(new java.awt.Dimension(75, 75));

        yellowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellowButton.png"))); // NOI18N
        yellowButton.setContentAreaFilled(false);

        greenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/greenButton.png"))); // NOI18N
        greenButton.setContentAreaFilled(false);
        greenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                greenButtonMouseReleased(evt);
            }
        });

        orangeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/orangeButton.png"))); // NOI18N
        orangeButton.setContentAreaFilled(false);
        orangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orangeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
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
                        .addContainerGap()
                        .addComponent(time_dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(gameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButtonActionPerformed
 
    }//GEN-LAST:event_redButtonActionPerformed

    private void orangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orangeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orangeButtonActionPerformed

    private void greenButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_greenButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_greenButtonMouseReleased

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

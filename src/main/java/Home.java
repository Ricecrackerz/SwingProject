
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * @author TonyDiaz stans
 */

public class Home extends javax.swing.JFrame implements KeyListener{

    // To generate the Home screen
    public Home() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(252, 248, 232));
        setSize(600,400);
        setLocationRelativeTo(null);
        addKeyListener(this); 
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);  
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pongButton = new javax.swing.JButton();
        highButton = new javax.swing.JButton();
        creditButton = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        pongButton.setBackground(new java.awt.Color(236, 179, 144));
        pongButton.setFont(new java.awt.Font("Comic Sans MS", 0, 25)); // NOI18N
        pongButton.setText("Pong");
        pongButton.setToolTipText("Click to play Pong :)");
        pongButton.setBorder(null);
        pongButton.setBorderPainted(false);
        pongButton.setFocusable(false);
        pongButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pongButtonMouseReleased(evt);
            }
        });
        pongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pongButtonActionPerformed(evt);
            }
        });

        highButton.setBackground(new java.awt.Color(236, 179, 144));
        highButton.setFont(new java.awt.Font("Comic Sans MS", 0, 25)); // NOI18N
        highButton.setText("Highscores");
        highButton.setToolTipText("Click \"Highscores\" to view the latest highscores!");
        highButton.setBorder(null);
        highButton.setBorderPainted(false);
        highButton.setFocusable(false);
        highButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                highButtonMouseReleased(evt);
            }
        });

        creditButton.setBackground(new java.awt.Color(236, 179, 144));
        creditButton.setFont(new java.awt.Font("Comic Sans MS", 0, 25)); // NOI18N
        creditButton.setText("Credits");
        creditButton.setToolTipText("Click \"Credits\" to view the creators of this program!");
        creditButton.setBorder(null);
        creditButton.setBorderPainted(false);
        creditButton.setFocusable(false);
        creditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                creditButtonMouseReleased(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tDiaz.png"))); // NOI18N

        playButton.setBackground(new java.awt.Color(236, 179, 144));
        playButton.setFont(new java.awt.Font("Comic Sans MS", 0, 25)); // NOI18N
        playButton.setText("Play");
        playButton.setToolTipText("Click \"Play\" to start playing!");
        playButton.setBorder(null);
        playButton.setBorderPainted(false);
        playButton.setFocusable(false);
        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logo)
                        .addGap(215, 215, 215)
                        .addComponent(pongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(highButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logo)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pongButton)
                        .addGap(13, 13, 13)
                        .addComponent(playButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(highButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(creditButton)
                .addGap(31, 31, 31))
        );

        setSize(new java.awt.Dimension(616, 439));
    }// </editor-fold>//GEN-END:initComponents

    // To enter Highscore screen
    private void highButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_highButtonMouseReleased
        setVisible(false);
        Highscore hs;
        try {
            hs = new Highscore();
            hs.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_highButtonMouseReleased

    // To enter Credits screen
    private void creditButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creditButtonMouseReleased
        setVisible(false);
        Credits credits = new Credits();
        credits.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_creditButtonMouseReleased

    // To play the Hangman game
    private void pongButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pongButtonMouseReleased
        setVisible(false); 
        GameFrame game = new GameFrame(); 
        game.setVisible(true); 
        this.dispose(); 
    }//GEN-LAST:event_pongButtonMouseReleased

    private void playButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButtonMouseReleased
        setVisible(false); 
        Game game = new Game(); 
        game.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_playButtonMouseReleased

    private void pongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pongButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pongButtonActionPerformed

    // Main method
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creditButton;
    private javax.swing.JButton highButton;
    private javax.swing.JLabel logo;
    private javax.swing.JButton playButton;
    private javax.swing.JButton pongButton;
    // End of variables declaration//GEN-END:variables
}

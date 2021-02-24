
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author TonyDiaz stans
 */

public class Home extends javax.swing.JFrame {

    // To generate the Home screen
    public Home() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(252, 248, 232));
        setSize(600,400);
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playButton = new javax.swing.JButton();
        highButton = new javax.swing.JButton();
        creditButton = new javax.swing.JButton();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        playButton.setBackground(new java.awt.Color(236, 179, 144));
        playButton.setFont(new java.awt.Font("Comic Sans MS", 0, 25)); // NOI18N
        playButton.setText("Play");
        playButton.setBorder(null);
        playButton.setBorderPainted(false);
        playButton.setFocusable(false);
        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButtonMouseReleased(evt);
            }
        });

        highButton.setBackground(new java.awt.Color(236, 179, 144));
        highButton.setFont(new java.awt.Font("Comic Sans MS", 0, 25)); // NOI18N
        highButton.setText("Highscores");
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
        creditButton.setBorder(null);
        creditButton.setBorderPainted(false);
        creditButton.setFocusable(false);
        creditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                creditButtonMouseReleased(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tDiaz.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(highButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(creditButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1190, 1190, 1190))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(highButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(creditButton)
                .addGap(31, 31, 31))
        );

        pack();
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
    private void playButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButtonMouseReleased
        setVisible(false); 
        Game game = new Game(); 
        game.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_playButtonMouseReleased

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
    // End of variables declaration//GEN-END:variables
}

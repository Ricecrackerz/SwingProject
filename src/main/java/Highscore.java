/*
 * @author TonyDiaz stans
 */

public class Highscore extends javax.swing.JFrame {

    // To generate the Highscore screen
    public Highscore() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(212, 226, 212));
        setSize(600,400);
        setLocationRelativeTo(null);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleHighScores = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        filler1 = new javax.swing.JLabel();
        filler2 = new javax.swing.JLabel();
        filler3 = new javax.swing.JLabel();
        filler4 = new javax.swing.JLabel();
        filler5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(212, 226, 212));

        titleHighScores.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        titleHighScores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleHighScores.setText("Highscores");

        backButton.setBackground(new java.awt.Color(236, 179, 144));
        backButton.setFont(new java.awt.Font("Comic Sans MS", 0, 25)); // NOI18N
        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backButtonMouseReleased(evt);
            }
        });

        filler1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        filler1.setText("ABC.....00000");

        filler2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        filler2.setText("ABC.....00000");

        filler3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        filler3.setText("ABC.....00000");

        filler4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        filler4.setText("ABC.....00000");

        filler5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        filler5.setText("ABC.....00000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 135, Short.MAX_VALUE)
                        .addComponent(titleHighScores, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler4)
                    .addComponent(filler2)
                    .addComponent(filler5)
                    .addComponent(filler3)
                    .addComponent(filler1))
                .addGap(252, 252, 252))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(titleHighScores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // To go back to the Home screen
    private void backButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseReleased
        setVisible(false);
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonMouseReleased

    // Main method
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Highscore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel filler1;
    private javax.swing.JLabel filler2;
    private javax.swing.JLabel filler3;
    private javax.swing.JLabel filler4;
    private javax.swing.JLabel filler5;
    private javax.swing.JLabel titleHighScores;
    // End of variables declaration//GEN-END:variables
}

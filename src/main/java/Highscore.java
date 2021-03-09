
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author TonyDiaz stans
 */

public class Highscore extends javax.swing.JFrame {

    // To generate the Highscore screen
    public Highscore() throws FileNotFoundException {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(212, 226, 212));
        setSize(600,400);
        setLocationRelativeTo(null);
        setInitialLabels(); 
    }
    
    public void setInitialLabels() throws FileNotFoundException{
        InputStream in = getClass().getResourceAsStream("HighScores.txt");
        Scanner scanner = new Scanner(new File("HighScores.txt"));
        
        ArrayList<Integer> scoreArray = new ArrayList<Integer>(3);
        ArrayList<String> hsInitialsArray = new ArrayList<String>(3); 
        
        InputStream in1 = getClass().getResourceAsStream("hsText.txt");
        Scanner scanner1 = new Scanner(new File("hsText.txt"));
                    
        for(int k = 0; k < 3; k++){
            hsInitialsArray.add(scanner1.nextLine()); 
        }
        scanner1.close(); 
        
        
        for(int i = 0; i < 3; i++){
            scoreArray.add(scanner.nextInt());
        }
        scanner.close(); 
        
        initialLabel1.setText(hsInitialsArray.get(0)); 
        initialLabel2.setText(hsInitialsArray.get(1));
        initialLabel3.setText(hsInitialsArray.get(2));
        
        hsScore1.setText(String.valueOf(scoreArray.get(0))); 
        hsScore2.setText(String.valueOf(scoreArray.get(1))); 
        hsScore3.setText(String.valueOf(scoreArray.get(2))); 
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleHighScores = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        initialLabel3 = new javax.swing.JLabel();
        initialLabel1 = new javax.swing.JLabel();
        initialLabel2 = new javax.swing.JLabel();
        hsScore1 = new javax.swing.JLabel();
        hsScore3 = new javax.swing.JLabel();
        hsScore2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(212, 226, 212));
        setResizable(false);

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

        initialLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        initialLabel3.setText("No User");

        initialLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        initialLabel1.setText("No User");

        initialLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        initialLabel2.setText("No User");

        hsScore1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        hsScore1.setText("Score1");

        hsScore3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        hsScore3.setText("Score3");

        hsScore2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        hsScore2.setText("Score2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 135, Short.MAX_VALUE)
                        .addComponent(titleHighScores, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(169, 169, 169))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(initialLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(initialLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(initialLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hsScore3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hsScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hsScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(235, 235, 235))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(titleHighScores)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initialLabel1)
                    .addComponent(hsScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initialLabel2)
                    .addComponent(hsScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initialLabel3)
                    .addComponent(hsScore3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
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
                try {
                    new Highscore().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Highscore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel hsScore1;
    private javax.swing.JLabel hsScore2;
    private javax.swing.JLabel hsScore3;
    private javax.swing.JLabel initialLabel1;
    private javax.swing.JLabel initialLabel2;
    private javax.swing.JLabel initialLabel3;
    private javax.swing.JLabel titleHighScores;
    // End of variables declaration//GEN-END:variables
}

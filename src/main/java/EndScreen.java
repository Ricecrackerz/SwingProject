
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author TonyDiaz stans
 */

public class EndScreen extends javax.swing.JFrame {

    public static int INDEX = 0;
    public static int NEW_SCORE = 0;
    // To generate the screen
    public EndScreen() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(252, 248, 232));
        setSize(600,400);
        setLocationRelativeTo(null);
    }
    
    // To display SCORE on screen
    public EndScreen(String para) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(252, 248, 232));
        setSize(600,400);
        setLocationRelativeTo(null);
        
        ScoreLabel.setText(para);
    }
    
    public EndScreen(int s) throws FileNotFoundException, IOException {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(252, 248, 232));
        setSize(600,400);
        setLocationRelativeTo(null);
        hsLabel.setVisible(false);
        hsLabel1.setVisible(false);
        hsButton.setVisible(false);
        initialsTextField.setVisible(false); 
        highScorePromptLabel.setVisible(false); 
        
        String score = String.valueOf(s);
        
        ScoreLabel.setText(score);
        
        checkScore(s);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        End = new javax.swing.JButton();
        ScoreLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hsLabel = new javax.swing.JLabel();
        hsButton = new javax.swing.JButton();
        hsLabel1 = new javax.swing.JLabel();
        highScorePromptLabel = new javax.swing.JLabel();
        initialsTextField = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(252, 248, 232));
        setResizable(false);

        Title.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        Title.setText("Game Over");

        End.setBackground(new java.awt.Color(212, 226, 212));
        End.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        End.setText("End");
        End.setBorderPainted(false);
        End.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EndMouseReleased(evt);
            }
        });

        ScoreLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        ScoreLabel.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setText("Score: ");

        hsLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        hsLabel.setText("HIGHSCORE!!! Would you like to save it?");
        hsLabel.setEnabled(false);

        hsButton.setBackground(new java.awt.Color(212, 226, 212));
        hsButton.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        hsButton.setText("YES");
        hsButton.setEnabled(false);
        hsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hsButtonMouseReleased(evt);
            }
        });

        hsLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        hsLabel1.setText("If no, click the End button");
        hsLabel1.setEnabled(false);

        highScorePromptLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        highScorePromptLabel.setText("If yes, please write your initials ");

        initialsTextField.setToolTipText("Write your initials here :)");
        initialsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initialsTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(highScorePromptLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(initialsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Title)
                        .addGap(265, 265, 265))))
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(hsLabel1)
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(hsLabel)
                        .addGap(147, 147, 147))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(hsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(End, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initialsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(highScorePromptLabel))
                .addGap(18, 18, 18)
                .addComponent(hsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hsLabel1)
                .addGap(18, 18, 18)
                .addComponent(End)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        public void checkScore(int score) throws FileNotFoundException, IOException {
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
        
        for(int i = 0; i < 3; i++){
            if(score > scoreArray.get(i)){
                hsLabel.setEnabled(true);
                hsLabel1.setEnabled(true);
                hsButton.setEnabled(true);
                initialsTextField.setEnabled(true); 
                hsLabel.setVisible(true);
                hsLabel1.setVisible(true);
                hsButton.setVisible(true);
                highScorePromptLabel.setVisible(true); 
                initialsTextField.setVisible(true); 
                INDEX = i;
                NEW_SCORE = score;
                break;
            }
        }
        
        hsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scoreArray.add(INDEX,NEW_SCORE);
                try {
                    Scanner scanner = new Scanner(new File("HighScores.txt"));
                    FileWriter myWriter = new FileWriter("HighScores.txt");
                    PrintWriter writer = new PrintWriter(myWriter);
                    for(int i = 0; i < 3; i++){
                        writer.println(scoreArray.get(i));
                    }
                    myWriter.close();
                    writer.close();

                    //For initials text file
                    String initials = initialsTextField.getText(); 
                    hsInitialsArray.add(INDEX,initials);
                    Scanner scanner1 = new Scanner(new File("hsText.txt")); 
                    FileWriter myWriter1 = new FileWriter("hsText.txt"); 
                    PrintWriter writer1 = new PrintWriter(myWriter1);
                    
                    for(int j=0; j < 3; j++){
                        writer1.println(hsInitialsArray.get(j));
                    }
                    myWriter1.close(); 
                    writer1.close(); 
                    
                } catch (IOException ex) {
                    Logger.getLogger(EndScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                });
    }
        
    
    // To go to the next screen
    private void EndMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EndMouseReleased
        setVisible(false);
        Home end = new Home();
        end.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EndMouseReleased

    private void initialsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initialsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initialsTextFieldActionPerformed

    private void hsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hsButtonMouseReleased

        setVisible(false);
        Home end = new Home();
        end.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hsButtonMouseReleased

    // Main method
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EndScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton End;
    private javax.swing.JLabel ScoreLabel;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel highScorePromptLabel;
    private javax.swing.JButton hsButton;
    private javax.swing.JLabel hsLabel;
    private javax.swing.JLabel hsLabel1;
    private javax.swing.JTextField initialsTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

/* 
 * @author TonyDiaz stans
 */

public class SplashScreen extends javax.swing.JFrame {

    // To generate the Splash screen
    public SplashScreen() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(252, 248, 232));
        setSize(600,400);
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setLocation(new java.awt.Point(0, 0));
        setName("SplashFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        title.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        title.setText("Swing Project");

        name.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        name.setText("By: T.Diaz Stans");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tonydiazlogobig.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(title))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(name))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Main method 
    public static void main(String args[]) {
        SplashScreen splash = new SplashScreen();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                splash.setVisible(true);
            }
        });
        try {
            Thread.sleep(3000);
        } catch (Exception e) {}
        
        splash.setVisible(false);
        Home home = new Home();
        home.setVisible(true);
        splash.dispose(); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}


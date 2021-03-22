/**
 * @author TDiaz stans
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
        
    GamePanel p;
    JPanel mPanel, btnPanel;
    Timer timer; 
    JLabel timeLabel = new JLabel(); 
    JButton exitButton = new JButton("Quit"); 
        
    GameFrame() {
        
        // Generate the panels for components to display on screen
        // We have seperate panels since paint component don't co-exist with Swing widgets
	p = new GamePanel();
        btnPanel = new JPanel();
        Dimension panelD = new Dimension(170,350); 
        btnPanel.setPreferredSize(panelD);
        exitButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        exitButton.setBackground(new Color(212, 226, 212));
        btnPanel.setBackground(new Color(251, 230, 194));
        
        // Create a main panel to include all components for the game
        mPanel = new JPanel(); 
        mPanel.add(p); 
        mPanel.add(btnPanel); 
        
        // Add timer and exit button
        startTimer(); 
        btnPanel.add(timeLabel,BorderLayout.PAGE_START);
        btnPanel.add(exitButton, BorderLayout.CENTER);
                
        // Ensure all settings is in this Pong frame
        this.add(mPanel); 
	this.setTitle("Pong Game");
	this.setResizable(false);
	this.setBackground(new Color(252, 248, 232));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	this.pack();
	this.setVisible(true);
	this.setLocationRelativeTo(null);
                
        // Set actionListener to register user click on exit button        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Home end = new Home();
                end.setVisible(true);
                dispose(); 
            }
        });
    }
    
    // We use this method instead of calling this.dispose in button 
    // to prevent override issues
    @Override
    public void dispose() {
        this.dispose(); 
    }
    
    // Add real timer in the code
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
                timeLabel.setFont(new Font("Comic Sans", Font.PLAIN, 15));
                timeLabel.setText(time2 + "   " + time);
            }
        }; 
        timer = new Timer(1000, actionListener); 
        timer.setInitialDelay(0); 
        timer.start();
    }
    /*
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
        
    } */
}
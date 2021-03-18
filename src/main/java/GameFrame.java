/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryant
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class GameFrame extends JFrame{

	GamePanel panel;
	JPanel mainPanel, buttonPanel;
        Timer timer; 
        JLabel timeLabel = new JLabel(); 
        
	GameFrame(){
		panel = new GamePanel();
                buttonPanel = new JPanel();
                Dimension panelD = new Dimension(170,350); 
                buttonPanel.setPreferredSize(panelD);
                mainPanel = new JPanel(); 
                mainPanel.add(panel); 
                mainPanel.add(buttonPanel); 
                startTimer(); 
                buttonPanel.add(timeLabel,BorderLayout.PAGE_START); 
                JButton exitButton = new JButton("Quit"); 
                buttonPanel.add(exitButton, BorderLayout.CENTER);
                
                this.add(mainPanel); 
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
        
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
}
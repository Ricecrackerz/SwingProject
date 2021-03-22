/**
 * @author TDiaz stans
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    // Set game interface with game components to set size
    static final int SCREEN_WIDTH = 400;
    static final int SCREEN_HEIGHT = 350; 
    static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT);
    static final int BALL_DIAMETER = 15;
    static final int PADDLE_WIDTH = 15;
    static final int PADDLE_HEIGHT = 50;
    
    Thread thread;
    Image image;
    Graphics graphics;
    Random rand;
    Paddle pad1;
    Paddle pad2;
    Ball ball;
    Score score;
    boolean gameCheck = false;
    
	
    GamePanel() {
        
        // Generating the game in the constructor
	newPaddles();
	newBall();
	score = new Score(SCREEN_WIDTH,SCREEN_HEIGHT);
	this.setFocusable(true);
	this.addKeyListener(new AL());
	this.setPreferredSize(SCREEN_SIZE);
        setBorder(new EmptyBorder(10,10,10,10));
                
        addKeyListener(this); 
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
	
        // Create a thread as a main path for the program execution
	thread = new Thread(this);
	thread.start();
    }
    
    // Generate a new ball for each round
    public void newBall() {
        rand = new Random();
	ball = new Ball((SCREEN_WIDTH / 2) - (BALL_DIAMETER / 2), rand.nextInt(SCREEN_HEIGHT - BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
    }

    // Generate new paddles for each round
    public void newPaddles() {
            pad1 = new Paddle(0,(SCREEN_HEIGHT / 3) - (PADDLE_HEIGHT / 3),PADDLE_WIDTH, PADDLE_HEIGHT, 1);
            pad2 = new Paddle(SCREEN_WIDTH - PADDLE_WIDTH,(SCREEN_HEIGHT / 3) - (PADDLE_HEIGHT / 3),PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }
    
    // Paint the image
    public void paint(Graphics g) {
	image = createImage(getWidth(), getHeight());
	graphics = image.getGraphics();
	draw(graphics);
	g.drawImage(image, 0, 0, this);
    }
    
    // Redraw to update the gameplay and score
    public void draw(Graphics g) {
	pad1.draw(g);
	pad2.draw(g);
	ball.draw(g);
	score.draw(g);
        Toolkit.getDefaultToolkit().sync(); // helps with the animation
    }

    // Allow paddles and ball to move on screen
    public void move() {
        pad1.move();
	pad2.move();
        ball.move();
    }
    
    // Ensure all collisions work for all components
    public void checkCollision() {
		
	// Set boundary for ball with top and bottom border
	if(ball.y <= 0) { ball.setYPath(-ball.ySpeed);}
        
	if(ball.y >= SCREEN_HEIGHT - BALL_DIAMETER) {
            ball.setYPath(-ball.ySpeed);
	}
        
	// Prevent ball and paddle overlapping each other
	if(ball.intersects(pad1)) {
            ball.xSpeed = Math.abs(ball.xSpeed);
            ball.xSpeed++;
            if(ball.ySpeed > 0) {
		ball.ySpeed++; 
            } else {
		ball.ySpeed--;
            }
            ball.setXPath(ball.xSpeed);
            ball.setYPath(ball.ySpeed);
	}
        
	if(ball.intersects(pad2)) {
            ball.xSpeed = Math.abs(ball.xSpeed);
            ball.xSpeed++; 
            if(ball.ySpeed > 0) {
		ball.ySpeed++;
            } else {
		ball.ySpeed--;
            }
            ball.setXPath(-ball.xSpeed);
            ball.setYPath(ball.ySpeed);
        }
        
	// Set boundary for paddles with top and bottom border panel
	if(pad1.y <= 0) { pad1.y = 0;}
	if(pad1.y >= (SCREEN_HEIGHT - PADDLE_HEIGHT)) { pad1.y = SCREEN_HEIGHT - PADDLE_HEIGHT;}
		
        if(pad2.y <= 0) { pad2.y = 0;}
	if(pad2.y >= (SCREEN_HEIGHT - PADDLE_HEIGHT)) { pad2.y = SCREEN_HEIGHT - PADDLE_HEIGHT;}
	
        //give a player 10 points and creates new paddles & ball
	if (ball.x <= 0) {
            score.player2 += 10;
            newPaddles();
            newBall();
            gameCheck = false; 
            checkScore(); 
	}
	if(ball.x >= SCREEN_WIDTH - BALL_DIAMETER) {
            score.player1 += 10;
            newPaddles();
            newBall();
            gameCheck = false; 
            checkScore(); 
	}
    }
    
    // To calculate the score and determine the winner
    public void checkScore() {
        if(score.player1 == 100) {
            // Show Popup dialogue when player 1 wins 
            int input = JOptionPane.showOptionDialog(null, "Player 1 has won", "Pong Winner", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if(input == JOptionPane.OK_OPTION) {
                setVisible(false);
                Home end = new Home();
                end.setVisible(true);
                dispose(); 
            }
                
            if(input == JOptionPane.OK_CANCEL_OPTION) {
                setVisible(false);
                Home end = new Home();
                end.setVisible(true);
                dispose();
            }
        }
            
        if(score.player2 == 100) {
            // Show Popup dialogue when player 2 wins
            int input = JOptionPane.showOptionDialog(null, "Player 2 has won", "Pong Winner", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if(input == JOptionPane.OK_OPTION) {
                setVisible(false);
                Home end = new Home();
                end.setVisible(true);
                dispose();
            }
                
            if(input == JOptionPane.OK_CANCEL_OPTION) {
                setVisible(false);
                Home end = new Home();
                end.setVisible(true);
                dispose();
            }
        }
    }
    
    // To dispose the current screen
    public void dispose() {
        Home.game.setVisible(false);
    } 
    
    // To run the actual pong game
    public void run() {
	long lastTime = System.nanoTime();
	double amountOfTicks =60.0;
	double ns = 1000000000 / amountOfTicks;
	double delta = 0;
        
        // Game loop
	while(true) {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1) {
                if(gameCheck == true) {
                    move();
                }
		checkCollision();
		repaint();
                delta--;
            }
	}
    }

    // To start game when space button is pressed
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            gameCheck = true;  
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_F1){
            JOptionPane.showMessageDialog(this, "Vincent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
                    "Nhi Nguyen #013925392 \n" + "Term: Spring 2021", "Swing Project", JOptionPane.PLAIN_MESSAGE);
        }
    }
  
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            gameCheck = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_F1){
            JOptionPane.showMessageDialog(this, "Vincent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
                    "Nhi Nguyen #013925392 \n" + "Term: Spring 2021", "Swing Project", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            gameCheck = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_F1){
            JOptionPane.showMessageDialog(this, "Vincent Hoang #013410449 \n" + "Bryant Hong #014176552 \n" + "Lan Nguyen #013327561 \n" + 
                    "Nhi Nguyen #013925392 \n" + "Term: Spring 2021", "Swing Project", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // Allow user to control paddles with W, S keys and Up, Down keys
    public class AL extends KeyAdapter {
	public void keyPressed(KeyEvent e) {
            pad1.keyPressed(e);
            pad2.keyPressed(e);
	}
	public void keyReleased(KeyEvent e) {
            pad1.keyReleased(e);
            pad2.keyReleased(e);
	}
    }
}

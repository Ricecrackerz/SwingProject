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
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GamePanel extends JPanel implements Runnable, KeyListener{

	static final int GAME_WIDTH = 400;
        static final int GAME_HEIGHT = 350; 
	//static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(400,350);
        //static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 15;
	static final int PADDLE_WIDTH = 15;
	static final int PADDLE_HEIGHT = 50;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score score;
        boolean gameCheck = false; 
        
	
	GamePanel(){
		newPaddles();
		newBall();
		score = new Score(GAME_WIDTH,GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
                setBorder(new EmptyBorder(10,10,10,10));
                
                addKeyListener(this); 
                setFocusable(true);
                setFocusTraversalKeysEnabled(false);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBall() {
		random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	public void newPaddles() {
            paddle1 = new Paddle(0,(GAME_HEIGHT/3)-(PADDLE_HEIGHT/3),PADDLE_WIDTH,PADDLE_HEIGHT,1);
            paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/3)-(PADDLE_HEIGHT/3),PADDLE_WIDTH,PADDLE_HEIGHT,2);
            
	}
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
Toolkit.getDefaultToolkit().sync(); // I forgot to add this line of code in the video, it helps with the animation

	}
	public void move() {
                 
		paddle1.move();
		paddle2.move();
                /*
                if(c == KeyEvent.VK_SPACE){
                    ball.move();
                }
                */
                
                
                 
                ball.move();
              
		
	}
        
	public void checkCollision() {
		
		//bounce ball off top & bottom window edges
		if(ball.y <=0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		//bounce ball off paddles
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
	}
		if(ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		//stops paddles at window edges
		if(paddle1.y<=0)
			paddle1.y=0;
		if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		if(paddle2.y<=0)
			paddle2.y=0;
		if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
		//give a player 1 point and creates new paddles & ball
		if(ball.x <=0) {
                        //player2Score++; 
			score.player2+=10;
			newPaddles();
			newBall();
                        gameCheck = false; 
                        checkScore(); 
                        //score(player1Score); 
                        //System.out.println(String.valueOf(score.player2)); 
                       
			//System.out.println("Player 2: "+score.player2);
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
                        //player1Score++; 
			score.player1+=10;
			newPaddles();
			newBall();
                        gameCheck = false; 
                        checkScore(); 
                        //score1(player2Score); 
			//System.out.println("Player 1: "+score.player1);
		}
	}
        
        public void checkScore(){
            if(score.player1 == 10){
                
                
                int input = JOptionPane.showOptionDialog(null, "Player 1 has won", "Pong Winner", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                if(input == JOptionPane.OK_OPTION)
                {
                    setVisible(false);
                        Home end = new Home();
                        end.setVisible(true);
                        dispose(); 
                }
                
                if(input == JOptionPane.OK_CANCEL_OPTION)
                {
                    setVisible(false);
                        Home end = new Home();
                        end.setVisible(true);
                        dispose(); 
                }
            }
            
            if(score.player2 == 10){
                
                int input = JOptionPane.showOptionDialog(null, "Player 2 has won", "Pong Winner", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                        

                if(input == JOptionPane.OK_OPTION)
                {
                    setVisible(false);
                        Home end = new Home();
                        end.setVisible(true);
                        dispose(); 
                }
                
                if(input == JOptionPane.OK_CANCEL_OPTION)
                {
                    setVisible(false);
                        Home end = new Home();
                        end.setVisible(true);
                        dispose(); 
                }
            }
        }
        
            public void dispose() {
                JFrame parent = (JFrame) this.getTopLevelAncestor();
                parent.dispose();
            }
        
        
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
                            if(gameCheck == true){
                                move();
                            }
				checkCollision();
				repaint();
                                
				delta--;
			}
		}
	}

    @Override
    public void keyTyped(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            gameCheck = true; 
            System.out.println(gameCheck); 
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            gameCheck = true;
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            gameCheck = true;
        }
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
    }
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}
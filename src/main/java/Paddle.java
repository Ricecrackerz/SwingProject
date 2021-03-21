/**
 * @author Bryant
 */
import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {
    // Declaring variables 
    int id;
    int ySpeed;
    int speed = 10;
	
    // To associate an ID with the coressponding paddle
    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
	this.id=id;
    }
	
    // Corresponding W & S keys to paddle 1
    //       and Up & Down keys to paddle 2
    public void keyPressed(KeyEvent e) {
	switch(id) {
            case 1:
		if(e.getKeyCode()==KeyEvent.VK_W) { setYDirection(-speed);}
		
                if(e.getKeyCode()==KeyEvent.VK_S) { setYDirection(speed);}
		break;
	
            case 2:
		if(e.getKeyCode()==KeyEvent.VK_UP) { setYDirection(-speed);}
			
                if(e.getKeyCode()==KeyEvent.VK_DOWN) { setYDirection(speed);}
		break;
	}
    }
    
    // Force paddles to stop moving if butttons are released
    public void keyReleased(KeyEvent e) {
	switch(id) {
            case 1:
		if(e.getKeyCode()==KeyEvent.VK_W) { setYDirection(0);}
                
		if(e.getKeyCode()==KeyEvent.VK_S) { setYDirection(0);}
		break;
                
            case 2:
		if(e.getKeyCode()==KeyEvent.VK_UP) { setYDirection(0);}
                
		if(e.getKeyCode()==KeyEvent.VK_DOWN) { setYDirection(0);}
		break;
	}
    }
    
    // 
	public void setYDirection(int yDirection) {
		ySpeed = yDirection;
	}
	public void move() {
		y= y + ySpeed;
	}
	public void draw(Graphics g) {
		if(id==1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
}

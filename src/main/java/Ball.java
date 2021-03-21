/**
 * @author TDiaz stans
 */
import java.awt.*;
import java.util.*;

public class Ball extends Rectangle {
    
    Random rand;
    int xSpeed;
    int ySpeed;
    int initSpeed = 2;
	
    // Ball constructor to create the speed to set xSpeed and ySpeed
    Ball(int x, int y, int width, int height) {
           
        super(x,y,width,height);
        // Generate random X position and speed
        rand = new Random();
        int randXPath = rand.nextInt(2);
        if(randXPath == 0) { randXPath--;}
        setXPath(randXPath * initSpeed);
            
        // Generate random Y position and speed
        int randYPath = rand.nextInt(2);
        if(randYPath == 0) { randYPath--;}
        setYPath(randYPath * initSpeed);	
    }
	
    // set X speed 
    public void setXPath(int randXPath) {
        xSpeed = randXPath;
    }
        
    // Set Y speed
    public void setYPath(int randYPath) {
        ySpeed = randYPath;
    }
        
    // Calculate X and Y speed of the ball  
    public void move() {
        x += xSpeed;
        y += ySpeed;
    }
        
    // To generate the ball on the screen
    public void draw(Graphics g) {
	g.setColor(Color.white);
	g.fillOval(x, y, height, width);
    }
}

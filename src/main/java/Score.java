/**
 * @author Bryant
 */
import java.awt.*;

public class Score extends Rectangle{
    // Declaring variables
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;
    
    // Constructor for Score
    Score(int GAME_WIDTH, int GAME_HEIGHT){
	Score.GAME_WIDTH = GAME_WIDTH;
	Score.GAME_HEIGHT = GAME_HEIGHT;
    }
    
    // Update score by redrawing them
    public void draw(Graphics g) {
	g.setColor(Color.gray);
	g.setFont(new Font("Comic Sans",Font.PLAIN,18));
		
	g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);
		
	g.drawString("Player 1 Score: " +String.valueOf(player1 / 10)+String.valueOf(player1 % 10), (GAME_WIDTH / 2)-190, 50);
	g.drawString("Player 2 Score: " + String.valueOf(player2 / 10)+String.valueOf(player2 % 10), (GAME_WIDTH / 2)+20, 50);
    }
        
        
}

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Screen extends JPanel{ 
	
	
//paddle/ player refrences
	Paddle p1;  
	Paddle p2; 
	Ball b;
	ScoreBoard sb;  
	
	String winnerString;
	boolean showWinner =false;
	//constructor which gets gameobjects and sets the refrences 
	Screen(Paddle _p1, Paddle _p2, Ball _b, ScoreBoard _sb){ 
	
		p1 = _p1; 
		p2 = _p2;  
		sb = _sb;
		b = _b;
		
	} 
	 
	
	

	public void paintComponent(Graphics g) {  
		
		g.setFont(g.getFont().deriveFont(50F));
		//sets Background color to black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());  
		
		//paints the first paddle
		g.setColor(p1.getColor());
		g.fillRect(p1.getX(), p1.getY(), p1.getWidth(), p1.getHeigth()); 
		
		g.setColor(p2.getColor());
		g.fillRect(p2.getX(), p2.getY(), p2.getWidth(), p2.getHeigth());
		
	
		g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());   
		
		//ssg.getFont().size
		
		g.drawString(sb.Getp1Score(), 225, 50); 
		g.drawString(sb.Getp2Score(), 675, 50); 
		
		if(showWinner) {
			g.drawString(winnerString, 450 - 150, 250);
		}
		
		
	} 
	
	void showWinner(int winner) {
		 
		
		switch(winner) {
		case 1: 
			winnerString = "Player 1 Wins!";
			break; 
		case 2: 
			winnerString = "Player 2 Wins!"; 
			break;
		} 
		showWinner = true;  
		this.repaint();
		
	}
	
}

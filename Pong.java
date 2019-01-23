import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

public class Pong extends JFrame implements ActionListener, KeyListener{ 
	
	//size of frame
	int width = 900; 
	int height = 500;  
	
	//title of frame
	String title = "Pong";   
	
	//Paddle/player refrences
	Paddle p1; 
	Paddle p2; 
	Ball b; 
	
	
	ScoreBoard sb;
	//Screen/Graphic refrence
	Screen sc;  
	
	ArrayList<Integer> keyArray = new ArrayList(); 

	
	Timer timer; 
	
	JButton restartButton;

	
	boolean gameOn;
	public static void main(String[] args) {
		
		//creates Pong class by running its constructor
		new Pong();

	}  
	
	//pong constructor
	Pong(){ 
		
		//sets up frame
		this.setSize(width,height); 
		this.setVisible(true); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
		this.setResizable(false);
		this.setTitle(title);  
		this.addKeyListener(this); 
		
		timer =  new Timer(100,this); 

		
		start();
	
				
	} 
	
	void start() {
		p1 = new Paddle(50, this.height/2);  
		p2 = new Paddle(810,this.height/2 );    
		sb = new ScoreBoard(this);
		b = new Ball(this.width/2, this.height/2, sb);
		b.setPlayer1(p1); 
		b.setPlayer2(p2);
		
		// sets up the screen which does the graphics for the game
		sc = new Screen(p1,p2,b,sb); 
		this.add(sc);  
		sc.repaint();  
		
		
		
		
		gameOn = true; 
		update();
		
	}
	
	void update() { 
		b.start(); 
		
		if(gameOn) {
			timer.start();  
			
			
			//b.move();  
		
			
		} else {
		 
			timer.stop(); 
			}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub   
		if(e.getSource().equals(restartButton)) { 
			sc.remove(restartButton);
			start();
		} 
		System.out.print(gameOn);
		
		if(e.getSource().equals(timer)) {
		if(gameOn) {
		b.move();    
		System.out.println(keyArray);
		if(keyArray.contains(83)) {
			p1.moveDown(); 
			p1.setIsMoving(true);
		}  
		if(keyArray.contains(87)) {
			p1.moveUp(); 
			p1.setIsMoving(true);
		} 
		if((!keyArray.contains(83)&& !keyArray.contains(87))) {
			p1.setIsMoving(false);
		}
		if(keyArray.contains(40)) {
			p2.moveDown(); 
			p2.setIsMoving(true);
		} 
		if(keyArray.contains(38)) {
			p2.moveUp(); 
			p2.setIsMoving(true);
		}  
		if((!keyArray.contains(40)&& !keyArray.contains(38))) {
			p2.setIsMoving(false);
		}
		
		sc.repaint(); 
		sc.revalidate(); 
		
		}
	} 
	}
	
	void endGame(int winner) {
		gameOn = false;  
		sc.showWinner(winner);
		restartButton = new JButton("Play Agian!");   
		restartButton.addActionListener(this);
		restartButton.setPreferredSize(new Dimension(200,100)); 
		
		sc.add(restartButton);  
		//prevents keyevents from breaking
		restartButton.setFocusable(false);
		
		//sc = null;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub 
		if(gameOn) {
			if(!keyArray.contains(e.getKeyCode())) {
				keyArray.add((Integer) e.getKeyCode()); 
				
			}
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub 
		if(gameOn) {
			if(keyArray.contains(e.getKeyCode())) {
				keyArray.remove((Integer) e.getKeyCode()); 
			}
	}
		
	}
	
	

}

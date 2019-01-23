import java.awt.Color;

public class Paddle { 
	private int x; 
	private int y; 
	private int width;
	private int height; 
	private Color c = Color.white;   
	private boolean isMoving;
	
	Paddle(int _x, int _y){ 
		
		width = 20; 
		height = 70;
		x = _x; 
		y = _y - this.height/2;
		
		
		
	}
	
	int getX() {
		
		return x;		
	}
	
	int getY() {
		
		return y;
	} 
	
	int getWidth() {
		
		return width;
	}
	
	int getHeigth() {
		return height;
	} 
	
	Color getColor() {
		return c;
	} 
	
	void setIsMoving(boolean _im) {
		isMoving = _im;
	}
	Boolean isMoving() {
		return isMoving;
	}
	void moveDown() {
		if(y <= (500 - 100)) {
		y+=15;  
		//System.out.println(isMoving());
		} 
	} 
	void moveUp() { 
	if(y >= 0) { 
		y-=15;}
	}

}

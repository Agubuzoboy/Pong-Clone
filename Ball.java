import java.util.Random;

public class Ball { 
	
	//positon (x,y)
	int x; 
	int y;   
	int iX; 
	int iY;
	//dimensions
	int width = 20;
	int height = 20;  
	//ball movement atributes
	int speed = 10;  
	int directionX = 1;  
	int directionY = 1; 
	int velX = 1; 
	int velY = 1;
	//refrences to paddles
	Paddle p1; 
	Paddle p2; 
	ScoreBoard sb; 
	Random ran;
	
	Pong p;
	
	Ball(int _x, int _y, ScoreBoard _sb){  
		//sets postions
		iX = _x; 
		iY = _y;  
		sb = _sb; 
		ran = new Random(); 
	 
		System.out.println(velX);		 
		System.out.println(velY);	

		
		
	} 
	 
	//getters and setters
	int getX() {
		return x;
	} 
	
	int getY() {
		return y;
	} 
	int getWidth() {
		return width;
	} 
	
	int getHeight() {
		return height;
	} 
	
	void setPlayer1(Paddle _p1) {
		p1 = _p1;
	} 
	
	void setPlayer2(Paddle _p2) {
		p2 = _p2;
	}
 
	//handles movement and collison of the ball
	void move() {  
		
		//if the ball intercepts the x line where the front surface of p2 is
	if(this.x + this.width >= p2.getX()) {  
		//if the ball falls inbetween the y range of the paddle (if the top and bottm conditions are satrisfied then the ball has collied)
		if(this.y >= p2.getY() && this.y <= p2.getY() + p2.getHeigth()) { 
			//ball has hit player  
			
			//moves ball is another direction if the paddle was moving 
			if(p2.isMoving()) { 
				speed +=1;
			//if it hits top half 
			if(this.y>= p2.getY() && this.y <= p2.getY() + p2.getHeigth()/2) {
				directionY = -1; 
				
			}  
			
			//if it hits bottom half
			if(this.y> p2.getY() + p2.getHeigth()/2 && this.y <= p2.getY() + p2.getHeigth()) {
				directionY = 1;
			} 
			}
			//changes direction 
		//velX = (ran.nextInt(5) +1);	 
		//velY = (ran.nextInt(5) +1);	
		directionX *= -1; 
		speed +=1;
		}
	}  
	
	//esientally the same concept as above, just modified because player one is flipped 
	if(this.x  <= p1.getX() + p1.getWidth()) { 
		if(this.y >= p1.getY() && this.y <= p1.getY() + p1.getHeigth()) {  
			if(p1.isMoving()) { 
				speed +=1;
			if(this.y>= p1.getY() && this.y <= p1.getY() + p1.getHeigth()/2) {
				directionY = -1;
			} 
			if(this.y> p1.getY() + p1.getHeigth()/2 && this.y <= p1.getY() + p1.getHeigth()) {
				directionY = 1;
			} 
			}
			//changes directon 
			//velX = (ran.nextInt(3) +1);	 
		//	velY = (ran.nextInt(3) +1);	
		directionX *= -1; 
		speed +=1;
		
		}
	}  
	
	if(this.y <= 0) {
		directionY *= -1;
	} 
	
	if(this.y + this.height >= 480) { 
		//System.out.println(this.y + this.height);
		directionY *= -1;
	} 
	
	if(this.x +this.width < p1.getX() - 10) {
		sb.p2Score();
		this.start();
	} 
	
	if(this.x > p2.getX() + p2.getWidth() + 10) {
		sb.p1Score();
		this.start();
	}
	
	// make the ball move at a certian speed in an either negetive or postive direction
		x += speed * (directionX );  
		y += speed * (directionY ); 
		//System.out.println(this.y + this.height); 
		//System.out.println(this.speed);
		 
		
		
	}  
	void hit() { 
		//if(this.)
		
	}
	
	void start() {  
		x = iX; 
		y = iY;    
		velX =1;	 
		velY = 1;	
		speed = 10;
		/*try {
		Thread.sleep(100);} 
		catch {
			System.out.println("ops");
		}*/
		Random ran = new Random();
		boolean xd = ran.nextBoolean();
		if(xd) {
			directionX = 1;
		} 
		else {
			directionX = -1;
		} 
		boolean yd = ran.nextBoolean();
		if(yd){
			directionY = 1;
		} 
		else {
			directionY = -1;
		}
	}
}

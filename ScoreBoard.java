
public class ScoreBoard { 
	
	private int Player1Score;
	private int Player2Score;  
	private int Winner = 0; 
	private Pong pong;
	
	ScoreBoard(Pong p){
		pong = p;
	}
	
	void p1Score() {
		Player1Score +=1; 
		System.out.println("p1: " + Player1Score + "p2:" + Player2Score );  
		if(Player1Score >= 10) {
			System.out.println("end game");    
			Winner = 1;
			pong.endGame(Winner);

		}
		
	} 
	void p2Score() {
		Player2Score +=1; 
		System.out.println("p1: " + Player1Score + "p2:" + Player2Score );  
		if(Player2Score >= 10) { 
			Winner = 2;
			pong.endGame(Winner);

		}
		
	} 
	
	String Getp1Score() {
		String Stringp1s = String.valueOf(Player1Score);
		return Stringp1s;
	}

	String Getp2Score() {
		String Stringp2s = String.valueOf(Player2Score);
		return Stringp2s;
	}
}

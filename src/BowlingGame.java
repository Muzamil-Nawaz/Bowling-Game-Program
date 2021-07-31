


public class BowlingGame {
	public static final int PINS = 10;
	
	private int totalFrames;
	private String givenPlayerName;
	private int roll;
	private int remainingPins;
	private int score;
	private boolean gameOver;
	private int currFrame;
	private int AllowedRolls;
        private boolean spare;
	/***
	 * Initially all 10 pins are up, it is frame number 1, roll number 1, 
		and the score is zero.
	 * @param playerName
	 * @param howManyFrames
	 **/
	public BowlingGame(String playerName, int howManyFrames) 
	{
		currFrame = 1;
		this.givenPlayerName=playerName;
		this.totalFrames=howManyFrames;
		score=0;
		AllowedRolls = 2;
		roll=1;
		remainingPins = PINS;
		gameOver = false;
                spare = false;
	}
	
	/*** 
	 * 
	 * @param playerName
	 */
	public BowlingGame(String playerName) 
	{
		currFrame = 1;
		totalFrames = 10;
		this.givenPlayerName=playerName;
		score=0;
		AllowedRolls = 2;
		roll=1;
		remainingPins = PINS;
		gameOver = false;


	}
	
	public int getFrame() 
	{
		//Returns the current frame number, or -1 if game is over
		if(isGameOver()){
			return-1;
		}
		
		return currFrame;
	}

	public String getPlayerName()
	{
		return givenPlayerName;
	
	}
	
	public int getRoll()
	{
	//Returns the current roll number within the frame, 
		//or -1 if the game is over
		
		if(isGameOver()){
			return-1;
		}
		
		return roll;
	}
	
	public int getRemainingPins() 
	{
	//Returns the number of standing pins in this game,
		//or -1 if the game i
		if(isGameOver()){
			return-1;
		}
		
		return remainingPins;
	}
	
	public boolean isGameOver()
	{
		return gameOver;
	
	
	}
	
	public void reset() 
	{
            currFrame = 1;
            totalFrames = 10;
            score=0;
            AllowedRolls = 2;
            roll=1;
            remainingPins = PINS;
            gameOver = false;
            spare = false;
		
	}
	
	public int getScore()
	{
		return score;
	}
	
	/***
	 * 
	 * @param pins
	 */
	public void bowl(int pins) 
	{
	
		if(!(isGameOver()) || (pins > remainingPins)) {
			if(currFrame == totalFrames) {
				if(pins == PINS) {
					AllowedRolls+=2;
				}
				else if(pins == remainingPins ) {
					AllowedRolls++;
                                        
				}
				else {
					if(!(roll == AllowedRolls)) {
						roll++;
					}
					else {
						gameOver = true;
					}
					
				}
			}
		
			if((pins == remainingPins)){

				currFrame++;
				roll = 1;
				remainingPins= PINS;
				score += pins; 
                                spare =true;
			}
			else if(pins == PINS) {  // Strike
				currFrame++;
				roll = 1;
				remainingPins= PINS;
				score += 10; 
                                spare = true;
			}
			
			else if((roll == AllowedRolls)) {
				score+= pins;
				currFrame++;
				roll = 1;
				remainingPins= PINS;
			}
			
			else {
                                        if(spare ==true)
                                            score += (pins*2);
                                        else
                                            score+=pins;
					roll++;
					remainingPins-= pins;
                                        spare =false;
				}
		 
			
		}
		
		//isGameOver(); // is it correct to check status if it is (over or not).
	}
	/***
	 * 
	 * @param isFoul
	 */
	public void foul(boolean isFoul)
	{
                if(isGameOver())
                    return;
                else if(isFoul==true && this.roll ==1 )
                {
			this.roll+=1;
                        this.remainingPins=10;
		}
                else if(isFoul == true && this.roll ==2)
                {
                    this.currFrame +=1;
                    
                }
                else if(isFoul == false && this.roll ==1)
                {
                    this.roll +=1;   
                }
                else if(isFoul == false && this.roll ==2)
                {
                    this.currFrame+=1;
                    
                }
	}
}



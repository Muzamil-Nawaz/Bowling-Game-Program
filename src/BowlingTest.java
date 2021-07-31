

public class BowlingTest {
	public static void main(String[] args)
	 {
	 BowlingGame game = new BowlingGame("Player 1", 3);
	 System.out.println(game.getFrame()); // expected 1
	 System.out.println(game.getRoll ()); // expected 1
	 System.out.println(game.getRemainingPins()); // expected 10
	 System.out.println(game.isGameOver()); // expected false
	 System.out.println(game.getScore()); // expected 0
	 
	 System.out.println();
	 
	 
	 game.bowl(3);
	 System.out.println(game.getFrame()); // expected 1 
	 System.out.println(game.getRoll()); // expected 2
	 System.out.println(game.getRemainingPins());// expected 7
	 System.out.println(game.getScore());
	 System.out.println();
	
	 game.bowl(4);
	 System.out.println(game.getFrame()); // expected 2 
	 System.out.println(game.getRoll()); // expected 1 
	 System.out.println(game.getRemainingPins()); // expected 10
	 System.out.println(game.getScore());
	 System.out.println();
	 
	 game.bowl(10); 
	 System.out.println(game.getFrame()); // expected 3
	 System.out.println(game.getRoll()); // expected 1
	 System.out.println(game.getRemainingPins());// expected 10
	 System.out.println(game.getScore());
	 
	 game = new BowlingGame("Player 1", 3);
	 game.bowl(3);
	 game.bowl(7);
	 game.bowl(4);
	 game.bowl(1);
	 System.out.println(game.getScore()); // expected 19
         System.out.println();
         game.reset();
         System.out.println(game.getScore()); // expected 0
         System.out.println(game.getFrame()); // expected 1
         System.out.println(game.getRemainingPins()); // expected 10
         game.bowl(10);
         System.out.println(game.getRemainingPins()); // expected 0;
         System.out.println(game.getFrame()); // expected 2;
         System.out.println(game.getRoll()); // expected 1;
         System.out.println(game.getScore()); // expected 10
         game.foul(true);
         System.out.println(game.getRoll()); // expected 2;
         System.out.println(game.getScore()); // expected 10
         

	 }

}

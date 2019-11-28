import java.util.Random;
/**
 * Date: 28-Nov-2019
 * This is a class used to manage the recharge cards in the game
 * 
 * @author Group 25 (Ng Yee Jien, Ibrahim Keith Harold Ford, Choy Ee Lee, Teo Yun Xian)
 * @version 1.0
 *
 *
 */
public class RechargeCardDeck {
	
	/**
	 * 3 different cards with colour blue, yellow and red respectively
	 */
	private static String[] Colours = {"Blue","Yellow","Red"};
	/**
	 * a random function used
	 */
	static Random randint = new Random();
	
	/**
	 * This method is called when the player draws one energy card
	 * @return a random colour card
	 */
	public static String deal() {
		int card = randint.nextInt(Colours.length);
		return Colours[card];
		
		
		
	}
	
	
	
	
}

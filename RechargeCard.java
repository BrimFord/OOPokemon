import java.util.Random;

public class RechargeCardDeck {
	
	private static String[] Colours = {"Blue","Yellow","Red"};
	static Random randint = new Random();
	
	public static String deal() {
		int card = randint.nextInt(Colours.length);
		return Colours[card-1];
		
		
		
	}
	
	
	
	
}

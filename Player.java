import java.util.ArrayList;
/**
 * Date: 28-Nov-2019
 * This is a class used to manage the players in the game
 * 
 * @author Group 25 (Ng Yee Jien, Ibrahim Keith Harold Ford, Choy Ee Lee, Teo Yun Xian)
 * @version 1.0
 *
 *
 */
public class Player {
	
	/**
	 * The name of the player
	 */
	private String name;
	/**
	 * The no. of cards the player has in hand
	 */
	private int noOfCard;
	/**
	 * A list of 6 cards the player has in hand
	 */
	private static ArrayList<PokemonCard> hand;
	/**
	 * The score of the player
	 */
	private Score score;
	
	

	/**
	 * A default constructor that set the player name to none and no. of cards to 0
	 */
	public Player() {
		this.name = "none";
		this.noOfCard = 0;
	}

	/**
	 * This method returns the name of the player
	 * @return name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the name of the player
	 * @param name is the name being set to the player
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns the no. of cards the player has in hand
	 * @return no. of cards the player has in hand
	 */
	public int getnoOfCard() {
		return noOfCard;
	}

	/**
	 * This method sets the no. of cards the player has in hand
	 * @param noOfCard is the no. of cards the player has in hand
	 */
	public void setnoOfCard(int noOfCard) {
		this.noOfCard = noOfCard;
	}

	/**
	 * This method returns the score of the player
	 * @return player's score
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * This method sets the score of the player
	 * @param score is the player's score added in each round
	 */
	public void setScore(Score score) {
		this.score = score;
	}

	/**
	 * This method returns the cards of the player
	 * @return the set of cards of the player
	 */
	public static ArrayList getHand() {
		return hand;
	}

	/**
	 * This method sets 6 cards for each player by drawing the cards from pokemon card deck
	 */
	public void setHand() {
		hand=PokemonCardDeck.deal();
	}


}




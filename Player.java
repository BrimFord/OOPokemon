import java.util.ArrayList;

public class Player {
	
	private String name;
	private int noOfCard;
	private static ArrayList<PokemonCard> hand;
	private Score score;
	
	

	public Player() {
		this.name = "none";
		this.noOfCard = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getnoOfCard() {
		return noOfCard;
	}

	public void setnoOfCard(int noOfCard) {
		this.noOfCard = noOfCard;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public static ArrayList getHand() {
		return hand;
	}

	public void setHand() {
		hand=PokemonCardDeck.deal();
	}


}




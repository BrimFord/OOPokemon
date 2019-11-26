
public class Player {
	private String name;
	private int noOfCard;
	private static PokemonCardDeck hand;
	private Score score;

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

	public static PokemonCardDeck getHand() {
		return hand;
	}

	public static void setHand(PokemonCardDeck hand) {
		Player.hand = hand;
	}

}

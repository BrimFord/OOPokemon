import java.util.Arrays;

public class Player {
	private String name;
	private int noOfCard;
	private PokemonCard[] hand = new PokemonCard[6];
	//private static ArrayList<PokemonCard> card1 = new ArrayList<PokemonCard>();
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
	
	public PokemonCard getHand(int i) {
		return hand[i];
	}

	public void setHand(PokemonCard[] hand) {
		
		this.hand = PokemonCardDeck.deal(); 

	}

	/*public static PokemonCard getCard1(int i) {
		return card1.get(i);
	}

	public static void setCard1(ArrayList<PokemonCard> card1) {
		card1.add(PokemonCardDeck.deal());
		card1.add(PokemonCardDeck.deal());
		card1.add(PokemonCardDeck.deal());
		card1.add(PokemonCardDeck.deal());
		card1.add(PokemonCardDeck.deal());
		card1.add(PokemonCardDeck.deal());
	}
	*/

	@Override
	public String toString() {
		return String.format("Player [hand=%s]", Arrays.toString(hand));
	}

	

	

	

}




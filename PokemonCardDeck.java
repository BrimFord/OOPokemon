import java.util.*;

public class PokemonCardDeck {

	private ArrayList<PokemonCard> cards = new ArrayList<PokemonCard>();
	
	public void deck() {
		cards.add(new PokemonCard("Attacking", 0, 0, 54, 50, "Red", 2, null, "Active"));
		cards.add(new PokemonCard("Attacking", 0, 0, 79, 36, "Yellow", 3, null, "Active"));
		cards.add(new PokemonCard("Attacking", 0, 0, 75, 44, "Colourless", 4, null, "Active"));
		cards.add(new PokemonCard("Attacking", 0, 0, 60, 37, "Blue", 5, null, "Active"));
		cards.add(new PokemonCard("Attacking", 0, 0, 55, 47, "Colourless", 3, null, "Active"));
		cards.add(new PokemonCard("Attacking", 0, 0, 73, 28, "Yellow", 2, null, "Active"));
		cards.add(new PokemonCard("Attacking", 0, 0, 68, 33, "Blue", 3, null, "Active"));
		cards.add(new PokemonCard("Attacking", 0, 0, 61, 37, "Red", 4, null, "Active"));
		cards.add(new PokemonCard("Attacking", 0, 0, 58, 43, "Yellow", 5, null, "Active"));
		cards.add(new PokemonCard("Defending", 0, 0, 56, 46, "Red", null, 1, "Active"));
		cards.add(new PokemonCard("Defending", 0, 0, 68, 31, "Blue", null, 2, "Active"));
		cards.add(new PokemonCard("Defending", 0, 0, 75, 28, "Colourless", null, 3, "Active"));
		cards.add(new PokemonCard("Defending", 0, 0, 71, 20, "Yellow", null, 2, "Active"));
		cards.add(new PokemonCard("Defending", 0, 0, 68, 35, "Red", null, 1, "Active"));
		cards.add(new PokemonCard("Defending", 0, 0, 51, 49, "Blue", null, 2, "Active"));
		cards.add(new PokemonCard("Defending", 0, 0, 67, 21, "Yellow", null, 3, "Active"));
		cards.add(new PokemonCard("Fairy", 0, 0, 76, 25, "Colourless", null, null, "Active"));
		cards.add(new PokemonCard("Fairy", 0, 0, 63, 38, "Yellow", null, null, "Active"));
		cards.add(new PokemonCard("Fairy", 0, 0, 58, 44, "Blue", null, null, "Active"));
		cards.add(new PokemonCard("Fairy", 0, 0, 63, 37, "Red", null, null, "Active"));
	}

	Random r = new Random();
	
	public void deal() {
		for(char i=1; i <= 6; i++) {
			cards.get(r.nextInt(20));
			//check type condition ;(
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
}

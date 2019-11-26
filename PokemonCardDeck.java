import java.util.*;

public class PokemonCardDeck {
	
	private static ArrayList<PokemonCard> cards = new ArrayList<PokemonCard>();
	private static PokemonCard[] pokemons = new PokemonCard[6];
	//private static PokemonCard pokemons;
	
	public void deck() {		
		
		cards.add(new DefendingPokemon(0, 0, 56, 46, "Red", "Active", 1));
		cards.add(new DefendingPokemon(0, 0, 68, 31, "Blue", "Active", 2));
		cards.add(new DefendingPokemon(0, 0, 75, 28, "Colourless", "Active", 3));
		cards.add(new DefendingPokemon(0, 0, 71, 20, "Yellow", "Active", 2));
		cards.add(new DefendingPokemon(0, 0, 68, 35, "Red", "Active", 1));
		cards.add(new DefendingPokemon(0, 0, 51, 49, "Blue", "Active", 2));
		cards.add(new DefendingPokemon(0, 0, 67, 21, "Yellow", "Active", 3));
		
		cards.add(new AttackingPokemon(0, 0, 54, 50, "Red", "Active", 2));
		cards.add(new AttackingPokemon(0, 0, 79, 36, "Yellow", "Active", 3));
		cards.add(new AttackingPokemon(0, 0, 74, 44, "Colourless", "Active", 4));
		cards.add(new AttackingPokemon(0, 0, 60, 37, "Blue", "Active", 5));
		cards.add(new AttackingPokemon(0, 0, 55, 47, "Colourless", "Active", 3));
		cards.add(new AttackingPokemon(0, 0, 73, 28, "Yellow", "Active", 2));
		cards.add(new AttackingPokemon(0, 0, 68, 33, "Blue", "Active", 3));
		cards.add(new AttackingPokemon(0, 0, 61, 37, "Red", "Active", 4));
		cards.add(new AttackingPokemon(0, 0, 58, 43, "Yellow", "Active", 5));
		

		cards.add(new FairyPokemon(0, 0, 76, 25, "Colourless", "Active"));
		cards.add(new FairyPokemon(0, 0, 63, 38, "Yellow", "Active"));
		cards.add(new FairyPokemon(0, 0, 58, 44, "Blue", "Active"));
		cards.add(new FairyPokemon(0, 0, 63, 37, "Red", "Active"));

	}

	static Random r = new Random();
	
	public static PokemonCard[] deal() {
		for(char i=1; i <= 6; i++) {
			pokemons[i]=cards.get(r.nextInt(20));
			//check type condition ;(
		}
		return pokemons;
	}
		/*for (int i = 1; i <= 6; i++) {
			pokemons = cards.get(r.nextInt(20));
		}
		return pokemons;
	}
	*/
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
}

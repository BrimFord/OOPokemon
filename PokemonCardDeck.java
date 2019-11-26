import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PokemonCardDeck  {
	private static ArrayList<PokemonCard> cards = new ArrayList<PokemonCard>();

	
	public void deck() {
		
		cards.add(new AttackingPokemon(0,0,54,50,"Red","Active",2));
		cards.add(new AttackingPokemon(0,0,54,50,"Blue","Active",2));
		cards.add(new AttackingPokemon(0,0,54,50,"Red","Active",2));
		cards.add(new AttackingPokemon(0,0,54,50,"Yellow","Active",2));
		cards.add(new AttackingPokemon(0,0,54,50,"Colourless","Active",2));
		cards.add(new AttackingPokemon(0,0,54,50,"Red","Active",2));
		cards.add(new AttackingPokemon(0,0,54,50,"Blue","Active",2));
		cards.add(new AttackingPokemon(0,0,54,50,"Red","Active",2));
		cards.add(new AttackingPokemon(0,0,54,50,"Blue","Active",2));
		cards.add(new DefendingPokemon(0,0,54,50,"Colourless","Active",2));
		cards.add(new DefendingPokemon(0,0,54,50,"Red","Active",2));
		cards.add(new DefendingPokemon(0,0,54,50,"Blue","Active",2));
		cards.add(new DefendingPokemon(0,0,54,50,"Colourless","Active",2));
		cards.add(new DefendingPokemon(0,0,54,50,"Yellow","Active",2));
		cards.add(new DefendingPokemon(0,0,54,50,"Red","Active",2));
		cards.add(new DefendingPokemon(0,0,54,50,"Blue","Active",2));
		cards.add(new DefendingPokemon(0,0,54,50,"Blue","Active",2));
		cards.add(new DefendingPokemon(0,0,54,50,"Yellow","Active",2));
		cards.add(new FairyPokemon(0,0,54,50,"Red","Active"));
		
	}
	

	
	
	public static ArrayList deal() {
		ArrayList <PokemonCard> newhand = new ArrayList();
		ArrayList <PokemonCard> currentdeck = getDeck();
		for(char i=1; i <= 6; i++) {
			PokemonCard dealed = currentdeck.get(i);
			newhand.add(dealed);
			currentdeck.remove(i);
		
			//check type condition ;(
		}
		return newhand;
	}
	
	public static  ArrayList getDeck() {
		return cards;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
	
}
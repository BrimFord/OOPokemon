import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PokemonCardDeck  {
	private static ArrayList<PokemonCard> cards = new ArrayList<PokemonCard>();

	
	public void deck() {
		
		cards.add(new AttackingPokemon(0,0,54,50,"Red","Active",2));
		cards.add(new AttackingPokemon(0,0,58,45,"Blue","Active",2));
		cards.add(new AttackingPokemon(0,0,61,47,"Red","Active",2));
		cards.add(new AttackingPokemon(0,0,55,30,"Yellow","Active",2));
		cards.add(new AttackingPokemon(0,0,50,25,"Colourless","Active",2));
		cards.add(new AttackingPokemon(0,0,60,35,"Red","Active",2));
		cards.add(new AttackingPokemon(0,0,55,37,"Blue","Active",2));
		cards.add(new AttackingPokemon(0,0,52,40,"Red","Active",2));
		cards.add(new DefendingPokemon(0,0,65,27,"Colourless","Active",2));
		cards.add(new DefendingPokemon(0,0,68,44,"Red","Active",2));
		cards.add(new DefendingPokemon(0,0,70,23,"Blue","Active",2));
		cards.add(new DefendingPokemon(0,0,75,33,"Colourless","Active",2));
		cards.add(new DefendingPokemon(0,0,78,31,"Yellow","Active",2));
		cards.add(new DefendingPokemon(0,0,77,30,"Red","Active",2));
		cards.add(new DefendingPokemon(0,0,69,23,"Blue","Active",2));
		cards.add(new DefendingPokemon(0,0,72,33,"Blue","Active",2));
		cards.add(new FairyPokemon(0,0,60,37,"Red","Active"));
		cards.add(new FairyPokemon(0,0,65,38,"Blue","Active"));
		cards.add(new FairyPokemon(0,0,51,32,"Yellow","Active"));
		cards.add(new FairyPokemon(0,0,52,33,"Colourless","Active"));
		
	}
	

	
	
	public static ArrayList deal() {
		ArrayList <PokemonCard> newhand = new ArrayList();
		ArrayList <PokemonCard> currentdeck = getDeck(); 
		int i = 0;
		int ii = 0;
		int j = 0;
		int jj = 0;
		int k = 0;
		
		while (i < 2) {
			PokemonCard dealed = currentdeck.get(ii);
			if (dealed instanceof AttackingPokemon) {
				AttackingPokemon AttackPoke = (AttackingPokemon) dealed;
				newhand.add(AttackPoke);
				currentdeck.remove(ii);
				i+=1;
			}
			ii+=1;
		}
		while (j < 1) {
			PokemonCard dealed = currentdeck.get(jj);
			if (dealed instanceof DefendingPokemon) {
				DefendingPokemon AttackPoke = (DefendingPokemon) dealed;
				newhand.add(AttackPoke);
				currentdeck.remove(jj);
				j+=1;
			}
			jj+=1;
		}
		while (k < 3) {
				PokemonCard dealed = currentdeck.get(k);
				newhand.add(dealed);
				currentdeck.remove(k);
				k+=1;
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


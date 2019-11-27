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
		
		
		
		
		/*
		cards.add(new AttackingPokemon(0, 0, 54, 50, "Red", 2,"Active",null));
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
		*/
		
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



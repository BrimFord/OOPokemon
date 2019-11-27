
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private static int token =1; // to determine who is playing 
	private Player p1 = new Player();
	private Player p2 = new Player();
	private RechargeCardDeck EnerDeck1 = new RechargeCardDeck();
	private PokemonCardDeck Deck1 = new PokemonCardDeck();
	private static ArrayList<PokemonCard> hand1 = new ArrayList();
	private static ArrayList<PokemonCard> hand2 = new ArrayList();
	

	//deck
	Scanner input = new Scanner(System.in);	
	
	public void start() {
		int choice=0;
		System.out.print("Key in the name for player 1: ");
		p1.setName(input.next());
		System.out.println();
		System.out.print("Key in the name for player 2: ");
		p2.setName(input.next());
		System.out.println();
		
		while (choice==0) {
			System.out.println("Choose option:");
			System.out.println("\t1. Start game");
			System.out.println("\t2. Display top 10 scores");
			System.out.print("Option: ");
			choice = input.nextInt();
			System.out.println();
			
			switch (choice)
			{
				case 1:
					drawCard();
					while (checkWin(p1,p2)==false || checkWin(p2,p1)==false) {
						chooseOption(p1,p2);
						checkWin(p1,p2);
			
						chooseOption(p2,p1);
						checkWin(p2,p1);
					}
					break;
				case 2:
					Score.loadScore();
					break;
				
				default:
					System.out.println("Invalid choice!\n");
					start();
			}
			
		}
	}
	public void displayCards() { //a method for display for hands of both players 
		System.out.println();
		String type;
		System.out.println("Player 1 Pokemon");
		System.out.println("PokeNum Type	  	Stage Experience HP 	Energy	 Status \tEnergyColour \n ");
		for(PokemonCard p : hand1) {
			if(p instanceof AttackingPokemon) {
				type = "Attacking";
			}
			else if (p instanceof DefendingPokemon){
				type = "Defending";
			}
			else {
				type = "Fairy    ";
			}
			
			System.out.printf("%d	%s \t %d \t %d \t %d \t %d \t %s \t %s \t \n",hand1.indexOf(p)+1, type,p.getStage(),p.getExperience(),p.getHP(),p.getEnergy(),p.getStatus(),p.getEnergyColour());
		}
		System.out.println();
		System.out.println("Player 2 Pokemon");
		System.out.println("PokeNum	Type	  	Stage Experience HP 	Energy	 Status \tEnergyColour \n ");
		
		for(PokemonCard i : hand2) {
			if(i instanceof AttackingPokemon) {
				type = "Attacking";
			}
			else if (i instanceof DefendingPokemon){
				type = "Defending";
			}
			else {
				type = "Fairy    ";
			}
			System.out.printf("%d	%s \t %d \t %d \t %d \t %d \t %s \t %s \t \n",hand2.indexOf(i)+1, type,i.getStage(),i.getExperience(),i.getHP(),i.getEnergy(),i.getStatus(),i.getEnergyColour());
		}
		}
		
	
	public void drawCard() {
		
		Deck1.deck();
		Deck1.shuffle();	
		System.out.println("Drawing the card for Player 1...");
		p1.setnoOfCard(6);
		p1.setHand();
		hand1 = p1.getHand();
		
		System.out.println("Drawing the card for Player 2...");
		p2.setnoOfCard(6);
		p2.setHand();
		hand2 = p2.getHand();
		
		
		
	}
		
		
	public void chooseOption(Player player, Player comparePlayer) {
		while (true) {
		System.out.println();
		System.out.println("Player " + player.getName() + "'s turn!");
		displayCards();
		System.out.println();
		System.out.println("Option 1: Attack");
		System.out.println("Option 2: Recharge");
		System.out.println("Option 3: Train");
		System.out.print("Choose the option: ");
		int option = input.nextInt();
		System.out.println();
		
		System.out.print("Choose Pokemon: ");
		int i = (input.nextInt() -1) ;
		
		PokemonCard poke1 = hand1.get(i);
		PokemonCard pokex = hand1.get(i);
		if (token%2==0) {
			 pokex = hand2.get(i);
		}
		System.out.println();

			switch(option)
			{
				case 1: //Attack
					if (checkStatus(pokex)==false || pokex.getStatus()=="Idle") {
						System.out.print("Pokemon is in idle, please choose another Pokemon.");
						continue;
						}
					
					while (true) {
					System.out.print("Attack Pokemon: ");
					int j = (input.nextInt() -1);
					System.out.println();
					PokemonCard poke2 = hand2.get(j);
					PokemonCard pokey = hand2.get(j);
					if (pokey.getStatus()=="-----") {
						System.out.print("please choose another Pokemon.");
						continue;
						}
		
						if (token%2==1) {
						attackPokemon(hand1,hand2,poke1,poke2,p1,p2);
						}
						else {
							attackPokemon(hand2,hand1,poke2,poke1,p2,p1);
						}
						token+=1;
					break;
					}
					break;
				
				case 2: //Recharge
					if (pokex.getStatus()=="-----") {
						System.out.print("Pokemon has been defeated, please choose another Pokemon.");
						continue;
						}
					rechargepokemon(pokex);
					
					token+=1;
					break;
				
				case 3: //Train
					if (pokex.getStatus()=="-----") {
						System.out.print("Pokemon has been defeated, please choose another Pokemon.");
						continue;
						}
					pokex.Train();
					System.out.println("Pokemon TRAINED!");
					if (pokex.getExperience() > 20){
						
						pokex.setStage(1);
						pokex.setExperience(0);
						pokex.setHP(pokex.getHP()*2);
					}
					
					token+=1;
					break;
					
				default:
					System.out.println("Invalid choice!\n");
					continue;
			}
			break;
		}
	}
	
	public boolean coin() {
		Random rand = new Random();
		int randomInt = rand.nextInt(1) + 1;
		if (randomInt == 1) 
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean comparePokemon(PokemonCard i, PokemonCard j) {
		
		if ((j instanceof AttackingPokemon) && (i instanceof AttackingPokemon)) {  //|| get type equal
			return true;
		}
		else if ((j instanceof DefendingPokemon) && (i instanceof DefendingPokemon)) {  //|| get type equal
			return true;
		}
		else if ((j instanceof FairyPokemon) && (i instanceof FairyPokemon)) {  //|| get type equal
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean checkStatus(PokemonCard i) {
		if (i.getStatus().equals("Active")){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void attackPokemon(ArrayList attackhand, ArrayList defendhand, PokemonCard i, PokemonCard j, Player p, Player cp) {
		int energyused = -1;
		int multiplier = 1;
		int reducept=0;
		int damagept=1;
		if (comparePokemon(i,j)) {
			System.out.println("Weakness: on, double attack point");
			multiplier *= 2;
			energyused = -2;
		}
		else {
			System.out.println("Weakness: off");
		}
			
		if (i instanceof AttackingPokemon) {
			AttackingPokemon AttackPoke =(AttackingPokemon) i;
			if (coin()) {
				System.out.println("[Flip a coin: head] Attack point is " + AttackPoke.getATKPoint());
				damagept = AttackPoke.getATKPoint();
			}
			}
		else if (i instanceof FairyPokemon && coin()==true) {
			System.out.println("[Flip a coin: head] Pokemon " + (defendhand.indexOf(j)+1) + " is poisoned");
			j.setStatus("Poisoned");
		}
		else if (i instanceof FairyPokemon && coin()==false) {
			System.out.println("[Flip a coin: tail] Pokemon " + (defendhand.indexOf(j)+1) + " is paralyzed");
			j.setStatus("Paralyzed");
			
		}
		
		if (j.getStatus().equals("Poisoned") || (j.getStatus().equals("Paralyzed"))) {
			multiplier *= 2;}
		if (j instanceof DefendingPokemon) { 
			DefendingPokemon DefendPoke = (DefendingPokemon) j;
			if (coin()) {
				System.out.println("[Flip a coin: head] resistance point is " + DefendPoke.getRSTPoint());
				reducept =  DefendPoke.getRSTPoint();
						}
			}
		damagept = (damagept * multiplier) - reducept;
		if (damagept < 0) {
			damagept=0;
		}
		
		System.out.printf("HitPoint for Pokemon %d ", (defendhand.indexOf(j)+1));
		System.out.printf(" damaged by %d", damagept);
		System.out.println();
		System.out.printf("Energy for Pokemon " + (attackhand.indexOf(i)+1));
		System.out.printf(" reduced by %d\n", energyused);
		i.Attack(j, damagept,energyused);
		i.setExperience(i.getExperience()+1);
		
		if (i.getHP() < 1) {
			i.setHP(0);
			i.setStatus("-----");
			p.setnoOfCard(p.getnoOfCard()-1);
		}
		
		if (i.getEnergy() < 1) {
			i.setEnergy(0);
			i.setStatus("Idle");
		}
		
		if (i.getExperience() > 20){
			i.setStage(1);
			i.setExperience(0);
			i.setHP(i.getHP()*2);
			
			if (i instanceof AttackingPokemon) {
				AttackingPokemon AttackPoke = (AttackingPokemon) i;
				AttackPoke.setATKPoint(AttackPoke.getATKPoint()*2);
			}
			else if (i instanceof DefendingPokemon) { 
				DefendingPokemon DefendPoke = (DefendingPokemon) i;
				DefendPoke.setRSTPoint(DefendPoke.getRSTPoint()*2);

			}
		}
}


	
	public boolean checkWin(Player player, Player comparePlayer) {
		if (comparePlayer.getnoOfCard() < 3) {
			System.out.print("Player " + player + " has successfully defeated three Pokemon of Player " + comparePlayer
					+ ". Player " + player + " is the winner");
			return true;
		}
		else if (player.getnoOfCard() < 3) {
			System.out.print("Player " + comparePlayer + " has successfully defeated three Pokemon of Player " + player
					+ ". Player " + comparePlayer + " is the winner");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void rechargepokemon(PokemonCard pokemon) {
			String color = RechargeCardDeck.deal();
			
			if (pokemon.getEnergyColour().equals(color) || pokemon.getEnergyColour().equals("Colourless")) {
				pokemon.Recharge();
				System.out.printf("Draw card... Color drawn: %s", color);
				System.out.println();
				System.out.println("Recharge sucessful!");
				}
			else {
				System.out.printf("Draw card... Color drawn: %s", color);
				System.out.println();
				System.out.println("Recharge Failed");
			
			}
		

	}

}

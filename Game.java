
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
					//Score.loadScore();
					break;
				
				default:
					System.out.println("Invalid choice!\n");
					start();
			}
			
		}
	}
	public void displayCards() {
		
		System.out.println("Player 1 Pokemon");
		System.out.println("PokeNum , Type					, Stage, Experience, HP, Energy,EnergyColour,Status \n ");
		for(PokemonCard p : hand1) {
			System.out.printf("%d	%s \t %d \t %d \t %d \t %d \t %s \t %s \t \n",hand1.indexOf(p)+1, p.getClass(),p.getStage(),p.getExperience(),p.getHP(),p.getEnergy(),p.getEnergyColour(),p.getStatus());
		}
		
		System.out.println("Player 2 Pokemon");
		System.out.println("PokeNum , Type					, Stage, Experience, HP, Energy,EnergyColour,Status \n ");
		
		for(PokemonCard i : hand2) {
			System.out.printf("%d	%s \t %d \t %d \t %d \t %d \t %s \t %s \t \n",hand2.indexOf(i)+1, i.getClass(),i.getStage(),i.getExperience(),i.getHP(),i.getEnergy(),i.getEnergyColour(),i.getStatus());
		}
		
		
	}
		
	
	public void drawCard() {
		
		Deck1.deck();
		Deck1.shuffle();	
		System.out.println("Drawing the card for Player 1...");
		p1.setnoOfCard(6);
		p1.setHand();
		hand1 = p1.getHand();
		System.out.printf("%s",p1.getHand());
		System.out.println("Drawing the card for Player 2...");
		p2.setnoOfCard(6);
		p2.setHand();
		hand2 = p2.getHand();
		
		
		
	}
		
		
			
		
			
			
			
		
	
	
	public void chooseOption(Player player, Player comparePlayer) {
		while (true) {
		displayCards();
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
		if (checkStatus(poke1)==false) {
				System.out.print(", please choose another Pokemon.");
				break;
		}
		else 
		{
			switch(option)
			{
				case 1: //Attack
					//sigh
					System.out.print("Attack Pokemon: ");
					int j = (input.nextInt() -1);
					PokemonCard poke2 = hand2.get(j);
					System.out.println();
					if (token%2==1) {
					attackPokemon(hand1,hand2,poke1,poke2);
					}
					else {
						attackPokemon(hand2,hand1,poke1,poke2);
					}
					token+=1;
					break;
				
				case 2: //Recharge
					rechargepokemon(pokex);
					token+=1;
					
					break;
				
				case 3: //Train
					pokex.Train();
					System.out.println("Pokemon TRAINED!");
					token+=1;
					break;
					
				default:
					System.out.println("Invalid choicce!\n");
				
			}
		}
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
		checkStatus(j);
		
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
		
		//else return false;
	}
	
	public void attackPokemon(ArrayList attackhand, ArrayList defendhand,PokemonCard i, PokemonCard j) {
		//sigh cast pokemon
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
				damagept = AttackPoke.getATKPoint();
			}
			}
		else if (i instanceof FairyPokemon && coin()) {
			System.out.println("[Flip a coin: head] Pokemon " + j + " is poisoned");
			j.setStatus("Poisoned");
		}
		else if (i instanceof FairyPokemon && coin()==false) {
			System.out.println("[Flip a coin: tail] Pokemon " + j + " is paralyzed");
			j.setStatus("Paralyzed");
			
		}
		
		if (j.getStatus().equals("Poisoned") ||(j.getStatus().equals("Paralyzed"))) {
			multiplier *= 2;}
		if (j instanceof DefendingPokemon) { 
			DefendingPokemon DefendPoke = (DefendingPokemon) j;
			if (coin()) {
				System.out.println("[Flip a coin: head] resistance point is getresistancept");
				reducept =  DefendPoke.getRSTPoint();
						}
			}
		damagept = (damagept * multiplier) - reducept;
		if (damagept < 0) {
			damagept=0;
		}
		
		System.out.printf("HitPoint for Pokemon %d ", (defendhand.indexOf(j)+1));
		System.out.printf(" damaged by %d", damagept);
		System.out.printf("Energy for Pokemon " + (attackhand.indexOf(i)+1));
		System.out.printf(" reduced by %d\n", energyused);
		i.Attack(j, damagept,energyused);
		//player setHP(reducept);
		//player experience(1);
		//if (player experience > 20){
			//set stage(1);
			//set experience(0);
			//attackpt/resistancept *2;
			//hitpoint * 2; } */
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
	
	public void rechargepokemon( PokemonCard pokemon) {
		
			if (pokemon.getEnergyColour().equals(RechargeCardDeck.deal()) || pokemon.getEnergyColour().equals("Colourless")) {
				pokemon.Recharge();
				System.out.println("Recharge sucessful!");
				}
			else {
				System.out.println("Recharge Failed");
			
			}
		
		
		
	}

}

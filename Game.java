import java.util.Random;
import java.util.Scanner;

public class Game {
	private Player p1;
	private Player p2;

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
			System.out.println("/t1. Start game");
			System.out.println("/t2. Display top 10 scores");
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
	
	public void drawCard() {
		System.out.println("Drawing the card for Player 1...");
		p1.setnoOfCard(6);
		System.out.println("Drawing the card for Player 2...");
		p2.setnoOfCard(6);
	}
	
	public void chooseOption(Player player, Player comparePlayer) {
		while (true) {
		System.out.println("Option 1: Attack");
		System.out.println("Option 2: Recharge");
		System.out.println("Option 3: Train");
		System.out.print("Choose the option: ");
		int option = input.nextInt();
		System.out.println();
		
		System.out.print("Choose Pokemon: ");
		int i = input.nextInt();
		System.out.println();
		checkStatus(i);
		if (checkStatus(i)==true) {
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
					int j = input.nextInt();
					System.out.println();
								attackPokemon(player, i, comparePlayer, j);
					break;
				
				case 2: //Recharge
					//drawRechargeCard
					RechargeCardDeck.deal();
					break;
				
				case 3: //Train
					//sigh
					//Pokemon experience + 1
					//Energy -5
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
	
	public boolean comparePokemon(int i, int j) {
		checkStatus(j);
		if (checkStatus(j) == true) {  //|| get type equal
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean checkStatus(int i) {
		//if status != active
		System.out.print("Pokemon " + i + " is ???"); //??? = getStatus
		return true;
		//else return false;
	}
	
	public void attackPokemon(Player p, int i, Player cp, int j) {
		//sigh cast pokemon
/*		int reducept=1;
		int damagept=1;
		if (comparePokemon(i,j)==true) {
			System.out.println("Weakness: on, double attack point");
			reducept = 2;
			
			if (p == attacking pokemon) {
				damagept = getattackpt * 2;
				}
			else if (p == defending pokemon) { 
				if (cp == defending pokemon && coin()==true && checkStatus(j)==false) {
					System.out.println("[Flip a coin: head] resistance point is getresistancept");
					damagept = 2 - resistancept
				}
				else {
					damagept = 2;
				}
			}
			else if (p == fairy && coin()==true) {
				System.out.println("[Flip a coin: head] Pokemon " + j + " is poisoned");
				damagept = 2;
			}
			else if (p== fairy && coin()==false) {
				System.out.println("[Flip a coin: tail] Pokemon " + j + " is paralyzed");
				damagept = 2;
			}
			else {
				damagept = 2;
			}
		}
		
		else {
			System.out.println("Weakness: off");
			reducept = 1;
			if (p == attacking pokemon && coin()==true) {
				System.out.println("[Flip a coin: head] attack point is getattackpoint");
				damagept = getattackpt;
				if (cp == defending pokemon && coin()==true) {
					System.out.println("[Flip a coin: head] resistance point is getresistancept");
					damagept = getattackpt - resistancept;
				}
			}
			else if (p == fairy && coin()==true) {
				System.out.println("[Flip a coin: head] Pokemon " + j + " is poisoned");
				damagept == 1;
					if (cp == defending pokemon && coin()==true) {
					System.out.println("[Flip a coin: head] resistance point is getresistancept");
					damagept = damagept - resistancept;
				}
			}
			else if (p == fairy && coin()==false) {
				System.out.println("[Flip a coin: tail] Pokemon " + j + " is paralyzed");
				damagept = 1;
					if (cp == defending pokemon && coin()==true) {
					System.out.println("[Flip a coin: head] resistance point is getresistancept");
					damagept = damagept - resistancept; }
			else {
				damagept = 1;
				}
	
		}
		}
		if (damagept < 0) {
			damagept=0;
		}
		
		System.out.print("HitPoint for Pokemon " + j);
		System.out.printf(" damaged by %d", damagept);
		//comparePlayer setHP(damagept);
		System.out.print("Energy for Pokemon " + i);
		System.out.printf(" reduced by %d", reducept);
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
}

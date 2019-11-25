import java.util.Scanner;

public class AttackingPokemon extends PokemonCard {
	private int AttackPoint = 2;
	private int result;
	private int heads = 0;
	private int tails = 1;
	
	public class JavaFlip {
		public static void main(String[] args) { 
		if (Math.random() < 0.5){
		System.out.println("Heads");
		this.AttackPoint *= 2;
		}else{
		System.out.println("Tails, NO BONUS DMG");
		}
		}
		}

	public void Attacking(int AttackPoint) {
		this.setAttackPoint(AttackPoint);
	
	public int getAttackPoint() {
		return AttackPoint;
	}

	public void setAttackPoint(int attackPoint) {
		AttackPoint = attackPoint;
	}
	
	
}

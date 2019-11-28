/**
 * Date: 28-Nov-2019
 * This is a class used to manage the attacking pokemon in the game
 * 
 * @author Group 25 (Ng Yee Jien, Ibrahim Keith Harold Ford, Choy Ee Lee, Teo Yun Xian)
 * @version 1.0
 *
 *
 */
public class AttackingPokemon extends PokemonCard {
	
/**
 * The attack point of the attacking pokemon
 */
private int ATKPoint = 1;
	
	
	/**
	 * The constructor of the attacking pokemon
	 * @param stage is the stage of the attacking pokemon
	 * @param experience is the attacking pokemon's experience in the game
	 * @param HP is the attacking pokemon's hit point
	 * @param energy is the attacking pokemon's energy point
	 * @param energyColour is the attacking pokemon's energy colour
	 * @param status is the status of the attacking pokemon
	 * @param ATKPoint is the attacking point of the attacking pokemon
	 */
	public AttackingPokemon(int stage, int experience, int HP, int energy, String energyColour, String status, int ATKPoint) {
		super(stage, experience, HP, energy, energyColour, status);
		this.ATKPoint = ATKPoint;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method returns the attack point of the attacking pokemon
	 * @return attacking pokemon's attacking point
	 */
	public int getATKPoint() {
		return ATKPoint;
	}

	/**
	 * This mehod sets the attack point of the attacking pokemon
	 * @param ATKPoint is the attack point set to the attacking pokemon
	 */
	public void setATKPoint(int ATKPoint) {
		this.ATKPoint = ATKPoint;
		if (getStage() > 0) {
			this.ATKPoint *= 2;
		}
	}


	/**
	 * This method prints the attacking pokemon's stage, experience level, hit point, energy, energy colour, status, and attack point
	 */
	@Override
	public String toString() {
		return String.format("AttackingPokemon %s ATKPoint=%s\n",super.toString(), ATKPoint);
	}
	

}

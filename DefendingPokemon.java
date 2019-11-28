/**
 * Date: 28-Nov-2019
 * This is a class used to manage the defending pokemon in the game
 * 
 * @author Group 25 (Ng Yee Jien, Ibrahim Keith Harold Ford, Choy Ee Lee, Teo Yun Xian)
 * @version 1.0
 *
 *
 */
public class DefendingPokemon extends PokemonCard {
	
/**
 * The resistance point of the defending pokemon
 */
private int RSTPoint = 1;
	
	
	/**
	 * This is the constructor of the defending pokemon
	 * @param stage is the stage of the defending pokemon
	 * @param experience is the defending pokemon's experience in the game
	 * @param HP is the defending pokemon's hit point
	 * @param energy is the defending pokemon's energy point
	 * @param energyColour is the defending pokemon's energy colour
	 * @param status is the status of the defending pokemon
	 * @param RSTPoint is the resistance point of the defending pokemon
	 */
	public DefendingPokemon(int stage, int experience, int HP, int energy, String energyColour, String status, int RSTPoint) {
		super(stage, experience, HP, energy, energyColour, status);
		this.RSTPoint = RSTPoint;
		// TODO Auto-generated constructor stub
	}



	/**
	 * This method returns the resistance point of the defending pokemon
	 * @return defending pokemon's resistance point
	 */
	public int getRSTPoint() {
		return RSTPoint;
	}

	/**
	 * This mehod sets the resistance point of the defending pokemon
	 * @param RSTPoint is the resistance point set to the defending pokemon
	 */
	public void setRSTPoint(int RSTPoint) {
		this.RSTPoint = RSTPoint;
	}
	
	/**
	 * This method prints the defending pokemon's stage, experience level, hit point, energy, energy colour, status, and resistance point
	 */
	@Override
	public String toString() {
		return String.format("DefendingPokemon %s RSTPoint=%s\n",super.toString(), RSTPoint);
	}
	
}

/**
 * Date: 28-Nov-2019
 * This is a class used to manage the Pokemon Cards in the game
 * 
 * @author Group 35 (Ng Yee Jien, Ibrahim Keith Harold Ford, Choy Ee Lee, Teo Yun Xian)
 * @version 1.0
 *
 *
 */

public class PokemonCard {
	/**
	 * Stage of the pokemon
	 */
	private int Stage;
	/**
	 * Pokemon's experience in the game
	 */
	private int Experience;
	/**
	 * Pokemon's hit point
	 */
	private int HP;
	/**
	 * Pokemon's energy point
	 */
	private int Energy;
	/**
	 * Pokemon's energy colour
	 */
	private String EnergyColour;
	/**
	 * Status of the pokemon
	 */
	private String Status;
	/**
	 * int value used to count the no. of rounds when the pokemon is in idle
	 */
	private int idlecount =0;
	
	
	/**
	 * This is the contructor of the PokemonCard class
	 * @param stage is the stage of the pokemon
	 * @param experience is the pokemon's experience in the game
	 * @param HP is the pokemon's hit point
	 * @param energy is the pokemon's energy point
	 * @param energyColour is the pokemon's energy colour
	 * @param status is the status of the pokemon
	 */
	public PokemonCard(int stage, int experience, int HP, int energy, String energyColour, String status) {
		setStage(stage);
		setExperience(experience);
		setHP(HP);
		setEnergy(energy);
		setEnergyColour(energyColour);
		setStatus(status);
	}


	/**
	 * This method returns the stage of the pokemon
	 * @return which stage the pokemon is in
	 */
	public int getStage() {
		return Stage;
	}


	/**
	 * This method sets which stage the pokemon is in
	 * @param stage is the stage is the stage of the pokemon
	 */
	public void setStage(int stage) {
		Stage += stage;
	}


	/**
	 * This method returns the pokemon's experience level
	 * @return pokemon's experience level
	 */
	public int getExperience() {
		return Experience;
	}

	/**
	 * This method sets the pokemon's experience level
	 * @param experience is the pokemon's experience level being set
	 */
	public void setExperience(int experience) {
		Experience = experience;
	}

	/**
	 * This method returns the hit point of the pokemon
	 * @return pokemon's hit point
	 */
	public int getHP() {
		return HP;
	}

	/**
	 * This method sets the pokemon's hit point
	 * @param hP is the pokemon's hit point being set
	 */
	public void setHP(int hP) {
		this.HP = hP;
	}

	/**
	 * This method returns the energy point of the pokemon
	 * @return pokemon's energy point
	 */
	public int getEnergy() {
		return Energy;
	}

	/**
	 * This method sets the pokemon's energy point
	 * @param energy is the pokemon's energy point being set
	 */
	public void setEnergy(int energy) {
		Energy += energy;
	}

	/**
	 * This method returns the energy colour of the pokemon
	 * @return pokemon's energy colour
	 */
	public String getEnergyColour() {
		return EnergyColour;
	}

	/**
	 * This method sets the pokemon's energy colour
	 * @param energyColour is the pokemon's energy colour being set
	 */
	public void setEnergyColour(String energyColour) {
		EnergyColour = energyColour;
	}

	/**
	 * This method returns the status of the pokemon
	 * @return the status of the pokemon
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * This method sets the status of the pokemon
	 * @param status is the status of the pokemon being set
	 */
	public void setStatus(String status) {
		Status = status;
	}
	
	/**
	 * This is the method called when the player's pokemon is attacking the opponent's pokemon
	 * This method sets the hit point of the pokemon being attacked and the energy point of the attacking pokemon
	 * @param DefendPoke is the pokemon being attacked
	 * @param AttackScore is the attacking score of the attacking pokemon
	 * @param energyused is the energy used by the attacking pokemon
	 */
	public void Attack(PokemonCard DefendPoke, int AttackScore,int energyused)
	{
		int newHP = (DefendPoke.getHP() - AttackScore);
		DefendPoke.setHP(newHP);
		this.setEnergy(energyused);

		
	}
	
	/**
	 * This method is called when the player has chosen to train the selected pokemon
	 * The pokemon's energy will reduce by 5 and the pokemon's experience level will increase by 1
	 */
	public void Train() {
		this.setEnergy(-5);
		this.setExperience(+1);
	}
	
	/**
	 * This method is called when the player has chosen to recharge the selected pokemon
	 * The pokemon's energy will increase by 5
	 */
	public void Recharge() {
		this.setEnergy(+5);
		
	}
	
	/**
	 * This method is used to set the count of the pokemon in idle state
	 * @param idle is the count set for the pokemon in idle state
	 */
	public void setIdleCount(int idle) {
		this.idlecount += idle;
	}
	
	/**
	 * This method returns the count of the pokemon in idle state
	 * @return idle count of the pokemon
	 */
	public int getIdleCount() {
		return this.idlecount;
	}
	
	
	/**
	 * This method decrease the idle count of the pokemon by 1 until it turns 0
	 * When the idle count turns 0, the status of the poisoned/paralyzed pokemon will be set to active
	 */
	public void RefreshIdleCounter() {
		if (this.getIdleCount() >0) {
			this.setIdleCount(-1);
		}
		if (this.getIdleCount()==0 && (this.getStatus().equals("Poisoned") || this.getStatus().equals("Paralyzed"))) {
			this.setStatus("Active");
			
		}
	}

	/**
	 * This method prints the pokemon's stage, experience level, hit point, energy, energy colour and status
	 */
	@Override
	public String toString() {
		return String.format(" [Stage=%s, Experience=%s, HP=%s, Energy=%s, EnergyColour=%s, Status=%s]",
				Stage, Experience, HP, Energy, EnergyColour, Status);
	}
	
	
	
	
	

}


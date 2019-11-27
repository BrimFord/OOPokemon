public class PokemonCard {
	private int Stage;
	private int Experience;
	private int HP;
	private int Energy;
	private String EnergyColour;
	private String Status;
	
	
	public PokemonCard(int stage, int experience, int HP, int energy, String energyColour, String status) {
		setStage(stage);
		setExperience(experience);
		setHP(HP);
		setEnergy(energy);
		setEnergyColour(energyColour);
		setStatus(status);
	}


	public int getStage() {
		return Stage;
	}


	public void setStage(int stage) {
		Stage += stage;
	}


	public int getExperience() {
		return Experience;
	}


	public void setExperience(int experience) {
		Experience += experience;
	}


	public int getHP() {
		return HP;
	}


	public void setHP(int hP) {
		this.HP = hP;
	}


	public int getEnergy() {
		return Energy;
	}


	public void setEnergy(int energy) {
		Energy += energy;
	}


	public String getEnergyColour() {
		return EnergyColour;
	}


	public void setEnergyColour(String energyColour) {
		EnergyColour = energyColour;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}
	
	public void Attack(PokemonCard DefendPoke, int AttackScore,int energyused)
	{
		int newHP = (DefendPoke.getHP() - AttackScore);
		DefendPoke.setHP(newHP);
		this.setEnergy(energyused);
		this.setExperience(1);
		
	}
	
	public void Train() {
		this.setEnergy(-5);
		this.setExperience(1);
	}
	public void Recharge() {
		this.setEnergy(5);
		
	}


	@Override
	public String toString() {
		return String.format(" [Stage=%s, Experience=%s, HP=%s, Energy=%s, EnergyColour=%s, Status=%s]",
				Stage, Experience, HP, Energy, EnergyColour, Status);
	}
	
	
	
	
	

}

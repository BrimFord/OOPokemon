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
		HP += hP;
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
	
	public void Attack(PokemonCard DefendPoke, int AttackScore)
	{
		int newHP = DefendPoke.getHP() -1;
		DefendPoke.setHP(newHP);
	}
	
	public void Train(PokemonCard TrainedPoke) {
		TrainedPoke.setEnergy(-5);
		TrainedPoke.setExperience(1);
	}
	public void Recharge(PokemonCard RechargePoke) {
		RechargePoke.setEnergy(5);
		
	}
	
	
	
	

}

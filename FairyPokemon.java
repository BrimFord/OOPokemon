
public class FairyPokemon extends PokemonCard{
	private String[] MGCPower = { "Poisoned" , "Paralysed" };

	
	public FairyPokemon(int stage, int experience, int HP, int energy, String energyColour, String status, String[] MGCPower) {
		super(stage, experience, HP, energy, energyColour, status);
		this.MGCPower = MGCPower;
	}


	public String[] getMGCPower() {
		return MGCPower;
	}
	
}

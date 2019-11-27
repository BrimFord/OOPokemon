
public class DefendingPokemon extends PokemonCard {
	
private int RSTPoint = 1;
	
	
	public DefendingPokemon(int stage, int experience, int HP, int energy, String energyColour, String status, int RSTPoint) {
		super(stage, experience, HP, energy, energyColour, status);
		this.RSTPoint = RSTPoint;
		// TODO Auto-generated constructor stub
	}



	
	public int getRSTPoint() {
		return RSTPoint;
	}

	public void setRSTPoint(int RSTPoint) {
		this.RSTPoint = RSTPoint;
	}
	
	@Override
	public String toString() {
		return String.format("DefendingPokemon %s RSTPoint=%s\n",super.toString(), RSTPoint);
	}
	
}
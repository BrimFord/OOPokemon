public class AttackingPokemon extends PokemonCard {
	
private int ATKPoint = 1;
	
	
	public AttackingPokemon(int stage, int experience, int HP, int energy, String energyColour, String status, int ATKPoint) {
		super(stage, experience, HP, energy, energyColour, status);
		this.ATKPoint = ATKPoint;
		// TODO Auto-generated constructor stub
	}
	

	public int getATKPoint() {
		return ATKPoint;
	}

	public void setATKPoint(int ATKPoint) {
		this.ATKPoint = ATKPoint;
		if (getStage() > 0) {
			this.ATKPoint *= 2;
		}
	}


	@Override
	public String toString() {
		return String.format("AttackingPokemon %s ATKPoint=%s\n",super.toString(), ATKPoint);
	}
	

}

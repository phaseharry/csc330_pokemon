package pokemon_battle;

public class FullRestore implements Item {
	private boolean used;
	public FullRestore(){
		used = false;
	};
	
	/**
	 * restores the pokemon back to full health and sets the
	 * status of the item to used so it can't be used again
	 */
	public void use(Pokemon p) {
		if(used) return;
		int pokemonMaxHp = p.getMaxHP();
		p.setHp(pokemonMaxHp);
		used = true;
	}
	
	/**
	 * returns a boolean indicating whether the item has been used or not
	 * @return used
	 */
	public boolean isUsed() {
		return used;
	}
}

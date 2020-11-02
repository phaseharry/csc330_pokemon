package pokemon_battle;

public class FullRestore implements Item {
	private boolean used;
	public FullRestore(){
		used = false;
	};
	
	public void use(Pokemon p) {
		if(used) return;
		int pokemonMaxHp = p.getMaxHP();
		p.setHp(pokemonMaxHp);
		used = true;
	}
}

package pokemon_battle;
import java.util.ArrayList;

public abstract class Pokemon {
	private String name;
	private int hp, attack, defense;
	private ArrayList<String> types;
	
	public Pokemon(String name, int hp, int attack, int defense, ArrayList<String> types) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.types = types;
	}
	
	public abstract void attack(Pokemon other);
	public abstract void speak();
	
	/**
	 * Gets the name of the Pokemon
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the types of the Pokemon
	 * @return types
	 */
	public ArrayList<String> getTypes() {
		return this.types;
	}
	
	/**
	 * Gets the stats of the pokemon in the form of an array [hp, sttack, defense];
	 * @return stats[hp, attack, defense];
	 */
	public int[] getStats() {
		int stats[] = { hp, attack, defense };
		return stats;
	}
}

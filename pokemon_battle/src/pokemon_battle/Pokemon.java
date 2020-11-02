package pokemon_battle;
import java.util.ArrayList;

public abstract class Pokemon {
	private String name;
	private int hp, attack, defense, speed;
	private ArrayList<String> types;
	private ArrayList<AttackMove>attackMoves;
	
	public Pokemon(String name, int hp, int attack, int defense, int speed, ArrayList<String> types, ArrayList<AttackMove> attackMoves) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.types = types;
		this.attackMoves = attackMoves;
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
		return types;
	}
	
	/**
	 * Gets the HP of the pokemon
	 * @return hp
	 */
	public int getHP() {
		return hp;
	}
	
	/**
	 * Gets the attack power of the pokemon
	 * @return attack
	 */
	public int getAttack() {
		return attack;
	}
	
	/**
	 * Gets the defense stat of the pokemon
	 * @return defense
	 */
	public int getDefense() {
		return defense;
	}
	
	/**
	 * Get the speed stat of the pokemon
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Sets the hp field to a newHp data value for when this pokemon takes an attack
	 * @param newHp
	 */
	public void setHp(int newHp) {
		hp = newHp;
	}
	
	/**
	 * @return a list of the AttackMoves
	 */
	public ArrayList<AttackMove> getAttackMoves() {
		return attackMoves;
	}
}

package pokemon_battle;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Pokemon {
	private String name;
	private int hp, attack, defense, speed;
	private String[] types;
	private ArrayList<AttackMove>attackMoves;
	private final static AttackMove struggle = new AttackMove("Struggle", "normal", 50, Integer.MAX_VALUE);
	
	public Pokemon(String name, int hp, int attack, int defense, int speed, String[] types, ArrayList<AttackMove> attackMoves) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.types = types;
		this.attackMoves = attackMoves;
	}
	
	public abstract void speak();
	
	/**
	 * calculates the attack damage done to a target pokemon based on move's attack type & power vs 
	 * target pokemon's types 
	 * @param other - the target of the attack
	 * @param typesMultiplier - the multiplier matrix used to determine the damage done
	 * @param idxOfAttack - the index of the chosen attack
	 * @return whether or not the answer was successful
	 */
	public boolean attack(Pokemon other, int idxOfAttack, double[][] typesMultiplier, HashMap<String, Integer> typesMap) {
		if(idxOfAttack > 1 || idxOfAttack < 0) return false; // idx out of bounds (no attacks found)
		AttackMove move = attackMoves.get(idxOfAttack);
		if(move.getPP() <= 0) return false; // if no more pp, this move can't be done
		
		int powerMultiplier = 1;
		String[] targetPokemonTypes = other.getTypes(); // at most, a pokemon can have 2 types
		int targetPokemonDefense = other.getDefense();
		int targetPokemonHealth = other.getHP();
		
		// first calculate the multiplier derived by move attack type vs the target pokemon's types
		for(int i = 0; i < targetPokemonTypes.length; i++) {
			int attackRow = typesMap.get(move.getType());
			int defenseCol = typesMap.get(targetPokemonTypes[i]);
			powerMultiplier *= typesMultiplier[attackRow][defenseCol];
		}
		
		// multiply the multiplier to the moves attack power minus the target pokemon's defense to determine the total damage done
		double damage = (powerMultiplier * move.getAttackPower()) - targetPokemonDefense;
		other.setHp((int)(targetPokemonHealth - damage)); 
		return true;
	}
	
	/**
	 * Used to display the attack moves available to this pokemon including its
	 * power, pp, and its type
	 */
	public void printAttackMoves() {
		ArrayList<AttackMove> moves = getAttackMoves();
		// printing the moves for selection
		for(int i = 0; i < moves.size(); i++) {
			AttackMove currentMove = moves.get(i);
			String attackName = currentMove.getName();
			String type = currentMove.getType();
			int power = currentMove.getAttackPower();
			int pp = currentMove.getPP();
			System.out.println(i + ") " + attackName + ", Type: " + type + ", Power: " + power + ", PP: " + pp);
		}
	}
	
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
	public String[] getTypes() {
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
	
	/**
	 * A getting for attack move struggle for a pokemon to use when they are out of PP 
	 * for their other attack moves
	 * @return struggle
	 */
	public AttackMove getStruggle() {
		return struggle;
	}
}

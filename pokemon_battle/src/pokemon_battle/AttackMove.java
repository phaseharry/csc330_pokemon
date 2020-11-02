package pokemon_battle;

public class AttackMove {
	private String name, type;
	private int attackPower, powerPoints;
	
	public AttackMove(String name, String type, int attackPower, int powerPoints) {
		this.name = name;
		this.type = type;
		this.attackPower = attackPower;
		this.powerPoints = powerPoints;
	}
	
	/**
	 * Getter for the attack's name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter for the attack's type
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Getter for the attack's power
	 * @return type
	 */
	public int getAttackPower() {
		return attackPower;
	}
	
	/**
	 * Getter for the attack's current powerPoints
	 * @return powerPowers
	 */
	public int getPP() {
		return powerPoints;
	}
	
	/**
	 * Setter method for updating the current powerPoints when this move is used. If the operation
	 * was successful (We had a powerPoint of >= 1) then return true else it was zero meaning we couldn't
	 * use this attack move.
	 * @return 
	 */
	public boolean useMove() {
		if(powerPoints > 0) {
			powerPoints -= 1;
			return true;
		}
		return false;
	}
}

package pokemon_battle;
import java.util.ArrayList;

public class Charizard extends Pokemon {
	private final static String[] types = { "fire", "flying" };
	
	public Charizard() {
		super("Charizard", 364, 340, 240, 300, types, initAttackMoves());
	}

	/**
	 * initializes the Charizard class with attack moves
	 * @return an ArrayList of attack moves that Charizard has
	 */
	private static ArrayList<AttackMove> initAttackMoves() {
		ArrayList<AttackMove> moves = new ArrayList<AttackMove>();
		AttackMove flameThrower = new AttackMove("Flamerthrower", "fire", 90, 4);
		AttackMove thunderPunch = new AttackMove("Thunder Punch", "electric", 75, 4);
		moves.add(flameThrower);
		moves.add(thunderPunch);
		return moves;
	}
	
	@Override
	public void attack(Pokemon other, double[][] typesMultiplier) {
		ArrayList<AttackMove> moves = getAttackMoves();
		// printing the moves for selection
		for(int i = 0; i < moves.size(); i++) {
			AttackMove currentMove = moves.get(i);
			String attackName = currentMove.getName();
			String type = currentMove.getType();
			int power = currentMove.getAttackPower();
			int pp = currentMove.getPP();
			System.out.println(attackName + ", Type: " + type + ", Power: " + power + ", PP: " + pp);
		}
		
		double powerMultiplier = 1;
		boolean moveCompleted = false;
		while(!moveCompleted) {
			
		}
	}

	@Override
	public void speak() {
		System.out.println("char char charrr");
	}
}

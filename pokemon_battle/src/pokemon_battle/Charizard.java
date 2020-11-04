package pokemon_battle;
import java.util.ArrayList;

public class Charizard extends Pokemon {
	private final static String[] types = { "fire", "flying" };
	
	public Charizard() {
		super("Charizard", 364, 340, 300, types, initAttackMoves());
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
	public void speak() {
		System.out.println("char char charrr");
	}
}

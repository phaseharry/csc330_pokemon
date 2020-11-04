package pokemon_battle;
import java.util.ArrayList;

public class Blastoise extends Pokemon {
	private final static String[] types = { "water" };
	
	public Blastoise() {
		super("Blastoise", 350, 310, 240, types, initAttackMoves());
	}

	/**
	 * initializes the Blastoise class with attack moves
	 * @return an ArrayList of attack moves that Blastoise has
	 */
	private static ArrayList<AttackMove> initAttackMoves() {
		ArrayList<AttackMove> moves = new ArrayList<AttackMove>();
		AttackMove surf = new AttackMove("Surf", "water", 90, 4);
		AttackMove headbutt = new AttackMove("Headbutt", "normal", 70, 4);
		moves.add(surf);
		moves.add(headbutt);
		return moves;
	}
	
	@Override
	public void speak() {
		System.out.println("blas blas blass");
	}
}

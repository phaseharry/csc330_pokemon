package pokemon_battle;
import java.util.ArrayList;
import java.util.HashMap;

public class ComputerPlayer extends Player{
	public ComputerPlayer(Pokemon partner, Item item) {
		super(partner, item);
	}

	@Override
	public Pokemon getPokemon() {
		return partner;
	}

	@Override
	public Item getItem() {
		return item;
	}

	public void run(Pokemon other, double[][] typesMultiplier, HashMap<String, Integer> typesMap) {
		// if pokemon health is lower than 40% then player will use item
		if(Math.floor(partner.getCurrentHP() / partner.getMaxHP()) < 0.4 && item != null) {
			item.use(partner);
			return;
		}
		int idxOfMaxDamageAttack = getMaxDamage(other, typesMultiplier, typesMap);
		if(idxOfMaxDamageAttack == -1) { // if none is found (probably due to PP == 0, then use struggle
			// TODO: handle -1 case
			partner.attack(other, idxOfMaxDamageAttack, typesMultiplier, typesMap);
		} else {
			partner.attack(other, idxOfMaxDamageAttack, typesMultiplier, typesMap);
		}
	}
	
	/**
	 * Returns the idx of the pokemon move that would do the most damage, give a target type and move types
	 * @param other
	 * @param typesMultiplier
	 * @param typesMap
	 * @return idx of the pokemon attack
	 */
	public int getMaxDamage(Pokemon other, double[][] typesMultiplier, HashMap<String, Integer> typesMap) {
		ArrayList<AttackMove> moves = partner.getAttackMoves();
		int maxDamage = Integer.MIN_VALUE;
		int idxOfAttackMove = -1;
		for(int i = 0; i < moves.size(); i++) {
			AttackMove move = moves.get(i);
			if(move.getPP() <= 0) continue; // don't bother calculating if PP is 0.
			int currentDamage = 0;
			int powerMultiplier = 1;
			String[] targetPokemonTypes = other.getTypes(); // at most, a pokemon can have 2 types
			
			// first calculate the multiplier derived by move attack type vs the target pokemon's types
			for(int j = 0; j < targetPokemonTypes.length; j++) {
				int attackRow = typesMap.get(move.getType());
				int defenseCol = typesMap.get(targetPokemonTypes[j]);
				powerMultiplier *= typesMultiplier[attackRow][defenseCol];
			}
			currentDamage = move.getAttackPower() * powerMultiplier;
			// if the currently calculated damage is greater then update it
			if(currentDamage > maxDamage) {
				idxOfAttackMove = i;
				maxDamage = currentDamage;
			}
		}
		return idxOfAttackMove;
	}

	@Override
	public void run() {}
}

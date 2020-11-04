package pokemon_battle;
import java.util.HashMap;

public class PokemonBattlerRunner {
	// Row = Attack, Col = Defense
	static final double[][] typesMultiplier = { 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.5, 0, 1 }, // normal
			{ 1, 0.5, 0.5, 1, 2, 2, 1, 1, 1, 1, 1, 2, 0.5, 1, 0.5 }, // fire
			{ 1, 2, 0.5, 1, 0.5, 1, 1, 1, 2, 1, 1, 1, 2, 1, 0.5 }, // water
			{ 1, 1, 2, 0.5, 0.5, 1, 1, 1, 0, 2, 1, 1, 1, 1, 0.5 }, // electric
			{ 1, 0.5, 2, 1, 0.5, 1, 1, 0.5, 2, 0.5, 1, 0.5, 2, 1, 0.5 }, // grass
			{ 1, 1, 0.5, 1, 2, 0.5, 1, 1, 2, 2, 1, 1, 1, 1, 2 }, // ice
			{ 2, 1, 1, 1, 1, 2, 1, 0.5, 1, 0.5, 0.5, 0.5, 2, 0, 1 }, // fighting
			{ 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5, 1, 1, 2, 0.5, 0.5, 1 }, // poison
			{ 1, 2, 1, 2, 0.5, 1, 1, 2, 1, 0, 1, 0.5, 2, 1, 1 }, // ground
			{ 1, 1, 1, 0.5, 2, 1, 2, 1, 1, 1, 1, 2, 0.5, 1, 1 }, // flying
			{ 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 0.5, 1, 1, 1, 1 }, // psychic
			{ 1, 0.5, 1, 1, 2, 1, 0.5, 2, 1, 0.5, 2, 1, 1, 0.5, 1 }, // bug
			{ 1, 2, 1, 1, 1, 2, 0.5, 1, 0.5, 2, 1, 2, 1, 1, 1 }, // rock
			{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 2, 1 }, // ghost
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 } // dragon
	};

	public static void main(String[] args) {
		HashMap<String, Integer> types = new HashMap<String, Integer>();
		initTypes(types);
		FullRestore item1 = new FullRestore();
		FullRestore item2 = new FullRestore();
		Pokemon c1 = new Charizard();
		Pokemon b1 = new Blastoise();
		// each player gets 1 full restore
		HumanPlayer readyPlayerOne = new HumanPlayer(c1, item1);
		ComputerPlayer computerPlayer = new ComputerPlayer(b1, item2); 
		
		// while either pokemon still have hitpoints, continue the battle
		while(readyPlayerOne.getPokemon().getCurrentHP() > 0 && computerPlayer.getPokemon().getCurrentHP() > 0) {
			int playerPokemonSpeed = readyPlayerOne.getPokemon().getSpeed();
			int computerPokemonSpeed = computerPlayer.getPokemon().getSpeed();
			System.out.println("Your " + readyPlayerOne.getPokemon().getName() + "'s hp: " + readyPlayerOne.getPokemon().getCurrentHP());
			System.out.println("Computer's " + computerPlayer.getPokemon().getName() + "'s hp: " + computerPlayer.getPokemon().getCurrentHP());
			// if player's pokemon is faster then player gets first move, else the computer gets first move
			if(playerPokemonSpeed > computerPokemonSpeed) {
				readyPlayerOne.run(computerPlayer.getPokemon(), typesMultiplier, types);
				// if computer pokemon fainted during the attack, they don't get to attack
				if(computerPlayer.getPokemon().getCurrentHP() <= 0) break; 
				computerPlayer.run(readyPlayerOne.getPokemon(), typesMultiplier, types);
			} else if(playerPokemonSpeed < computerPokemonSpeed) {
				computerPlayer.run(readyPlayerOne.getPokemon(), typesMultiplier, types);
				if(readyPlayerOne.getPokemon().getCurrentHP() <= 0) break;
				readyPlayerOne.run(computerPlayer.getPokemon(), typesMultiplier, types);
			} else {
				// TODO: handle the speed equal case
				break;
			}
		}
		if(readyPlayerOne.getPokemon().getCurrentHP() > 0) {
			System.out.println("YOU WIN");
		} else {
			System.out.println("YOU LOSE");
		}
	}

	/**
	 * Initializes our types to an index value that matches the types multiplier
	 * @param types
	 */
	private static void initTypes(HashMap<String, Integer> types) {
		types.put("normal", 0);
		types.put("fire", 1);
		types.put("water", 2);
		types.put("electric", 3);
		types.put("grass", 4);
		types.put("ice", 5);
		types.put("fighting", 6);
		types.put("poison", 7);
		types.put("ground", 8);
		types.put("flying", 9);
		types.put("psychic", 10);
		types.put("bug", 11);
		types.put("rock", 12);
		types.put("ghost", 13);
		types.put("dragon", 14);
	}
}

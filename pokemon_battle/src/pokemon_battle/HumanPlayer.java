package pokemon_battle;
import java.util.HashMap;
import java.util.Scanner;

public class HumanPlayer extends Player {
	private Scanner input = new Scanner(System.in);
	private int action;
	
	public HumanPlayer(Pokemon partner, Item item) {
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
	
	@Override
	public void run() {}

	public void run(Pokemon other, double[][] typesMultiplier, HashMap<String, Integer> typesMap) {
		boolean openMenu = true;
		System.out.print("0) Fight\n1) Use Item");
		do {
			try {
				getInput();
				
				if(action == 1 && item == null) { 
					System.out.println("Item used already");
				} else if(action == 1 && item != null){
					item.use(partner);
					openMenu = false;
				} else {
					openMenu = false;
				} 
			} catch(PokemonBattleException err) {
				System.out.println("Invalid input");
			}
		} while(openMenu);
		
		if(action != 0) return; // if player used item then their turn is done
		partner.printAttackMoves();
		boolean attacked = false;
		do {
			try {
				getInput();
				partner.attack(other, action, typesMultiplier, typesMap);
				attacked = true;
			} catch(PokemonBattleException err) {
				System.out.println("Invalid input");
			} 
		} while(!attacked);
	}
	
	/**
	 * Prints the options available to the player
	 */
	private void getInput() throws PokemonBattleException {
		action = input.nextInt();
		if(action < 0 || action > 1) {
			throw new PokemonBattleException(action + " is not a valid selection");
		}
	}
}

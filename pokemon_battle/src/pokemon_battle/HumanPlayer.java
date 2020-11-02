package pokemon_battle;

public class HumanPlayer extends Player {
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
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

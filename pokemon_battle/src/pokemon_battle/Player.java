package pokemon_battle;

public abstract class Player {
	protected Pokemon partner;
	protected Item item;
	
	public Player(Pokemon partner, Item item) {
		this.partner = partner;
		this.item = item;
	}
	
	public abstract Pokemon getPokemon();
	public abstract Item getItem();
	public abstract void run();
	
	/**
	 * Used to remove the item from the player once it is used
	 */
	public void useItem() {
		this.item = null;
	}
}

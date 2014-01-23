package spaceinvaders;

public class ShipEntity extends Entity {
	private SpaceInvaders game;
	
	public ShipEntity(SpaceInvaders game,String ref,int x,int y) {
		super(ref,x,y);
		
		this.game = game;
	}
	
	public void move(long delta) {
		if ((dx < 0) && (x < 10)) {
			return;
		}
		if ((dx > 0) && (x > 750)) {
			return;
		}
		
		super.move(delta);
	}
	
	public void collidedWith(Entity other) {
		if (other instanceof EnemyEntity || other instanceof AlienShotEntity) {
			game.notifyDeath();
		}
	}
}
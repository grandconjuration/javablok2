package spaceinvaders;

public class AlienShotEntity extends ShotEntity {

    private double moveSpeed = 300;
    private SpaceInvaders game;

    public AlienShotEntity(SpaceInvaders game, String sprite, int x, int y) {
        super(game, sprite, x, y);

    }

    public void move(long delta) {
        y -= (delta * dy) / 1000;
        if (y > 700) {
            System.out.println(y);
            game.removeEntity(this);
        }
    }

    public void collidedWith(Entity other) {

        if (other instanceof ShipEntity) {

            game.notifyDeath();
        }
    }
}

package spaceinvaders;

public class AlienShotEntity extends Entity {

    private double moveSpeed = 300;
    private SpaceInvaders game;

    public AlienShotEntity(SpaceInvaders game, String sprite, int x, int y) {
        super(sprite, x, y);

        this.game = game;

        dy = moveSpeed;
    }

    public void move(long delta) {
        super.move(delta);

        if (y < 700) {
            game.removeEntity(this);
        }
    }

    public void collidedWith(Entity other) {
    }

}

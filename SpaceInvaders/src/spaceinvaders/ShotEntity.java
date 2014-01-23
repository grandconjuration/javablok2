package spaceinvaders;

public class ShotEntity extends Entity {

    private double moveSpeed = -300;
    private SpaceInvaders game;
    private boolean used = false;

    public ShotEntity(SpaceInvaders game, String sprite, int x, int y) {
        super(sprite, x, y);

        this.game = game;

        dy = moveSpeed;
    }

    public void move(long delta) {
        super.move(delta);

        if (y < -100) {
            game.removeEntity(this);
        }
    }

    public void collidedWith(Entity other) {
        if (used) {
            return;
        }

        if (other instanceof EnemyEntity) {

            game.removeEntity(this);
            game.removeEntity(other);

            game.notifyEnemyKilled();
            used = true;
        }
    }
}

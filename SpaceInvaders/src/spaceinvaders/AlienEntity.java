package spaceinvaders;

public class AlienEntity extends EnemyEntity {

    private double moveSpeed = 75;
    private SpaceInvaders game;

    public AlienEntity(SpaceInvaders game, String ref, int x, int y, int row, int column) {
        super(game, ref, x, y, row, column);
/*
        this.game = game;
        dx = -moveSpeed;*/
    }
/*
    public void move(long delta) {
        if ((dx < 0) && (x < 10)) {
            game.updateLogic();
        }
        if ((dx > 0) && (x > 750)) {
            game.updateLogic();
        }

        super.move(delta);
    }

    public void doLogic() {
        dx = -dx;
        y += 10;

        if (y > 570) {
            game.notifyDeath();
        }
    }

    public void collidedWith(Entity other) {
    }*/
}

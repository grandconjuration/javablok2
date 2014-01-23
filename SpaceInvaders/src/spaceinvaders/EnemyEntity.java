package spaceinvaders;

public class EnemyEntity extends Entity {

    private double moveSpeed = 75;
    private SpaceInvaders game;
    private int row;
    private int column;

    public EnemyEntity(SpaceInvaders game, String ref, int x, int y, int row, int column) {
        super(ref, x, y);

        this.game = game;
        dx = -moveSpeed;
        this.row = row;
        this.column = column;
    }

    public void move(long delta) {
        if ((dx < 0) && (x < 10)) {
            game.updateLogic();
        }
        if ((dx > 0) && (x > 750)) {
            game.updateLogic();
        }

        super.move(delta);
    }
    
    public int getColumn() {
        return column;
    }

    public void doLogic() {
        dx = -dx;
        y += 10;

        if (y > 570) {
            game.notifyDeath();
        }
    }

    public void collidedWith(Entity other) {
    }
}

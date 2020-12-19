package obstacles;

import creations.Jumpable;

public class Wall {
    int height;

    public Wall(int height) {
        this.height = height;
    }
    public boolean obstaclePass(Jumpable obj) {
        obj.jump();
        return obj.isJumpingOver(height);
    }
}

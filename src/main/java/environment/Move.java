package environment;

import rover.Position;

public class Move {

    private final Position position;
    private final boolean obstacle;

    public Move(Position position, boolean obstacle) {
        this.position = position;
        this.obstacle = obstacle;
    }

    public Position position() {
        return position;
    }

    public boolean obstacle() {
        return obstacle;
    }
}

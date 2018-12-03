package environment;

import rover.Direction;
import rover.Position;

public class Environment {

    private final int width;
    private final int height;

    public Environment(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Position move(Position start, Direction direction) {
        return accept(start.translate(direction));
    }

    private Position accept(Position p) {
        return new Position(acceptX(p.x()), acceptY(p.y()));
    }

    private int acceptX(int x) {
        return x > width ? 0 : x < 0 ? width : x;
    }

    private int acceptY(int y) {
        return y > height ? 0 : y < 0 ? height : y;
    }
}

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

    public Position move(Position start, Direction direction){
        return new Position(acceptX(start.x() + direction.translationX()), acceptY(start.y() + direction.translationY()));
    }

    private int acceptX(int x) {
        return x > width ? 0 : x < 0 ? width : x;
    }

    private int acceptY(int y) {
        return y > height ? 0 : y < 0 ? height : y;
    }
}

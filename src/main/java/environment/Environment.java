package environment;

import rover.Direction;
import rover.Position;
import utils.Either;

import java.util.ArrayList;
import java.util.List;

public class Environment {

    private final int width;
    private final int height;
    private final List<Position> obstacles;

    public Environment(int width, int height) {
        this.width = width;
        this.height = height;
        obstacles = new ArrayList<>();
    }

    private Environment(int width, int height, List<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public Either<Position, Position> move(Position start, Direction direction) {
        final Position translate = accept(start.translate(direction));
        final Position obstacle = obstacles.contains(translate) ? translate : null;
        return Either.<Position, Position> either(translate).or(obstacle);
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

    public Environment addObstacleOn(Position position) {
        List<Position> obstacles = this.obstacles;
        obstacles.add(position);
        return new Environment(width, height, obstacles);
    }
}

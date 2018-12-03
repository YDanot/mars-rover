package environment;

import rover.Direction;
import rover.Position;
import utils.Either;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Environment {

    private final int width;
    private final int height;
    private final List<Obstacle> obstacles;

    public Environment(int width, int height) {
        this.width = width;
        this.height = height;
        obstacles = new ArrayList<>();
    }

    private Environment(int width, int height, List<Obstacle> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public Either<Position, Obstacle> move(Position start, Direction direction) {
        final Position translate = accept(start.translate(direction));
        final Optional<Obstacle> obstacle = obstacles.stream().filter(o -> o.position().equals(translate)).findFirst();

        return Either.<Position, Obstacle>either(translate).or(obstacle.orElse(null));
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
        List<Obstacle> obstacles = this.obstacles;
        obstacles.add(Obstacle.at(position));
        return new Environment(width, height, obstacles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Environment)) return false;
        Environment that = (Environment) o;
        return width == that.width &&
                height == that.height &&
                Objects.equals(obstacles, that.obstacles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, obstacles);
    }
}

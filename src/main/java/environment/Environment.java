package environment;

import rover.Direction;
import rover.Position;

import java.util.Objects;

public class Environment {

    private final Map environment;
    private final Obstacles obstacles;

    public Environment(int width, int height) {
        environment = new Map(width, height);
        obstacles = new Obstacles();
    }

    private Environment(Map environment, Obstacles obstacles) {
        this.obstacles = obstacles;
        this.environment = environment;
    }

    public Move move(Position start, Direction direction) {
        final Position translate = environment.accept(start.translate(direction));

        if (obstacles.at(translate)) {
            return new Move(start, true);
        }
        return new Move(translate, false);

    }

    public Environment addObstacleOn(Position position) {
        return new Environment(environment, obstacles.putObstacleOn(position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Environment)) return false;
        Environment that = (Environment) o;
        return Objects.equals(environment, that.environment) &&
                Objects.equals(obstacles, that.obstacles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obstacles, environment);
    }
}

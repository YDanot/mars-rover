package environment;

import rover.Direction;
import rover.Position;

import java.util.Objects;

public class Planet {

    private final Environment environment;
    private final Obstacles obstacles;

    public Planet(int width, int height) {
        environment = new Environment(width, height);
        obstacles = new Obstacles();
    }

    private Planet(Environment environment, Obstacles obstacles) {
        this.obstacles = obstacles;
        this.environment = environment;
    }

    public Move move(Position start, Direction direction) {
        final Position translate = environment.accept(start.toward(direction));

        if (obstacles.at(translate)) {
            return new Move(start, true);
        }
        return new Move(translate, false);

    }

    public Planet putObstacleAt(Position position) {
        return new Planet(environment, obstacles.putObstacleAt(position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet)) return false;
        Planet that = (Planet) o;
        return Objects.equals(environment, that.environment) &&
                Objects.equals(obstacles, that.obstacles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obstacles, environment);
    }
}

package environment;

import rover.Position;

import java.util.Objects;

public class Obstacle {

    private final Position position;

    private Obstacle(Position position) {
        this.position = position;
    }

    public static Obstacle at(Position position) {
        return new Obstacle(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obstacle)) return false;
        Obstacle obstacle = (Obstacle) o;
        return Objects.equals(position, obstacle.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public Position position() {
        return position;
    }
}

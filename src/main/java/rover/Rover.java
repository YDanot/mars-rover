package rover;

import environment.Environment;

import java.util.Objects;

public class Rover {

    private final Position position;
    private final Direction facingDirection;
    private final Environment environment;

    public Rover(Position position, Direction facingDirection, Environment environment) {
        this.position = position;
        this.facingDirection = facingDirection;
        this.environment = environment;
    }

    public Position position() {
        return position;
    }

    public Direction facingDirection() {
        return facingDirection;
    }

    public Environment environment() {
        return environment;
    }

    public Rover moveForward() {
        if (facingDirection().equals(Direction.WEST)) {
            return new Rover(translationOf(-1, 0), facingDirection(), environment);
        }
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(translationOf(1, 0), facingDirection(), environment);
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(translationOf(0, -1), facingDirection(), environment);
        }
        return new Rover(translationOf(0, 1), facingDirection(), environment);
    }

    public Rover moveBackward() {
        if (facingDirection().equals(Direction.WEST)) {
            return new Rover(translationOf(1, 0), facingDirection(), environment);
        }
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(translationOf(-1, 0), facingDirection(), environment);
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(translationOf(0, 1), facingDirection(), environment);
        }
        return new Rover(translationOf(0, -1), facingDirection(), environment);
    }

    public Rover turnLeft() {
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(position(), Direction.NORTH, environment);
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(position(), Direction.EAST, environment);
        }
        if (facingDirection().equals(Direction.WEST)) {
            return new Rover(position(), Direction.SOUTH, environment);
        }
        return new Rover(position(), Direction.WEST, environment);
    }

    public Rover turnRight() {
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(position(), Direction.SOUTH, environment);
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(position(), Direction.WEST, environment);
        }
        if (facingDirection().equals(Direction.WEST)) {
            return new Rover(position(), Direction.NORTH, environment);
        }
        return new Rover(position(), Direction.EAST, environment);
    }

    private Position translationOf(int x, int y) {
        return position().translationOf(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rover)) return false;
        Rover rover = (Rover) o;
        return Objects.equals(position, rover.position) &&
                facingDirection == rover.facingDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, facingDirection);
    }
}

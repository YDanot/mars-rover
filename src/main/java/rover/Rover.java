package rover;

import environment.Environment;

import java.util.Objects;

public class Rover {

    private final Position position;
    private final Direction facingDirection;

    public Rover(Position position, Direction facingDirection) {
        this.position = position;
        this.facingDirection = facingDirection;
    }

    public Position position() {
        return position;
    }

    public Direction facingDirection() {
        return facingDirection;
    }

    public Rover moveForward(Environment environment) {
        return new Rover(facingDirection().translation().apply(position(), environment), facingDirection());
    }

    public Rover moveBackward(Environment environment) {
        return new Rover(facingDirection().opposite().translation().apply(position(), environment), facingDirection());
    }

    public Rover turnLeft() {
        return new Rover(position(), facingDirection().left());
    }

    public Rover turnRight() {
        return new Rover(position(), facingDirection().opposite().left());
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

package rover;

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

    public Rover moveForward() {
        if (facingDirection().equals(Direction.WEST)) {
            return new Rover(position().translationOf(-1, 0), facingDirection());
        }
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(position().translationOf(1, 0), facingDirection());
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(position().translationOf(0, -1), facingDirection());
        }
        return new Rover(position().translationOf(0, 1), facingDirection());
    }

    public Rover moveBackward() {
        if (facingDirection().equals(Direction.WEST)) {
            return new Rover(position().translationOf(1, 0), facingDirection());
        }
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(position().translationOf(-1, 0), facingDirection());
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(position().translationOf(0, 1), facingDirection());
        }
        return new Rover(position().translationOf(0, -1), facingDirection());
    }

    public Rover turnLeft() {
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(position(), Direction.NORTH);
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(position(), Direction.EAST);
        }
        if (facingDirection().equals(Direction.WEST)) {
            return new Rover(position(), Direction.SOUTH);
        }
        return new Rover(position(), Direction.WEST);
    }

    public Rover turnRight() {
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(position(), Direction.SOUTH);
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(position(), Direction.WEST);
        }
        if (facingDirection().equals(Direction.WEST)) {
            return new Rover(position(), Direction.NORTH);
        }
        return new Rover(position(), Direction.EAST);
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

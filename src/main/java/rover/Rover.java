package rover;

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
            return new Rover(new Position(position().x() - 1, position().y()), facingDirection());
        }
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(new Position(position().x() + 1, position().y()), facingDirection());
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(new Position(position().x(), position().y() - 1), facingDirection());
        }
        return new Rover(new Position(position().x(), position().y() + 1), facingDirection());
    }

    public Rover moveBackward() {
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(new Position(position().x() - 1, position().y()), facingDirection());
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(new Position(position().x(), position().y() + 1), facingDirection());
        }
        return new Rover(new Position(position().x(), position().y() - 1), facingDirection());
    }
}

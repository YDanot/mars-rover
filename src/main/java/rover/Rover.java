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
        if (facingDirection.equals(Direction.SOUTH)){
            return new Rover(new Position(position.x(), position.y() - 1), facingDirection);
        }
        return new Rover(new Position(position.x(), position.y() + 1), facingDirection);
    }
}

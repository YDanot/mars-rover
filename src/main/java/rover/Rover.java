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
            return new Rover(position().translationOf(-1,0), facingDirection());
        }
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(position().translationOf(1,0), facingDirection());
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(position().translationOf(0,-1), facingDirection());
        }
        return new Rover(position().translationOf(0,1), facingDirection());
    }

    public Rover moveBackward() {
        if (facingDirection().equals(Direction.WEST)) {
            return new Rover(position().translationOf(1,0), facingDirection());
        }
        if (facingDirection().equals(Direction.EAST)) {
            return new Rover(position().translationOf(-1,0), facingDirection());
        }
        if (facingDirection().equals(Direction.SOUTH)) {
            return new Rover(position().translationOf(0,1), facingDirection());
        }
        return new Rover(position().translationOf(0,-1), facingDirection());
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
        return this;
    }
}

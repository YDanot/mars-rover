package rover;

import environment.Environment;
import environment.Move;

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

    public Moved moveForward(Environment environment) {
        return move(facingDirection(), environment);
    }

    private Moved move(Direction direction, Environment environment) {
        final Move move = environment.move(position, direction);

        return new Moved(new Rover(move.position(), facingDirection()), move.obstacle());

    }

    public Moved moveBackward(Environment environment) {
        return move(facingDirection().opposite(), environment);
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

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", facingDirection=" + facingDirection +
                '}';
    }
}

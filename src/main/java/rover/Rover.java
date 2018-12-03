package rover;

import environment.Environment;
import utils.Either;

import java.util.Objects;

public class Rover {

    private final Position position;
    private final Direction facingDirection;

    private final Position reportedObstacle;

    public Rover(Position position, Direction facingDirection) {
        this.position = position;
        this.facingDirection = facingDirection;
        this.reportedObstacle = null;
    }

    private Rover(Position position, Direction facingDirection, Position reportedObstacle) {
        this.position = position;
        this.facingDirection = facingDirection;
        this.reportedObstacle = reportedObstacle;
    }

    public Position position() {
        return position;
    }

    public Direction facingDirection() {
        return facingDirection;
    }

    public Either<Rover, Position> moveForward(Environment environment) {
        return move(facingDirection(), environment);
    }

    private Either<Rover, Position> move(Direction direction, Environment environment) {
        final Either<Position, Position> move = environment.move(position, direction);

        final Rover moved = new Rover(move.option1(), facingDirection());
        Position obstacle = null;
        if (move.isOption2()) {
            obstacle = move.option2();
        }
        return Either.<Rover, Position>either(moved).or(obstacle);
    }

    public Either<Rover, Position> moveBackward(Environment environment) {
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
}

package rover;

import environment.Environment;
import environment.Obstacle;
import utils.Either;

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

    public Either<Rover, Obstacle> moveForward(Environment environment) {
        return move(facingDirection(), environment);
    }

    private Either<Rover, Obstacle> move(Direction direction, Environment environment) {
        final Either<Position, Obstacle> move = environment.move(position, direction);

        final Rover moved = new Rover(move.option1(), facingDirection());
        Obstacle obstacle = null;
        if (move.isOption2()) {
            obstacle = move.option2();
        }
        return Either.<Rover, Obstacle>either(moved).or(obstacle);
    }

    public Either<Rover, Obstacle> moveBackward(Environment environment) {
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

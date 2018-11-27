import command.Execute;
import org.assertj.core.api.Assertions;
import rover.Direction;
import rover.Position;
import rover.Rover;

public class GlueRover {

    private Position position;
    private String direction;

    private Rover rover;

    public GlueRover located_at(int x, int y) {
        this.position = new Position(x, y);
        this.rover = new Rover(position, toDirection(direction));
        return this;
    }

    public GlueRover facing(String direction) {
        this.direction = direction;
        this.rover = new Rover(position, toDirection(direction));
        return this;
    }

    public GlueRover moveForward() {
        this.rover = rover.moveForward();
        return this;
    }

    private Direction toDirection(String direction) {
        if ("W".equals(direction)) {
            return Direction.WEST;
        }
        if ("E".equals(direction)) {
            return Direction.EAST;
        }
        if ("S".equals(direction)) {
            return Direction.SOUTH;
        }

        return Direction.NORTH;
    }

    public GlueRover should_be_located_at(int x, int y) {
        Assertions.assertThat(rover.position()).isEqualTo(new Position(x, y));
        return this;
    }

    public GlueRover moveBackward() {
        this.rover = rover.moveBackward();
        return this;
    }

    public GlueRover and() {
        return this;
    }

    public GlueRover should_face(String direction) {
        Assertions.assertThat(rover.facingDirection()).isEqualTo(toDirection(direction));
        return this;
    }

    public GlueRover turnLeft() {
        this.rover = rover.turnLeft();
        return this;
    }

    public GlueRover turnRight() {
        this.rover = rover.turnRight();
        return this;
    }

    public Rover get() {
        return rover;
    }

    public Rover execute(String commands) {
        return new Execute().execute(rover, commands);
    }
}

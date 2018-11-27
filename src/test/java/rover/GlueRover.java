package rover;

import command.Execute;
import environment.Environment;
import org.assertj.core.api.Assertions;

import java.util.Objects;

public class GlueRover {

    private final Rover rover;

    public GlueRover() {
        this.rover = new Rover(new Position(1, 1), Direction.NORTH, new Environment(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    private GlueRover(Rover rover) {
        this.rover = rover;
    }

    public GlueRover located_at(int x, int y) {
        return new GlueRover(new Rover(new Position(x, y), rover.facingDirection(), rover.environment()));
    }

    public GlueRover facing(String direction) {
        return new GlueRover(new Rover(rover.position(), toDirection(direction), rover.environment()));
    }

    public GlueRover forward() {
        return new GlueRover(rover.moveForward());
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

    public GlueRover backward() {
        return new GlueRover(rover.moveBackward());
    }

    public GlueRover and() {
        return this;
    }

    public GlueRover should_face(String direction) {
        Assertions.assertThat(rover.facingDirection()).isEqualTo(toDirection(direction));
        return this;
    }

    public GlueRover left() {
        return new GlueRover(rover.turnLeft());
    }

    public GlueRover right() {
        return new GlueRover(rover.turnRight());
    }

    public Rover get() {
        return rover;
    }

    public GlueRover execute(String commands) {
        return new GlueRover(new Execute().execute(rover, commands));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GlueRover)) return false;
        GlueRover glueRover = (GlueRover) o;
        return Objects.equals(rover, glueRover.rover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rover);
    }

    public GlueRover on_an_environment_of(int width, int height) {
        return new GlueRover(new Rover(rover.position(), rover.facingDirection(), new Environment(width, height)));
    }
}

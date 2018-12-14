package rover;

import command.Commands;
import environment.Planet;
import org.assertj.core.api.Assertions;

import java.util.Objects;

public class GlueRover {

    private final Rover rover;
    private final Planet environment;
    private final boolean obstacle;

    private GlueRover() {
        this.rover = new Rover(new Position(1, 1), Direction.NORTH);
        this.environment = new Planet(5, 5);
        obstacle = false;
    }

    private GlueRover(Rover rover, Planet environment) {
        this.rover = rover;
        this.environment = environment;
        obstacle = false;
    }

    private GlueRover(Rover rover, Planet environment, boolean obstacle) {
        this.rover = rover;
        this.environment = environment;
        this.obstacle = obstacle;
    }

    public GlueRover located_at(int x, int y) {
        return new GlueRover(new Rover(new Position(x, y), rover.facingDirection()), environment);
    }

    public GlueRover facing(String direction) {
        return new GlueRover(new Rover(rover.position(), toDirection(direction)), environment);
    }

    public GlueRover forward() {

        final MovedRover moved = rover.moveForward(environment);

        return new GlueRover(moved.rover(), environment, moved.obstacle());
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
        final MovedRover moved = rover.moveBackward(environment);
        return new GlueRover(moved.rover(), environment, moved.obstacle());
    }

    public GlueRover and() {
        return this;
    }

    public GlueRover should_face(String direction) {

        Assertions.assertThat(rover.facingDirection()).isEqualTo(toDirection(direction));
        return this;
    }

    public GlueRover left() {
        return new GlueRover(rover.turnLeft(), environment);
    }

    public GlueRover right() {
        return new GlueRover(rover.turnRight(), environment);
    }

    public GlueRover execute(String commands) {
        final MovedRover moved = new Commands(commands, environment).executeOn(rover);
        return new GlueRover(moved.rover(), environment, moved.obstacle());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GlueRover)) return false;
        GlueRover glueRover = (GlueRover) o;
        return obstacle == glueRover.obstacle &&
                Objects.equals(rover, glueRover.rover) &&
                Objects.equals(environment, glueRover.environment);
    }

    @Override
    public String toString() {
        return "GlueRover{" +
                "rover=" + rover +
                ", environment=" + environment +
                ", obstacle=" + obstacle +
                '}';
    }

    public GlueRover on_an_environment_of(int width, int height) {
        return new GlueRover(new Rover(rover.position(), rover.facingDirection()), new Planet(width, height));
    }

    public GlueRover with_obstacle_on(int x, int y) {
        return new GlueRover(rover, environment.putObstacleAt(new Position(x, y)));
    }

    public GlueRover should_report_obstacle() {
        Assertions.assertThat(obstacle).isTrue();
        return this;
    }

    public static GlueRover a_rover() {
        return new GlueRover();
    }
}

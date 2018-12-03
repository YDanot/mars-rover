package rover;

import command.Commands;
import environment.Environment;
import environment.Obstacle;
import org.assertj.core.api.Assertions;
import utils.Either;

import java.util.Objects;

public class GlueRover {

    private final Rover rover;
    private final Environment environment;
    private final Obstacle obstacle;

    public GlueRover() {
        this.rover = new Rover(new Position(1, 1), Direction.NORTH);
        this.environment = new Environment(5, 5);
        obstacle = null;
    }

    private GlueRover(Rover rover, Environment environment) {
        this.rover = rover;
        this.environment = environment;
        obstacle = null;
    }

    private GlueRover(Rover rover, Environment environment, Obstacle obstacle) {
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
        final Either<Rover, Obstacle> roverPositionEither = rover.moveForward(environment);
        if (roverPositionEither.isOption1()) {
            return new GlueRover(roverPositionEither.option1(), environment);
        }
        return new GlueRover(rover, environment, roverPositionEither.option2());
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
        final Either<Rover, Obstacle> roverPositionEither = rover.moveBackward(environment);
        if (roverPositionEither.isOption1()) {
            return new GlueRover(roverPositionEither.option1(), environment);
        }
        return new GlueRover(rover, environment, roverPositionEither.option2());
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
        final Either<Rover, Obstacle> roverPositionEither = new Commands(commands).execute(rover, environment);
        if (roverPositionEither.isOption1()) {
            return new GlueRover(roverPositionEither.option1(), environment);
        }
        return new GlueRover(rover, environment, roverPositionEither.option2());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GlueRover)) return false;
        GlueRover glueRover = (GlueRover) o;
        return Objects.equals(rover, glueRover.rover) &&
                Objects.equals(environment, glueRover.environment) &&
                Objects.equals(obstacle, glueRover.obstacle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rover, environment, obstacle);
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
        return new GlueRover(new Rover(rover.position(), rover.facingDirection()), new Environment(width, height));
    }

    public GlueRover with_obstacle_on(int x, int y) {
        return new GlueRover(rover, environment.addObstacleOn(new Position(x, y)));
    }

    public GlueRover should_report_obstacle_in(int x, int y) {
        Assertions.assertThat(obstacle).isEqualTo(Obstacle.at(new Position(x, y)));
        return this;
    }

    public Rover get() {
        return rover;
    }
}

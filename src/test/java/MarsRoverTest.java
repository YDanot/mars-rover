import org.assertj.core.api.Assertions;
import org.junit.Test;
import rover.Direction;
import rover.Position;
import rover.Rover;

public class MarsRoverTest {

    @Test
    public void facing_north_move_forward() {
        a_rover().located_at(0, 0).facing("N").moveForward().should_be_located_at(0, 1);
        a_rover().located_at(0, 1).facing("N").moveForward().should_be_located_at(0, 2);
    }

    @Test
    public void facing_south_move_forward() {
        a_rover().located_at(0, 0).facing("S").moveForward().should_be_located_at(0, -1);
        a_rover().located_at(0, -1).facing("S").moveForward().should_be_located_at(0, -2);
    }

    @Test
    public void facing_east_move_forward() {
        a_rover().located_at(0, 0).facing("E").moveForward().should_be_located_at(1, 0);
        a_rover().located_at(1, 0).facing("E").moveForward().should_be_located_at(2, 0);
    }

    @Test
    public void facing_west_move_forward() {
        a_rover().located_at(0, 0).facing("W").moveForward().should_be_located_at(-1, 0);
        a_rover().located_at(-1, 0).facing("W").moveForward().should_be_located_at(-2, 0);
    }

    @Test
    public void facing_north_move_backward() {
        a_rover().located_at(0, 0).facing("N").moveBackward().should_be_located_at(0, -1);
        a_rover().located_at(0, -1).facing("N").moveBackward().should_be_located_at(0, -2);
    }

    @Test
    public void facing_south_move_backward() {
        a_rover().located_at(0, 0).facing("S").moveBackward().should_be_located_at(0, 1);
    }

    @Test
    public void facing_east_move_backward() {
        a_rover().located_at(0, 0).facing("E").moveBackward().should_be_located_at(-1, 0);
    }

    @Test
    public void facing_west_move_backward() {
        a_rover().located_at(0, 0).facing("W").moveBackward().should_be_located_at(1, 0);
    }

    private GlueRover a_rover() {
        return new GlueRover();
    }

    private class GlueRover {

        private Position position;
        private String direction;

        private Rover rover;

        public GlueRover located_at(int x, int y) {
            this.position = new Position(x, y);
            return this;
        }

        public GlueRover facing(String direction) {
            this.direction = direction;
            return this;
        }

        public GlueRover moveForward() {
            final Rover rover = new Rover(position, toDirection(direction));
            this.rover = rover.moveForward();
            return this;
        }

        private Direction toDirection(String direction) {
            if (direction.equals("W")) {
                return Direction.WEST;
            }
            if (direction.equals("E")) {
                return Direction.EAST;
            }
            if (direction.equals("S")) {
                return Direction.SOUTH;
            }

            return Direction.NORTH;
        }

        public void should_be_located_at(int x, int y) {
            Assertions.assertThat(rover.position()).isEqualTo(new Position(x, y));
        }

        public GlueRover moveBackward() {
            final Rover rover = new Rover(position, toDirection(direction));
            this.rover = rover.moveBackward();
            return this;
        }
    }
}

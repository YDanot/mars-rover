import org.assertj.core.api.Assertions;
import org.junit.Test;
import rover.Direction;
import rover.Position;
import rover.Rover;

public class MarsRoverTest {

    @Test
    public void facing_north_move_forward() {
        a_rover().located_at(0, 0).facing("N").moveForward().should_be_located_at(0, 1).and().should_face("N");
        a_rover().located_at(0, 1).facing("N").moveForward().should_be_located_at(0, 2).and().should_face("N");
    }

    @Test
    public void facing_south_move_forward() {
        a_rover().located_at(0, 0).facing("S").moveForward().should_be_located_at(0, -1) .and().should_face("S");
        a_rover().located_at(0, -1).facing("S").moveForward().should_be_located_at(0, -2).and().should_face("S");
    }

    @Test
    public void facing_east_move_forward() {
        a_rover().located_at(0, 0).facing("E").moveForward().should_be_located_at(1, 0).and().should_face("E");
        a_rover().located_at(1, 0).facing("E").moveForward().should_be_located_at(2, 0).and().should_face("E");
    }

    @Test
    public void facing_west_move_forward() {
        a_rover().located_at(0, 0).facing("W").moveForward().should_be_located_at(-1, 0) .and().should_face("W");
        a_rover().located_at(-1, 0).facing("W").moveForward().should_be_located_at(-2, 0).and().should_face("W");
    }

    @Test
    public void facing_north_move_backward() {
        a_rover().located_at(0, 0).facing("N").moveBackward().should_be_located_at(0, -1).and().should_face("N");
        a_rover().located_at(0, -1).facing("N").moveBackward().should_be_located_at(0, -2).and().should_face("N");
    }

    @Test
    public void facing_south_move_backward() {
        a_rover().located_at(0, 0).facing("S").moveBackward().should_be_located_at(0, 1).and().should_face("S");
    }

    @Test
    public void facing_east_move_backward() {
        a_rover().located_at(0, 0).facing("E").moveBackward().should_be_located_at(-1, 0).and().should_face("E");;
    }

    @Test
    public void facing_west_move_backward() {
        a_rover().located_at(0, 0).facing("W").moveBackward().should_be_located_at(1, 0).and().should_face("W");
    }

    @Test
    public void facing_north_turn_left() {
        a_rover().located_at(0, 0).facing("N").turnLeft().should_be_located_at(0, 0).and().should_face("W");
    }

    @Test
    public void facing_west_turn_left() {
        a_rover().located_at(0, 0).facing("W").turnLeft().should_be_located_at(0, 0).and().should_face("S");
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

        public GlueRover should_be_located_at(int x, int y) {
            Assertions.assertThat(rover.position()).isEqualTo(new Position(x, y));
            return this;
        }

        public GlueRover moveBackward() {
            final Rover rover = new Rover(position, toDirection(direction));
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
            final Rover rover = new Rover(position, toDirection(direction));
            this.rover = rover.turnLeft();
            return this;
        }
    }
}

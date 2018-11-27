import org.assertj.core.api.Assertions;
import org.junit.Test;
import rover.Direction;
import rover.Position;
import rover.Rover;

public class MarsRoverTest {

    @Test
    public void first_forward_north_move() {
        a_rover().located_at(0, 0).facing("N").moveForward().should_be_located_at(0, 1);
    }

    @Test
    public void second_forward_north_move() {
        a_rover().located_at(0, 1).facing("N").moveForward().should_be_located_at(0, 2);
    }

    @Test
    public void first_forward_south_move() {
        a_rover().located_at(0, 0).facing("S").moveForward().should_be_located_at(0, -1);
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
            if (direction.equals("S")) {
                return Direction.SOUTH;
            }

            return Direction.NORTH;
        }

        public void should_be_located_at(int x, int y) {
            Assertions.assertThat(rover.position()).isEqualTo(new Position(x, y));
        }
    }
}

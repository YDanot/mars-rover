import org.junit.Test;

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

    @Test
    public void facing_south_turn_left() {
        a_rover().located_at(0, 0).facing("S").turnLeft().should_be_located_at(0, 0).and().should_face("E");
    }

    @Test
    public void facing_east_turn_left() {
        a_rover().located_at(0, 0).facing("E").turnLeft().should_be_located_at(0, 0).and().should_face("N");
    }

    @Test
    public void facing_north_turn_right() {
        a_rover().located_at(0, 0).facing("N").turnRight().should_be_located_at(0, 0).and().should_face("E");
    }

    @Test
    public void facing_east_turn_right() {
        a_rover().located_at(0, 0).facing("E").turnRight().should_be_located_at(0, 0).and().should_face("S");
    }

    @Test
    public void facing_south_turn_right() {
        a_rover().located_at(0, 0).facing("S").turnRight().should_be_located_at(0, 0).and().should_face("W");
    }

    @Test
    public void facing_west_turn_right() {
        a_rover().located_at(0, 0).facing("W").turnRight().should_be_located_at(0, 0).and().should_face("N");
    }

    private GlueRover a_rover() {
        return new GlueRover();
    }

}

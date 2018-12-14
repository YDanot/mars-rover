package rover;

import org.junit.Test;

import static rover.GlueRover.a_rover;

public class MarsRoverTest {

    @Test
    public void facing_north_move_forward() {
        a_rover().located_at(0, 0).facing("N").forward().should_be_located_at(0, 1).and().should_face("N");
        a_rover().located_at(0, 1).facing("N").forward().should_be_located_at(0, 2).and().should_face("N");
    }

    @Test
    public void facing_south_move_forward() {
        a_rover().located_at(0, 2).facing("S").forward().should_be_located_at(0, 1) .and().should_face("S");
        a_rover().located_at(0, 1).facing("S").forward().should_be_located_at(0, 0).and().should_face("S");
    }

    @Test
    public void facing_east_move_forward() {
        a_rover().located_at(0, 0).facing("E").forward().should_be_located_at(1, 0).and().should_face("E");
        a_rover().located_at(1, 0).facing("E").forward().should_be_located_at(2, 0).and().should_face("E");
    }

    @Test
    public void facing_west_move_forward() {
        a_rover().located_at(2, 0).facing("W").forward().should_be_located_at(1, 0) .and().should_face("W");
        a_rover().located_at(1, 0).facing("W").forward().should_be_located_at(0, 0).and().should_face("W");
    }

    @Test
    public void facing_north_move_backward() {
        a_rover().located_at(0, 2).facing("N").backward().should_be_located_at(0, 1).and().should_face("N");
        a_rover().located_at(0, 1).facing("N").backward().should_be_located_at(0, 0).and().should_face("N");
    }

    @Test
    public void facing_south_move_backward() {
        a_rover().located_at(0, 0).facing("S").backward().should_be_located_at(0, 1).and().should_face("S");
    }

    @Test
    public void facing_east_move_backward() {
        a_rover().located_at(1, 0).facing("E").backward().should_be_located_at(0, 0).and().should_face("E");
    }

    @Test
    public void facing_west_move_backward() {
        a_rover().located_at(0, 0).facing("W").backward().should_be_located_at(1, 0).and().should_face("W");
    }

    @Test
    public void facing_north_turn_left() {
        a_rover().located_at(0, 0).facing("N").left().should_be_located_at(0, 0).and().should_face("W");
    }

    @Test
    public void facing_west_turn_left() {
        a_rover().located_at(0, 0).facing("W").left().should_be_located_at(0, 0).and().should_face("S");
    }

    @Test
    public void facing_south_turn_left() {
        a_rover().located_at(0, 0).facing("S").left().should_be_located_at(0, 0).and().should_face("E");
    }

    @Test
    public void facing_east_turn_left() {
        a_rover().located_at(0, 0).facing("E").left().should_be_located_at(0, 0).and().should_face("N");
    }

    @Test
    public void facing_north_turn_right() {
        a_rover().located_at(0, 0).facing("N").right().should_be_located_at(0, 0).and().should_face("E");
    }

    @Test
    public void facing_east_turn_right() {
        a_rover().located_at(0, 0).facing("E").right().should_be_located_at(0, 0).and().should_face("S");
    }

    @Test
    public void facing_south_turn_right() {
        a_rover().located_at(0, 0).facing("S").right().should_be_located_at(0, 0).and().should_face("W");
    }

    @Test
    public void facing_west_turn_right() {
        a_rover().located_at(0, 0).facing("W").right().should_be_located_at(0, 0).and().should_face("N");
    }

}

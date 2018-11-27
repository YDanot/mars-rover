import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommandExecutionTest {

    @Test
    public void command_f() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("f"))
                .isEqualToComparingFieldByField(
                        a_rover().located_at(0, 0).facing("N").moveForward().get()
                );
    }

    @Test
    public void command_ff() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("ff"))
                .isEqualToComparingFieldByField(
                        a_rover().located_at(0, 0).facing("N").moveForward().moveForward().get()
                );
    }

    @Test
    public void command_b() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("b"))
                .isEqualToComparingFieldByField(
                        a_rover().located_at(0, 0).facing("N").moveBackward().get()
                );
    }

    @Test
    public void command_l() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("l"))
                .isEqualToComparingFieldByField(
                        a_rover().located_at(0, 0).facing("N").turnLeft().get()
                );
    }

    @Test
    public void command_r() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("r"))
                .isEqualToComparingFieldByField(
                        a_rover().located_at(0, 0).facing("N").turnRight().get()
                );
    }

    private GlueRover a_rover() {
        return new GlueRover();
    }
}

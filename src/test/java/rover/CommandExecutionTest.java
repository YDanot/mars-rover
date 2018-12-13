package rover;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommandExecutionTest {

    @Test
    public void command_f() {

        Assertions.assertThat(
                        a_rover().execute("f"))
                .isEqualTo(
                        a_rover().forward()
                );
    }

    @Test
    public void command_ff() {

        Assertions.assertThat(
                        a_rover().execute("ff"))
                .isEqualTo(
                        a_rover().forward().forward()
                );
    }

    @Test
    public void command_b() {
        Assertions.assertThat(
                        a_rover().execute("b"))
                .isEqualTo(
                        a_rover().backward()
                );
    }

    @Test
    public void command_l() {
        Assertions.assertThat(
                        a_rover().execute("l"))
                .isEqualTo(
                        a_rover().left()
                );
    }

    @Test
    public void command_r() {
        Assertions.assertThat(
                        a_rover().execute("r"))
                .isEqualTo(
                        a_rover().right()
                );
    }

    @Test
    public void command_frbl() {
        Assertions.assertThat(
                            a_rover().execute("frbl"))
                .isEqualTo(
                        a_rover().forward().right().backward().left()
                );
    }

    private GlueRover a_rover() {
        return new GlueRover();
    }
}

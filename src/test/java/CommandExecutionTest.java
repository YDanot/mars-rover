import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommandExecutionTest {

    @Test
    public void command_f() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("f"))
                .isEqualToComparingFieldByField(
                        a_rover().located_at(0, 0).facing("N").forward().get()
                );
    }

    @Test
    public void command_ff() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("ff"))
                .isEqualToComparingFieldByField(
                        a_rover().located_at(0, 0).facing("N").forward().forward().get()
                );
    }

    @Test
    public void command_b() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("b"))
                .isEqualToComparingFieldByField(
                        a_rover().located_at(0, 0).facing("N").backward().get()
                );
    }

    @Test
    public void command_l() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("l"))
                .isEqualToComparingFieldByField(
                        a_rover().located_at(0, 0).facing("N").left().get()
                );
    }

    @Test
    public void command_r() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("r"))
                .isEqualToComparingFieldByField(
                        a_rover().located_at(0, 0).facing("N").right().get()
                );
    }

    @Test
    public void command_frbl() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("frbl"))
                .isEqualToComparingFieldByField(
                        a_rover().located_at(0, 0).facing("N").forward().right().backward().left().get()
                );
    }

    private GlueRover a_rover() {
        return new GlueRover();
    }
}

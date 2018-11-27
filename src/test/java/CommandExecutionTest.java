import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommandExecutionTest {

    @Test
    public void command_f() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("f").position())
                .isEqualTo(
                        a_rover().located_at(0, 0).facing("N").moveForward().get().position()
                );
    }

    @Test
    public void command_ff() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("ff").position())
                .isEqualTo(
                        a_rover().located_at(0, 0).facing("N").moveForward().moveForward().get().position()
                );
    }

    @Test
    public void command_fff() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("fff").position())
                .isEqualTo(
                        a_rover().located_at(0, 0).facing("N").moveForward().moveForward().moveForward().get().position()
                );
    }

    @Test
    public void command_b() {
        Assertions.assertThat(
                a_rover().located_at(0, 0).facing("N").execute("b").position())
                .isEqualTo(
                        a_rover().located_at(0, 0).facing("N").moveBackward().get().position()
                );
    }

    private GlueRover a_rover() {
        return new GlueRover();
    }
}

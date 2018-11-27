import command.Execute;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import rover.Rover;

public class CommandExecutionTest {

    @Test
    public void command_f() {
        final Rover rover = a_rover().located_at(0, 0).facing("N").get();
        final Rover f = new Execute().execute(rover, "f");
        Assertions.assertThat(f.position()).isEqualTo(rover.moveForward().position());
    }

    @Test
    public void command_ff() {
        Assertions.assertThat(a_rover().located_at(0, 0).facing("N").execute("ff").position())
                .isEqualTo(
                        a_rover().located_at(0, 0).facing("N").moveForward().moveForward().get().position()
                );
    }

    private GlueRover a_rover() {
        return new GlueRover();
    }
}

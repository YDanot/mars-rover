import command.Execute;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import rover.Rover;

public class CommandExecutionTest {

    @Test
    public void aTest() {
        final Rover rover = a_rover().located_at(0, 0).facing("N").get();
        final Rover f = new Execute().execute(rover, "f");
        Assertions.assertThat(f.position()).isEqualTo(rover.moveForward().position());
    }

    private GlueRover a_rover() {
        return new GlueRover();
    }
}

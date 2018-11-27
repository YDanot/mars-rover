package rover;

import org.junit.Test;

public class WrappingEdgeTest {

    @Test
    public void environment() {
        a_rover()
                .on_an_environment_of(3, 3)
                .located_at(0, 0)
                .facing("N")
                .backward()
                .should_be_located_at(0, 3)
                .and()
                .should_face("N");
    }

    private GlueRover a_rover() {
        return new GlueRover();
    }
}

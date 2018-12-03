package rover;

import org.junit.Test;

public class ObstacleDetectionTest {

    @Test
    public void aTest() {
        a_rover().located_at(1, 1)
                .on_an_environment_of(3,3)
                .with_obstacle_on(1,2)
                .facing("N")
                .forward()
                .should_be_located_at(1, 1)
                .and()
                .should_report_obstacle_in(1,2);
    }

    private GlueRover a_rover() {
        return new GlueRover();
    }
}

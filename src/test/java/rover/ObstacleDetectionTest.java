package rover;

import org.junit.Test;

import static rover.GlueRover.a_rover;

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
                .should_report_obstacle();
    }

    @Test
    public void asecondTest() {
        a_rover().located_at(1, 1)
                .on_an_environment_of(3,3)
                .with_obstacle_on(1,0)
                .facing("N")
                .backward()
                .should_be_located_at(1, 1)
                .and()
                .should_report_obstacle();
    }

    @Test
    public void aThirdTest() {
        a_rover().located_at(1, 1)
                .on_an_environment_of(3,3)
                .with_obstacle_on(1,0)
                .facing("N")
                .execute("bfff")
                .should_be_located_at(1, 1)
                .and()
                .should_report_obstacle();
    }
}

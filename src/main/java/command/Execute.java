package command;

import environment.Environment;
import rover.Rover;

public class Execute {

    public Rover execute(Rover rover, String commands, Environment environment) {
        Rover afterMoving = rover;
        for (String order : commands.split("")) {
            afterMoving = executeOrder(afterMoving, order,environment);
        }
        return afterMoving;
    }

    private Rover executeOrder(Rover rover, String commands, Environment environment) {
        if (commands.equals("f")) {
            return rover.moveForward(environment);
        }

        if (commands.equals("b")) {
            return rover.moveBackward(environment);
        }

        if (commands.equals("l")) {
            return rover.turnLeft();
        }

        if (commands.equals("r")) {
            return rover.turnRight();
        }
        return rover;
    }
}

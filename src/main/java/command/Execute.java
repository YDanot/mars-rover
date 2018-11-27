package command;

import rover.Rover;

public class Execute {

    public Rover execute(Rover rover, String commands) {
        Rover afterMoving = rover;
        for (String order : commands.split("")) {
            afterMoving = executeOrder(afterMoving, order);
        }
        return afterMoving;
    }

    private Rover executeOrder(Rover rover, String commands) {
        if (commands.equals("f")) {
            return rover.moveForward();
        }

        if (commands.equals("b")) {
            return rover.moveBackward();
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

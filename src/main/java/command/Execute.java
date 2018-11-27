package command;

import rover.Rover;

public class Execute {

    public Rover execute(Rover rover, String commands){
        if (commands.equals("ff")){
            return rover.moveForward().moveForward();
        }
        if (commands.equals("b")){
            return rover.moveBackward();
        }

        if (commands.equals("l")){
            return rover.turnLeft();
        }
        if (commands.equals("r")){
            return rover.turnRight();
        }
        return rover.moveForward();
    }
}

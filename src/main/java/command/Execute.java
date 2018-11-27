package command;

import rover.Rover;

public class Execute {

    public Rover execute(Rover rover, String commands){
        if (commands.equals("ff")){
            return rover.moveForward().moveForward();
        }
        return rover.moveForward();
    }
}

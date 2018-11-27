package command;

import rover.Rover;

public class Execute {

    public Rover execute(Rover rover, String commands){
        if (commands.equals("fff")){
            return rover.moveForward().moveForward().moveForward();
        }
        if (commands.equals("ff")){
            return rover.moveForward().moveForward();
        }
        return rover.moveForward();
    }
}

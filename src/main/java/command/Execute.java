package command;

import rover.Rover;

public class Execute {

    public Rover execute(Rover rover, String commands){
        return rover.moveForward();
    }
}

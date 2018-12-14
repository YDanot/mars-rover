package command;

import environment.Planet;
import rover.MovedRover;
import rover.Rover;

import java.util.Arrays;

public enum Command {

    FORWARD("f") {
        @Override
        public MovedRover execute(Rover rover, Planet environment) {
            return rover.moveForward(environment);
        }
    },
    BACKWARD("b") {
        @Override
        public MovedRover execute(Rover rover, Planet environment) {
            return rover.moveBackward(environment);
        }
    },
    LEFT("l") {
        @Override
        public MovedRover execute(Rover rover, Planet environment) {
            return new MovedRover(rover.turnLeft(), false);
        }
    },
    RIGHT("r") {
        @Override
        public MovedRover execute(Rover rover, Planet environment) {
            return new MovedRover(rover.turnRight(), false);
        }
    };

    private final String symbol;

    Command(String symbol) {
        this.symbol = symbol;
    }

    public static Command get(String symbol) {
        return Arrays.stream(values()).filter(c -> c.symbol.equals(symbol)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public abstract MovedRover execute(Rover rover, Planet environment);
}

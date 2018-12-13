package command;

import environment.Environment;
import rover.Moved;
import rover.Rover;

import java.util.Arrays;

public enum Command {

    FORWARD("f") {
        @Override
        public Moved execute(Rover rover, Environment environment) {
            return rover.moveForward(environment);
        }
    },
    BACKWARD("b") {
        @Override
        public Moved execute(Rover rover, Environment environment) {
            return rover.moveBackward(environment);
        }
    },
    LEFT("l") {
        @Override
        public Moved execute(Rover rover, Environment environment) {
            return new Moved(rover.turnLeft(), false);
        }
    },
    RIGHT("r") {
        @Override
        public Moved execute(Rover rover, Environment environment) {
            return new Moved(rover.turnRight(), false);
        }
    };

    private final String symbol;

    Command(String symbol) {
        this.symbol = symbol;
    }

    public static Command get(String symbol) {
        return Arrays.stream(values()).filter(c -> c.symbol.equals(symbol)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public abstract Moved execute(Rover rover, Environment environment);
}

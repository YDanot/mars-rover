package command;

import environment.Environment;
import environment.Obstacle;
import rover.Position;
import rover.Rover;
import utils.Either;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Commands {

    private static final Map<String, BiFunction<Rover, Environment, Either<Rover, Obstacle>>> commandMapping = classic();

    private static Map<String, BiFunction<Rover, Environment, Either<Rover, Obstacle>>> classic() {
        Map<String, BiFunction<Rover, Environment, Either<Rover, Obstacle>>> rules = new HashMap<>();
        rules.put("f", Rover::moveForward);
        rules.put("b", Rover::moveBackward);
        rules.put("l", (rover, environment) -> Either.either(rover.turnLeft()));
        rules.put("r", (rover, environment) -> Either.either(rover.turnRight()));
        return rules;
    }

    private final List<String> commands;

    public Commands(String commandLine) {
        this.commands = Arrays.stream(commandLine.split("")).collect(Collectors.toList());
    }

    public Either<Rover, Obstacle> execute(Rover rover, Environment environment) {
        Either<Rover, Obstacle> moved = Either.either(rover);
        for (String c : commands) {
            if (moved.isOption1()) {
                moved = commandMapping.get(c).apply(moved.option1(), environment);
            }
            if (moved.isOption2()) {
                break;
            }
        }
        return moved;
    }

}

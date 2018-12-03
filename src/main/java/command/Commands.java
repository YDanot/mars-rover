package command;

import environment.Environment;
import rover.Rover;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Commands {

    private static final Map<String, BiFunction<Rover, Environment, Rover>> commandMapping = classic();

    private static Map<String, BiFunction<Rover, Environment, Rover>> classic() {
        Map<String, BiFunction<Rover, Environment, Rover>> rules = new HashMap<>();
        rules.put("f", Rover::moveForward);
        rules.put("b", Rover::moveBackward);
        rules.put("l", (rover, environment) -> rover.turnLeft());
        rules.put("r", (rover, environment) -> rover.turnRight());
        return rules;
    }

    private final List<String> commands;

    public Commands(String commandLine) {
        this.commands = Arrays.stream(commandLine.split("")).collect(Collectors.toList());
    }

    public Rover execute(Rover rover, Environment environment) {
        Rover afterMoving = rover;
        for (String c : commands) {
            afterMoving = commandMapping.get(c).apply(afterMoving, environment);
        }
        return afterMoving;
    }

}

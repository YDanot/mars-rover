package command;

import environment.Planet;
import rover.MovedRover;
import rover.Rover;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

import static java.util.stream.Collectors.toList;

public class Commands {

    private final Queue<Command> commands;
    private final Planet environment;

    public Commands(String commandLine, Planet environment) {
        this.environment = environment;
        this.commands = new ArrayDeque<>();
        commands.addAll(
                Arrays.stream(commandLine.split("")).map(Command::get).collect(toList())
        );
    }

    public MovedRover executeOn(Rover rover) {
        return executeOn(executeNextCommandOn(rover));
    }

    private MovedRover executeNextCommandOn(Rover rover) {
        return Objects.requireNonNull(commands.poll()).execute(rover, environment);
    }

    private MovedRover executeOn(MovedRover moved) {
        if (moved.obstacle() || commands.isEmpty()) {
            return moved;
        }

        return executeOn(executeNextCommandOn(moved.rover()));
    }

}

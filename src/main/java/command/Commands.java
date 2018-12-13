package command;

import environment.Environment;
import rover.Moved;
import rover.Rover;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

import static java.util.stream.Collectors.toList;

public class Commands {

    private final Queue<Command> commands;
    private final Environment environment;

    public Commands(String commandLine, Environment environment) {
        this.environment = environment;
        this.commands = new ArrayDeque<>();
        commands.addAll(
                Arrays.stream(commandLine.split("")).map(Command::get).collect(toList())
        );
    }

    public Moved executeOn(Rover rover) {
        return executeOn(executeNextCommandOn(rover));
    }

    private Moved executeNextCommandOn(Rover rover) {
        return Objects.requireNonNull(commands.poll()).execute(rover, environment);
    }

    private Moved executeOn(Moved moved) {
        if (moved.obstacle() || commands.isEmpty()) {
            return moved;
        }

        return executeOn(executeNextCommandOn(moved.rover()));
    }

}

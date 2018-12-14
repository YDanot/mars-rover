package rover;

public class MovedRover {

    private final Rover rover;
    private final boolean obstacle;

    public MovedRover(Rover rover, boolean obstacle) {
        this.rover = rover;
        this.obstacle = obstacle;
    }

    public Rover rover() {
        return rover;
    }

    public boolean obstacle() {
        return obstacle;
    }
}

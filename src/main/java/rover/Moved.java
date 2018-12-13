package rover;

public class Moved {

    private final Rover rover;
    private final boolean obstacle;

    public Moved(Rover rover, boolean obstacle) {
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

package environment;

import rover.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Obstacles {

    private final List<Obstacle> obstacles;

    private Obstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public Obstacles() {
        this.obstacles = new ArrayList<>();
    }

    public boolean at(Position position){
        return obstacles.stream().anyMatch(o -> o.position().equals(position));
    }

    public Obstacles putObstacleAt(Position position) {
        List<Obstacle> obstacles = this.obstacles;
        obstacles.add(Obstacle.at(position));
        return new Obstacles(obstacles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obstacles)) return false;
        Obstacles obstacles1 = (Obstacles) o;
        return Objects.equals(obstacles, obstacles1.obstacles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obstacles);
    }
}

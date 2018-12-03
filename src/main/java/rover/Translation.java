package rover;

import environment.Environment;

import java.util.Objects;

public class Translation {

    private final int x;
    private final int y;

    public Translation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x() {
        return x;
    }

    public Position apply(Position pos, Environment environment) {
        return new Position(acceptX(x() + pos.x(), environment), acceptY(y() + pos.y(), environment));
    }

    private int acceptX(int x, Environment environment) {
        return x > environment.width() ? 0 : x < 0 ? environment.width() : x;
    }

    private int acceptY(int y, Environment environment) {
        return y > environment.height() ? 0 : y < 0 ? environment.height() : y;
    }

    private int y() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Translation)) return false;
        Translation position = (Translation) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

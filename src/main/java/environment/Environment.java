package environment;

import rover.Position;

import java.util.Objects;

public class Environment {

    private final int width;
    private final int height;

    public Environment(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Position accept(Position p) {
        return new Position(acceptX(p.x()), acceptY(p.y()));
    }

    private int acceptX(int x) {
        return x > width ? 0 : x < 0 ? width : x;
    }

    private int acceptY(int y) {
        return y > height ? 0 : y < 0 ? height : y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Environment)) return false;
        Environment that = (Environment) o;
        return width == that.width &&
                height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}

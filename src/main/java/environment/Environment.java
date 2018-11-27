package environment;

public class Environment {

    private final int width;
    private final int height;

    public Environment(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
}

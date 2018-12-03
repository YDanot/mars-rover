package utils;

public class Either<O1, O2> {

    private final O1 option1;
    private final O2 option2;

    private Either(O1 pos, O2 option2) {
        this.option1 = pos;
        this.option2 = option2;
    }

    public static <O1, O2> Either<O1, O2> either(O1 pos) {
        return new Either<>(pos, null);
    }

    public Either<O1, O2> or(O2 obstacle) {
        if (obstacle != null)
            return new Either<>(null, obstacle);
        return this;
    }

    public O1 option1() {
        return option1;
    }

    public O2 option2() {
        return option2;
    }

    public boolean isOption1() {
        return option1 != null;
    }

    public boolean isOption2() {
        return !isOption1();
    }
}

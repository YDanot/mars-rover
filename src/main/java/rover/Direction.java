package rover;

public enum Direction {

    NORTH {
        @Override
        public int translationX() {
            return 0;
        }

        @Override
        public int translationY() {
            return 1;
        }

        @Override
        public Direction opposite() {
            return SOUTH;
        }

        @Override
        public Direction left() {
            return WEST;
        }

    },
    SOUTH {
        @Override
        public int translationX() {
            return 0;
        }

        @Override
        public int translationY() {
            return -1;
        }

        @Override
        public Direction opposite() {
            return NORTH;
        }

        @Override
        public Direction left() {
            return EAST;
        }

    },
    EAST {
        @Override
        public int translationX() {
            return 1;
        }

        @Override
        public int translationY() {
            return 0;
        }

        @Override
        public Direction opposite() {
            return WEST;
        }

        @Override
        public Direction left() {
            return NORTH;
        }

    },
    WEST {
        @Override
        public int translationX() {
            return -1;
        }

        @Override
        public int translationY() {
            return 0;
        }

        @Override
        public Direction opposite() {
            return EAST;
        }

        @Override
        public Direction left() {
            return SOUTH;
        }

    };

    public abstract int translationX();
    public abstract int translationY();
    public abstract Direction opposite();
    public abstract Direction left();

}

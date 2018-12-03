package rover;

public enum Direction {

    NORTH() {
        @Override
        public Translation translation() {
            return new Translation(0,1);
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
    SOUTH() {
        @Override
        public Translation translation() {
            return new Translation(0,-1);
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
    EAST() {
        @Override
        public Translation translation() {
            return new Translation(1,0);
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
    WEST() {
        @Override
        public Translation translation() {
            return new Translation(-1,0);
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

    public abstract Translation translation();
    public abstract Direction opposite();
    public abstract Direction left();

}

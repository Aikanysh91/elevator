package building.model;

public class Floor {
    private int countOfPassenger= (int) Math.random()*(10-0);
    private int sourceFloor;
    private Direction direction;

    public Floor(int countOfPassenger, int sourceFloor, Direction direction) {
        this.countOfPassenger = countOfPassenger;
        this.sourceFloor = sourceFloor;
        this.direction = direction;
    }

    public int getCountOfPassenger() {
        return countOfPassenger;
    }

    public void setCountOfPassenger(int countOfPassenger) {
        this.countOfPassenger = countOfPassenger;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

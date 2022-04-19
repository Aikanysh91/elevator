package building.model;

public class Building {

    private int countOfFloor= (int) (Math.random()*(20-5));

    public Building(int countOfFloor) {
        this.countOfFloor = countOfFloor;
    }

    public int getCountOfFloor() {
        return countOfFloor;
    }

    public void setCountOfFloor(int countOfFloor) {
        this.countOfFloor = countOfFloor;
    }

    @Override
    public String toString() {
        return "Building{" +
                "countOfFloor=" + countOfFloor +
                '}';
    }
}

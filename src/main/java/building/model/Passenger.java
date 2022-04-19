package building.model;

public class Passenger {
    private int requestFloor;

    public Passenger(int requestFloor) {
        this.requestFloor = requestFloor;
    }

    public int getRequestFloor() {
        return requestFloor;
    }

    public void setRequestFloor(int requestFloor) {
        this.requestFloor = requestFloor;
    }
}

package building.service;

import building.model.Floor;
import building.model.Passenger;

public class Request implements Comparable<Request>{
    private Passenger passenger;
    private Floor floor;

    public Request(Passenger passenger) {
        this.passenger = passenger;
    }

    public Request(Floor floor) {
        this.floor = floor;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public int compareTo(Request o) {
        return 0;
    }
}

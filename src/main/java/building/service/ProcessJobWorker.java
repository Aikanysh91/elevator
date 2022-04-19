package building.service;

public class ProcessJobWorker implements Runnable{
    private Elevator elevator;

    public ProcessJobWorker(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        elevator.startElevator();
    }
}

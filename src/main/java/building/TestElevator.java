package building;

import building.model.*;
import building.service.AddJobWorker;
import building.service.Elevator;
import building.service.ProcessJobWorker;
import building.service.Request;

public class TestElevator {
    public static void main(String[] args) {
        Building building = new Building(10);
        System.out.println("Created a new "+building);
        Elevator elevator = new Elevator();
        Floor floor1 = new Floor(3,0, Direction.UP);
        Passenger person1 = new Passenger(2);
        Passenger person2 = new Passenger(4);
        Passenger person3 = new Passenger(6);
        Request request= new Request(floor1);
        Request request1 = new Request(person1);
        Request request2 = new Request(person2);
        Request request3 = new Request(person3);
        elevator.addJob(request1);
        elevator.addJob(request2);
        elevator.addJob(request3);

        ProcessJobWorker processJobWorker = new ProcessJobWorker(elevator);
        Thread t2 = new Thread(processJobWorker);
        t2.start();

        new Thread(new AddJobWorker(elevator, request1)).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package building.service;


import building.model.Direction;


import java.util.TreeSet;

public class Elevator {
    private int currentFloor=0;
    private Direction currentDirection=Direction.UP;
    private final int maxPassenger=5;

    private TreeSet<Request> requests =new TreeSet<>();
    private TreeSet<Request> upPendingJobs = new TreeSet<>();
    private TreeSet<Request> downPendingJobs = new TreeSet<>();

    public void startElevator(){
        if(currentDirection == Direction.UP){
            Request request = requests.pollFirst();
            processUpRequest(request);
            if(maxPassenger<5){
                requests.add(request);
            }
        }
        if(currentDirection == Direction.DOWN){
            Request request = requests.pollLast();
            processDownRequest(request);
            if(requests.isEmpty()){
                addPendingFloorToFloors();
            }
        }
    }
    private void addPendingFloorToFloors(){
        if (currentDirection == Direction.UP) {
            if(!upPendingJobs.isEmpty())
                requests.add(upPendingJobs.pollFirst());
            ;
        } else {
            if(!downPendingJobs.isEmpty())
                requests.add(downPendingJobs.pollFirst());
        }
        System.out.println("The elevator waiting for a request");
    }
    private void processUpRequest(Request request) {
        System.out.println("Please enter your destination floor!");
        for (int i = currentFloor; i <= request.getPassenger().getRequestFloor(); i++) {
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("|^  "+i+"  ^|");
            currentFloor=i;

        }
        System.out.println("Your destination floor is "+currentFloor);
    }
    private void processDownRequest(Request request) {
        System.out.println("Please enter your destination floor!");
            for (int i = currentFloor; i <= request.getPassenger().getRequestFloor(); i--) {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("|v  "+i+"  v|");
                currentFloor=i;

            }
        System.out.println("Your destination floor is "+currentFloor);
    }
    public void addJob(Request request){
        if(currentDirection==Direction.UP){
            if(currentFloor<=request.getPassenger().getRequestFloor()) {
                requests.add(request);
            }else{
                addToPendingJobs(request);
            }
        }else if(currentDirection == Direction.DOWN){
            if(currentFloor >= request.getPassenger().getRequestFloor()){
                requests.add(request);
            }else{
                addToPendingJobs(request);
            }
        }
    }

    private void addToPendingJobs(Request request) {
        if (request.getPassenger().getRequestFloor()==currentFloor) {
            requests.add(request);
        } else {
            downPendingJobs.add(request);
        }
    }
}

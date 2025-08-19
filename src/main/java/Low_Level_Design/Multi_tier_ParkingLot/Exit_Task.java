package Low_Level_Design.Multi_tier_ParkingLot;

public class Exit_Task implements Runnable {

    private final Vehicle vehicle;
    private final Entry_Exit_Service service;

    Exit_Task(Vehicle vehicle, Entry_Exit_Service service){
        this.service = service;
        this.vehicle = vehicle;
    }

    @Override
    public void run(){
        System.out.println("Exiting vehicle "+vehicle.id);
        int charge = service.exitVehicle(vehicle);
        System.out.println(Thread.currentThread().getName() + " - Exit charge: " + charge);
    }
}

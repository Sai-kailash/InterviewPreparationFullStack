package Low_Level_Design.Multi_tier_ParkingLot;

public class Entry_Task implements Runnable{

    private final Vehicle vehicle;
    private final Entry_Exit_Service service;

    Entry_Task(Vehicle vehicle, Entry_Exit_Service service){
        this.vehicle = vehicle;
        this.service = service;
    }

    @Override
    public void run(){
        try {
            service.fillSlot(vehicle);
        } catch (Parking_Full_Exception e) {
           System.out.println(e.toString());
        }
    }
}

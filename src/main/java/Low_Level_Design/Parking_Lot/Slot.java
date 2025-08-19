package Low_Level_Design.Parking_Lot;


public class Slot {

    String slot_id;
    Vehicle vehicle;
    boolean isOccupied = false;

    Slot(Vehicle vehicle){
        this.vehicle = vehicle;
        this.slot_id = this.vehicle.id;
        this.isOccupied = true;
    }

}

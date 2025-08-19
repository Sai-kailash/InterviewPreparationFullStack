package Low_Level_Design.Multi_tier_ParkingLot;


import Low_Level_Design.Multi_tier_ParkingLot.Vehicle;


public class Slot {

    char[] zones = new char[]{'A', 'B', 'C', 'D'};
    String slot_id;
    Vehicle vehicle;

    Slot(Vehicle vehicle, int floor_id, int slot_no, int zone_id){
        this.vehicle = vehicle;
        this.slot_id = "B"+ (floor_id + 1) + "_" + zones[zone_id] + "_" + (slot_no + 1);
    }

}

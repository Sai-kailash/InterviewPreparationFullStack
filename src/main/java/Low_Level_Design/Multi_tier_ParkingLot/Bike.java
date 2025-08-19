package Low_Level_Design.Multi_tier_ParkingLot;

import java.sql.Timestamp;

public class Bike extends Vehicle {


    Bike(String id, Timestamp time) {
        super(id, time, VehicleType.BIKE);
    }
}

package Low_Level_Design.Parking_Lot;

import java.sql.Timestamp;

public class Bike extends Vehicle {


    Bike(String id, Timestamp time) {
        super(id, time, VehicleType.BIKE);
    }
}

package Low_Level_Design.Multi_tier_ParkingLot;

import java.sql.Timestamp;

public class Car extends Vehicle {


    Car(String id, Timestamp time) {
        super(id, time, VehicleType.CAR);
    }
}

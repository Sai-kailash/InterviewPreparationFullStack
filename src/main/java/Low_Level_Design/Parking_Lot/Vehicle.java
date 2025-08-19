package Low_Level_Design.Parking_Lot;

import java.sql.Timestamp;

public class Vehicle {

    enum VehicleType {
        BIKE, CAR
    }

    String id;
    Timestamp entryTime;
    VehicleType type;

    Vehicle(String id, Timestamp time, VehicleType type){
        this.id = id;
        this.entryTime = time;
        this.type = type;
    }
}

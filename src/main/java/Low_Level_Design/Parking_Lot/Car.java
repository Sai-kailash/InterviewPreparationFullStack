package Low_Level_Design.Parking_Lot;

import java.sql.Timestamp;

public class Car extends Vehicle{


    Car(String id, Timestamp time) {
        super(id, time, VehicleType.CAR);
    }
}

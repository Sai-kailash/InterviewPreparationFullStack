package Low_Level_Design.Parking_Lot;

import java.sql.Timestamp;

public class Parking_Lot {

    int size = 2;
    Slot[] slots = new Slot[size];
    int charges = 30;
    int count = 0;
    boolean isParkingFull = false;

    public int getEmptySlot() {

        int i=0;
        for(Slot s: slots){
            if(s == null){
                return i;
            }
            i++;
        }

        return -1;

    }

    public void fillSlot(Slot slot, int slot_no){
        slots[slot_no] = slot;
        count++;

        if(count == size){
            isParkingFull = true;
        }
    }

    public int exitVehicle(Vehicle vehicle){

        int i=0;
        for(Slot s: slots){
            if(s.slot_id.equals(vehicle.id)){
                slots[i] = null;
                count--;
                isParkingFull = false;
                Timestamp now = new Timestamp(System.currentTimeMillis());
                long diff = now.getTime() - vehicle.entryTime.getTime();
                double h = Math.ceil((double) diff /(1000 * 60 * 60));
                return (int)h * charges;
            }
            i++;
        }

        return -1;

    }


    public static void main(String[] args){

        Parking_Lot parkingLot = new Parking_Lot();

        System.out.println("Number of vehicles "+ parkingLot.count);

        Bike b1 = new Bike("ka01", new Timestamp(System.currentTimeMillis()));
        Slot s1 = new Slot(b1);

        int slot_no = parkingLot.getEmptySlot();
        parkingLot.fillSlot(s1, slot_no);

        System.out.println("Number of vehicles "+ parkingLot.count);

        Car c1 = new Car("ka02", new Timestamp(System.currentTimeMillis()));

        if(!parkingLot.isParkingFull) {
            slot_no = parkingLot.getEmptySlot();
            parkingLot.fillSlot(new Slot(c1), slot_no);
        } else {
            System.out.println("Parking full");
        }

        System.out.println("Number of vehicles "+ parkingLot.count);

        Bike b2 = new Bike("ka03", new Timestamp(System.currentTimeMillis()));

        if(!parkingLot.isParkingFull) {
            slot_no = parkingLot.getEmptySlot();
            parkingLot.fillSlot(new Slot(b2), slot_no);
        } else {
            System.out.println("Parking full");
        }

        System.out.println("Charges for bike "+b1.id+" is "+ parkingLot.exitVehicle(b1));
        System.out.println("Number of vehicles "+ parkingLot.count);

        if(!parkingLot.isParkingFull) {
            slot_no = parkingLot.getEmptySlot();
            parkingLot.fillSlot(new Slot(b2), slot_no);
        } else {
            System.out.println("Parking full");
        }

        System.out.println("Number of vehicles "+ parkingLot.count);

    }
}

package Low_Level_Design.Multi_tier_ParkingLot;

import java.sql.Timestamp;
import java.util.Objects;

public class Entry_Exit_Service {

    int floor_size = 3;
    int slot_size = 4;
    int zone_size = slot_size/4;
    int charges = 50;

    int count = 0;
    boolean isParkingFull = false;

    Slot[][] slots = new Slot[floor_size][slot_size];

    public int[] getEmptySlot() throws Parking_Full_Exception {

        if(isParkingFull){
            throw new Parking_Full_Exception("Parking Full");
        }

        for(int i=0;i<floor_size;i++){
            for(int j=0;j<slot_size;j++){
                if(slots[i][j] == null){
                    return new int[]{i, j, j/zone_size};
                }
            }
        }

        return new int[]{-1,-1,1};
    }

    synchronized void fillSlot(Vehicle vehicle) throws Parking_Full_Exception {

        if(isParkingFull){
            throw new Parking_Full_Exception("Parking Full");
        }

        int[] space = getEmptySlot();

        slots[space[0]][space[1]] = new Slot(vehicle, space[0], space[1], space[2]);
        count++;

        System.out.println("Slot id is "+slots[space[0]][space[1]].slot_id);
        System.out.println("Count of vehicles is "+ count);

        if(count == floor_size * slot_size){
            isParkingFull = true;
        }

    }

    synchronized int exitVehicle(Vehicle vehicle) {

        for (int i = 0; i < floor_size; i++) {
            for (int j = 0; j < slot_size; j++) {
                if (slots[i][j] != null && Objects.equals(slots[i][j].vehicle.id, vehicle.id)) {
                    count--;
                    System.out.println(" Exited vehicle "+ vehicle.id + " Count of vehicles is "+ count);
                    isParkingFull = false;
                    Timestamp now = new Timestamp(System.currentTimeMillis());
                    long diff = now.getTime() - slots[i][j].vehicle.entryTime.getTime();
                    double h = Math.ceil((double) diff / (1000));
                    slots[i][j] = null;
                    return (int) h * charges;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Parking_Full_Exception, InterruptedException {
        Entry_Exit_Service gate = new Entry_Exit_Service();

        Bike b1 = new Bike("ka01", new Timestamp(System.currentTimeMillis()));
        Car c1 = new Car("ka02", new Timestamp(System.currentTimeMillis()));
        Bike b2 = new Bike("ka03", new Timestamp(System.currentTimeMillis()));
        Car c2 = new Car("ka04", new Timestamp(System.currentTimeMillis()));
        Bike b3 = new Bike("ka00", new Timestamp(System.currentTimeMillis()));

        Thread t1 = new Thread(new Entry_Task(b1, gate));
        Thread t2 = new Thread(new Entry_Task(c1, gate));
        Thread t3 = new Thread(new Entry_Task(b2, gate));
        Thread t4 = new Thread(new Entry_Task(c2, gate));
        Thread t10 = new Thread(new Entry_Task(b3, gate));

        Thread t5 = new Thread(new Exit_Task(b1, gate));
        Thread t6 = new Thread(new Exit_Task(c1, gate));

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();
        Thread.sleep(1000);
        t4.start();
        Thread.sleep(1000);
        t10.start();
        Thread.sleep(1000);

        t5.start();
        Thread.sleep(1000);
        t6.start();

        Thread.sleep(100);

        Thread t7 = new Thread(new Entry_Task(b1, gate));
        t7.start();t7.join();
    }

}

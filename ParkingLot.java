package systemdesign.parkinglot;

import java.util.List;

public class ParkingLot {

    private static String nameOfParkingLot;
    private static Address address;
    private static List<ParkingFloor> parkingFloors;
    private static ParkingLot parkingLot = null;

    private ParkingLot(String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors) {
        this.address = address;
        this.nameOfParkingLot = nameOfParkingLot;
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLot getInstance(String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors) {
        if(parkingLot == null) {
            parkingLot = new ParkingLot(nameOfParkingLot, address, parkingFloors);
        }
        return parkingLot;
    }

    public Ticket assignTicket(Vehicle vehicle) {
        ParkingSlot parkingSlot = getParkingSlot(vehicle);
        Ticket ticket = null;
        if(parkingSlot != null) {
            ticket = createTicket(vehicle, parkingSlot);
        }
        return ticket;
    }

    private Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
        return Ticket.createTicket(vehicle, parkingSlot);
    }

    private ParkingSlot getParkingSlot(Vehicle vehicle) {
        for(ParkingFloor parkingFloor : parkingFloors) {
            ParkingSlot parkingSlot = parkingFloor.getRelevantParkingSlot(vehicle);
            if(parkingSlot != null) {
                return parkingSlot;
            }
        }
        return null;
    }

    public void addFloor(ParkingFloor floor) {
        this.parkingFloors.add(floor);
    }

    public void removeFloor(ParkingFloor floor) {
        this.parkingFloors.remove(floor);
    }

    public double scanAndPay(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
        int duration = (int)(endTime - ticket.getStartTime())/1000;
        double price = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
        return price;
    }
}

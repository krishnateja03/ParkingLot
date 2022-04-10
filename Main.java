package systemdesign.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String nameOfParkingLot = "BusinessBay Parking";
        Address address = Address.builder().street("Lane1").area("BusinessBay").city("Pune").state("MH").country("India").build();
        Map<ParkingSlotType, Map<String, ParkingSlot>> mapOfDifferentSlotTypes = new HashMap<>();
        Map<String, ParkingSlot> compactSlotMap = new HashMap<>();
        compactSlotMap.put("C1", new ParkingSlot("C1",ParkingSlotType.COMPACT));
        compactSlotMap.put("C2", new ParkingSlot("C2",ParkingSlotType.COMPACT));
        compactSlotMap.put("C3", new ParkingSlot("C3",ParkingSlotType.COMPACT));
        mapOfDifferentSlotTypes.put(ParkingSlotType.COMPACT, compactSlotMap);

        Map<String, ParkingSlot> largeSlotMap = new HashMap<>();
        largeSlotMap.put("L1", new ParkingSlot("L1",ParkingSlotType.LARGE));
        largeSlotMap.put("L2", new ParkingSlot("L2",ParkingSlotType.LARGE));
        largeSlotMap.put("L3", new ParkingSlot("L3",ParkingSlotType.LARGE));
        mapOfDifferentSlotTypes.put(ParkingSlotType.LARGE, largeSlotMap);

        ParkingFloor parkingFloor = new ParkingFloor("1", mapOfDifferentSlotTypes);
        List<ParkingFloor> listOfFloors = new ArrayList<>();
        listOfFloors.add(parkingFloor);

        ParkingLot parkingLot = ParkingLot.getInstance(nameOfParkingLot, address, listOfFloors);

        Vehicle vehicle1 = new Vehicle("TS-05-8486-AE", VehicleType.SEDAN);
        Vehicle vehicle2 = new Vehicle("MH-23-1234-TR", VehicleType.SUV);

        Ticket ticket1 = parkingLot.assignTicket(vehicle1);
        System.out.println("Generated ticket for vehicle1 >>> "+ ticket1.getTicketNum());
        System.out.println("Slot Id is >>> "+ ticket1.getParkingSlot().getName());

        Thread.sleep(10000);

        double price = parkingLot.scanAndPay(ticket1);
        System.out.println("Price for parking vehicle1 : Rs. " + price);
    }
}

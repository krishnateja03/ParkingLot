package systemdesign.parkinglot;

import java.util.Map;

public class ParkingFloor {
    private String parkingFloorId;
    private Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots;

    ParkingFloor(String parkingFloorId, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        this.parkingFloorId = parkingFloorId;
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot getRelevantParkingSlot(Vehicle vehicle) {
        ParkingSlotType parkingSlotType = getParkingSlotTypeFromVehicleType(vehicle.getVehicleType());
        Map<String, ParkingSlot> slots = parkingSlots.get(parkingSlotType);
        if(slots != null) {
            for (Map.Entry<String, ParkingSlot> slot : slots.entrySet()) {
                ParkingSlot parkingSlot = slot.getValue();
                if (parkingSlot.isAvailable()) {
                    parkingSlot.addVehicle(vehicle);
                    return parkingSlot;
                }
            }
        }
        return null;
    }

    private ParkingSlotType getParkingSlotTypeFromVehicleType(VehicleType vehicleType) {
        if(vehicleType.equals(VehicleType.TWO_WHEELER)) {
            return ParkingSlotType.TWO_WHEELER;
        } else if(vehicleType.equals(VehicleType.HATCH_BACK) || vehicleType.equals(VehicleType.SEDAN)) {
            return ParkingSlotType.COMPACT;
        } else if(vehicleType.equals(VehicleType.SUV)) {
            return ParkingSlotType.MEDIUM;
        } else return ParkingSlotType.LARGE;
    }

}

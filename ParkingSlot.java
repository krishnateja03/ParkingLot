package systemdesign.parkinglot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {

    private String name;

    @Builder.Default
    private boolean available = true;

    private Vehicle vehicle;
    private ParkingSlotType parkingSlotType;

    ParkingSlot(String name, ParkingSlotType parkingSlotType) {
        this.name = name;
        this.parkingSlotType = parkingSlotType;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.available = false;
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        this.available = true;
    }
}

package systemdesign.parkinglot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private String vehicleNum;
    private VehicleType vehicleType;

    Vehicle(String vehicleNum, VehicleType vehicleType) {
        this.vehicleNum = vehicleNum;
        this.vehicleType = vehicleType;
    }
}

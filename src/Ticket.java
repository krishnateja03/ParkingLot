package systemdesign.parkinglot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ticket {
    private String ticketNum;
    private long startTime;
    private long endTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
        return Ticket.builder()
                .vehicle(vehicle)
                .ticketNum(vehicle.getVehicleNum() + System.currentTimeMillis())
                .parkingSlot(parkingSlot)
                .startTime(System.currentTimeMillis())
                .build();
    }
}

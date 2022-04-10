package systemdesign.parkinglot;

public enum ParkingSlotType {
    TWO_WHEELER {
        public double getPriceForParking(long duration) {
            return duration*(0.05);
        }
    },
    COMPACT {
        public double getPriceForParking(long duration) {
            return duration*(0.075);
        }
    },
    MEDIUM {
        public double getPriceForParking(long duration) {
            return duration*(0.09);
        }
    },
    LARGE {
        public double getPriceForParking(long duration) {
            return duration*(0.10);
        }
    };

    public abstract double getPriceForParking(long duration);
}

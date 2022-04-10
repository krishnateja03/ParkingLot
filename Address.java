package systemdesign.parkinglot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Address {
     String street;
     String area;
     String city;
     String state;
     String country;
}

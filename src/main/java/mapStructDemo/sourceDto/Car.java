package mapStructDemo.sourceDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Car {
    private String make;
    private Integer numberOfSeats;
    private String name;
    private Date createDate;
    private Person person;
    private String manufacturer;


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Person {
        String fullName;
        String phone;
    }
}

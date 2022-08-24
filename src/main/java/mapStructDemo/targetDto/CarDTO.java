package mapStructDemo.targetDto;

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
public class CarDTO {
    private String manufacturer;
    private int seatCount;
    private String name;
    private Date createDate;
    private PersonDTO personDTO;


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class PersonDTO {
        String userName;
        String phoneNumber;
    }
}

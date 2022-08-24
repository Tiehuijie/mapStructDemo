package mapStructDemo.mappers;

import mapStructDemo.mappers.CarDIMapper;
import mapStructDemo.sourceDto.Car;
import mapStructDemo.targetDto.CarDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarDIMapperTest {
    CarDIMapper carDIMapper;

    @Test
    void should_create_carDto_when_call_carMapper_with_car() {
        Car car = Car.builder()
                .make("CHINA")
                .numberOfSeats(4)
                .name("小鹏")
                .createDate(new Date())
                .person(Car.Person.builder()
                        .fullName("张三")
                        .phone("1234556576767")
                        .build())
                .build();
        CarDTO carDto = carDIMapper.toCarDto(car);

        assertThat(carDto.getManufacturer()).isEqualTo(car.getMake());
        assertThat(carDto.getSeatCount()).isEqualTo(car.getNumberOfSeats());
        assertThat(carDto.getName()).isEqualTo(car.getName());
        assertThat(carDto.getCreateDate()).isEqualTo(car.getCreateDate());

        assertThat(carDto.getPersonDTO().getUserName()).isEqualTo(car.getPerson().getFullName());
        assertThat(carDto.getPersonDTO().getPhoneNumber()).isEqualTo(car.getPerson().getPhone());
    }

}

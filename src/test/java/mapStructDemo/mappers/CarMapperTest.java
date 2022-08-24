package mapStructDemo.mappers;

import mapStructDemo.sourceDto.Car;
import mapStructDemo.targetDto.CarDTO;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static mapStructDemo.mappers.CarMapper.CAR_MAPPER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarMapperTest {

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
        CarDTO carDto = CAR_MAPPER.toCarDto(car);

        assertThat(carDto.getManufacturer()).isEqualTo(car.getMake());
        assertThat(carDto.getSeatCount()).isEqualTo(car.getNumberOfSeats());
        assertThat(carDto.getName()).isEqualTo(car.getName());
        assertThat(carDto.getCreateDate()).isEqualTo(car.getCreateDate());

        assertThat(carDto.getPersonDTO().getUserName()).isEqualTo(car.getPerson().getFullName());
        assertThat(carDto.getPersonDTO().getPhoneNumber()).isEqualTo(car.getPerson().getPhone());
    }

    @Test
    void test_Inherit_for_map_car_to_carDto() {
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
        CarDTO carDto = new CarDTO();
        CAR_MAPPER.carDtoIntoCar(car, carDto);

        assertThat(carDto.getManufacturer()).isEqualTo("testManufacturer");
        assertThat(carDto.getSeatCount()).isEqualTo(car.getNumberOfSeats());
        assertThat(carDto.getName()).isEqualTo(car.getName());
        assertThat(carDto.getCreateDate()).isEqualTo(car.getCreateDate());

        assertThat(carDto.getPersonDTO().getUserName()).isEqualTo(car.getPerson().getFullName());
        assertThat(carDto.getPersonDTO().getPhoneNumber()).isEqualTo(car.getPerson().getPhone());
    }

    @Test
    void should_revert_mapper_when_use_carDtoToCar() {
        CarDTO carDTO = CarDTO.builder()
                .manufacturer("CHINA")
                .seatCount(4)
                .name("小鹏")
                .createDate(new Date())
                .personDTO(CarDTO.PersonDTO.builder()
                        .userName("张三")
                        .phoneNumber("1234556576767")
                        .build())
                .build();
        Car car = CAR_MAPPER.carDtoToCar(carDTO);

        assertThat(car.getMake()).isEqualTo("CHINA");
        assertThat(car.getNumberOfSeats()).isEqualTo(carDTO.getSeatCount());
        assertThat(car.getName()).isEqualTo(carDTO.getName());
        assertThat(car.getCreateDate()).isEqualTo(carDTO.getCreateDate());

        assertThat(car.getPerson().getFullName()).isEqualTo(carDTO.getPersonDTO().getUserName());
        assertThat(car.getPerson().getPhone()).isEqualTo(carDTO.getPersonDTO().getPhoneNumber());
    }

}

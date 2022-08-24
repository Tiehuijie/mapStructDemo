package mapStructDemo.mappers;


import mapStructDemo.sourceDto.Car;
import mapStructDemo.targetDto.CarDTO;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static mapStructDemo.mappers.CarConstantAndDefaultValueMapper.CAR_CONSTANT_AND_DEFAULT_VALUE_MAPPER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarConstantAndDefaultValueMapperTest {

    @Test
    void should_set_default_and_constant_value_with_mapper_when_call_toCarDto_with_car_has_null() {
        Car car = Car.builder()
                .numberOfSeats(null)
                .person(Car.Person.builder().phone("111").fullName("zhangsan").build())
                .build();
        CarDTO carDTO = CAR_CONSTANT_AND_DEFAULT_VALUE_MAPPER.toCarDto(car);

        assertThat(carDTO.getManufacturer()).isEqualTo("make");
        assertThat(carDTO.getSeatCount()).isEqualTo(-1);
        assertThat(carDTO.getCreateDate()).isEqualTo(new Date(1560839400000L));
    }

}

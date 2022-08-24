package mapStructDemo.mappers;

import mapStructDemo.sourceDto.CarWithDate;
import mapStructDemo.targetDto.CarWithStringDTO;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static mapStructDemo.mappers.CarMapperWithDate.CAR_MAPPER_WITH_DATE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarMapperWithDateTest {
    @Test
    void should_create_carDto_when_call_carMapper_with_car() {
        CarWithDate carWithDate = CarWithDate.builder()
                .createDate(new Date(1560839400000L))
                .build();

        CarWithStringDTO carWithStringDTO = CAR_MAPPER_WITH_DATE.toCarWithStringDto(carWithDate);

        assertThat(carWithStringDTO.getCreateDate()).isEqualTo("2019-06-18");

    }

}

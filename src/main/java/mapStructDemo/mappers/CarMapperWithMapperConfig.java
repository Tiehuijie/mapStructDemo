package mapStructDemo.mappers;

import mapStructDemo.config.CentralConfig;
import mapStructDemo.sourceDto.CarWithDate;
import mapStructDemo.targetDto.CarWithStringDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = CentralConfig.class)
public interface CarMapperWithMapperConfig {
    CarMapperWithMapperConfig CAR_MAPPER_WITH_MAPPER_CONFIG = Mappers.getMapper(CarMapperWithMapperConfig.class);

    CarWithStringDTO toCarWithStringDto(CarWithDate carWithDate);
}

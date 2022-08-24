package mapStructDemo.mappers;

import mapStructDemo.sourceDto.CarWithDate;
import mapStructDemo.targetDto.CarWithStringDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarMapperWithDate {
    CarMapperWithDate CAR_MAPPER_WITH_DATE = Mappers.getMapper(CarMapperWithDate.class);

    CarWithStringDTO toCarWithStringDto(CarWithDate carWithDate);
}

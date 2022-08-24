package mapStructDemo.mappers;

import mapStructDemo.exception.InvalidMapperException;
import mapStructDemo.sourceDto.Car;
import mapStructDemo.targetDto.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarConstantAndDefaultValueMapper {
    CarConstantAndDefaultValueMapper CAR_CONSTANT_AND_DEFAULT_VALUE_MAPPER = Mappers.getMapper(CarConstantAndDefaultValueMapper.class);

    @Mapping(target = "manufacturer", constant = "make")
    @Mapping(target = "seatCount", source = "numberOfSeats", defaultValue = "-1")
    @Mapping(target = "createDate", expression = "java(new java.util.Date(1560839400000L))")
    @Mapping(target = "personDTO", source = "person")
    CarDTO toCarDto(Car car) throws InvalidMapperException;

    default CarDTO.PersonDTO toPersonDto(Car.Person person) {
        return CarDTO.PersonDTO
                .builder()
                .userName(person.getFullName())
                .phoneNumber(person.getPhone())
                .build();
    }
}

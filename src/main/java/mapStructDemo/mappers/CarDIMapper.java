package mapStructDemo.mappers;

import mapStructDemo.sourceDto.Car;
import mapStructDemo.targetDto.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface CarDIMapper {

    @Mapping(target = "manufacturer", source = "make")
    @Mapping(target = "seatCount", source = "numberOfSeats")
    @Mapping(target = "personDTO", source = "person")
    CarDTO toCarDto(Car car);

    default CarDTO.PersonDTO toPersonDto(Car.Person person) {
        return CarDTO.PersonDTO
                .builder()
                .userName(person.getFullName())
                .phoneNumber(person.getPhone())
                .build();
    }
}

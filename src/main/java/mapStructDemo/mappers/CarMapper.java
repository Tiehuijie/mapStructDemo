package mapStructDemo.mappers;

import mapStructDemo.sourceDto.Car;
import mapStructDemo.targetDto.CarDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper CAR_MAPPER = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "manufacturer", constant = "make")
    @Mapping(target = "seatCount", source = "numberOfSeats")
    @Mapping(target = "personDTO", source = "person")
    CarDTO toCarDto(Car car);

    @Mapping(target = "seatCount", constant = "1")
    CarDTO carDtoIntoCar2(Car car);

    @InheritConfiguration(name = "toCarDto")
    @Mapping(target = "manufacturer", constant = "testManufacturer")
    void carDtoIntoCar(Car car, @MappingTarget CarDTO carDTO);

    @InheritInverseConfiguration(name = "toCarDto")
    Car carDtoToCar(CarDTO carDto);

    default CarDTO.PersonDTO toPersonDto(Car.Person person) {
        return CarDTO.PersonDTO
                .builder()
                .userName(person.getFullName())
                .phoneNumber(person.getPhone())
                .build();
    }

    @Mapping(source = "userName", target = "fullName")
    @Mapping(source = "phoneNumber", target = "phone")
    Car.Person toPerson(CarDTO.PersonDTO personDTO);
}

package mapStructDemo.mappers.beforeOrAfterMapper;

import mapStructDemo.sourceDto.Person;
import mapStructDemo.targetDto.PersonDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper
public interface PersonBeforeOrAfterMapper {
    PersonBeforeOrAfterMapper PERSON_BEFORE_OR_AFTER_MAPPER = Mappers.getMapper( PersonBeforeOrAfterMapper.class );

    PersonDto personToPersonDto(Person person);

    @BeforeMapping
    default PersonDto toDTOBefore(Person person) {
        if (Objects.isNull(person)) {
            return PersonDto.builder()
                    .fullName("zhang san")
                    .build();
        }
        return PersonDto.builder().fullName(person.getFirstName() + " " + person.getLastName()).build();
    }

    @AfterMapping //后置执行
    default void toDTOAfter(Person person, @MappingTarget PersonDto personDto) {
        personDto.setFullName(person.getFirstName() + " " + person.getLastName());
    }

}

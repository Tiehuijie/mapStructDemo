package mapStructDemo.mappers.decorateMapper;

import mapStructDemo.sourceDto.Person;
import mapStructDemo.targetDto.PersonDto;
import org.junit.jupiter.api.Test;

import static mapStructDemo.mappers.decorateMapper.PersonMapper.PERSON_MAPPER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PersonMapperDecoratorTest {

    PersonMapperDecorator personMapperDecorator = new PersonMapperDecorator(PERSON_MAPPER);

    @Test
    void should_mapp_personDto_fullName_with_person_firstName_and_lastName() {
        PersonDto personDto = personMapperDecorator.personToPersonDto(Person.builder()
                        .firstName("zhang")
                        .lastName("san")
                .build());

        assertThat(personDto.getFullName()).isEqualTo("zhang san");
    }

}

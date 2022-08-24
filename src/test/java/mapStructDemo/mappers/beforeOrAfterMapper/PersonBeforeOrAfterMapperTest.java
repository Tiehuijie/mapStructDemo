package mapStructDemo.mappers.beforeOrAfterMapper;

import mapStructDemo.sourceDto.Person;
import mapStructDemo.targetDto.PersonDto;
import org.junit.jupiter.api.Test;

import static mapStructDemo.mappers.beforeOrAfterMapper.PersonBeforeOrAfterMapper.PERSON_BEFORE_OR_AFTER_MAPPER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PersonBeforeOrAfterMapperTest {

    @Test
    void should_mapp_personDto_fullName_with_person_firstName_and_lastName() {
        PersonDto personDto = PERSON_BEFORE_OR_AFTER_MAPPER.personToPersonDto(Person.builder()
                .firstName("li")
                .lastName("si")
                .build());

        assertThat(personDto.getFullName()).isEqualTo("li si");
    }


}

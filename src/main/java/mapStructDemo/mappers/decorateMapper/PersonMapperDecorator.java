package mapStructDemo.mappers.decorateMapper;

import mapStructDemo.sourceDto.Person;
import mapStructDemo.targetDto.PersonDto;

public class PersonMapperDecorator implements PersonMapper{
    private final PersonMapper personMapper;

    public PersonMapperDecorator(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @Override
    public PersonDto personToPersonDto(Person person) {
        PersonDto dto = personMapper.personToPersonDto( person );
        dto.setFullName( person.getFirstName() + " " + person.getLastName() );
        return dto;
    }
}

package mapStructDemo.mappers.decorateMapper;

import mapStructDemo.sourceDto.Person;
import mapStructDemo.targetDto.PersonDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(PersonMapperDecorator.class)
public interface PersonMapper {
    PersonMapper PERSON_MAPPER = Mappers.getMapper( PersonMapper.class );

    PersonDto personToPersonDto(Person person);

}

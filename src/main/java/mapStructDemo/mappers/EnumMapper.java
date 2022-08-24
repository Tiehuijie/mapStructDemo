package mapStructDemo.mappers;

import mapStructDemo.enums.ExtraOrderType;
import mapStructDemo.enums.OrderType;
import mapStructDemo.sourceDto.User;
import mapStructDemo.targetDto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Mapper
public interface EnumMapper {
    EnumMapper ENUM_MAPPER = Mappers.getMapper(EnumMapper.class);

    @ValueMappings({
            @ValueMapping( source = MappingConstants.NULL, target = "DEFAULT" ),
            @ValueMapping( source = "STANDARD", target = MappingConstants.NULL ),
            @ValueMapping( source = MappingConstants.ANY_REMAINING, target = "SPECIAL" )
    })
    ExtraOrderType getExtraOrderType(OrderType orderType);
}

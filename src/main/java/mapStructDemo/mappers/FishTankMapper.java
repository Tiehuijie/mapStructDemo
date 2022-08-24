package mapStructDemo.mappers;

import mapStructDemo.sourceDto.FishTank;
import mapStructDemo.targetDto.FishTankDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FishTankMapper {
    FishTankMapper FISH_TANK_MAPPER = Mappers.getMapper(FishTankMapper.class);

    @Mapping(target = "fish.kind", source = "fish.type")
    @Mapping(target = "fish.name", expression = "java(\"Jaws\")")
    @Mapping(target = "quality.document", source = "quality.report")
    @Mapping(target = "quality.document.organisation.name", constant = "NoIdeaInc" )
    FishTankDTO toFishTankDTO(FishTank source );
}

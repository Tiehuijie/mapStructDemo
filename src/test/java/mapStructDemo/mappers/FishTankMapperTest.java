package mapStructDemo.mappers;

import mapStructDemo.sourceDto.FishTank;
import mapStructDemo.targetDto.FishTankDTO;
import org.junit.jupiter.api.Test;

import static mapStructDemo.mappers.FishTankMapper.FISH_TANK_MAPPER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FishTankMapperTest {

    @Test
    void should_create_carDto_when_call_carMapper_with_car() {
        FishTank fishTank = FishTank.builder()
                .plant("IOS")
                .material("material")
                .ornament("ornament")
                .fish(FishTank.Fish.builder().name("liyu").type("common").build())
                .quality(FishTank.Quality.builder().report(FishTank.Quality.Report.builder().fileName("test.doc").build()).build())
                .build();
        FishTankDTO fishTankDTO = FISH_TANK_MAPPER.toFishTankDTO(fishTank);

        assertThat(fishTankDTO.getMaterial()).isEqualTo(fishTank.getMaterial());
        assertThat(fishTankDTO.getPlant()).isEqualTo(fishTank.getPlant());
        assertThat(fishTankDTO.getOrnament()).isEqualTo(fishTank.getOrnament());
        assertThat(fishTankDTO.getFish().getKind()).isEqualTo(fishTank.getFish().getType());
        assertThat(fishTankDTO.getFish().getName()).isEqualTo("Jaws");
        assertThat(fishTankDTO.getQuality().getDocument().getFileName()).isEqualTo(fishTank.getQuality().getReport().getFileName());
        assertThat(fishTankDTO.getQuality().getDocument().getOrganisation().getName()).isEqualTo("NoIdeaInc");
    }
}

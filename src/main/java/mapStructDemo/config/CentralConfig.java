package mapStructDemo.config;

import mapStructDemo.mappers.DateMapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;


@MapperConfig(
        uses = DateMapper.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CentralConfig {
}

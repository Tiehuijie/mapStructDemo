package mapStructDemo.mappers;

import mapStructDemo.enums.ExtraOrderType;
import mapStructDemo.enums.OrderType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static mapStructDemo.mappers.EnumMapper.ENUM_MAPPER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EnumMapperTest {

    @ParameterizedTest
    @CsvSource({
            "OFFLINE, OFFLINE",
            "WECHAT, WECHAT",
            "WEBSITE, WEBSITE",
            "OTHERS, SPECIAL"
    })
    void should_return_ExtraOrderType_when_call_getExtraOrderType_given_OrderType(OrderType orderType, ExtraOrderType extraOrderTypeTarget) {
        ExtraOrderType extraOrderType = ENUM_MAPPER.getExtraOrderType(orderType);

        assertThat(extraOrderType).isEqualTo(extraOrderTypeTarget);
    }

    @Test
    void should_return_DEFAULT_when_call_getExtraOrderType_given_OrderType_is_null() {
        ExtraOrderType extraOrderType = ENUM_MAPPER.getExtraOrderType(null);

        assertThat(extraOrderType).isEqualTo(ExtraOrderType.DEFAULT);
    }

    @Test
    void should_return_null_when_call_getExtraOrderType_given_OrderType_is_STANDARD() {
        ExtraOrderType extraOrderType = ENUM_MAPPER.getExtraOrderType(OrderType.STANDARD);

        assertThat(extraOrderType).isNull();
    }

}

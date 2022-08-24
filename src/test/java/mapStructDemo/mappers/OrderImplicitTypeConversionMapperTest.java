package mapStructDemo.mappers;

import mapStructDemo.enums.Gender;
import mapStructDemo.enums.OrderType;
import mapStructDemo.sourceDto.Order;
import mapStructDemo.targetDto.OrderDTO;
import org.junit.jupiter.api.Test;

import static mapStructDemo.mappers.OrderImplicitTypeConversionMapper.ORDER_IMPLICIT_TYPE_CONVERSION_MAPPER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrderImplicitTypeConversionMapperTest {

    @Test
    void should_create_OrderDto_when_call_OrderImplicitConversionMapper_with_Order() {
        Order order = Order.builder()
                .orderId(1)
                .orderNumber(123)
                .canceled(false)
                .price(1.12)
                .amount(1)
                .orderType(OrderType.OFFLINE)
                .customerInfo(Order.CustomerInfo.builder()
                        .name("zhangsan")
                        .gender(Gender.MALE)
                        .telephone("111111111111111")
                        .build())
                .build();
        OrderDTO orderDTO = ORDER_IMPLICIT_TYPE_CONVERSION_MAPPER.toOrderDto(order);

        assertThat(orderDTO.getOrderId()).isEqualTo(1L);
        assertThat(orderDTO.getOrderNumber()).isEqualTo(Integer.valueOf(123));
        assertThat(orderDTO.getCanceled()).isEqualTo(Boolean.FALSE);
        assertThat(orderDTO.getPrice()).isEqualTo(Double.valueOf(1.12));
        assertThat(orderDTO.getAmount()).isEqualTo("1");
        assertThat(orderDTO.getOrderType()).isEqualTo("OFFLINE");

        assertThat(orderDTO.getCustomerInfo().getGender()).isEqualTo(Gender.MALE.name());
        assertThat(orderDTO.getCustomerInfo().getCustomerName()).isEqualTo("zhangsan");
        assertThat(orderDTO.getCustomerInfo().getTelephone()).isEqualTo("111111111111111");
    }

    @Test
    void should_create_Order_when_call_OrderImplicitConversionMapper_with_OrderDTO() {
        OrderDTO orderDTO = OrderDTO.builder()
                .orderId(1L)
                .orderNumber(123)
                .canceled(Boolean.FALSE)
                .price(1.12)
                .build();
        Order order = ORDER_IMPLICIT_TYPE_CONVERSION_MAPPER.toOrder(orderDTO);

        assertThat(order.getOrderId()).isEqualTo(1);
        assertThat(order.getOrderNumber()).isEqualTo(123);
        assertThat(orderDTO.getCanceled()).isEqualTo(false);
        assertThat(orderDTO.getPrice()).isEqualTo(1.12);
    }

}

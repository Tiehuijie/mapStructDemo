package mapStructDemo.mappers;

import mapStructDemo.sourceDto.Order;
import mapStructDemo.targetDto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderImplicitTypeConversionMapper {
    OrderImplicitTypeConversionMapper ORDER_IMPLICIT_TYPE_CONVERSION_MAPPER = Mappers.getMapper(OrderImplicitTypeConversionMapper.class);

    OrderDTO toOrderDto(Order order);

    Order toOrder(OrderDTO orderDTO);

    @Mapping(source = "name", target = "customerName")
    OrderDTO.CustomerInfoDTO toCustomerInfoDTO(Order.CustomerInfo customerInfo);

    @Mapping(source = "customerName", target = "name")
    Order.CustomerInfo toCustomerInfo(OrderDTO.CustomerInfoDTO customerInfoDTO);
}

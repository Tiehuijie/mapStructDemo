package mapStructDemo.mappers;

import mapStructDemo.sourceDto.User;
import mapStructDemo.targetDto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Mapper
public interface UserCollectionsMapper {
    UserCollectionsMapper USER_COLLECTIONS_MAPPER = Mappers.getMapper(UserCollectionsMapper.class);

    List<UserDTO> toUserDTOS(List<User> cars);

    Set<UserDTO> toUserDtoSet(Set<User> users);

    Set<UserDTO> toUserDtoSet(List<User> users);

    Map<Integer, UserDTO> toUserDtoMap(Map<Integer, User> userMap);

    List<UserDTO> toUserListWithStream(Stream<User> userStream);

    @Mapping(source = "userId", target = "id")
    UserDTO toUserDto(User user);

    @Mapping(source = "orderId", target = "orderNumber")
    UserDTO.Order toUserDtoOrder(User.Order order);
}

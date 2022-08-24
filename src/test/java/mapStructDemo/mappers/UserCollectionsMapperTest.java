package mapStructDemo.mappers;

import mapStructDemo.sourceDto.User;
import mapStructDemo.targetDto.UserDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static mapStructDemo.mappers.UserCollectionsMapper.USER_COLLECTIONS_MAPPER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserCollectionsMapperTest {

    @Test
    void should_return_user_list_with_mapper_for_list() {
        User user1 = User.builder()
                .name("zhangsan")
                .orderList(Arrays.asList(User.Order.builder().orderId("123").id(1).build(), User.Order.builder().orderId("234").id(2).build()))
                .build();

        User user2 = User.builder()
                .name("lisi")
                .orderList(Arrays.asList(User.Order.builder().orderId("345").id(3).build()))
                .build();

        List<UserDTO> userDTOS = USER_COLLECTIONS_MAPPER.toUserDTOS(Arrays.asList(user1, user2));

        assertThat(userDTOS.size()).isEqualTo(2);
        assertThat(userDTOS.get(0).getName()).isEqualTo("zhangsan");
        assertThat(userDTOS.get(0).getOrderList().size()).isEqualTo(2);
        assertThat(userDTOS.get(0).getOrderList().get(0).getId()).isEqualTo(1);
        assertThat(userDTOS.get(0).getOrderList().get(1).getId()).isEqualTo(2);
    }


    @Test
    void should_return_user_set_with_mapper_for_set() {
        User user1 = User.builder()
                .name("zhangsan")
                .orderList(Arrays.asList(User.Order.builder().orderId("123").id(1).build(), User.Order.builder().orderId("234").id(2).build()))
                .build();

        User user2 = User.builder()
                .name("lisi")
                .orderList(Arrays.asList(User.Order.builder().orderId("345").id(3).build()))
                .build();

        Set<UserDTO> userDTOS = USER_COLLECTIONS_MAPPER.toUserDtoSet(Arrays.asList(user1, user2));

        assertThat(userDTOS.size()).isEqualTo(2);
    }

    @Test
    void should_return_user_map_with_mapper_for_map() {
        User user1 = User.builder()
                .userId(1)
                .name("zhangsan")
                .orderList(Arrays.asList(User.Order.builder().orderId("123").id(1).build(), User.Order.builder().orderId("234").id(2).build()))
                .build();

        User user2 = User.builder()
                .userId(2)
                .name("lisi")
                .orderList(Arrays.asList(User.Order.builder().orderId("345").id(3).build()))
                .build();

        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(user1.getUserId(), user1);
        userMap.put(user2.getUserId(), user2);

        Map<Integer, UserDTO> userDTOS = USER_COLLECTIONS_MAPPER.toUserDtoMap(userMap);

        assertThat(userDTOS.size()).isEqualTo(2);
        assertThat(userDTOS.get(1).getId()).isEqualTo(1);
        assertThat(userDTOS.get(1).getName()).isEqualTo("zhangsan");
        assertThat(userDTOS.get(1).getOrderList().size()).isEqualTo(2);
        assertThat(userDTOS.get(1).getOrderList().get(0).getOrderNumber()).isEqualTo("123");
    }

    @Test
    void should_return_user_list_with_mapper_for_Stream() {
        User user1 = User.builder()
                .userId(1)
                .name("zhangsan")
                .orderList(Arrays.asList(User.Order.builder().orderId("123").id(1).build(), User.Order.builder().orderId("234").id(2).build()))
                .build();

        User user2 = User.builder()
                .userId(2)
                .name("lisi")
                .orderList(Arrays.asList(User.Order.builder().orderId("345").id(3).build()))
                .build();

        List<UserDTO> userDTOS = USER_COLLECTIONS_MAPPER.toUserListWithStream(Stream.of(user1, user2));

        assertThat(userDTOS.size()).isEqualTo(2);
        assertThat(userDTOS.get(0).getName()).isEqualTo("zhangsan");
        assertThat(userDTOS.get(0).getOrderList().size()).isEqualTo(2);
        assertThat(userDTOS.get(0).getOrderList().get(0).getId()).isEqualTo(1);
        assertThat(userDTOS.get(0).getOrderList().get(1).getId()).isEqualTo(2);
    }

}

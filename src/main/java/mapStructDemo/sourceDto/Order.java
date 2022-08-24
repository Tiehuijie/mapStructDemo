package mapStructDemo.sourceDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mapStructDemo.enums.Gender;
import mapStructDemo.enums.OrderType;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order {
    private int orderNumber;
    private boolean canceled;
    private long orderId;
    private double price;
    private int amount;
    private OrderType orderType;
    private CustomerInfo customerInfo;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class CustomerInfo {
        private String name;
        private String telephone;
        private Gender gender;
    }
}

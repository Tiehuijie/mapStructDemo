package mapStructDemo.targetDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mapStructDemo.enums.Gender;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDTO {
    private Integer orderNumber;
    private Boolean canceled;
    private Long orderId;
    private Double price;
    private String amount;
    private String orderType;
    private CustomerInfoDTO customerInfo;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class CustomerInfoDTO {
        private String customerName;
        private String telephone;
        private String gender;
    }
}

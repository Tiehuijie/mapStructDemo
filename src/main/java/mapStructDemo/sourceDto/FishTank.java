package mapStructDemo.sourceDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FishTank {
    private String plant;
    private String ornament;
    private String material;

    private Fish fish;
    private Quality quality;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Fish {
        private String type;
        private String name;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Quality{
        private Report report;

        @AllArgsConstructor
        @NoArgsConstructor
        @Getter
        @Setter
        @Builder
        public static class Report {
            private String fileName;
        }

    }
}

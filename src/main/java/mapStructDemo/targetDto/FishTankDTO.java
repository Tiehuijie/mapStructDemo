package mapStructDemo.targetDto;

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
public class FishTankDTO {
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
        private String kind;
        private String name;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Quality{
        private Document document;

        @AllArgsConstructor
        @NoArgsConstructor
        @Getter
        @Setter
        @Builder
        public static class Document {
            private String fileName;
            private Organisation organisation;

            @AllArgsConstructor
            @NoArgsConstructor
            @Getter
            @Setter
            @Builder
            public static class Organisation {
                private String name;
            }
        }

    }
}

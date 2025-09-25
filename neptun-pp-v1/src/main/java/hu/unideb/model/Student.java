package hu.unideb.model;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Student {
    @EqualsAndHashCode.Include
    private String neptun;
    private String name;
    private Program program;
    private OffsetDateTime created;
    private OffsetDateTime updated;

    public enum Program {
        CS_BSC,
        CSE_BSC,
        BI_BSC;

        private static final Random RANDOM = new Random();

        public static Program radom(){
            int position = RANDOM.nextInt(Program.values().length);
            return Program.values()[position];
        }
    }
}

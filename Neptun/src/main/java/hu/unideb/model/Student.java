package hu.unideb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {
    @EqualsAndHashCode.Include
    private String neptun;
    private String name;
    private Program program;
    private OffsetDateTime created;
    private OffsetDateTime updated;

    public enum Program{
        @JsonProperty("PTI BSc")
        CS_BSC,
        CSE_BSC,
        BI_BSC
    }



}

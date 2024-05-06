package hu.gde.ks.futoverseny.futoverseny.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VersenyDto {
    private Long id;
    private String name;
    private Integer distance;
}

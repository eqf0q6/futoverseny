package hu.gde.ks.futoverseny.futoverseny.dto;

import hu.gde.ks.futoverseny.futoverseny.models.Futo;
import hu.gde.ks.futoverseny.futoverseny.models.Verseny;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EredmenyDto {

    private Long id;
    private Integer eredmeny;


    private Futo resztvevo;


    private Verseny verseny;
}

package hu.gde.ks.futoverseny.futoverseny.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Eredmenyek")
public class Eredmeny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer eredmeny;

    @ManyToOne
    @JoinColumn(name = "resztvevo_id")
    private Futo resztvevo;

    @ManyToOne
    @JoinColumn(name = "verseny_id")
    private Verseny verseny;
}

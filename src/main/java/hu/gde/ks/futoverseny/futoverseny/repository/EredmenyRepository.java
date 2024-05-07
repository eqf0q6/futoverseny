package hu.gde.ks.futoverseny.futoverseny.repository;

import hu.gde.ks.futoverseny.futoverseny.dto.EredmenyDto;
import hu.gde.ks.futoverseny.futoverseny.models.Eredmeny;
import hu.gde.ks.futoverseny.futoverseny.models.Verseny;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EredmenyRepository extends JpaRepository<Eredmeny, Long> {

}

package hu.gde.ks.futoverseny.futoverseny.repository;

import hu.gde.ks.futoverseny.futoverseny.models.Eredmeny;
import hu.gde.ks.futoverseny.futoverseny.models.Verseny;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EredmenyRepository extends JpaRepository<Eredmeny, Long> {

}

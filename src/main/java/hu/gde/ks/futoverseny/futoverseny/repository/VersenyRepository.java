package hu.gde.ks.futoverseny.futoverseny.repository;

import hu.gde.ks.futoverseny.futoverseny.models.Futo;
import hu.gde.ks.futoverseny.futoverseny.models.Verseny;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VersenyRepository extends JpaRepository<Verseny, Long> {

}

package hu.gde.ks.futoverseny.futoverseny.repository;

import hu.gde.ks.futoverseny.futoverseny.models.Futo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FutoRepository extends JpaRepository<Futo, Long> {
    Optional<Futo> findByName(String url);
}

package hu.gde.ks.futoverseny.futoverseny.service;

import hu.gde.ks.futoverseny.futoverseny.dto.FutoDto;
import hu.gde.ks.futoverseny.futoverseny.models.Futo;

import java.util.List;


public interface FutoService {
    List<FutoDto> findAllFuto();

    Futo saveFuto(Futo futo);
}

package hu.gde.ks.futoverseny.futoverseny.service;

import hu.gde.ks.futoverseny.futoverseny.dto.EredmenyDto;
import hu.gde.ks.futoverseny.futoverseny.dto.VersenyDto;

import java.util.List;


public interface EredmenyService {
    List<EredmenyDto> findAllEredmeny();

//    Futo saveFuto(Futo futo);
//
//    FutoDto findFutoById(long futoId);
//
//    void updateFuto(FutoDto futo);
}

package hu.gde.ks.futoverseny.futoverseny.service;

import hu.gde.ks.futoverseny.futoverseny.dto.VersenyDto;
import hu.gde.ks.futoverseny.futoverseny.models.Verseny;

import java.util.List;


public interface VersenyService {
    List<VersenyDto> findAllVerseny();

    Verseny saveVerseny(Verseny verseny);

    VersenyDto findVersenyById(long versenyId);
//
//    void updateFuto(FutoDto futo);
}

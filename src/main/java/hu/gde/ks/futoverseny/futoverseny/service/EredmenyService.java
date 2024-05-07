package hu.gde.ks.futoverseny.futoverseny.service;

import hu.gde.ks.futoverseny.futoverseny.dto.EredmenyDto;
import hu.gde.ks.futoverseny.futoverseny.models.Eredmeny;

import java.util.List;


public interface EredmenyService {
    List<EredmenyDto> findAllEredmenyByVersenyId(long versenyId);

    Eredmeny saveEredmeny(Eredmeny eredmeny);

}

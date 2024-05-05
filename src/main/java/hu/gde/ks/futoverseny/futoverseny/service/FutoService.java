package hu.gde.ks.futoverseny.futoverseny.service;

import hu.gde.ks.futoverseny.futoverseny.dto.FutoDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FutoService {
    List<FutoDto> findAllFuto();
}

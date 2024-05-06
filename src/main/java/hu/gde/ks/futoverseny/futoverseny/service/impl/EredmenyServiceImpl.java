package hu.gde.ks.futoverseny.futoverseny.service.impl;

import hu.gde.ks.futoverseny.futoverseny.dto.EredmenyDto;
import hu.gde.ks.futoverseny.futoverseny.dto.VersenyDto;
import hu.gde.ks.futoverseny.futoverseny.models.Eredmeny;
import hu.gde.ks.futoverseny.futoverseny.models.Verseny;
import hu.gde.ks.futoverseny.futoverseny.repository.EredmenyRepository;
import hu.gde.ks.futoverseny.futoverseny.service.EredmenyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EredmenyServiceImpl implements EredmenyService {
    private EredmenyRepository eredmenyRepository;

    @Autowired
    public EredmenyServiceImpl(EredmenyRepository eredmenyRepository) {
        this.eredmenyRepository = eredmenyRepository;
    }

//    @Override
//    public List<FutoDto> findAllFuto() {
//        List<Futo> futok = futoRepository.findAll();
//        return futok.stream().map(futo -> mapToFutoDto(futo)).collect(Collectors.toList());
//    }

    @Override
    public List<EredmenyDto> findAllEredmeny() {
        List<Eredmeny> eredmenyek = eredmenyRepository.findAll();
        return eredmenyek.stream().map(eredmeny -> mapEredmenyToEredmenyDto(eredmeny)).collect(Collectors.toList());
    }

//    @Override
//    public Futo saveFuto(Futo futo) {
//        return futoRepository.save(futo);
//    }
//
//    @Override
//    public FutoDto findFutoById(long futoId) {
//        Futo futo = futoRepository.findById(futoId).get();
//        return mapToFutoDto(futo);
//    }
//
//    @Override
//    public void updateFuto(FutoDto futoDto) {
//        Futo futo = mapToClub(futoDto);
//        futoRepository.save(futo);
//    }

    private Eredmeny mapToVerseny(EredmenyDto eredmenyDto) {
        Eredmeny eredmeny = Eredmeny.builder()
                .id(eredmenyDto.getId())
                .verseny(eredmenyDto.getVerseny())
                .resztvevo(eredmenyDto.getResztvevo())
                .eredmeny(eredmenyDto.getEredmeny())
                .build();
        return eredmeny;
    }

    public EredmenyDto mapEredmenyToEredmenyDto(Eredmeny eredmeny) {
        EredmenyDto eredmenyDto = EredmenyDto.builder()
                .id(eredmeny.getId())
                .verseny(eredmeny.getVerseny())
                .resztvevo(eredmeny.getResztvevo())
                .eredmeny(eredmeny.getEredmeny())
                .build();
        return eredmenyDto;
    }
}

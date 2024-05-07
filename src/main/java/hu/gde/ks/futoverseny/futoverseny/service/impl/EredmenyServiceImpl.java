package hu.gde.ks.futoverseny.futoverseny.service.impl;

import hu.gde.ks.futoverseny.futoverseny.dto.EredmenyDto;
import hu.gde.ks.futoverseny.futoverseny.models.Eredmeny;
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

    @Override
    public List<EredmenyDto> findAllEredmenyByVersenyId(long versenyId) {
        List<Eredmeny> eredmenyek = eredmenyRepository.findAll();
        eredmenyek = eredmenyek.stream().filter(eredmeny -> eredmeny.getVerseny().getId().equals(versenyId)).toList();
        return eredmenyek.stream().map(eredmeny -> mapEredmenyToEredmenyDto(eredmeny)).collect(Collectors.toList());
    }

    @Override
    public Eredmeny saveEredmeny(Eredmeny eredmeny) {
        return eredmenyRepository.save(eredmeny);
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

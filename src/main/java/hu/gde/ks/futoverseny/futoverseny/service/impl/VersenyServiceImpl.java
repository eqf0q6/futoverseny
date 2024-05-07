package hu.gde.ks.futoverseny.futoverseny.service.impl;

import hu.gde.ks.futoverseny.futoverseny.dto.VersenyDto;
import hu.gde.ks.futoverseny.futoverseny.models.Verseny;
import hu.gde.ks.futoverseny.futoverseny.repository.VersenyRepository;
import hu.gde.ks.futoverseny.futoverseny.service.VersenyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VersenyServiceImpl implements VersenyService {
    private VersenyRepository versenyRepository;

    @Autowired
    public VersenyServiceImpl(VersenyRepository versenyRepository) {
        this.versenyRepository = versenyRepository;
    }

    @Override
    public List<VersenyDto> findAllVerseny() {
        List<Verseny> versenyek = versenyRepository.findAll();
        return versenyek.stream().map(verseny -> mapVersenyToVersenyDto(verseny)).collect(Collectors.toList());
    }

    @Override
    public Verseny saveVerseny(Verseny verseny) {
        return versenyRepository.save(verseny);
    }


    public VersenyDto mapVersenyToVersenyDto(Verseny verseny) {
        VersenyDto versenyDto = VersenyDto.builder()
                .id(verseny.getId())
                .distance(verseny.getDistance())
                .name(verseny.getName())
                .build();
        return versenyDto;
    }
}

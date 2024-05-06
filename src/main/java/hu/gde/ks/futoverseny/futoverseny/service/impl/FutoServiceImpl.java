package hu.gde.ks.futoverseny.futoverseny.service.impl;

import hu.gde.ks.futoverseny.futoverseny.dto.FutoDto;
import hu.gde.ks.futoverseny.futoverseny.models.Futo;
import hu.gde.ks.futoverseny.futoverseny.repository.FutoRepository;
import hu.gde.ks.futoverseny.futoverseny.service.FutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FutoServiceImpl implements FutoService {
    private FutoRepository futoRepository;

    @Autowired
    public FutoServiceImpl(FutoRepository futoRepository) {
        this.futoRepository = futoRepository;
    }

    @Override
    public List<FutoDto> findAllFuto() {
        List<Futo> futok = futoRepository.findAll();
        return futok.stream().map(futo -> mapToFutoDto(futo)).collect(Collectors.toList());
    }

    @Override
    public Futo saveFuto(Futo futo) {
        return futoRepository.save(futo);
    }

    public FutoDto mapToFutoDto(Futo futo) {
        FutoDto futoDto = FutoDto.builder()
                .id(futo.getId())
                .name(futo.getName())
                .age(futo.getAge())
                .gender(futo.getGender())
                .build();
        return futoDto;
    }
}

package hu.gde.ks.futoverseny.futoverseny.controller.rest;

import hu.gde.ks.futoverseny.futoverseny.dto.EredmenyDto;
import hu.gde.ks.futoverseny.futoverseny.models.Eredmeny;
import hu.gde.ks.futoverseny.futoverseny.service.EredmenyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EredmenyRestController {
    private EredmenyService eredmenyService;

    @Autowired
    public EredmenyRestController(EredmenyService eredmenyService) {
        this.eredmenyService = eredmenyService;
    }

    @GetMapping("/getRaceRunners/{versenyId}")
    public List<EredmenyDto> listVersenyDetails(@PathVariable("versenyId") long versenyId, Model model) {
        List<EredmenyDto> eredmenyDto = eredmenyService.findAllEredmenyByVersenyId(versenyId);

        eredmenyDto = eredmenyDto.stream()
                .sorted(Comparator.comparingInt(EredmenyDto::getEredmeny))
                .collect(Collectors.toList());
        return  eredmenyDto;
    }

    @PostMapping(path = "/addResult", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Eredmeny eredmeny) throws Exception {

        //add resource to database
        Eredmeny createdEredmeny = eredmenyService.saveEredmeny(eredmeny);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEredmeny.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/getAverageTime/{versenyId}")
    public double getAveragetime(@PathVariable("versenyId") long versenyId, Model model) {
        List<EredmenyDto> eredmenyDto = eredmenyService.findAllEredmenyByVersenyId(versenyId);

        double sum = eredmenyDto.stream()
                .mapToInt(EredmenyDto::getEredmeny)
                .sum();
        return sum / eredmenyDto.size();
    }
}


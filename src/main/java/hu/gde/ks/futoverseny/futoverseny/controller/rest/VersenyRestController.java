package hu.gde.ks.futoverseny.futoverseny.controller.rest;

import hu.gde.ks.futoverseny.futoverseny.dto.EredmenyDto;
import hu.gde.ks.futoverseny.futoverseny.models.Eredmeny;
import hu.gde.ks.futoverseny.futoverseny.models.Verseny;
import hu.gde.ks.futoverseny.futoverseny.service.EredmenyService;
import hu.gde.ks.futoverseny.futoverseny.service.VersenyService;
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
public class VersenyRestController {
    private VersenyService versenyService;

    @Autowired
    public VersenyRestController(VersenyService versenyService) {
        this.versenyService = versenyService;
    }


    @PatchMapping(path = "/updateRace", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> updateRace(@RequestBody Verseny verseny) throws Exception {

        //add resource to database
        Verseny updateVerseny = versenyService.saveVerseny(verseny);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updateVerseny.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}


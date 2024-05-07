package hu.gde.ks.futoverseny.futoverseny.controller.rest;

import hu.gde.ks.futoverseny.futoverseny.dto.FutoDto;
import hu.gde.ks.futoverseny.futoverseny.models.Futo;
import hu.gde.ks.futoverseny.futoverseny.service.FutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class FutoRestController {
    private FutoService futoService;

    @Autowired
    public FutoRestController(FutoService futoService) {
        this.futoService = futoService;
    }

    @GetMapping("/getRunners")
    public List<FutoDto> getRunners() {
        List<FutoDto> futok = futoService.findAllFuto();
        return futok;

    }

    @PostMapping(path = "/addRunner", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Futo futo) throws Exception {

        //add resource to database
        Futo createdFuto = futoService.saveFuto(futo);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdFuto.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

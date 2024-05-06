package hu.gde.ks.futoverseny.futoverseny.controller;

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

//    @GetMapping("/futok/new")
//    public String createFutoForm(Model model){
//        Futo futo = new Futo();
//        model.addAttribute("futo", futo);
//        return "futo-create";
//    }
//
//    @PostMapping("/futok/new")
//    public String saveFuto(@ModelAttribute("futo") Futo futo){
//        futoService.saveFuto(futo);
//        return "redirect:/futok";
//    }


    @PostMapping(path = "/addRunner", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(
//            @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
//            @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
            @RequestBody Futo futo
    ) throws Exception {

        //validate the employee data if required

        System.out.println("created futo" + futo);

        //add resource to database
        Futo createdFuto = futoService.saveFuto(futo);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdFuto.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

//
//    @GetMapping("/futok/{futoId}/edit")
//    public String editFutoForm(@PathVariable("futoId") long futoId, Model model){
//        FutoDto futo = futoService.findFutoById(futoId);
//        model.addAttribute("futo", futo);
//        return "futo-edit";
//    }
//
//    @PostMapping("/futok/{futoId}/edit")
//    public String updateFuto(@PathVariable("futoId")long futoId, @ModelAttribute("futo") FutoDto futo){
//        futo.setId(futoId);
//        futoService.updateFuto(futo);
//        return "redirect:/futok";
//    }
}

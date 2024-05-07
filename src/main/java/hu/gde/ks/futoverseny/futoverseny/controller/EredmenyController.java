package hu.gde.ks.futoverseny.futoverseny.controller;

import hu.gde.ks.futoverseny.futoverseny.dto.EredmenyDto;
import hu.gde.ks.futoverseny.futoverseny.dto.VersenyDto;
import hu.gde.ks.futoverseny.futoverseny.service.EredmenyService;
import hu.gde.ks.futoverseny.futoverseny.service.VersenyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EredmenyController {
    private EredmenyService eredmenyService;

    @Autowired
    public EredmenyController(EredmenyService eredmenyService) {
        this.eredmenyService = eredmenyService;
    }

    @GetMapping("/eredmeny/{versenyId}")
    public String listVersenyDetails(@PathVariable("versenyId") long versenyId, Model model) {
        List<EredmenyDto> eredmenyDto = eredmenyService.findAllEredmenyByVersenyId(versenyId);
        System.out.println();
        model.addAttribute("eredmenyek",eredmenyDto);
        return "eredmeny-details";
    }

//
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

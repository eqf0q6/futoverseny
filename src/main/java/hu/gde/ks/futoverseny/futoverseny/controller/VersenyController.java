package hu.gde.ks.futoverseny.futoverseny.controller;

import hu.gde.ks.futoverseny.futoverseny.dto.VersenyDto;
import hu.gde.ks.futoverseny.futoverseny.models.Verseny;
import hu.gde.ks.futoverseny.futoverseny.service.VersenyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VersenyController {
    private VersenyService versenyService;

    @Autowired
    public VersenyController(VersenyService versenyService) {
        this.versenyService = versenyService;
    }

    @GetMapping("/versenyek")
    public String listVersenyek(Model model) {
        List<VersenyDto> versenyek = versenyService.findAllVerseny();
        model.addAttribute("versenyek", versenyek);
        System.out.println("XXXX" + versenyek);
        return "verseny-list";
    }

    @GetMapping("/versenyek/new")
    public String createFutoForm(Model model) {
        Verseny verseny = new Verseny();
        model.addAttribute("verseny", verseny);
        return "verseny-create";
    }

    @PostMapping("/verseny/new")
    public String saveVerseny(@ModelAttribute("verseny") Verseny verseny) {
        versenyService.saveVerseny(verseny);
        return "redirect:/versenyek";
    }


}

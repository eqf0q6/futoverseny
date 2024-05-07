package hu.gde.ks.futoverseny.futoverseny.controller;

import hu.gde.ks.futoverseny.futoverseny.dto.EredmenyDto;
import hu.gde.ks.futoverseny.futoverseny.service.EredmenyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("eredmenyek", eredmenyDto);
        return "eredmeny-details";
    }
}

package hu.gde.ks.futoverseny.futoverseny.controller;

import hu.gde.ks.futoverseny.futoverseny.dto.FutoDto;
import hu.gde.ks.futoverseny.futoverseny.service.FutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FutoController {
    private FutoService futoService;

    @Autowired
    public FutoController(FutoService futoService) {
        this.futoService = futoService;
    }

    @GetMapping("/futok")
    public String listFutok(Model model) {
        List<FutoDto> futok = futoService.findAllFuto();
        model.addAttribute("futok",futok);
        return "futo-list";
    }
}

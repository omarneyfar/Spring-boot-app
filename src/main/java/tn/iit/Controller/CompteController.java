package tn.iit.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.iit.entity.Compte;
import tn.iit.service.CompteService;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    private CompteService compteService;

    @Autowired
    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }


    @GetMapping("/edit/{rib}")
    public String showEditCompteForm(@PathVariable Long rib, Model model) {
        Compte compte = compteService.getCompteByRib(rib);
        if (compte != null) {
            model.addAttribute("compte", compte);
            return "editCompte"; // Redirige vers la page d'édition de compte.
        }
        return "redirect:/comptes";
    }

    @PostMapping("/update/{rib}")
    public String updateCompte(@PathVariable Long rib, @ModelAttribute("compte") Compte compte) {
        compte.setRib(rib);
        compteService.updateCompte(compte);
        return "redirect:/comptes";
    }

    @GetMapping("/delete/{rib}")
    public String deleteCompte(@PathVariable Long rib) {
        compteService.deleteCompte(rib);
        return "redirect:/comptes";
    }

    @PostMapping("/save")
    public String saveCompte(@ModelAttribute("compte") Compte compte) {
        compteService.createCompte(compte);
        return "redirect:/comptes";
    }

    @GetMapping("/add")
    public String showAddCompteForm(Model model) {
        model.addAttribute("compte", new Compte());
        return "addCompte"; // Redirige vers la page d'ajout de compte.
    }

}
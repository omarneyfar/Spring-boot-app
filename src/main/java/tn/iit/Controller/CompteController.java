package tn.iit.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.iit.entity.Client;
import tn.iit.entity.Compte;
import tn.iit.service.ClientService;
import tn.iit.service.CompteService;

import java.util.List;

@Controller
@RequestMapping("/comptes")
public class CompteController {

    private CompteService compteService;
    private ClientService clientService;

    @Autowired
    public CompteController(CompteService compteService,ClientService clientService ) {
        this.compteService = compteService;
        this.clientService = clientService;
    }

    @GetMapping
    public String showComptesPage(Model model) {
        List<Compte> comptes = compteService.getAllComptes();
        List<Client> clients = clientService.getAllClients(); // Assuming you have this method in ClientService
        model.addAttribute("comptes", comptes);
        model.addAttribute("clients", clients); // Add clients to the model
        model.addAttribute("compte", new Compte());
        return "comptes";
    }

    @GetMapping("/edit/{rib}")
    public String showEditCompteForm(@PathVariable Long rib, Model model) {
        Compte compte = compteService.getCompteByRib(rib);
        List<Client> clients = clientService.getAllClients(); // Assuming you have this method in ClientService
        model.addAttribute("clients", clients); // Add clients to the model

        if (compte != null) {
            model.addAttribute("compte", compte);
            return "editCompte"; // Redirige vers la page d'édition de compte.
        } else {
            return "redirect:/comptes"; // Redirect if the compte with the given rib does not exist.
        }
    }

    @PostMapping("/update/{rib}")
    public String updateCompte(@PathVariable Long rib, @ModelAttribute("compte") Compte updatedCompte) {
        Compte existingCompte = compteService.getCompteByRib(rib);

        if (existingCompte != null) {
            updatedCompte.setRib(rib); // Set the rib for the updatedCompte.
            compteService.updateCompte(updatedCompte);
        }
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

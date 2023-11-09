package tn.iit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.iit.entity.Client;
import tn.iit.service.ClientService;
import tn.iit.service.CompteService;

import java.util.List;
@Controller
@RequestMapping("/clients")

public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String showClientsPage(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        model.addAttribute("client", new Client());
        return "clients";
    }


    @GetMapping("/edit/{id}")
    public String showEditClientForm(@PathVariable Long id, Model model) {
        Client client = clientService.getClientById(rib);
        if (client != null) {
            model.addAttribute("client", client);
            return "editclient"; // Redirige vers la page d'édition de client.
        }
        return "redirect:/clients";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute("client") Client client) {
        client.setId(id);
        clientService.updateClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }

    @PostMapping("/save")
    public String saveCompte(@ModelAttribute("client") Client client) {
        clientService.createClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/add")
    public String showAddClientForm(Model model) {
        model.addAttribute("client", new client());
        return "addClient"; // Redirige vers la page d'ajout de client.
    }

}
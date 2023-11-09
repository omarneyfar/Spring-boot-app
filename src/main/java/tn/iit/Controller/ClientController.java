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



    @GetMapping("/edit/{cin}")
    public String showEditClientForm(@PathVariable Long cin, Model model) {
        Client client = clientService.getClientByCin(cin);
        if (client != null) {
            model.addAttribute("client", client);
            return "editclient"; // Redirect to the client edit page.
        }
        return "redirect:/clients";
    }

    @PostMapping("/update/{cin}")
    public String updateClient(@PathVariable Long cin, @ModelAttribute("client") Client client) {
        clientService.updateClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{cin}")
    public String deleteClient(@PathVariable Long cin) {
        clientService.deleteClientByCin(cin);
        return "redirect:/clients";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute("client") Client client, Model model) {
        Long cin = client.getCin();

        // Check if a client with the same cin already exists
        if (clientService.getClientByCin(cin) != null) {
            model.addAttribute("error", "Client with the same CIN already exists");
        } else {
            clientService.createClient(client);
        }

        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/add")
    public String showAddClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "addClient"; // Redirige vers la page d'ajout de client.
    }

}
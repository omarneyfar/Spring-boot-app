package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.entity.Client;
import tn.iit.entity.Compte;
import tn.iit.repository.ClientRepository;
import tn.iit.repository.CompteRepository;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Méthode pour récupérer tous les comptes
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Méthode pour récupérer un compte par son rib
    public Client getClientByCin(Long cin) {
        return clientRepository.findById(cin).orElse(null);
    }

    // Méthode pour créer un nouveau compte
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Méthode pour mettre à jour un compte existant
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    // Méthode pour supprimer un compte par son rib
    public void deleteClientByCin(Long cin) {
        clientRepository.deleteById(cin);
    }
}
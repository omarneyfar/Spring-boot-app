package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.entity.Compte;
import tn.iit.repository.CompteRepository;

import java.util.List;

@Service
public class CompteService {

    private CompteRepository compteRepository;

    @Autowired
    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    // Méthode pour récupérer tous les comptes
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    // Méthode pour récupérer un compte par son rib
    public Compte getCompteByRib(Long rib) {
        return compteRepository.findById(rib).orElse(null);
    }

    // Méthode pour créer un nouveau compte
    public Compte createCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    // Méthode pour mettre à jour un compte existant
    public Compte updateCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    // Méthode pour supprimer un compte par son rib
    public void deleteCompte(Long rib) {
        compteRepository.deleteById(rib);
    }
}
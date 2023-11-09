package tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.entity.Client;
import tn.iit.entity.Compte;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
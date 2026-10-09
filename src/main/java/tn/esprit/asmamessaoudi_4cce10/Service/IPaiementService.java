package tn.esprit.asmamessaoudi_4cce10.Service;

import tn.esprit.asmamessaoudi_4cce10.domain.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement findById(Long id);
    List<Paiement> findAll();
}
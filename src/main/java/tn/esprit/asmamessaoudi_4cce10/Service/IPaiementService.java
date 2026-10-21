package tn.esprit.asmamessaoudi_4cce10.Service;

import org.jspecify.annotations.Nullable;
import tn.esprit.asmamessaoudi_4cce10.domain.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement findById(Long id);
    List<Paiement> findAll();
    Paiement update(Long id, Paiement paiement);
    void deleteById(Long id);
    @Nullable Paiement create(Paiement paiement);
}
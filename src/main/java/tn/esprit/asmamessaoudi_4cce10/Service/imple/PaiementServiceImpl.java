package tn.esprit.asmamessaoudi_4cce10.Service.imple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.asmamessaoudi_4cce10.Service.IPaiementService;
import tn.esprit.asmamessaoudi_4cce10.domain.Paiement;
import tn.esprit.asmamessaoudi_4cce10.repository.IPaiementRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository paiementRepository;

    @Override
    public Paiement create(Paiement paiement) {
        if (paiement.getIdPaiement() != null) {
            throw new IllegalArgumentException("Un nouveau paiement ne doit pas avoir d'identifiant");
        }
        verifier(paiement);
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement findById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Paiement introuvable: " + id));
    }

    @Override
    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement update(Long id, Paiement paiement) {
        verifier(paiement);
        Paiement existant = paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé avec l'id : " + id));
        existant.setMontant(paiement.getMontant());
        existant.setDatePaiement(paiement.getDatePaiement());
        existant.setModePaiement(paiement.getModePaiement());
        existant.setContrat(paiement.getContrat());
        return paiementRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!paiementRepository.existsById(id)) {
            throw new NoSuchElementException("Paiement introuvable: " + id);
        }
        paiementRepository.deleteById(id);
    }

    private void verifier(Paiement paiement) {
        if (paiement.getMontant() != null && paiement.getMontant().signum() < 0) {
            throw new IllegalArgumentException("Le montant du paiement ne peut pas être négatif");
        }
    }
}
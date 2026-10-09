package tn.esprit.asmamessaoudi_4cce10.Service.imple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.asmamessaoudi_4cce10.Service.IPaiementService;
import tn.esprit.asmamessaoudi_4cce10.domain.Paiement;
import java.util.NoSuchElementException;
import tn.esprit.asmamessaoudi_4cce10.repository.IPaiementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository paiementRepository;

    @Override
    public Paiement findById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Paiement introuvable: " + id));
    }

    @Override
    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }
}
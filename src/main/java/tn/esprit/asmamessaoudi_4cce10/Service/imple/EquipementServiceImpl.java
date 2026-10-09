package tn.esprit.asmamessaoudi_4cce10.Service.imple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.asmamessaoudi_4cce10.Service.IEquipementService;
import tn.esprit.asmamessaoudi_4cce10.domain.Equipement;

import tn.esprit.asmamessaoudi_4cce10.repository.IEquipementRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final IEquipementRepository equipementRepository;

    @Override
    public Equipement create(Equipement equipement) {
        if (equipement.getIdEquipement() != null) {
            throw new IllegalArgumentException("Un nouvel équipement ne doit pas avoir d'identifiant");
        }
        verifier(equipement);
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement findById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Equipement introuvable: " + id));
    }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement update(Long id, Equipement equipement) {
        verifier(equipement);
        Equipement existant = findById(id);
        existant.setLibelle(equipement.getLibelle());
        return equipementRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!equipementRepository.existsById(id)) {
            throw new NoSuchElementException("Equipement introuvable: " + id);
        }
        equipementRepository.deleteById(id);
    }

    private void verifier(Equipement equipement) {
        if (equipement.getLibelle() == null || equipement.getLibelle().isBlank()) {
            throw new IllegalArgumentException("Le libellé de l'équipement est obligatoire");
        }
    }
}
package tn.esprit.asmamessaoudi_4cce10.Service;

import tn.esprit.asmamessaoudi_4cce10.domain.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement create(Equipement equipement);
    Equipement findById(Long id);
    List<Equipement> findAll();
    Equipement update(Long id, Equipement equipement);
    void deleteById(Long id);
}
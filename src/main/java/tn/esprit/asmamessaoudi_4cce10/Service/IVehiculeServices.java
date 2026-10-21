package tn.esprit.asmamessaoudi_4cce10.Service;

import tn.esprit.asmamessaoudi_4cce10.domain.Vehicule;

import java.util.List;

public interface IVehiculeServices {
    Vehicule create(Vehicule vehicule);

    Vehicule findById(Long id);

    Vehicule findById(long id);
    List<Vehicule> findAll();

    Vehicule update(Long id, Vehicule vehicule);

    void deleteById(Long id);
    Vehicule update(Vehicule vehicule);

}

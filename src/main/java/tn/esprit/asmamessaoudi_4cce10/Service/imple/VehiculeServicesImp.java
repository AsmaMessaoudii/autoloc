package tn.esprit.asmamessaoudi_4cce10.Service.imple;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.asmamessaoudi_4cce10.Service.IVehiculeServices;
import tn.esprit.asmamessaoudi_4cce10.domain.Vehicule;
import tn.esprit.asmamessaoudi_4cce10.repository.IVehiculeRepository;

import java.util.List;
import java.util.NoSuchElementException;
@Service
@RequiredArgsConstructor
public class VehiculeServicesImp implements IVehiculeServices {


    private final IVehiculeRepository vehiculeRepository;



    @Override
    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule findById(long id) {
        return vehiculeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Vehicule introuvable: "+ id));
    }

    @Override
    public List<Vehicule> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
}

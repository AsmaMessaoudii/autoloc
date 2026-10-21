package tn.esprit.asmamessaoudi_4cce10.Service;

import org.jspecify.annotations.Nullable;
import tn.esprit.asmamessaoudi_4cce10.domain.Agence;

import java.util.List;

public interface IAgenceService {
    Agence create(Agence agence);
    Agence findById(Long id);
    List<Agence> findAll();
    Agence update(Long id, Agence agence);
    void deleteById(Long id);


}
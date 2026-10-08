package tn.esprit.asmamessaoudi_4cce10.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAgence;
    String nom;
    String ville;
    String adresse;
    String telephone;
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    Set<Vehicule> vehicules= new HashSet<>();
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    Set<Employe> employes = new HashSet<>();


}

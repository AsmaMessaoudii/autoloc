package tn.esprit.asmamessaoudi_4cce10.domain;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idVehicule;
    @Column(nullable = false,unique = true)
    private  String immatriculation;
    private  String marque;
    private  String modele;
    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;
    private BigDecimal tarifJournalier;
    private StatutVehicule statut;
    @ManyToOne
    private Agence agence;
    @ManyToMany
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "id_vehicule"),
            inverseJoinColumns = @JoinColumn(name = "id_equipement")
    )
    private Set<Equipement> equipements = new HashSet<>();

    @OneToMany(mappedBy = "vehicule")
    Set<Maintenance> maintenances = new HashSet<>();

    @OneToMany(mappedBy = "vehicule")
    Set<Reservation> reservations = new HashSet<>();
}

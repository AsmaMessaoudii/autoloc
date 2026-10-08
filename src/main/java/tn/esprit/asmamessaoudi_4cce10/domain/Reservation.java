package tn.esprit.asmamessaoudi_4cce10.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReservation;
    LocalDate dateDebut;
    LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    StatutReservation statut;

    @ManyToOne(fetch = FetchType.LAZY)

    Vehicule vehicule;

    @ManyToOne(fetch = FetchType.LAZY)

    Client client;

    @OneToOne(mappedBy = "reservation", fetch = FetchType.LAZY)
    Contrat contrat;
}
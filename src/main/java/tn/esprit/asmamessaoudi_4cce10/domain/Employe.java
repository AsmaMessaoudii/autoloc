package tn.esprit.asmamessaoudi_4cce10.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEmploye;
    String nom;
    String prenom;

    @Enumerated(EnumType.STRING)
    RoleEmploye role;

    @ManyToOne(fetch = FetchType.LAZY)
    Agence agence;
}
package it.unisa.IS_Project.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "proprieta")
public class ProprietaEntity {
    @Id
    @Column(name = "nomeProprieta")
    private String nome;
    private String valore;

    @ManyToOne
    @MapsId("idEntita")
    @JoinColumn(name = "idEntita")
    private EntitaEntity entita;
}

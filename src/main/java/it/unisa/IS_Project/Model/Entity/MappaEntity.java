package it.unisa.IS_Project.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mappa")
public class MappaEntity {
    @Id
    @Column(name = "idMappa")
    private int id;
    private String nome;
    private int lunghezza;
    private int larghezza;

    @OneToOne(mappedBy = "idMappa")
    private UtenteEntity idMappaUtente;

    @OneToMany(mappedBy = "idMappaEvento")
    private List<EventoEntity> idMappaEvento;

    @OneToMany(mappedBy = "idMappaPiazzato")
    private List<PiazzatoEntity> idMappaPiazzato;
}

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMappa")
    private int id;
    private String nome;
    private int lunghezza;
    private int larghezza;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "email",referencedColumnName = "email",nullable = true)
    private UtenteEntity idMappaUtente;

    @OneToMany(mappedBy = "idMappaEvento")
    private List<EventoEntity> idMappaEvento;

    @OneToMany(mappedBy = "idMappaEntity")
    private List<EntitaEntity> entitaEntity;
}

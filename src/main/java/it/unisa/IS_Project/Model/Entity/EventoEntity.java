package it.unisa.IS_Project.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "evento")
public class EventoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvento")
    private int idEvento;

    private String nome;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("idMappa")
    @JoinColumn(name = "idMappa")
    private MappaEntity idMappaEvento;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("email")
    @JoinColumn(name = "email")
    private UtenteEntity utenteEntity;

    @OneToMany(mappedBy = "eventoEntity")
    private List<IstruzioneEntity> istruzioneEntities;
}

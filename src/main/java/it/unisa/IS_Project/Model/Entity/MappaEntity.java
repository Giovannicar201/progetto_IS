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
    private long altezza;
    private long larghezza;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email",referencedColumnName = "email")
    private UtenteEntity utenteEntity;

    @OneToMany(mappedBy = "mappaEntity",cascade = CascadeType.REMOVE)
    private List<EventoEntity> eventoEntityList;

    @OneToMany(mappedBy = "mappaEntity",cascade = CascadeType.REMOVE)
    private List<EntitaEntity> entitaEntityList;
}

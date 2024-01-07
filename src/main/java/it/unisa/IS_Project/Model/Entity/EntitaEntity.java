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
@Table(name = "entita")
public class EntitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntita")
    private int id;
    private String nome;
    private String collisione;

    @OneToMany(mappedBy = "entitaEntity",cascade = CascadeType.REMOVE)
    private List<ProprietaEntity> proprietaEntityList;

    @OneToMany(mappedBy = "entitaEntity",cascade = CascadeType.REMOVE)
    private List<CoordinateEntity> coordinateEntityList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMappa",referencedColumnName = "idMappa")
    private MappaEntity mappaEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCartella",referencedColumnName = "idCartella")
    private CartellaEntity cartellaEntity;

    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name = "email",referencedColumnName = "email")
    private UtenteEntity utenteEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFoto",referencedColumnName = "idFoto")
    private ImmagineEntity immagineEntity;
}

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
    private String coordinate;

    @OneToMany(mappedBy = "entita")
    private List<ProprietaEntity> idEntitaEntityProprieta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMappa",referencedColumnName = "idMappa")
    private MappaEntity idMappaEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCartella",referencedColumnName = "idCartella")
    private CartellaEntity cartellaEntity;

    @ManyToOne(cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "email",referencedColumnName = "email")
    private UtenteEntity email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFoto",referencedColumnName = "idFoto")
    private ImmagineEntity immagineEntita;
}

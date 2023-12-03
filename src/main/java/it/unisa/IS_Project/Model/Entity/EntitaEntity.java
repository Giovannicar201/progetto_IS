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

    @ManyToOne(cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "idMappa",referencedColumnName = "idMappa",nullable = true,insertable=false, updatable=false)
    private MappaEntity idMappaEntity;

    @ManyToOne(cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "idCartella",referencedColumnName = "idCartella",nullable = true)
    private CartellaEntity cartellaEntity;

    @OneToOne(cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "idFoto",referencedColumnName = "idFoto", nullable = true)
    private ImmagineEntity immagineEntita;
}

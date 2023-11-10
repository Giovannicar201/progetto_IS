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
@Table(name = "tilesetCustom")
public class TilesetCustomEntity {
    @Id
    @Column(name = "idTilesetCustom")
    private int id;
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId("idEntita")
    @JoinColumn(name = "idEntita")
    private EntitaEntity entitaEntity;

    @OneToMany(mappedBy = "tilesetCustom")
    private List<UtenteEntity> utenteEntities;
}

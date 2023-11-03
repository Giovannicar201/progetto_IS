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
@Table(name = "tilesetPremium")
public class TilesetPremiumEntity {
    @Id
    @Column(name = "idTilesetPremium")
    private int id;
    private String nome;
    private double prezzo;

    @OneToMany(mappedBy = "idTilesetPremium")
    private List<CompraEntity> tilesetPremiumList;

    @OneToMany(mappedBy = "idTilesetPrem")
    private List<ContieneEntity> idTilesetPremiumContiene;
}

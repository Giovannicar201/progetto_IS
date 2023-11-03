package it.unisa.IS_Project.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "contiene")
public class ContieneEntity {
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKey implements Serializable{
        @Column(name = "idTilesetPremium")
        private int idTilesetPremium;
        @Column(name = "idEntita")
        private int idEntita;
    }
    @EmbeddedId
    private PrimaryKey primaryKey;

    @ManyToOne
    @MapsId("idEntita")
    @JoinColumn(name = "idEntita")
    private EntitaEntity entity;

    @ManyToOne
    @MapsId("idTilesetPremium")
    @JoinColumn(name = "idTilesetPremium")
    private TilesetPremiumEntity idTilesetPrem;
}

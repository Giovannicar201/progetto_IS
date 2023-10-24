package it.unisa.IS_Project.Entity;

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
@Table(name = "piazzato")
public class PiazzatoEntity {
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKey implements Serializable{
        @Column(name = "idMappa")
        private int idMappa;
        @Column(name = "idTile")
        private int idTile;
        @Column(name = "coordinate")
        private String coordinate;
    }

    @EmbeddedId
    private PrimaryKey primaryKey;

    @ManyToOne
    @MapsId("idMappa")
    @JoinColumn(name = "idMappa")
    private MappaEntity mappaEntity;

    @ManyToOne
    @MapsId("idTile")
    @JoinColumn(name = "idTile")
    private TileEntity idIileEntity;
}

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
@Table(name = "crea")
public class CreaEntity {
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKey implements Serializable {
        @Column(name = "idTilesetCustom")
        private int idTilesetCustom;
        @Column(name = "usernameUtente")
        private String usernameEntity;
    }

    @EmbeddedId
    private PrimaryKey primaryKey;

    @ManyToOne
    @MapsId("idTilesetCustom")
    @JoinColumn(name = "idTilesetCustom")
    private TilesetCustomEntity tilesetCustom;

    @ManyToOne
    @MapsId("usernameUtente")
    @JoinColumn(name = "usernameUtente")
    private UtenteEntity utenteEntity;
}

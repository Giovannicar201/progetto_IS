package it.unisa.IS_Project.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "compra")
public class CompraEntity {
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKey implements Serializable{
        @Column(name = "usernameUtente")
        private String usernameUtente;
        @Column(name = "idTilesetPremium")
        private Integer idTilesetPremium;
        @Column(name = "data")
        private Date data;
        @Column(name = "time")
        private Time time;
    }

    @EmbeddedId
    private PrimaryKey primaryKey;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("usernameUtente")
    @JoinColumn(name = "usernameUtente")
    private UtenteEntity usernameUtente;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idTilesetPremium")
    @JoinColumn(name = "idTilesetPremium")
    private TilesetPremiumEntity idTilesetPremium;
}
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
@Table(name = "piazzato")
public class PiazzatoEntity {
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKey implements Serializable{
        @Column(name = "idMappa")
        private int idMappa;
        @Column(name = "idEntita")
        private int idEntita;
        @Column(name = "coordinate")
        private String cooridnate;
    }
    @EmbeddedId
    private PrimaryKey primaryKey;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idMappa")
    @JoinColumn(name = "idMappa")
    private MappaEntity idMappaPiazzato;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idEntita")
    @JoinColumn(name = "idEntita")
    private EntitaEntity idEntitaPiazzato;
}

package it.unisa.IS_Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comprende")
public class ComprendeEntity {
    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class PrimaryKey implements Serializable {
        @Column(name="idEntita")
        private int idEntita;
        @Column(name = "idPacchettiCustom")
        private int idPacchettiCustom;
    }

    @EmbeddedId
    private PrimaryKey primaryKey;

    @ManyToOne
    @MapsId("idEntita")
    @JoinColumn(name = "idEntita")
    private EntitaEntity entitaEntity;

    @ManyToOne
    @MapsId("idPacchettiCustom")
    @JoinColumn(name = "idPacchettiCustom")
    private PacchettiCustomEntity pacchettiCustomEntity;
}

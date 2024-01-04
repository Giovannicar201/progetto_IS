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
@Entity
@Builder
@Table(name = "coordinate")
public class CoordinateEntity {
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKeyCoordinate implements Serializable {
        @Column(name = "coordinataX")
        private String coordinataX;
        @Column(name = "coordinataY")
        private String coordinataY;
        @Column(name = "idEntita")
        private int idEvento;
    }

    @EmbeddedId
    private PrimaryKeyCoordinate primaryKeyCoordinate;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "idEntita",referencedColumnName = "idEntita",insertable=false, updatable=false)
    private EntitaEntity entitaEntity;
}

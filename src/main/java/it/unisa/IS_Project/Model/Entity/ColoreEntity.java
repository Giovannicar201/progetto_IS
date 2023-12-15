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
@Table(name = "colore")
public class ColoreEntity {
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKey implements Serializable{
        @Column(name = "esadecimale")
        private String esadecimale;
        @Column(name = "idPalette")
        private int idPalette;
    }

    @EmbeddedId
    private PrimaryKey primaryKey;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "idPalette",referencedColumnName = "idPalette",insertable=false, updatable=false)
    private PaletteEntity nomePaletteEntity;
}

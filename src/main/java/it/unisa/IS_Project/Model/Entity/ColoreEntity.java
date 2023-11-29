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
        @Column(name = "nomePalette")
        private String nomePalette;
    }

    @EmbeddedId
    private PrimaryKey primaryKey;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "nomePalette",nullable = true,insertable=false, updatable=false)
    private PaletteEntity nomePaletteEntity;
}

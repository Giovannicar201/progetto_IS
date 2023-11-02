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
@Table(name = "genera")
public class GeneraEntity {
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKey implements Serializable {
        @Column(name = "usernameUtente")
        private String usernameUtente;
        @Column(name = "nomePalette")
        private String nomePalette;
    }
    @EmbeddedId
    private PrimaryKey primaryKey;

    @ManyToOne
    @MapsId("usernameUtente")
    @JoinColumn(name = "usernameUtente")
    private UtenteEntity utente;

    @ManyToOne
    @MapsId("nomePalette")
    @JoinColumn(name = "nomePalette")
    private PaletteEntity paletteEntity;
}

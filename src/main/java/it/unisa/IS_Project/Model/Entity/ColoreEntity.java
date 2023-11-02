package it.unisa.IS_Project.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "colore")
public class ColoreEntity {
    @Id
    @Column(name = "esadecimale")
    private String esadecimale;
    private String nomeColore;

    @ManyToOne
    @MapsId("nomePalette")
    @JoinColumn(name = "nomePalette")
    private PaletteEntity nomePaletteEntity;
}

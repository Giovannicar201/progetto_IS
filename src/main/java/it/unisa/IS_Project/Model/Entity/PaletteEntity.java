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
@Table(name = "Palette")
public class PaletteEntity {
    @Id
    @Column(name = "nomePalette")
    private String nomePalette;

    @OneToMany(mappedBy = "paletteEntity")
    private List<UtenteEntity> utentePalette;

    @OneToMany(mappedBy = "nomePaletteEntity")
    private List<ColoreEntity> coloreEntityList;
}

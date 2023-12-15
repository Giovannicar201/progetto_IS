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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPalette")
    private int idPalette;
    private String nomePalette;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "email",referencedColumnName = "email")
    private UtenteEntity emailUtente;

    @OneToMany(mappedBy = "nomePaletteEntity")
    private List<ColoreEntity> coloreEntityList;
}

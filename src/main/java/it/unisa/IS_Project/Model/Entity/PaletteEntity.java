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

    @ManyToOne(cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "email",referencedColumnName = "email",nullable = true)
    private UtenteEntity emailUtente;

    @OneToMany(mappedBy = "nomePaletteEntity")
    private List<ColoreEntity> coloreEntityList;
}

package it.unisa.IS_Project.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "immagine")
public class ImmagineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoto")
    private int idFoto;
    private String foto;

    @OneToOne(mappedBy = "immagineEntita")
    private EntitaEntity entity;

    @ManyToOne(cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "email",referencedColumnName = "email",nullable = true)
    private UtenteEntity email;
}

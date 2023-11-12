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
@Table(name = "immagineEntita")
public class ImmagineEntitaEntity {
    @Id
    @Column(name = "idFoto")
    private int idFoto;
    private String nome;
    private String foto;

    @OneToOne(mappedBy = "immagineEntita")
    private EntitaEntity entity;
}

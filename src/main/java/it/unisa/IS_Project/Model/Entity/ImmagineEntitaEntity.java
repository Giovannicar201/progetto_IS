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
    private String foto;

    @Id
    @ManyToOne
    @MapsId("idEntita")
    @JoinColumn(name = "idEntita")
    private EntitaEntity e;
}

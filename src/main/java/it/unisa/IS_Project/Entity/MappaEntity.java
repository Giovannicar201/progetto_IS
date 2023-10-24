package it.unisa.IS_Project.Entity;

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
@Table(name = "mappa")
public class MappaEntity {
    @Id
    @Column(name = "idMappa")
    private int id;
    private String nome;
    private int lunghezza;
    private int larghezza;

    @OneToMany(mappedBy = "mappaEntity")
    private List<PiazzatoEntity> idMappaEntity;
}

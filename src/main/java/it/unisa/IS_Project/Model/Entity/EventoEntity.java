package it.unisa.IS_Project.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "evento")
public class EventoEntity {
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKey implements Serializable{
        @Column(name = "idMappa")
        private int idMappa;
        @Column(name = "idEvento")
        private int idEvento;
    }
    @EmbeddedId
    private PrimaryKey primaryKey;

    private String nome;

    @ManyToOne
    @MapsId("idMappa")
    @JoinColumn(name = "idMappa")
    private MappaEntity idMappaEvento;
}

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
        @Column(name = "idEvento")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idEvento;
        @Column(name = "idMappa")
        private int idMappa;
    }
    @EmbeddedId
    private PrimaryKey primaryKey;

    private String nome;

    @ManyToOne(cascade = CascadeType.ALL,optional = true)
    @MapsId("idMappa")
    @JoinColumn(name = "idMappa")
    private MappaEntity idMappaEvento;

    @ManyToOne(cascade = CascadeType.ALL,optional = true)
    @MapsId("email")
    @JoinColumn(name = "email")
    private UtenteEntity utenteEntity;
}

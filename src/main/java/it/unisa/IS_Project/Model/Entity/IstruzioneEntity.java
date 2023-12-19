package it.unisa.IS_Project.Model.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(PrimaryKeyIstruzione.class)
@Entity
@Table(name = "istruzione")
public class IstruzioneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIstruzione")
    private int idIstruzione;

    @Id
    @Column(name = "idEvento")
    private int idEvento;

    private String nome;

    @Nullable
    private String valore;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "idEvento",referencedColumnName = "idEvento",insertable=false, updatable=false)
    private EventoEntity eventoEntity;
}

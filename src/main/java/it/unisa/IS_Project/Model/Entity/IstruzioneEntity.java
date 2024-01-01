package it.unisa.IS_Project.Model.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Reference;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "istruzione")
@IdClass(PrimaryKeyIstruzione.class)

public class IstruzioneEntity {

    @Id
    @Column(name = "idIstruzione")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

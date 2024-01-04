package it.unisa.IS_Project.Model.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Reference;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "istruzione")
public class IstruzioneEntity {
    @Id
    @Column(name = "idIstruzione")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIstruzione;

    private String nome;

    @Nullable
    private String valore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEvento",referencedColumnName = "idEvento",insertable=false, updatable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EventoEntity eventoEntity;
}

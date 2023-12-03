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
@Table(name="utente")
public class UtenteEntity {
    @Id
    @Column(name = "email")
    private String email;
    private String password;
    private String nome;
    private String cognome;

    @OneToOne(mappedBy = "idMappaUtente")
    private MappaEntity idMappa;

    @OneToMany(mappedBy = "emailUtente", cascade = CascadeType.ALL)
    private List<PaletteEntity> paletteEntity;

    @OneToMany(mappedBy = "utenteEntity", cascade = CascadeType.ALL)
    private List<CartellaEntity> cartellaEntity;

    @OneToMany(mappedBy = "utenteEntity", cascade = CascadeType.ALL)
    private List<EventoEntity> eventoEntity;

    @OneToMany(mappedBy = "email", cascade = CascadeType.ALL)
    private List<ImmagineEntity> immagineEntity;
}

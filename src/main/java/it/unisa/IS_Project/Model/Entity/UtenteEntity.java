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

    @OneToOne(mappedBy = "utenteEntity",cascade = CascadeType.REMOVE)
    private MappaEntity mappaEntity;

    @OneToMany(mappedBy = "utenteEntity", cascade = CascadeType.REMOVE)
    private List<PaletteEntity> paletteEntity;

    @OneToMany(mappedBy = "utenteEntity", cascade = CascadeType.REMOVE)
    private List<CartellaEntity> cartellaEntity;

    @OneToMany(mappedBy = "utenteEntity", cascade = CascadeType.REMOVE)
    private List<EventoEntity> eventoEntity;

    @OneToMany(mappedBy = "utenteEntity", cascade = CascadeType.REMOVE)
    private List<ImmagineEntity> immagineEntity;

    @OneToMany(mappedBy = "utenteEntity",cascade = CascadeType.REMOVE)
    private List<EntitaEntity> entitaEntityList;
}

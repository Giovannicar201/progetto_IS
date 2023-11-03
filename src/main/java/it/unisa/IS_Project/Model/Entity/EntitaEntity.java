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
@Table(name = "entita")
public class EntitaEntity {
    @Id
    @Column(name = "idEntita")
    private int id;
    private String proprieta;
    private String collisione;

    @OneToMany(mappedBy = "entitaEntity")
    private List<ComprendeEntity> idEntitaComprende;

    @OneToMany(mappedBy = "newIdEntitaEntity")
    private List<ComponeEntity> idEnitaEntityCompone;

    @OneToMany(mappedBy = "entita")
    private List<ProprietaEntity> idEntitaEntityProprieta;

    @OneToMany(mappedBy = "entity")
    private List<ContieneEntity> idEntitaEntityContiene;

    @OneToMany(mappedBy = "e")
    private List<ImmagineEntitaEntity> idEntitaEntityFoto;
}

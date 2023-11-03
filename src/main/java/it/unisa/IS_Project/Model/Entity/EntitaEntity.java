package it.unisa.IS_Project.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private List<ImmagineEntitaEntity> idEntiaEntityFoto;
}

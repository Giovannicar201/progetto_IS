package it.unisa.IS_Project.Model.Entity;

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
@Entity
@Table(name = "compone")
public class ComponeEntity {
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKey implements Serializable{
        @Column(name = "usernameUtente")
        private String usernameUtente;
        @Column(name = "idEntita")
        private int idEntita;
    }

    @EmbeddedId
    private PrimaryKey primaryKey;

    @ManyToOne
    @MapsId("usernameUtente")
    @JoinColumn(name = "usernameUtente")
    private UtenteEntity newUsernameUtente;

    @ManyToOne
    @MapsId("idEntita")
    @JoinColumn(name = "idEntita")
    private EntitaEntity newIdEntitaEntity;
}

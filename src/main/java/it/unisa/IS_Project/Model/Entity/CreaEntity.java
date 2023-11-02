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
@Table(name = "crea")
public class CreaEntity {
    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKey implements Serializable {
        @Column(name = "idPacchettiCustom")
        private int idPacchettiCustom;
        @Column(name = "usernameUtente")
        private String usernameEntity;
    }

    @EmbeddedId
    private PrimaryKey primaryKey;

    @ManyToOne
    @MapsId("idPacchettiCustom")
    @JoinColumn(name = "idPacchettiCustom")
    private PacchettiCustomEntity pacchettiCustom;

    @ManyToOne
    @MapsId("usernameUtente")
    @JoinColumn(name = "usernameUtente")
    private UtenteEntity utenteEntity;
}

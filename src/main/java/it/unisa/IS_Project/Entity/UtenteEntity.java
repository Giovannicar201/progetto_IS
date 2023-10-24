package it.unisa.IS_Project.Entity;

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
    @Column(name = "usernameUtente")
    private String username;
    private String email;
    private String password;
    private String nome;
    private String cognome;

    @OneToMany(mappedBy = "usernameUtente")
    private List<CompraEntity> usernameUtenteList;

    @OneToMany(mappedBy = "utenteEntity")
    private List<CreaEntity> usernameUtenteCreaList;
}

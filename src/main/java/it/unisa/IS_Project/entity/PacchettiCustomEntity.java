package it.unisa.IS_Project.entity;

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
@Table(name = "pacchettiCustom")
public class PacchettiCustomEntity {
    @Id
    @Column(name = "idPacchettiCustom")
    private int id;
    private String nome;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private UtenteEntity idPacchettiCustomUtenti;

    @OneToMany(mappedBy = "pacchettiCustomEntity")
    private List<ComprendeEntity> idPacchettiCustomComprende;
}

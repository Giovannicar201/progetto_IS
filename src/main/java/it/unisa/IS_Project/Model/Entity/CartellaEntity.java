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
@Table(name = "cartella")
public class CartellaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCartella")
    private int id;
    private String nome;
    private int numeroEntitaContenute;

    @OneToMany(mappedBy = "cartellaEntity")
    private List<EntitaEntity> entitaEntity;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "email",referencedColumnName = "email", nullable = true)
    private UtenteEntity utenteEntity;
}

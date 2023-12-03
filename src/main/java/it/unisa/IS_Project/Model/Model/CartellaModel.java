package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartellaModel {
    private int id;
    private String nome;
    private int numeroEntitaContenute;

    private EntitaModel CartellaEntita;

    private UtenteModel emailUtente;
}

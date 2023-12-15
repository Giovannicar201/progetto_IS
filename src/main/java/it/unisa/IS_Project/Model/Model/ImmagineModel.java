package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImmagineModel {
    private int idFoto;
    private String nome;
    private Blob foto;

    private EntitaModel idEntita;
    private UtenteModel emailUtente;
}

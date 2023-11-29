package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImmagineModel {
    private int idFoto;
    private String foto;

    private EntitaModel idEntita;
    private UtenteModel emailUtente;
}

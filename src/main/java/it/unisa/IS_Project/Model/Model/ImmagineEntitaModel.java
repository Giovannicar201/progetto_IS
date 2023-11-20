package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImmagineEntitaModel {
    private int idFoto;
    private String nome;
    private String foto;

    private EntitaModel idEntita;
}

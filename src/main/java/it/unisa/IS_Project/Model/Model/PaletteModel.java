package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaletteModel {
    private int idPalette;
    private String nomePalette;

    private UtenteModel utentePalette;

    private List<ColoreModel> coloreModel;
}

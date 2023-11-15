package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaletteModel {
    private String nomePalette;

    private List<UtenteModel> utentePalette;

    private List<ColoreModel> coloreModel;
}

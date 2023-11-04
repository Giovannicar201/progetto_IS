package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColoreModel {
    private String esadecimale;
    private String nomeColore;
    private PaletteModel paletteModel;
}

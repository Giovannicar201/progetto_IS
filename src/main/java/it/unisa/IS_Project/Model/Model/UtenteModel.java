package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtenteModel {
    private String username;
    private String email;
    private String password;
    private String nome;
    private String cognome;

    private List<CompraModel> usernameUtenteCompra;

    private MappaModel idMappa;

    private PaletteModel paletteModel;

    private TilesetCustomModel idTilesetCustom;

    private EventoModel eventoModel;
}

package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtenteModel {
    private String email;
    private String password;
    private String nome;
    private String cognome;

    private MappaModel idMappa;

    private List<PaletteModel> paletteModel;

    private List<CartellaModel> cartellaUtente;

    private List<EventoModel> eventoModel;

    private List<ImmagineModel> immagineModel;
}

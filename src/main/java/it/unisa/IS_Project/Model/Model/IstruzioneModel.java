package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IstruzioneModel {
    private int idIstruzione;
    private String nome;
    private String valore;

    private EventoModel eventoModel;
}
package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MappaModel {
    private int id;
    private String nome;
    private int lunghezza;
    private int larghezza;

    private UtenteModel idMappaUtente;
    private List<EntitaModel> idMappaEvento;
    private List<PiazzatoModel> idMappaPiazzato;
}

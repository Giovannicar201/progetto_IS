package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoModel {
    private int idEvento;
    private String nome;

    private MappaModel idMappaEvento;
    private List<UtenteModel> utenteModels;
}

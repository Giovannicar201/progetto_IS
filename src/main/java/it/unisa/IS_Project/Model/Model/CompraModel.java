package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraModel {
    private String usernameUtente;
    private int idTilesetPremium;
    private Date data;
    private Time time;
}

package it.unisa.IS_Project.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrimaryKeyIstruzione implements Serializable {
    private int idIstruzione;

    private int idEvento;

}

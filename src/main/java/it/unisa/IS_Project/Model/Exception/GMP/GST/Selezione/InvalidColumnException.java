package it.unisa.IS_Project.Model.Exception.GMP.GST.Selezione;

import it.unisa.IS_Project.Model.Exception.GMP.GST.GSTException;

public class InvalidColumnException extends GSTException {
    public InvalidColumnException(String message) {
        super(message);
    }
}

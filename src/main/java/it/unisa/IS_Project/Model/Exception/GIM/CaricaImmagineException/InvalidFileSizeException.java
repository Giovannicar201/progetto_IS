package it.unisa.IS_Project.Model.Exception.GIM.CaricaImmagineException;

import it.unisa.IS_Project.Model.Exception.GIM.GIMException;

public class InvalidFileSizeException extends GIMException {
    public InvalidFileSizeException(String message) {
        super(message);
    }
}

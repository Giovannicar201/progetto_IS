package it.unisa.IS_Project.Model.Exception.GIM.CaricaImmagineException;

import it.unisa.IS_Project.Model.Exception.GIM.GIMException;

public class InvalidFileExtensionException extends GIMException {
    public InvalidFileExtensionException(String message) {
        super(message);
    }
}

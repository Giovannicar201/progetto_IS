package it.unisa.IS_Project.Controller.GMP.GST;

import it.unisa.IS_Project.Exception.GMP.GST.GSTException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class MatitaControl {

    public abstract void piazza(String obj, HttpServletRequest request, HttpServletResponse response) throws GSTException;

    public abstract void riempi(String obj, HttpServletRequest request, HttpServletResponse response);
}

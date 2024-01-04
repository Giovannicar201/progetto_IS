package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Service.MatitaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class MatitaControl {
    protected MatitaService matitaService;

    public abstract void piazza(String obj, HttpServletRequest request, HttpServletResponse response);

    public abstract void riempi(String obj, HttpServletRequest request, HttpServletResponse response);
}

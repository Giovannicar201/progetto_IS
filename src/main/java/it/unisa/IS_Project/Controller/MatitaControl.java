package it.unisa.IS_Project.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class MatitaControl {

    public abstract void piazza(String obj, HttpServletRequest request, HttpServletResponse response);

    public abstract void riempi(String obj, HttpServletRequest request, HttpServletResponse response);
}

package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtenteController {
    @Autowired
    public UtenteService utenteService;

    @PostMapping("/registrazione")
    public String registrazione(@RequestParam("email")String email, @RequestParam("password")String password, @RequestParam("nome")String nome, Model model){
        UtenteEntity utenteEntity=utenteService.add(email,password,nome);
        model.addAttribute("infoUtente",utenteEntity);
        return "login";
    }
}

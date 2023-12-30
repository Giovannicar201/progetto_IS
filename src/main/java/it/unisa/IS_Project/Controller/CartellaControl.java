package it.unisa.IS_Project.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartellaControl {

    @RequestMapping(value = "/griglia/creaCartella", method = RequestMethod.POST)

    public String creaCartella() {

        System.out.println("ciao");

        return "griglia";

    }

    @RequestMapping(value = "/griglia/trovaCartelle", method = RequestMethod.GET)

    public String trovaCartelle() {

        System.out.println("ciao");

        return "griglia";

    }

}

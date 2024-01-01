package it.unisa.IS_Project.Model.Controller;

//import it.unisa.IS_Project.Model.Model.UtenteModel;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Utility.UtilityClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Questa classe viene utilizzata per fornire il mapping delle pagine html
 * del progetto, la clausola @GetMapping("URL") viene utilizzata per dire a
 * spring che si tratta di un mapping di una jsp, thymeleaf viene utilizzato per
 * trasformare un file html in una jlst in mopo automatico.
 *
 */

@Controller

public class HTMLMapping {

    @GetMapping("/login")

    public String loginRegistrazione(Model model){

        model.addAttribute("infoUtente", new UtenteEntity());

        return "LogInRegistrazione";

    }

    @GetMapping("/griglia")

    public String griglia() {

        return "Griglia";

    }

    @GetMapping("/pixelArt")

    public String pixelArt () {

        return "PixelArtCreator";

    }

    @GetMapping("/eventi")

    public String eventi () {

        return "eventmanager";

    }

    @GetMapping("/test")

    public String test () {

        return "testDb";

    }

    @GetMapping("/entità")

    public String entità() {

        return "gestoreentità";

    }

    @GetMapping("/")

    public String index(){

        return "homepage";

    }

    @GetMapping("/error")
    public String error(){

        return "error";

    }
}

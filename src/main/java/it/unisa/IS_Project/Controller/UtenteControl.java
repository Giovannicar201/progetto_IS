package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.GAC.Login.LoginPasswordsMismatchException;
import it.unisa.IS_Project.Model.Exception.GAC.Login.UserNotFoundException;
import it.unisa.IS_Project.Model.Exception.GAC.Logout.EmailNotInSessionException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidEmailException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidNameException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidPasswordException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.SignupPasswordsMismatchException;
import it.unisa.IS_Project.Model.Service.UtenteService;
import it.unisa.IS_Project.Utility.UtilityClass;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Controller
public class UtenteControl {

    @Autowired
    public UtenteService utenteService;

    @RequestMapping(value = "/auth/signup", method = RequestMethod.POST)

    public String signup(@RequestBody String signup, HttpServletRequest request, Model model) {

        JSONParser parser = new JSONParser();
        String email, nome, password, passwordRipetuta;

        try {

            JSONObject signupJSON = (JSONObject) parser.parse(signup);

            email = (String) signupJSON.get("email");
            nome = (String) signupJSON.get("nome");
            password = (String) signupJSON.get("password");
            passwordRipetuta = (String) signupJSON.get("passwordRipetuta");

            utenteService.signup(email,nome,password,passwordRipetuta);

        } catch (NoSuchAlgorithmException | ParseException e) {

            return "redirect:/error";

        } catch (SignupPasswordsMismatchException e) {

            model.addAttribute("error", "ERROR - PASSWORDS DO NOT MATCH.");

            return "LogInRegistrazione";

        } catch (InvalidNameException e) {

            model.addAttribute("error", "ERROR - INVALID NAME FORMAT.");

            return "LogInRegistrazione";

        } catch (InvalidPasswordException e) {

            model.addAttribute("error", "ERROR - INVALID PASSWORD FORMAT.");

            return "LogInRegistrazione";

        } catch (InvalidEmailException e) {

            model.addAttribute("error", "ERROR - INVALID EMAIL FORMAT.");

            return "LogInRegistrazione";
        }

        UtilityClass.salvaEmail(request,email);

        try {
            UtilityClass.emailSessione(request);
        } catch (EmailNotInSessionException e) {
            return "redirect:/error";
        }

        return "redirect:/auth";
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)

    public String login(@RequestBody String login, HttpServletRequest request,
                        HttpServletResponse response, Model model) throws Exception {

      JSONParser parser = new JSONParser();
      String email, password;

        try {

            JSONObject loginJSON = (JSONObject) parser.parse(login);

            email = (String) loginJSON.get("email");
            password = (String) loginJSON.get("password");

            utenteService.login(email,password);

            UtilityClass.salvaEmail(request, email);

        } catch (NoSuchAlgorithmException | ParseException e) {

            return "redirect:/error";

        } catch (UserNotFoundException e) {

            response.sendError( 500,
                    "nf");

        } catch (LoginPasswordsMismatchException e) {

            response.sendError( 500,
                    "pe");

        }

        return "redirect:/auth";

    }

    @RequestMapping(value = "/auth/logout", method = RequestMethod.POST)

    public String logout(HttpServletRequest request) {

        try {
            UtilityClass.emailSessione(request);
        } catch (EmailNotInSessionException e) {
            return "redirect:/error";
        }

        if (request.getSession() != null)
            request.getSession().setMaxInactiveInterval(1);

        return "redirect:/auth";
    }

}

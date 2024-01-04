package it.unisa.IS_Project.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IAControl {

    @RequestMapping(value = "/IA/genera", method = RequestMethod.POST)

    public void genera(HttpServletRequest request, HttpServletResponse response) {

    }

}

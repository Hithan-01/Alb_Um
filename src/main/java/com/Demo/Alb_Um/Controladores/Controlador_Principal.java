package com.Demo.Alb_Um.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador_Principal {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/alumno")
    public String alumno() {
        return "alumno";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/coach")
    public String coach() {
        return "coach";
    }
}

package com.Demo.Alb_Um.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador_login {

    @GetMapping("/login")
    public String login() {
        return "login"; // Asegúrate de que existe un archivo login.html en src/main/resources/templates
    }
}

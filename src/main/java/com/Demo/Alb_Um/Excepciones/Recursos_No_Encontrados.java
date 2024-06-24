package com.Demo.Alb_Um.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class Recursos_No_Encontrados extends RuntimeException {
    public Recursos_No_Encontrados(String message) {
        super(message);
    }
}
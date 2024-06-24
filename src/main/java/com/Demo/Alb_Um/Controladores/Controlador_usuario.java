package com.Demo.Alb_Um.Controladores;

import com.Demo.Alb_Um.Entidades.Usuario;
import com.Demo.Alb_Um.Repositorios.Repositorio_usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class Controlador_usuario {
    @Autowired
    private Repositorio_usuario repositorio_usuario;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return repositorio_usuario.findAll();
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return repositorio_usuario.save(usuario);
    }

    // Otros métodos como update, delete pueden ser agregados aquí
}

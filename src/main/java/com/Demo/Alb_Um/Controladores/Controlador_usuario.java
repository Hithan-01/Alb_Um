package com.Demo.Alb_Um.Controladores;

import com.Demo.Alb_Um.Entidades.Usuario;
import com.Demo.Alb_Um.Excepciones.Recursos_No_Encontrados;
import com.Demo.Alb_Um.Repositorios.Repositorio_usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class Controlador_usuario {
    @Autowired
    private Repositorio_usuario repositorio_usuario;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return repositorio_usuario.findAll();
    }

    @GetMapping("/buscarPorUserName/{userName}")
    public ResponseEntity<Usuario> getUsuarioByUserName(@PathVariable String userName) {
        Usuario usuario = repositorio_usuario.findByUserName(userName)
                .orElseThrow(() -> new Recursos_No_Encontrados("Usuario not found with userName " + userName));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return repositorio_usuario.save(usuario);
    }

    @PutMapping("/actualizarPorUserName/{userName}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable String userName, @RequestBody Usuario usuarioDetails) {
        Usuario usuario = repositorio_usuario.findByUserName(userName)
                .orElseThrow(() -> new Recursos_No_Encontrados("Usuario not found with userName " + userName));

        usuario.setUserName(usuarioDetails.getUserName());
        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setApellido(usuarioDetails.getApellido());
        usuario.setContrasena(usuarioDetails.getContrasena());
        usuario.setRol(usuarioDetails.getRol());
        usuario.setEmail(usuarioDetails.getEmail());

        Usuario updatedUsuario = repositorio_usuario.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/eliminarPorUserName/{userName}")
    public ResponseEntity<Map<String, Boolean>> deleteUsuario(@PathVariable String userName) {
        Usuario usuario = repositorio_usuario.findByUserName(userName)
                .orElseThrow(() -> new Recursos_No_Encontrados("Usuario not found with userName " + userName));
    
        repositorio_usuario.delete(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

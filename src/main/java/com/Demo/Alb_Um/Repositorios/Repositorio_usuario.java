package com.Demo.Alb_Um.Repositorios;

import com.Demo.Alb_Um.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Repositorio_usuario extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUserName(String userName);
    void deleteByUserName(String userName);  // Asegúrate de que este método esté aquí
}

package com.Demo.Alb_Um.Repositorios;
import com.Demo.Alb_Um.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio_usuario extends JpaRepository<Usuario, Long> {
}

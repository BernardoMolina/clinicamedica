package br.sci.clinicamedica.model.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    public Usuario findByLogin(String login);
}

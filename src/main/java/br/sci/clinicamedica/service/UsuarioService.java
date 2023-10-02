package br.sci.clinicamedica.service;

import br.sci.clinicamedica.model.usuario.DadosUsuario;
import br.sci.clinicamedica.model.usuario.Usuario;
import br.sci.clinicamedica.model.usuario.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    public UsuarioService (UsuarioRepository repository){
        this.repository = repository;
    }
    public void cadastrar(Usuario usuario){
        //Criptografa a senha do usuário ANTES desse ser salvo
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        this.repository.save(usuario);
    }
    public DadosUsuario findUsuario(int id){
        Usuario usuario = this.repository.getReferenceById(id);
        return new DadosUsuario(usuario);
    }
    public List<DadosUsuario> findAllUsuarios(){
        return this.repository.findAll().stream().map(DadosUsuario::new).toList();
    }

}

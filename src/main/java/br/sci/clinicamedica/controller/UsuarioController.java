package br.sci.clinicamedica.controller;

import br.sci.clinicamedica.model.usuario.DadosUsuario;
import br.sci.clinicamedica.model.usuario.Usuario;
import br.sci.clinicamedica.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;
    public UsuarioController(UsuarioService service){
        this.service = service;
    }
    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriComponentsBuilder){
        this.service.cadastrar(usuario);
        URI uri = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }
    @GetMapping("/{id}")
    public DadosUsuario findById(@PathVariable int id){
        return this.service.findUsuario(id);
    }
    @GetMapping
    public List<DadosUsuario> findAll(){
        return this.service.findAllUsuarios();
    }


}

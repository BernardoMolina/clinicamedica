package br.sci.clinicamedica.model.usuario;

public record DadosUsuario(int id,String login,String permissao) {

    public DadosUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getLogin(),
                usuario.getPermissao());
    }
}

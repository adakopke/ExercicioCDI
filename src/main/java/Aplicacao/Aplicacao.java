package Aplicacao;

import View.UsuarioView;

import javax.inject.Inject;

public class Aplicacao {

    @Inject
    private UsuarioView usuarioView;

    public UsuarioView getUsuarioView() {
        return usuarioView;
    }
}






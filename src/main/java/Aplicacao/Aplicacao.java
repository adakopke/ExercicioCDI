package Aplicacao;

import View.UsuarioView;
import View.UsuarioViewImpl;

import javax.inject.Inject;

public class Aplicacao {


    private UsuarioView usuarioview;



    //Porque criou esse método?
    public UsuarioView getUsuarioview() {
        return usuarioview;
    }
}



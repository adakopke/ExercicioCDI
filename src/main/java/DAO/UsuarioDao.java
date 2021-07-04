package DAO;

import Dominio.Usuario;

import java.io.IOException;

public interface UsuarioDao {

    void gravar(Usuario usuario);

    void listar() throws IOException;
}

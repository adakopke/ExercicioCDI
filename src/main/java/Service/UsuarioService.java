package Service;

import Dominio.Usuario;

import java.io.IOException;

public interface UsuarioService {

    Usuario create(Usuario usuario);

    void listar() throws IOException;
}

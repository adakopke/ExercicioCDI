package Service;

import DAO.UsuarioDao;
import Dominio.Usuario;

import javax.inject.Inject;
import java.io.IOException;

public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    public UsuarioDao usuarioDao;


    @Override
    public Usuario create(Usuario usuario) {
        usuarioDao.gravar(usuario);
        return usuario;
    }

    @Override
    public void listar() throws IOException {
        usuarioDao.listar();

    }
}

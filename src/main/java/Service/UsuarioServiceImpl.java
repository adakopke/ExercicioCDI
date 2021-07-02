package Service;

import DAO.UsuarioDao;
import Dominio.Usuario;

import javax.inject.Inject;

public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    public UsuarioDao usuarioDao;


    @Override
    public Usuario create(Usuario usuario) {
        System.out.println("passou aqui");
        usuarioDao.gravar(usuario);
        return usuario;
    }
}

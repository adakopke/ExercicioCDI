package DAO;

import Dominio.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
    @Override
    public void gravar(Usuario usuario) {
        System.out.println(usuario.getNome());
        System.out.println(usuario.getIdade());
    }
}

package View;

import Dominio.Usuario;
import Service.UsuarioService;
import Service.UsuarioServiceImpl;

import javax.inject.Inject;
import java.util.Scanner;

public class UsuarioViewImpl implements UsuarioView {

    @Inject
    public UsuarioService usuarioService;

    @Override
    public Usuario create(Scanner sc){
    Usuario usuario = new Usuario();
        System.out.println("Informe o nome do usuário");
        usuario.setNome(sc.next());
        System.out.println("Informe a idade do usuário");
        usuario.setIdade(sc.nextInt());
        usuarioService.create(usuario);
        System.out.printf("O usuário %s foi criado.\n", usuario);

    return usuario;
    }

}

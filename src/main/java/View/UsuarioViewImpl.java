package View;

import Dominio.Usuario;

import java.util.Scanner;

public class UsuarioViewImpl implements UsuarioView {

    @Override
    public Usuario create(Scanner sc){
    Usuario usuario = new Usuario();
        System.out.println("Informe o nome do usuário");
        usuario.setNome(sc.next());
        System.out.println("Informe a idade do usuário");
        usuario.setIdade(sc.nextInt());
    return usuario;
    }

}

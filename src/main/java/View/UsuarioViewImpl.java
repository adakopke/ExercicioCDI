package View;

import Dominio.Usuario;
import Service.UsuarioService;
import Service.UsuarioServiceImpl;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Scanner;

public class UsuarioViewImpl implements UsuarioView {

    @Inject
    public UsuarioService usuarioService;

    @Override
    public Usuario create(Scanner sc){
    Usuario usuario = new Usuario();
        System.out.println("Informe o nome do cliente");
        usuario.setNome(sc.next());
        System.out.println("Informe a idade do cliente");
        usuario.setIdade(sc.nextInt());
        System.out.println("Informe o código do cliente");
        usuario.setCodCliente(sc.nextInt());
        System.out.println("Informe a senha:");
        usuario.setSenha(sc.next());
        usuarioService.create(usuario);
        System.out.println("Cliente cadastrado com sucesso");

    return usuario;
    }

    @Override
    public void listar() throws IOException {
       usuarioService.listar();
    }

}

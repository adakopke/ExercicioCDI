package View;

import Dominio.Usuario;

import java.io.IOException;
import java.util.Scanner;

public interface UsuarioView {

    Usuario create(Scanner sc);

    void listar() throws IOException;
}

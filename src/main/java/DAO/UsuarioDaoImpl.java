package DAO;

import Dominio.Usuario;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class UsuarioDaoImpl implements UsuarioDao {
    @Override
    public void gravar(Usuario usuario) {

        try (FileWriter fw = new FileWriter("usuarios.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.printf( usuario.getCodCliente() + "," + usuario.getNome() + "," + usuario.getIdade() + "," + usuario.getSenha() + "\n");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    }

    @Override
    public void listar() throws IOException {

        try {
            BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"));
            String linha;
            while ((linha = br.readLine()) != null) {

                String[] cols = linha.split(",");
                System.out.println("CodCliente: " + cols[0] + " | Nome: " + cols[1]) ;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }
}

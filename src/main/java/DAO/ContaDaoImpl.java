package DAO;

import Dominio.Conta;
import Dominio.ContaCorrente;
import Dominio.TipoConta;

import javax.inject.Inject;
import java.io.*;

public class ContaDaoImpl implements ContaDao{

    @Inject
    public UsuarioDao usuarioDao;

    @Override
    public void gravarConta(Conta conta) {
        String definirNomeArquivo = conta.getCodCliente() + "_" + conta.tipoConta + ".txt";

        try (FileWriter fw = new FileWriter(definirNomeArquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.printf(conta.getSaldo() + "\n");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    }

    @Override
    public boolean clienteExiste(String[] validar) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"));
            int usuarioCadastrado = 0;
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] cols = linha.split(",");
                if (validar[0].equalsIgnoreCase(cols[0])) {
                    usuarioCadastrado = 1;
                }
            }

            if (usuarioCadastrado == 0) {
                return false;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean autenticacaoCliente(String[] validar) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"));
            int usuarioAutenticado = 0;
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] cols = linha.split(",");
                if (validar[0].equalsIgnoreCase(cols[0]) && validar[1].equalsIgnoreCase(cols[3])) {
                    usuarioAutenticado = 1;
                }
            }

            if (usuarioAutenticado == 0) {
                return false;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean arquivoExiste(String[] validar, TipoConta tipoConta) {

        String nomeArquivo = validar[0] + "_" + tipoConta + ".txt";

        return new File(nomeArquivo).exists();
    }

    @Override
    public String saldo(String nomeArquivo) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));

            return br.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");

        return null;
    }

    @Override
    public void atualizarSaldo(int valor, String nomeArquivo) {

        try (FileWriter fw = new FileWriter(nomeArquivo);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.printf(Integer.toString(valor));
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }


    }

}


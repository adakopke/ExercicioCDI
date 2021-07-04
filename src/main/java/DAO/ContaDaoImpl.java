package DAO;

import Dominio.Conta;
import Dominio.ContaCorrente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContaDaoImpl implements ContaDao{
    @Override
    public void gravarConta(Conta contaCorrente) {
        String definirNomeArquivo = contaCorrente.getCodCliente() + "_" + contaCorrente.tipoConta + ".txt";

        try (FileWriter fw = new FileWriter(definirNomeArquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.printf(contaCorrente.getCodCliente() + "," + contaCorrente.getSaldo() + "\n");
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    }
}

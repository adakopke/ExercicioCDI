package DAO;

import Dominio.Conta;
import Dominio.ContaCorrente;
import Dominio.TipoConta;

public interface ContaDao {

    void gravarConta(Conta conta);

    boolean clienteExiste(String[] validar);

    boolean autenticacaoCliente(String[] validar);

    boolean arquivoExiste(String[] validar, TipoConta tipoConta);

    String saldo(String nomeArquivo);

    void atualizarSaldo(int valor, String nomeArquivo);
}

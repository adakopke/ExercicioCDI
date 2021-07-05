package DAO;

import Dominio.Conta;
import Dominio.TipoConta;

public interface ContaDao {

    void gravarConta(Conta conta);

    boolean clienteExiste(String[] validar);

    boolean autenticacaoCliente(String[] validar);

    boolean arquivoExiste(String[] validar, TipoConta tipoConta);

    String saldo(String nomeArquivo);

    void atualizarSaldo(Float valor, String nomeArquivo);
}

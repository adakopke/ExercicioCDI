package DAO;

import Dominio.Conta;
import Dominio.TipoConta;

import java.math.BigDecimal;

public interface ContaDao {

    void gravarConta(Conta conta);

    boolean clienteExiste(String[] validar);

    boolean autenticacaoCliente(String[] validar);

    boolean arquivoExiste(String[] validar, TipoConta tipoConta);

    BigDecimal saldo(String nomeArquivo);

    void atualizarSaldo(BigDecimal valor, String nomeArquivo);
}

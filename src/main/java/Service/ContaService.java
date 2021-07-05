package Service;

import Dominio.Conta;
import Dominio.TipoConta;

import java.math.BigDecimal;

public interface ContaService {

    void create(Conta conta);
    void sacar(BigDecimal valor, String nomeArquivo);
    void depositar(BigDecimal valor, String nomeArquivo);
    void saldo(String nomeArquivo);
    boolean validarConta(String[] validar);
    boolean autenticarCliente(String[] validar);
    boolean clientePossuiConta(String[] validar, TipoConta tipoConta);
}

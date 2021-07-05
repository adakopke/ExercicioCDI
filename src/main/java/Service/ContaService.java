package Service;

import Dominio.Conta;
import Dominio.ContaCorrente;
import Dominio.TipoConta;

public interface ContaService {

    void create(Conta conta);
    void sacar(int valor, String nomeArquivo);
    void depositar(int valor, String nomeArquivo);
    String saldo(String nomeArquivo);
    boolean validarConta(String[] validar);
    boolean autenticarCliente(String[] validar);
    boolean clientePossuiConta(String[] validar, TipoConta tipoConta);
}

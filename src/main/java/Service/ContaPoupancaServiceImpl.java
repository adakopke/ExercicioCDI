package Service;

import Dominio.Conta;
import Dominio.TipoConta;
import Dominio.TipoContaAnotation;

@TipoContaAnotation(value = TipoConta.POUPANCA)
public class ContaPoupancaServiceImpl implements ContaService {
    @Override
    public void create(Conta conta) {
        System.out.println("passou ContaPoupança");

    }

    @Override
    public void sacar(int valor, String nomeArquivo) {

    }

    @Override
    public void depositar(int valor, String nomeArquivo) {

    }

    @Override
    public String saldo(String nomeArquivo) {
        return null;
    }


    @Override
    public boolean validarConta(String[] validar) {
        return true;
    }

    @Override
    public boolean autenticarCliente(String[] validar) {
        return false;
    }

    @Override
    public boolean clientePossuiConta(String[] validar, TipoConta tipoConta) {
        return false;
    }
}

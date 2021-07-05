package Service;

import DAO.ContaDao;
import Dominio.Conta;
import Dominio.TipoConta;
import Dominio.TipoContaAnotation;

import javax.inject.Inject;

@TipoContaAnotation(value = TipoConta.POUPANCA)
public class ContaPoupancaServiceImpl implements ContaService {

    @Inject
    public ContaDao contaDao;

    @Override
    public void create(Conta conta) {
        contaDao.gravarConta(conta);

    }

    @Override
    public void sacar(Float valor, String nomeArquivo) {

        Float saldoAtual = Float.parseFloat(contaDao.saldo(nomeArquivo));

        if ((saldoAtual - valor) < 0) {
            System.out.println("Você não possui saldo para realizar esse saque");
        } else {
            Float taxa = ((saldoAtual * 0.07f)/100);
            contaDao.atualizarSaldo((saldoAtual - valor - taxa), nomeArquivo);
        }


    }

    @Override
    public void depositar(Float valor, String nomeArquivo) {

        Float saldoAtual = Float.parseFloat(contaDao.saldo(nomeArquivo));
        Float taxa = ((saldoAtual * 0.07f)/100);
        contaDao.atualizarSaldo((saldoAtual + valor - taxa), nomeArquivo);
    }

    @Override
    public String saldo(String nomeArquivo) {
        contaDao.saldo(nomeArquivo);
        return contaDao.saldo(nomeArquivo);
    }


    @Override
    public boolean validarConta(String[] validar) {
        contaDao.clienteExiste(validar);
        return contaDao.clienteExiste(validar);
    }

    @Override
    public boolean autenticarCliente(String[] validar) {
        contaDao.autenticacaoCliente(validar);
        return contaDao.autenticacaoCliente(validar);
    }

    @Override
    public boolean clientePossuiConta(String[] validar, TipoConta tipoConta) {
        contaDao.arquivoExiste(validar, tipoConta);
        return contaDao.arquivoExiste(validar, tipoConta);
    }
}

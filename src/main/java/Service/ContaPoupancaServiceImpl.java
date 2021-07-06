package Service;

import DAO.ContaDao;
import Dominio.Conta;
import Dominio.TipoConta;
import Dominio.TipoContaAnotation;

import javax.inject.Inject;
import java.math.BigDecimal;

@TipoContaAnotation(value = TipoConta.POUPANCA)
public class ContaPoupancaServiceImpl implements ContaService {

    @Inject
    public ContaDao contaDao;

    @Override
    public void create(Conta conta) {
        contaDao.gravarConta(conta);

    }

    @Override
    public void sacar(BigDecimal valor, String nomeArquivo) {

        BigDecimal saldoAtual = contaDao.saldo(nomeArquivo);

        if ((saldoAtual.subtract(valor).compareTo(BigDecimal.valueOf(0))) < 0) {
            System.out.println("Você não possui saldo para realizar esse saque");
        } else {
            BigDecimal taxa = ((saldoAtual.multiply(BigDecimal.valueOf(0.07).divide(BigDecimal.valueOf(100)))));
            contaDao.atualizarSaldo((saldoAtual.subtract(valor).subtract(taxa)), nomeArquivo);
        }


    }

    @Override
    public void depositar(BigDecimal valor, String nomeArquivo) {

        BigDecimal saldoAtual = contaDao.saldo(nomeArquivo);

            BigDecimal taxa = ((saldoAtual.multiply(BigDecimal.valueOf(0.07).divide(BigDecimal.valueOf(100)))));
            contaDao.atualizarSaldo((saldoAtual.add(valor).subtract(taxa)), nomeArquivo);

    }


    @Override
    public void saldo(String nomeArquivo) {
        System.out.println(contaDao.saldo(nomeArquivo)
        );

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

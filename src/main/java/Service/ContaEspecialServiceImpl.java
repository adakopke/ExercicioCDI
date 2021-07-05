package Service;

import DAO.ContaDao;
import Dominio.Conta;
import Dominio.TipoConta;
import Dominio.TipoContaAnotation;

import javax.inject.Inject;
import java.math.BigDecimal;

@TipoContaAnotation(value = TipoConta.ESPECIAL)
public class ContaEspecialServiceImpl implements ContaService {

    @Inject
    public ContaDao contaDao;

    @Override
    public void create(Conta conta) {
        contaDao.gravarConta(conta);
    }

    @Override
    public void sacar(BigDecimal valor, String nomeArquivo) {
        BigDecimal saldoAtual = contaDao.saldo(nomeArquivo);

        if ((saldoAtual.subtract(valor).compareTo(BigDecimal.valueOf(-200))) < 0) {
            System.out.println("Você não possui saldo para realizar esse saque");
        } else {
            contaDao.atualizarSaldo((saldoAtual.subtract(valor)), nomeArquivo);
        }
    }

        @Override
        public void depositar (BigDecimal valor, String nomeArquivo){
            BigDecimal saldoAtual = contaDao.saldo(nomeArquivo);
            contaDao.atualizarSaldo((saldoAtual.add(valor)), nomeArquivo);
        }


        @Override
        public void saldo (String nomeArquivo){
            BigDecimal saldoAtual = contaDao.saldo(nomeArquivo);
            //TODO trazer o limite do arquivo
            BigDecimal limite = BigDecimal.valueOf(200);
            if (saldoAtual.compareTo(BigDecimal.valueOf(0)) >= 0) {
                System.out.println(
                        "Seu saldo é de :" +
                                saldoAtual.toString() + "\n" +
                                "Seu limite é de :" + limite
                                        );


            } else {
                System.out.println(
                "Seu saldo é de : 0" +
                        "\n" +
                        "Seu limite é de :" + (limite.subtract(saldoAtual.abs()))
                );
            }

        }

        @Override
        public boolean validarConta (String[]validar){
        contaDao.clienteExiste(validar);
        return contaDao.clienteExiste(validar);

        }

        @Override
        public boolean autenticarCliente (String[]validar){
        contaDao.autenticacaoCliente(validar);
        return contaDao.autenticacaoCliente(validar);
        }

        @Override
        public boolean clientePossuiConta (String[]validar, TipoConta tipoConta){
            contaDao.arquivoExiste(validar, tipoConta);
            return contaDao.arquivoExiste(validar, tipoConta);
        }

    }



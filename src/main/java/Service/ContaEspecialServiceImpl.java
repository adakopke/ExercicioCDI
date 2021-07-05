package Service;

import DAO.ContaDao;
import Dominio.Conta;
import Dominio.ContaEspecial;
import Dominio.TipoConta;
import Dominio.TipoContaAnotation;
import org.w3c.dom.ls.LSOutput;

import javax.inject.Inject;

@TipoContaAnotation(value = TipoConta.ESPECIAL)
public class ContaEspecialServiceImpl implements ContaService {

    @Inject
    public ContaDao contaDao;

    @Override
    public void create(Conta conta) {
        contaDao.gravarConta(conta);
    }

    @Override
    public void sacar(Float valor, String nomeArquivo) {
        Float saldoAtual = Float.parseFloat(contaDao.saldo(nomeArquivo));

        if ((saldoAtual - valor) < -200) {
            System.out.println("Você não possui saldo para realizar esse saque");
        } else {
            contaDao.atualizarSaldo((saldoAtual - valor), nomeArquivo);
        }
    }

        @Override
        public void depositar ( Float valor, String nomeArquivo){
            Float saldoAtual = Float.parseFloat(contaDao.saldo(nomeArquivo));
            contaDao.atualizarSaldo((saldoAtual + valor), nomeArquivo);
        }


        @Override
        public String saldo (String nomeArquivo){
            Float saldoAtual = Float.parseFloat(contaDao.saldo(nomeArquivo));
            //TODO trazer o limite do arquivo
            Float limite = 200f;
            if (saldoAtual >= 0) {

                return "Seu saldo é de :" +
                        Float.toString(saldoAtual) + "\n" +
                        "Seu limite é de :" + limite;


            } else {
                return "Seu saldo é de : 0" +
                        "\n" +
                        "Seu limite é de :" + (limite - Math.abs(saldoAtual));
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



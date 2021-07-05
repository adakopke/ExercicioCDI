package Service;

import DAO.ContaDao;
import Dominio.Conta;
import Dominio.ContaCorrente;
import Dominio.TipoConta;
import Dominio.TipoContaAnotation;

import javax.inject.Inject;

@TipoContaAnotation(value = TipoConta.CORRENTE)
public class ContaCorrenteServiceImpl implements ContaService {

    @Inject
    public ContaDao contaDao;


    @Override
    public void create(Conta conta) {

        //contaDao.gravarConta(conta);
    System.out.println("passou ContaCorrente");
    }
}

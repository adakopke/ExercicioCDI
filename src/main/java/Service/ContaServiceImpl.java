package Service;

import DAO.ContaDao;
import Dominio.Conta;
import Dominio.ContaCorrente;

import javax.inject.Inject;

public class ContaServiceImpl implements ContaService {

    @Inject
    public ContaDao contaDao;


    @Override
    public void create(Conta contaCorrente) {
    contaDao.gravarConta(contaCorrente);
    }
}

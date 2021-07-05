package Service;

import Dominio.Conta;
import Dominio.TipoConta;
import Dominio.TipoContaAnotation;

@TipoContaAnotation(value = TipoConta.INVESTIMENTO)
public class ContaInvestimentoServiceImpl implements ContaService {
    @Override
    public void create(Conta conta) {
        System.out.println("passou ContaInvestimento");
    }
}

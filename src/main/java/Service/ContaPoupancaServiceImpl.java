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
}

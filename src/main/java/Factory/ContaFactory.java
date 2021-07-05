package Factory;

import AnotationLiteral.ContaAnotationLiteral;
import Dominio.TipoConta;
import Service.ContaService;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class ContaFactory {

    @Inject
    @Any
    private Instance<ContaService> contaServiceInstance;

    public ContaService createConta(TipoConta tipoConta) {
        ContaAnotationLiteral literal = new ContaAnotationLiteral(tipoConta);
        return contaServiceInstance.select(literal).get();
    }
}


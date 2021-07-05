package AnotationLiteral;

import Dominio.TipoConta;
import Dominio.TipoContaAnotation;

import javax.enterprise.util.AnnotationLiteral;

public class ContaAnotationLiteral extends AnnotationLiteral<TipoContaAnotation> implements TipoContaAnotation {

    private final TipoConta tipoConta;

    public ContaAnotationLiteral(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public TipoConta value() {
        return tipoConta;
    }
}

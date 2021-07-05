package Dominio;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.inject.Default;
import javax.inject.Qualifier;

@Getter
@Setter
public abstract class Conta {

    public TipoConta tipoConta;
    public Integer saldo;
    public Integer codCliente;


}

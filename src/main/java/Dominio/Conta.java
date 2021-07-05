package Dominio;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public abstract class Conta {

    public TipoConta tipoConta;
    public BigDecimal saldo;
    public Integer codCliente;


}

package Dominio;

import javax.enterprise.inject.Default;
import javax.inject.Qualifier;


public abstract class Conta {

    public TipoConta tipoConta;
    public Integer saldo;
    public Integer codCliente;

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "tipoConta=" + tipoConta +
                ", nome='" + saldo + '\'' +
                ", proprietario='" + codCliente + '\'' +
                '}';
    }
}

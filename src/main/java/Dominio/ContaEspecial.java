package Dominio;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ContaEspecial extends Conta {

  private BigDecimal limite;

}

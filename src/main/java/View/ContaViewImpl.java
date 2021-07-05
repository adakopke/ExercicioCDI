package View;

import DAO.UsuarioDao;
import Dominio.*;
import Factory.ContaFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Scanner;

public class ContaViewImpl implements ContaView {


    @Inject
    public UsuarioDao usuarioDao;

    @Inject
    public ContaFactory contaFactory;

    @Override
    public void init() throws IOException {
        System.out.println("Qual tipo de conta deseja criar?");
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println(
                    "1 - Conta Corrente\n" +
                    "2 - Conta Especial\n" +
                    "3 - Conta Poupança\n" +
                    "0 - Sair\n"
            );
            opcao = sc.nextInt();
            opcaoEscolhida(opcao, sc);
        } while (opcao > 0);

    }

    private void opcaoEscolhida(int opcao, Scanner sc) throws IOException {


        switch (opcao) {

            case 1:
                System.out.println("criar conta corrente");
                Conta contaCorrente = new ContaCorrente();
                contaCorrente.setSaldo(0f);
                System.out.println("Digite o código do cliente para associar a conta corrente");
                usuarioDao.listar();
                contaCorrente.setCodCliente(sc.nextInt());
                contaCorrente.setTipoConta(TipoConta.CORRENTE);
                contaFactory.escolherConta(TipoConta.CORRENTE).create(contaCorrente);
                System.out.println("Caso não queria criar outra conta digite 0 para sair");
                break;

            case 2:
                System.out.println("criar conta especial");
                ContaEspecial contaEspecial = new ContaEspecial();
                contaEspecial.setSaldo(400f);
                contaEspecial.setLimite(200f);
                System.out.println("Digite o código do cliente para associar a conta especial");
                usuarioDao.listar();
                contaEspecial.setCodCliente(sc.nextInt());
                contaEspecial.setTipoConta(TipoConta.ESPECIAL);
                contaFactory.escolherConta(TipoConta.ESPECIAL).create(contaEspecial);
                System.out.println("Caso não queria criar outra conta digite 0 para sair");
                break;

            case 3:
                System.out.println("criar conta poupança");
                Conta contaPoupanca = new ContaPoupanca();
                contaPoupanca.setSaldo(100f);
                System.out.println("Digite o código do cliente para associar a contaPoupança");
                usuarioDao.listar();
                contaPoupanca.setCodCliente(sc.nextInt());
                contaPoupanca.setTipoConta(TipoConta.POUPANCA);
                contaFactory.escolherConta(TipoConta.POUPANCA).create(contaPoupanca);
                System.out.println("Caso não queria criar outra conta digite 0 para sair");
                break;

            case 0:
                //TODO como faço para voltar ao menu anterior?
                System.exit(0);
                break;

            default:
                System.out.println("Escolha uma opção válida");
        }

    }

}

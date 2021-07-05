package View;

import DAO.UsuarioDao;
import Dominio.*;
import Factory.ContaFactory;
import Service.ContaPoupancaServiceImpl;
import Service.ContaService;

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

        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println(
                    "1 - Conta Corrente\n" +
                    "2 - Conta Investimento\n" +
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
                System.out.println("Informe o saldo de abertura");
                contaCorrente.setSaldo(sc.nextInt());
                System.out.println("A qual usuário deseja associar a contaCorrente");
                usuarioDao.listar();
                contaCorrente.setCodCliente(sc.nextInt());
                contaCorrente.setTipoConta(TipoConta.CORRENTE);
                contaFactory.createConta(TipoConta.CORRENTE).create(contaCorrente);


                break;

            case 2:
                System.out.println("criar conta investimento");
                Conta contaInvestimento = new ContaInvestimento();
                System.out.println("Informe o saldo de abertura");
                contaInvestimento.setSaldo(sc.nextInt());
                System.out.println("A qual usuário deseja associar a contaInvestimento");
                usuarioDao.listar();
                contaInvestimento.setCodCliente(sc.nextInt());
                contaInvestimento.setTipoConta(TipoConta.INVESTIMENTO);
                contaFactory.createConta(TipoConta.INVESTIMENTO).create(contaInvestimento);



                break;

            case 3:
                System.out.println("criar conta poupança");
                Conta contaPoupanca = new ContaPoupanca();
                System.out.println("Informe o saldo de abertura");
                contaPoupanca.setSaldo(sc.nextInt());
                System.out.println("A qual usuário deseja associar a contaPoupança");
                usuarioDao.listar();
                contaPoupanca.setCodCliente(sc.nextInt());
                contaPoupanca.setTipoConta(TipoConta.POUPANCA);
                contaFactory.createConta(TipoConta.POUPANCA).create(contaPoupanca);

                break;

            case 0:
                //TODO como faço para voltar ao menu anterior
                System.out.println("voltar ao menu anterior");

                break;

            default:
                System.out.println("Escolha uma opção válida");
        }

    }

}

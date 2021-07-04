package View;

import DAO.UsuarioDao;
import Dominio.Conta;
import Dominio.ContaCorrente;
import Dominio.TipoConta;
import Service.ContaService;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Scanner;

public class ContaViewImpl implements ContaView {

    @Inject
    public ContaService contaService;

    @Inject
    public UsuarioDao usuarioDao;


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
                contaService.create(contaCorrente);


                break;

            case 2:
                System.out.println("criar contaCorrente investimento");
                break;

            case 3:
                System.out.println("criar contaCorrente poupança");
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

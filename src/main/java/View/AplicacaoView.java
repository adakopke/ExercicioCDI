package View;

import View.UsuarioView;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Scanner;

public class AplicacaoView {

    @Inject
    private UsuarioView usuarioView;

    @Inject
    private ContaView contaView;

    @Inject
    private OperarContaView operarContaView;

    public void init() throws IOException {

        int opcao = 0;
        System.out.println("Bem-vindo");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(
                            "1 - Cadastrar Cliente\n" +
                            "2 - Cadastrar conta\n" +
                            "3 - Operar conta\n" +
                            "0 - Sair");
            opcao = sc.nextInt();
            definirOpcao(sc, opcao);
        } while (opcao > 0);


    }

    private void definirOpcao(Scanner sc, int opcao) throws IOException {

        switch (opcao) {
            case 1:
                usuarioView.create(sc);
                break;

            case 2:
                contaView.init();

            case 3:
                operarContaView.init();

            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Digite uma opção válida");

        }

    }
}






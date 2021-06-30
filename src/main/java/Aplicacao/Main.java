package Aplicacao;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

    final WeldContainer container = new Weld().initialize();
    final Aplicacao aplicacao = container.select(Aplicacao.class).get();

    init(aplicacao);

    }

    private static void init(Aplicacao aplicacao) {
        int opcao = 0;
        System.out.println("Bem-vindo");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1 - Cadastrar\n0 - Sair");
          opcao = sc.nextInt();
          definirOpcao(sc, opcao, aplicacao);
        } while (opcao > 0);

    }

    private static void definirOpcao(Scanner sc, int opcao, Aplicacao aplicacao) {
        switch (opcao) {
            case 1:
                //TODO fazer cadastro do usuário
               aplicacao.getUsuarioView().create(sc);
            break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Digite uma opção válida");

        }

    }

}

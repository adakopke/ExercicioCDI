package View;

import Dominio.TipoConta;
import Factory.ContaFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class OperarContaViewImpl implements OperarContaView {

@Inject
public ContaFactory contaFactory;

    @Override
        public void init() throws IOException {
        System.out.println("=== Autenticação ===");
            Scanner sc = new Scanner(System.in);
            String[] validar = new String[2];
            System.out.println("insira seu código de cliente");
            validar[0] = sc.next();
            System.out.println("insira sua senha");
            validar[1] = sc.next();
            //TODO usei o escolher conta mas aqui nem precisava escolhar uma conta só para validar o cliente. Melhorar
            if(!contaFactory.escolherConta(TipoConta.CORRENTE).validarConta(validar)) {
                System.err.println("usuário não cadastrado");
                System.exit(0);

            } else

                //TODO usei o escolher conta mas aqui nem precisava escolhar uma conta só para validar o cliente. Melhorar
                if (contaFactory.escolherConta(TipoConta.CORRENTE).autenticarCliente(validar)) {

                    int opcao = 0;
                    do {

                        System.out.println(
                                        "1 - Conta Corrente\n" +
                                        "2 - Conta Especial\n" +
                                        "3 - Conta Poupança\n" +
                                        "0 - Sair\n"
                        );
                        opcao = sc.nextInt();
                          opcaoEscolhida(opcao, sc, validar);
                    } while (opcao > 0);




                } else {
                    System.err.println("usuário ou senha inválido");
                    System.exit(0);
                }


        }

    private void opcaoEscolhida(int opcao, Scanner sc, String[] validar) {

        switch (opcao) {

            case 1:

               if(contaFactory.escolherConta(TipoConta.CORRENTE).clientePossuiConta(validar, TipoConta.CORRENTE)) {

                   System.out.println("Qual operação deseja realizar?\n" +
                                      "1 - Consultar saldo\n" +
                                      "2 - Sacar\n" +
                                      "3 - Depositar"
                                      );
                   int operacao = sc.nextInt();
                   escolhaOperacao(operacao, TipoConta.CORRENTE, validar, sc);


               } else {
                   System.out.println("Cliente não possui conta corrente associada.");
               }
                break;

            case 2:

                if(contaFactory.escolherConta(TipoConta.ESPECIAL).clientePossuiConta(validar, TipoConta.ESPECIAL)) {

                    System.out.println("Qual operação deseja realizar?\n" +
                            "1 - Consultar saldo\n" +
                            "2 - Sacar\n" +
                            "3 - Depositar"
                    );
                    int operacao = sc.nextInt();
                    escolhaOperacao(operacao, TipoConta.ESPECIAL, validar, sc);


                } else {
                    System.out.println("Cliente não possui conta especial associada.");
                }
                break;

            case 3:

                if(contaFactory.escolherConta(TipoConta.POUPANCA).clientePossuiConta(validar, TipoConta.POUPANCA)) {

                    System.out.println("Qual operação deseja realizar?\n" +
                            "1 - Consultar saldo\n" +
                            "2 - Sacar\n" +
                            "3 - Depositar"
                    );
                    int operacao = sc.nextInt();
                    escolhaOperacao(operacao, TipoConta.POUPANCA, validar, sc);


                } else {
                    System.out.println("Cliente não possui conta poupança associada.");
                }
                break;

            case 0:
                System.exit(0);

            default :
                System.out.println("Escolha uma opção válida");

        }


    }

    private void escolhaOperacao(int operacao, TipoConta tipoConta, String[] validar, Scanner sc) {

        String nomeArquivo = validar[0] + "_" + tipoConta + ".txt";

        switch (operacao) {

            case 1:
                System.out.print("Saldo em " + LocalDate.now() + " : ");
                contaFactory.escolherConta(tipoConta).saldo(nomeArquivo);
                System.out.println();
                break;

            case 2:

                System.out.println("Digite o valor que deseja sacar");
                BigDecimal valor = BigDecimal.valueOf(sc.nextFloat());
                contaFactory.escolherConta(tipoConta).sacar(valor, nomeArquivo);
                break;

            case 3:

                System.out.println("Digite o valor que deseja depositar");
                valor = BigDecimal.valueOf(sc.nextFloat());
                contaFactory.escolherConta(tipoConta).depositar(valor, nomeArquivo);
                break;

        }




    }


}

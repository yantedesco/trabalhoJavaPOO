package sistema;

import Users.Usuario;
import armazenamento.File;
import banco.Conta;

import java.util.Scanner;

public class SistemaInterno {


    Scanner sc = new Scanner(System.in);


    // menu principal
    public void menuPrincipal() {
        //String nome, int id, String cpf, String tipo, String senha, int agencia

        login();
        



        
    }

    // menu cliente
    public void menuCliente(Usuario usuario, Conta contaUsuario) {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - ÁREA DO CLIENTE:");
            System.out.println("\n                   =============================");
            System.out.println("                  |  1 - MOVIMENTACOES DE CONTA |");
            System.out.println("                  |  2 - RELATORIOS             |");
            System.out.println("                  |  3 - MENU PRINCIPAL         |");
            System.out.println("                  |  0 - SAIR                   |");
            System.out.println("                   =============================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    //MENU DE CONTA;
                    menuOpConta(usuario,contaUsuario);
                    break;
                case 2:
                    //MENU RELAATORIOS;
                    menuRelatorioCliente();
                    break;
                case 3:
                    menuPrincipal();
                    break;
                case 0:
                    break;

            }

        } while (opcao != 0);

    }

    //menu operações de conta cliente
    /*public void menuOpContaCliente() {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - MOVIMENTAÇÕES DE CONTA :");
            System.out.println("\n                   ======================");
            System.out.println("                  |  1 - SAQUE           |");
            System.out.println("                  |  2 - DEPOSITO        |");
            System.out.println("                  |  3 - TRANSFERÊNCIA   |");
            System.out.println("                  |  4 - MENU ANTERIOR   |");
            System.out.println("                  |  5 - MENU PRINCIPAL  |");
            System.out.println("                  |  0 - SAIR            |");
            System.out.println("                   ======================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    //SAQUE;
                    //           sacar();
//                    File.escritor(File.getPathBasico() +
//                            usuario.getNome() + "_" + usuario.getCpf() + File.getEXTENSAO());
                    break;

                case 2:
                    //DEPOSITO;
                    //            depositar();
                    break;
                case 3:
                    //TRANSFERÊNCIAS;
                    //            transferir();
                    break;
                case 4:
                    // VOLTA MENU ANT.
                    menuCliente();
                    break;
                case 5:
                    //VOLTA MENU PRINC.
                    menuPrincipal();
                    break;
                case 0:
                    //SAIR
                    break;

            }

        } while (opcao != 0);

    }*/

    //menu relatorios cliente
    public void menuRelatorioCliente() {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - RELATÓRIO :");
            System.out.println("\n                   ===========================");
            System.out.println("                  |  1 - SALDO                |");
            System.out.println("                  |  2 - TRIBUTAÇÃO CC        |");
            System.out.println("                  |  3 - RENDIMENTO POUPANÇA  |");
            System.out.println("                  |  4 - MENU ANTERIOR        |");
            System.out.println("                  |  5 - MENU PRINCIPAL       |");
            System.out.println("                  |  0 - SAIR                 |");
            System.out.println("                   ===========================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:

                    //				RELATORIO SALDO;
                    break;

                case 2:
                    //				RELATORIO TRIBUTAÇÃO CC;
                    break;

                case 3:
                    //				RELATORIO RENDIMENTO POUPANÇA;
                    break;
                case 4:
                    // VOLTA MENU ANT.
                   
                    break;

                case 5:
                    //VOLTA MENU PRINC.
                    menuPrincipal();
                    break;
                case 0:
                    //SAIR
                    break;

            }

        } while (opcao != 0);

    }

    // menu gerente
    public void menuGerente(Usuario usuario, Conta contaUsuario) {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - ÁREA DO CLIENTE:");
            System.out.println("\n                   =============================");
            System.out.println("                  |  1 - MOVIMENTACOES DE CONTA |");
            System.out.println("                  |  2 - RELATORIOS             |");
            System.out.println("                  |  3 - MENU PRINCIPAL         |");
            System.out.println("                  |  0 - SAIR                   |");
            System.out.println("                   =============================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    //MENU DE CONTA;
                    menuOpConta(usuario, contaUsuario);
                    break;
                case 2:
                    //MENU RELATORIOS;
                    menuRelatorioGerente();
                    break;
                case 3:
                    menuPrincipal();
                    break;
                case 0:
                    break;

            }

        } while (opcao != 0);

    }

    // menu operações de conta gerente
    public void menuOpConta(Usuario usuario, Conta contaUsuario) {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - MOVIMENTAÇÕES DE CONTA:");
            System.out.println("\n                   ======================");
            System.out.println("                  |  1 - SAQUE           |");
            System.out.println("                  |  2 - DEPOSITO        |");
            System.out.println("                  |  3 - TRANSFERÊNCIA   |");
            System.out.println("                  |  0 - MENU ANTERIOR   |");
            System.out.println("                   ======================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    //SAQUE;
                    System.out.println("Quanto deseja sacar? ");
                    System.out.print("Valor: ");
                    double valorSaque = sc.nextDouble();
                    contaUsuario.sacar(valorSaque);
                    break;

                case 2:
                    //DEPOSITO;
                    System.out.println("Quanto deseja depositar? ");
                    System.out.print("Valor: ");
                    double valorDeposito = sc.nextDouble();
                    contaUsuario.depositar(valorDeposito);
                    
                    break;
                case 3:
                    //TRANSFERÊNCIAS
                    System.out.println("Quanto deseja transferir? ");
                    System.out.print("Valor: ");
                    double valorTransf = sc.nextDouble();
                    System.out.print("Informe o cpf do titular da conta para transferência: ");
                    String cpfDestino = sc.next();
                    Conta contaDest = pegaConta(cpfDestino);
                    contaUsuario.transfere(contaDest, valorTransf);
                    break;
                case 0:
                    // VOLTA MENU ANT.
                    break;
            }

        } while (opcao != 0);

    }

    //menu relatorios gerente
    public void menuRelatorioGerente() {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - RELATÓRIO GERENTE :");
            System.out.println("\n                   =========================================");
            System.out.println("                  |  1 - SALDO                              |");
            System.out.println("                  |  2 - TRIBUTAÇÃO CC                      |");
            System.out.println("                  |  3 - RENDIMENTO POUPANÇA                |");
            System.out.println("                  |  4 - NÚMERO DE CONTAS NA MESMA AGÊNCIA  |");
            System.out.println("                  |  5 - MENU ANTERIOR                      |");
            System.out.println("                  |  6 - MENU PRINCIPAL                     |");
            System.out.println("                  |  0 - SAIR                               |");
            System.out.println("                   =========================================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:

                    //				RELATORIO SALDO;
                    break;

                case 2:
                    //				RELATORIO TRIBUTAÇÃO CC;
                    break;

                case 3:
                    //				RELATORIO RENDIMENTO POUPANÇA;
                    break;

                case 4:
                    //				Relatório do número contas na mesma agência em que este gerente trabalha
                    break;

                case 5:
                    // VOLTA MENU ANT.
                    break;

                case 6:
                    //VOLTA MENU PRINC.
                    menuPrincipal();
                    break;
                case 0:
                    //SAIR
                    break;

            }

        } while (opcao != 0);

    }


    // menu diretor
    public void menuDiretor(Usuario usuario, Conta contaUsuario) {
        
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - ÁREA DO DIRETOR:");
            System.out.println("\n                   =============================");
            System.out.println("                  |  1 - MOVIMENTAÇÕES DE CONTA |");
            System.out.println("                  |  2 - RELATORIOS             |");
            System.out.println("                  |  0 - SAIR                   |");
            System.out.println("                   =============================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    menuOpConta(usuario, contaUsuario);
                    break;

                case 2:
                    menuRelatorioDiretor(usuario, contaUsuario);
                    break;
                case 0:
                    break;

            }

        } while (opcao != 0);

    }

    // menu diretor
    public void menuPresidente(Usuario usuario, Conta contaUsuario) {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - ÁREA DO PRESIDENTE:");
            System.out.println("\n                   =============================");
            System.out.println("                  |  1 - RELATORIOS             |");
            System.out.println("                  |  0 - SAIR                   |");
            System.out.println("                   =============================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    //RELATORIO PRESIDENTE
                    break;

                case 0:
                    break;

            }

        } while (opcao != 0);

    }


    //Login menu
    public void login() {


        System.out.print("=============================================");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("Bem vindo ao Login do Banco dos Pinguins!\n");
        System.out.print("\n");
        int opcao = 1;
        while (opcao != 0) {
             System.out.println("\n        ===========================");
            System.out.println("      |  1 - LOGIN                  |");
            System.out.println("      |  0 - SAIR                   |");
            System.out.println("        ===========================\n");
            System.out.print("\n");
            System.out.print("OPÇÃO --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o seu CPF:");
                    String cpf = sc.next();
                    System.out.print("Digite sua senha:");
                    String senha = sc.next();



                    Usuario usuario = verificaLogin(cpf, senha);
                    Conta contaUsuario = pegaConta(cpf);
                    int numConta = usuario.getNumeroConta();
                    if (usuario != null) {
                        System.out.print("Login efetuado! Bem vindo!");
                        System.out.print("\n");
                        System.out.print("Quase lá, você será redirecionado...");
                        System.out.print("\n");
                        //for each para pegar as contas
                        

                        if (usuario.getTipo().equalsIgnoreCase("diretor")) {
                            menuDiretor(usuario, contaUsuario);
                        } else if (usuario.getTipo().equalsIgnoreCase("cliente")) {
                            menuCliente(usuario, contaUsuario);
                        } else if (usuario.getTipo().equalsIgnoreCase("presidente")) {
                            menuPresidente(usuario,contaUsuario);
                        } else if (usuario.getTipo().equalsIgnoreCase("gerente")) {
                            menuGerente(usuario, contaUsuario);
                        }


                    } else {
                        System.out.print("Usuário não reconhecido, tente novamente.");
                        System.out.print("\n");
                    }
                    break;
                case 0:
                    System.out.print("Até logo!");
                    System.out.print("\n");
                default:
                    System.out.print("Erro na leitura!");
                    System.out.print("\n");
            }
        }
    }

    //Método verificar login
    public Usuario verificaLogin(String cpf, String senha) {
        for (Usuario user : File.getMapUsuario().values()) {
            if ((user.getCpf().equalsIgnoreCase(cpf)) && (user.getSenha().equalsIgnoreCase(senha))) {
                return user;
            }
        }
        return null;
    }
     public void menuRelatorioDiretor(Usuario usuario, Conta contaDiretor) {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - RELATÓRIO DIRETOR :");
            System.out.println("\n                   =========================================");
            System.out.println("                  |  1 - SALDO                              |");
            System.out.println("                  |  2 - TRIBUTAÇÃO CC                      |");
            System.out.println("                  |  3 - RENDIMENTO POUPANÇA                |");
            System.out.println("                  |  4 - RELATORIO DE CLIENTES DO BANCO     |");
            System.out.println("                  |  5 - MENU ANTERIOR                      |");
            System.out.println("                  |  6 - MENU PRINCIPAL                     |");
            System.out.println("                  |  0 - SAIR                               |");
            System.out.println("                   =========================================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Saldo em conta: " );
                    System.out.println("O saldo atual de"+ usuario.getNome()+" em conta é de R$: "+ contaDiretor.getSaldo());
                    break;

                case 2:
                    //				RELATORIO TRIBUTAÇÃO CC;
                    break;

                case 3:
                    //				RELATORIO RENDIMENTO POUPANÇA;
                    break;

                case 4:
                    System.out.println(File.getMapUsuario());
                    break;

                case 5:
                    // VOLTA MENU ANT.
                    break;

                case 6:
                    //VOLTA MENU PRINC.
                    menuPrincipal();
                    break;
                case 0:
                    //SAIR
                    break;

            }

        } while (opcao != 0);

    }
     public Conta pegaConta(String cpfUsuario){
        for (Conta conta : File.getMapConta().values()){
            if(conta.getCpfTitular().equalsIgnoreCase(cpfUsuario)){
               return conta;
            }
        }    
         return null;
    }


    public void imprimePinguin() {
        System.out.println("========================***=====================");
        System.out.println("========================*0*0*===================");
        System.out.println("=======================******>>=================");
        System.out.println("=======================***@**===================");
        System.out.println("=================<<<<<<<</>>>>>>>>>=============");
        System.out.println("================<<<<<<<<</>>>>>>>>>=============");
        System.out.println("==============<<<<<<<<<<</>>>>>>>>>>>>==========");
        System.out.println("==============<<<<<<<<<<</>>>>>>>>>>>>==========");
        System.out.println("===============<<<<<<<<<</>>>>>>>>>>>===========");
        System.out.println("===============<<<<<<<<<</>>>>>>>>>>============");
        System.out.println("================<<<<<<<<</>>>>>>>>>=============");
        System.out.println("=================<<<<<<<</>>>>>>>>>=============");
        System.out.println("=================<<<<<<<</>>>>>>>>==============");
        System.out.println("==================<<<<<<</>>>>>>>===============");
        System.out.println("===================<<<<<</>>>>>>================");
        System.out.println("====================<<<<</>>>>>=================");
        System.out.println("===============////////////////////=============");
        System.out.println(" Grupo06 Pinguins: Lucas Azevedo, Marcos Bet, Brayan Cataldo, Igor Stumpf, Yan Tedesco, Ricardo Araújo");

    }
}

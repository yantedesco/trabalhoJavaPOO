package sistema;

import Users.Usuario;
import armazenamento.File;

import java.util.Scanner;

public class SistemaInterno {


    Scanner sc = new Scanner(System.in);


    // menu principal
    public void menuPrincipal() {
        //String nome, int id, String cpf, String tipo, String senha, int agencia

        login();
        //condicional enum



        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - ESCOLHA O TIPO DE ACESSO:");
            System.out.println("\n                   =========================");
            System.out.println("                  |     1 - CLIENTE         |");
            System.out.println("                  |     2 - GERÊNCIA        |");
            System.out.println("                  |     3 - DIREÇÃO         |");
            System.out.println("                  |     4 - PRESIDÊNCIA     |");
            System.out.println("                  |     0 - SAIR            |");
            System.out.println("                   =========================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            System.out.print("\n");
            switch (opcao) {
                case 1:
                    //                if(autenticaCliente()){

                    menuCliente();
                    //                }
                    break;
                case 2:
                    menuGerente();
                    break;

                case 3:
                    menuDiretor();
                    break;
                case 4:
                    menuPresidente();
                    break;

                case 0:
                    break;

            }
        } while (opcao != 0);
    }

    // menu cliente
    public void menuCliente() {
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
                    menuOpContaCliente();
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
    public void menuOpContaCliente() {
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

    }

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
                    menuOpContaCliente();
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
    public void menuGerente() {
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
                    menuOpContaGerente();
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
    public void menuOpContaGerente() {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - MOVIMENTAÇÕES DE CONTA GERENTE :");
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
                    menuGerente();
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
                    menuOpContaGerente();
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
    public void menuDiretor() {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - ÁREA DO DIRETOR:");
            System.out.println("\n                   =============================");
            System.out.println("                  |  1 - RELATORIOS             |");
            System.out.println("                  |  0 - SAIR                   |");
            System.out.println("                   =============================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    //RELATORIO DIRETOR
                    break;

                case 0:
                    break;

            }

        } while (opcao != 0);

    }

    // menu diretor
    public void menuPresidente() {
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


        System.out.print("****************************");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("Bem vindo ao Login do Banco dos Pinguins!\n");
        System.out.print("\n");
        System.out.print("****************************");
        System.out.print("\n");
        System.out.print("\n");



        int opcao = 1;
        while (opcao != 0) {
            System.out.print("****************************");
            System.out.print("\n");
            System.out.print(" 1: Login ");
            System.out.print("\n");
            System.out.print(" 0: Sair");
            System.out.print("\n");
            System.out.print("****************************");
            System.out.print("\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o seu CPF:");
                    String cpf = sc.next();
                    System.out.print("Digite sua senha:");
                    String senha = sc.next();



                    Usuario usuario = verificaLogin(cpf, senha);
                    if (usuario != null) {
                        System.out.print("Login efetuado! Bem vindo!");
                        System.out.print("\n");
                        System.out.print("Quase lá, você será redirecionado...");
                        System.out.print("\n");
                        File.hashMapFromFileTextUsuario(File.getPathBasico() +
                                usuario.getNome() + "_" + usuario.getCpf() + File.getEXTENSAO());

                        if (File.getMapUsuario().containsKey("diretor")) {
                            menuDiretor();
                        } else if (File.getMapUsuario().containsKey("cliente")) {
                            menuCliente();
                        } else if (File.getMapUsuario().containsKey("presidente")) {
                            menuPresidente();
                        } else if (File.getMapUsuario().containsKey("gerente")) {
                            menuGerente();
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

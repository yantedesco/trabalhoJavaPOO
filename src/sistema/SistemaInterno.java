package sistema;

import Users.Usuario;
import armazenamento.File;
import banco.Conta;
import banco.Relatorio;

import java.util.Scanner;

public class SistemaInterno {


    Scanner sc = new Scanner(System.in);
    Relatorio rel = new Relatorio();


    // menu principal
    public void menuPrincipal() {
        //String nome, int id, String cpf, String tipo, String senha, int agencia

        login();        
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
                    if (usuario != null) {
                        System.out.print("Login efetuado! Bem vindo!");
                        System.out.print("\n");
                        System.out.print("Quase lá, você será redirecionado...");
                        System.out.print("\n");
                        //for each para pegar as contas

                        menuPorTipo(usuario, contaUsuario);

                    } else {
                        System.out.print("Usuário não reconhecido, tente novamente.");
                        System.out.print("\n");
                    }
                    break;
                case 0:
                    System.out.print("Até logo!");
                    System.out.print("\n");
                    System.exit(opcao);
                    
            }
        }
    }
    
    
    // menu operações de conta 
    public void menuOpConta(Usuario usuario, Conta contaUsuario) {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - MOVIMENTAÇÕES DE CONTA:");
            System.out.println("\n                   ======================");
            System.out.println("                  |  1 - SAQUE           |");
            System.out.println("                  |  2 - DEPOSITO        |");
            System.out.println("                  |  3 - TRANSFERÊNCIA   |");
            System.out.println("                  |  4 - MENU ANTERIOR   |");
            System.out.println("                  |  0 - SAIR            |");
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
                case 4:
                	menuPorTipo(usuario, contaUsuario);
                	break;
                case 0:
                    System.out.print("Até logo, " + usuario.getNome());
                    System.out.print("\n");
                    System.exit(opcao);
            }

        } while (opcao != 0);

    }
    

    // menu cliente
    public void menuCliente(Usuario usuario, Conta contaCliente) {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - ÁREA DO CLIENTE:");
            System.out.println("\n                   =============================");
            System.out.println("                  |  1 - MOVIMENTACOES DE CONTA |");
            System.out.println("                  |  2 - RELATORIOS             |");
            System.out.println("                  |  0 - SAIR                   |");
            System.out.println("                   =============================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    //MENU DE CONTA;
                    menuOpConta(usuario, contaCliente);
                    break;
                case 2:
                    //MENU RELAATORIOS;
                    menuRelatorioCliente(usuario, contaCliente);
                    break;
                case 0:
                    System.out.print("Até logo, " + usuario.getNome());
                    System.out.print("\n");
                    System.exit(opcao);

            }

        } while (opcao != 0);

    }

    
    //menu relatorios cliente
    public void menuRelatorioCliente(Usuario usuario, Conta contaCliente) {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - RELATÓRIO :");
            System.out.println("\n                   ============================");
            System.out.println("                  |  1 - SALDO                 |");
            System.out.println("                  |  2 - TRIBUTAÇÃO CC         |");
            System.out.println("                  |  3 - RENDIMENTO POUPANÇA   |");
            System.out.println("                  |  4 - MENU ANTERIOR         |");
            System.out.println("                  |  5 - LOGIN COM OUTRA CONTA |");
            System.out.println("                  |  0 - SAIR                  |");
            System.out.println("                   ============================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Saldo em conta" );
                    System.out.println("O saldo atual de "+ usuario.getNome()+" em conta é de R$ "+ contaCliente.getSaldo());
                    break;

                case 2:
                    //				RELATORIO TRIBUTAÇÃO CC;
                    rel.tributacao(contaCliente);
                    break;

                case 3:
                    //				RELATORIO RENDIMENTO POUPANÇA;
                    System.out.print("Qual valor você deseja simular? ");
                    double valor = sc.nextDouble();
                    System.out.print("Qual a duração do investimento? ");
                    int dias = sc.nextInt();
                    rel.simulaPoupanca(valor, dias);
                    break;
                case 4:
                	menuPorTipo(usuario, contaCliente);                   
                    break;

                case 5:
                    //VOLTA MENU PRINC.
                    menuPrincipal();
                    break;
                case 0:
                    System.out.print("Até logo, " + usuario.getNome());
                    System.out.print("\n");
                    System.exit(opcao);

            }

        } while (opcao != 0);

    }

        
    // menu gerente
    public void menuGerente(Usuario usuario, Conta contaUsuario) {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - ÁREA DO GERENTE:");
            System.out.println("\n                   =============================");
            System.out.println("                  |  1 - MOVIMENTACOES DE CONTA |");
            System.out.println("                  |  2 - RELATORIOS             |");
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
                    menuRelatorioGerente(usuario, contaUsuario);
                    break;
                case 0:
                    System.out.print("Até logo, " + usuario.getNome());
                    System.out.print("\n");
                    System.exit(opcao);

            }

        } while (opcao != 0);

    }    
    
    //menu relatorios gerente
    public void menuRelatorioGerente(Usuario usuario, Conta contaGerente) {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - RELATÓRIO GERENTE :");
            System.out.println("\n                   =========================================");
            System.out.println("                  |  1 - SALDO                              |");
            System.out.println("                  |  2 - TRIBUTAÇÃO CC                      |");
            System.out.println("                  |  3 - RENDIMENTO POUPANÇA                |");
            System.out.println("                  |  4 - NÚMERO DE CONTAS NA MESMA AGÊNCIA  |");
            System.out.println("                  |  5 - MENU ANTERIOR                      |");
            System.out.println("                  |  6 - LOGIN COM OUTRA CONTA              |");
            System.out.println("                  |  0 - SAIR                               |");
            System.out.println("                   =========================================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Saldo em conta" );
                    System.out.println("O saldo atual de "+ usuario.getNome()+" em conta é de R$ "+ contaGerente.getSaldo());
                    break;

                case 2:
                    //				RELATORIO TRIBUTAÇÃO CC;
                    rel.tributacao(contaGerente);
                    break;

                case 3:
                    //				RELATORIO RENDIMENTO POUPANÇA;
                    System.out.print("Qual valor você deseja simular? ");
                    double valor = sc.nextDouble();
                    System.out.print("Qual a duração do investimento? ");
                    int dias = sc.nextInt();
                    rel.simulaPoupanca(valor, dias);
                    break;

                case 4:
                    //				Relatório do número contas na mesma agência em que este gerente trabalha

                    break;

                case 5:
                	menuPorTipo(usuario, contaGerente);
                	break;
                case 6:
                    menuPrincipal();
                    break;
                case 0:
                    System.out.print("Até logo, " + usuario.getNome());
                    System.out.print("\n");
                    System.exit(opcao);

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
                    System.out.print("Até logo, " + usuario.getNome());
                    System.out.print("\n");
                    System.exit(opcao);

            }

        } while (opcao != 0);

    }
    
    
// menu relatorio diretor
     public void menuRelatorioDiretor(Usuario usuario, Conta contaDiretor) {
        int opcao;
        do {
            System.out.println("\n\n BANCO DOS PINGUINS - RELATÓRIO DIRETOR :");
            System.out.println("\n                   ==========================================");
            System.out.println("                  |  1 - SALDO                               |");
            System.out.println("                  |  2 - TRIBUTAÇÃO CC                       |");
            System.out.println("                  |  3 - SIMULAÇÃO DE RENDIMENTO EM POUPANÇA |");
            System.out.println("                  |  4 - RELATORIO DE CLIENTES DO BANCO      |");
            System.out.println("                  |  5 - MENU ANTERIOR                       |");
            System.out.println("                  |  6 - LOGIN COM OUTRA CONTA               |");
            System.out.println("                  |  0 - SAIR                                |");
            System.out.println("                   ==========================================\n");
            System.out.print("Opção --> ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Saldo em conta" );
                    System.out.println("O saldo atual de "+ usuario.getNome()+" em conta é de R$ "+ contaDiretor.getSaldo());
                    break;

                case 2:
                    //				RELATORIO TRIBUTAÇÃO CC;
                    rel.tributacao(contaDiretor);
                    break;

                case 3:
                    //				RELATORIO RENDIMENTO POUPANÇA;
                    System.out.print("Qual valor você deseja simular? ");
                    double valor = sc.nextDouble();
                    System.out.print("Qual a duração do investimento? ");
                    int dias = sc.nextInt();
                    rel.simulaPoupanca(valor, dias);
                    break;

                case 4:
                    rel.nomesOrdemAlfabetica();
                    break;

                case 5:
                	menuPorTipo(usuario, contaDiretor);
                    break;

                case 6:
                    //VOLTA MENU PRINC.
                    menuPrincipal();
                    break;
                case 0:
                    System.exit(opcao);
                    break;

            }

        } while (opcao != 0);
        
    }

     // menu area presidente
     public void menuPresidente(Usuario usuario, Conta contaPresidente) {
         int opcao;
         do {
             System.out.println("\n\n BANCO DOS PINGUINS - ÁREA DO PRESIDENTE:");
             System.out.println("\n                   =============================");
             System.out.println("                  |  1 - MOVIMENTACOES DE CONTA |");
             System.out.println("                  |  2 - RELATORIOS             |");
             System.out.println("                  |  0 - SAIR                   |");
             System.out.println("                   =============================\n");
             System.out.print("Opção --> ");
             opcao = sc.nextInt();
             switch (opcao) {
                 case 1:
                     menuOpConta(usuario, contaPresidente);
                     break;
                 case 2:
                	//RELATORIO PRESIDENTE
                	 menuRelatorioPresidente(usuario, contaPresidente);
                	 break;

                 case 0:
                     System.out.print("Até logo!");
                     System.out.print("\n");
                     System.exit(opcao);

             }

         } while (opcao != 0);

     }
     
     // menu relatorio Presidente
     public void menuRelatorioPresidente(Usuario usuario, Conta contaPresidente) {
     	int opcao;
     	do {
     		System.out.println("\n\n BANCO DOS PINGUINS - RELATÓRIO PRESIDENTE :");
     		System.out.println("\n                   =========================================");
     		System.out.println("                  |  1 - SALDO                              |");
     		System.out.println("                  |  2 - TRIBUTAÇÃO CC                      |");
     		System.out.println("                  |  3 - RELATORIO RENDIMENTO EM POUPANÇA   |");
     		System.out.println("                  |  4 - RELATORIO DE CLIENTES DO BANCO     |");
     		System.out.println("                  |  5 - RELATORIO DE CAPITAL TOTAL         |");
     		System.out.println("                  |  6 - MENU ANTERIOR                      |");
     		System.out.println("                  |  7 - LOGIN COM OUTRA CONTA              |");
     		System.out.println("                  |  0 - SAIR                               |");
     		System.out.println("                   =========================================\n");
     		System.out.print("Opção --> ");
     		opcao = sc.nextInt();
     		switch (opcao) {
            case 1:
                System.out.println("Saldo em conta" );
                System.out.println("O saldo atual de "+ usuario.getNome()+" em conta é de R$ "+ contaPresidente.getSaldo());
                break;

            case 2:
                //				RELATORIO TRIBUTAÇÃO CC;
                rel.tributacao(contaPresidente);
                break;

            case 3:
                //				RELATORIO RENDIMENTO POUPANÇA;
                System.out.print("Qual valor você deseja simular? ");
                double valor = sc.nextDouble();
                System.out.print("Qual a duração do investimento? ");
                int dias = sc.nextInt();
                rel.simulaPoupanca(valor, dias);
                break;

            case 4:
                System.out.println(File.getMapUsuario());
                break;
     			
     		case 5:
     			// 			RELATORIO TOTAL DE CAPITAL
     			rel.capitalTotal();
     			break;
     			
     		case 6:
     			menuPorTipo(usuario, contaPresidente);
     			break;
     			
     		case 7:
     			//VOLTA MENU PRINC.
     			menuPrincipal();
     			break;
     		case 0:
                System.out.print("Até logo!");
                System.out.print("\n");
                System.exit(opcao);
     			
     		}
     		
     	} while (opcao != 0);
     	
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

     // Método pega conta
     public Conta pegaConta(String cpfUsuario){
         for (Conta conta : File.getMapConta().values()){
             if(conta.getCpfTitular().equalsIgnoreCase(cpfUsuario)){
                return conta;
             }
         }
          return null;
     }

     
     public void menuPorTipo(Usuario usuario, Conta contaUsuario) {
    	 if (usuario.getTipo().equalsIgnoreCase("diretor")) {
    		 menuDiretor(usuario, contaUsuario);
    	 } else if (usuario.getTipo().equalsIgnoreCase("cliente")) {
    		 menuCliente(usuario, contaUsuario);
    	 } else if (usuario.getTipo().equalsIgnoreCase("presidente")) {
    		 menuPresidente(usuario,contaUsuario);
    	 } else if (usuario.getTipo().equalsIgnoreCase("gerente")) {
    		 menuGerente(usuario, contaUsuario);
    	 }
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

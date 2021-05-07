
package sistema;

import Users.Usuario;
import banco.Conta;

import javax.xml.crypto.Data;
import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;
import Users.Gerente;

public class SistemaInterno {

	Scanner leia = new Scanner(System.in);

	// menu principal
	public void menuPrincipal(Usuario usuario) {
            //String nome, int id, String cpf, String tipo, String senha, int agencia
                Usuario user1 = new Gerente("Yan Tedesco", 01, "11122233344", "Gerente", "tedesco", 01);
                Usuario user2 = new Gerente("Igor Stumpf", 02, "11122233355", "Gerente", "stumpf", 02);
                Usuario user3 = new Gerente("Marcos Bet", 03, "11122233366", "Gerente", "bet", 03);
                Usuario user4 = new Gerente("Brayan Cataldo", 04, "11122233377", "Gerente", "cataldo", 04);
                Usuario user5 = new Gerente("Lucas Azevedo", 05, "11122233388", "Gerente", "azevedo", 05);
                Usuario user6 = new Gerente("Ricardo Araujo", 06, "11122233399", "Gerente", "araujo", 06);
                Set<Usuario> listaUsuarios = new TreeSet<>(Comparador());
                listaUsuarios
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
			opcao = leia.nextInt();
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
			opcao = leia.nextInt();
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
			opcao = leia.nextInt();
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
			opcao = leia.nextInt();
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
			opcao = leia.nextInt();
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
			opcao = leia.nextInt();
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
			opcao = leia.nextInt();
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
			opcao = leia.nextInt();
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
			opcao = leia.nextInt();
			switch (opcao) {
				case 1:
					//RELATORIO PRESIDENTE
					break;

				case 0:
					break;

			}

		} while (opcao != 0);

	}


	public Usuario menuLogin() {
		Scanner sc = new Scanner(System.in); //Entrada no console
		TreeSet<Usuario> listaUsuarios = Data.getData().getListaUsuarios(); //Pegar a TreeSet de Data
		Conta conta = Conta.getInstance(); //Pegar a instância de Conta
		File file = File.getFile(); //Pegar o arquivo de Arquivo
		//Login menu
		public void login () {
			System.out.print("****************************");
			System.out.print("\n");
			System.out.print("\n");
			System.out.print("Bem vindo ao Login do Banco dos Pinguins!\n");
			System.out.print("\n");
			System.out.print("****************************");
			System.out.print("\n");
			System.out.print("\n");
			listaUsuarios = File.ReadFromFile(); //Get the container from the file
			Data.getData().setHolder(listaUsuarios); //Store the container obtained from the file into the database


			int opcao = 1; //Get number from keyboard
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
				switch (opcao) { //Select based on the value entered by the user
					case 1:
						System.out.print("Digite o seu CPF:");
						String cpf = sc.next(); //Get the entered user name from the keyboard
						System.out.print("Digite sua senha:");
						String senha = sc.next(); //Enter the password from the keyboard
						Usuario usuario = verificaLogin(listaUsuarios, cpf, senha);
						if (usuario != null) {//Determine whether the login is successful
							System.out.print("Login efetuado! Bem vindo!");
							System.out.print("\n");
							System.out.print("Quase lá, você será redirecionado..."); //colocar wait
							System.out.print("\n");
							this.menuPrincipal(usuario); //If the login is successful, transfer the user object to the bank operation interface and jump
						} else {
							System.out.print("Usuário não reconhecido, tente novamente."); //Print this statement if login fails
							System.out.print("\n");
						}
						break;
					case 0:
						File.SaveToFile(listaUsuarios); //Exit system to save information to file
						System.out.print("Até logo!");
						System.out.print("\n");
					default: //verificar no tratamento de erros
						System.out.print("Erro na leitura!");
						System.out.print("\n");
				}
			}
		}
		//Login method
		public Usuario verificaLogin (TreeSet < Usuario > listaUsuarios, String cpf, String senha){
			Iterator<Usuario> it = listaUsuarios.iterator(); //Get iterator
			while (it.hasNext()) {
				Usuario usuario = it.next();
				if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
					System.out.print("Login efetuado!");
					System.out.print("\n");
					return usuario;
				}
			}
			System.out.print("CPF ou senha inválidos!");
			System.out.print("\n");
			return null;
		}
	}

	public void imprimePinguin(){
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
		System.out.println("""
				Grupo06 Pinguins:
				Lucas Azevedo, Marcos Bet, Brayan Cataldo,
				Igor Stumpf, Yan Tedesco, Ricardo Araújo\s""");

	}
}
        
                                    /*



        */

        
        
    
 /* public void menuUm(){
        int escolha1;
    do{
            System.out.println("Escolha o tipo de acesso:");
            System.out.println("[ 1 ] CLIENTE\n[ 2 ] FUNCIONARIO\n[ 3 ] SAIR\nDigite sua escolha: ");
            escolha1 = leia.nextInt();
            
    
    }while(escolha1 != 3);
    
  } */ 


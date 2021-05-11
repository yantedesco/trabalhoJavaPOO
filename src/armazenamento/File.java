
package armazenamento;


import Users.*;
import banco.Conta;
import banco.ContaCorrente;
import banco.ContaPoupanca;
import enumm.ContaTipoEnum;
import enumm.UsuarioTipoEnum;

import java.io.*;
import java.util.HashMap;
import java.util.Map;



public class File {

    static final String PATH_BASICO = "./temp/";
    static final String EXTENSAO = ".txt";

    static Map<String, Usuario> mapUsuario = new HashMap<>();
    static Map<String, Conta> mapConta = new HashMap<>();

    public static Map<String, Usuario> getMapUsuario() {
        return mapUsuario;
    }

    public static Map<String, Conta> getMapConta() {
        return mapConta;
    }

    public static void hashMapFromFileTextUsuario(String path) {

        try {
            BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + "lista" + EXTENSAO));
            String linha = "";

            while (true) {
                linha = buffRead.readLine();
                if (linha != null) {
                    String[] pp = linha.split(";");

                    if (pp[3].equalsIgnoreCase(UsuarioTipoEnum.DIRETOR.getTipo())) {
                        Diretor d = new Diretor(pp[0], Integer.parseInt(pp[1]), pp[2], pp[3], pp[4], Integer.parseInt(pp[5]), Integer.parseInt(pp[6]), Double.parseDouble(pp[7]));
                        String cpf = pp[2];
                        mapUsuario.put(cpf, d);
                        //String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta, double salario
                    } else if (pp[3].equalsIgnoreCase(UsuarioTipoEnum.CLIENTE.getTipo())) {
                        Cliente cli = new Cliente(pp[0], Integer.parseInt(pp[1]), pp[2], pp[3], pp[4], Integer.parseInt(pp[5]), Integer.parseInt(pp[6]));
                        String cpf = pp[2];
                        mapUsuario.put(cpf, cli);
                    } else if (pp[3].equalsIgnoreCase(UsuarioTipoEnum.GERENTE.getTipo())) {
                        Gerente ger = new Gerente(pp[0], Integer.parseInt(pp[1]), pp[2], pp[3], pp[4], Integer.parseInt(pp[5]), Integer.parseInt(pp[6]), Double.parseDouble(pp[7]), Integer.parseInt(pp[8]));
                        //String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta, double salario, int idAgencia
                        String cpf = pp[2];
                        mapUsuario.put(cpf, ger);
                    } else if (pp[3].equalsIgnoreCase(UsuarioTipoEnum.PRESIDENTE.getTipo())) {
                        Presidente pre = new Presidente(pp[0], Integer.parseInt(pp[1]), pp[2], pp[3], pp[4], Integer.parseInt(pp[5]), Integer.parseInt(pp[6]), Double.parseDouble(pp[7]));
                        //String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta, double salario

                        String cpf = pp[2];
                        mapUsuario.put(cpf, pre);
                    }

                } else
                    break;
            }
            buffRead.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hashMapFromFileTextContas(String path) {
        try {
            BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + "contas" + EXTENSAO));
            String linha = "";

            while (true) {
                linha = buffRead.readLine();
                if (linha != null) {
                    String[] pp = linha.split(";");
                    if (pp[0].equalsIgnoreCase(ContaTipoEnum.CORRENTE.getTipo())) {
                        ContaCorrente cc = new ContaCorrente(pp[0], Integer.parseInt(pp[1]), pp[2], pp[3], Double.parseDouble(pp[4]), Integer.parseInt(pp[5]));
                        String cpf = pp[3];
                        mapConta.put(cpf, cc);
//                            (int numeroDaConta, String nomeCompletoCliente, String cpfTitular, double saldo, int agencia,String tipoConta)
                    } else if (pp[0].equalsIgnoreCase(ContaTipoEnum.POUPANCA.getTipo())) {
                        ContaPoupanca cp = new ContaPoupanca(pp[0], Integer.parseInt(pp[1]), pp[2], pp[3], Double.parseDouble(pp[4]), Integer.parseInt(pp[5]));
                        String cpf = pp[3];
                        mapConta.put(cpf, cp);
//                          (String tipoConta, int numeroDaConta,String nomeCompletoCliente,String cpfTitular,double saldo,int agencia)
                    }

                } else
                    break;
            }
            buffRead.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void comprovanteDeposito(String path, Usuario usuario, Conta numConta, double vlrDeposito) throws IOException {

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "******************Depósito******************";
        buffWrite.append(linha).append("\n\n\n");

        linha = "Nome do Titular: " + numConta.getNomeCompletoCliente();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "CPF do Titular: " + usuario.getCpf();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "Agência: " + usuario.getAgencia();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "Conta: " + numConta.getNumeroDaConta();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "Valor do Depósito: R$ " + vlrDeposito;
        buffWrite.append("\t").append(linha).append("\n");

        linha = "******************Fim do Depósito******************";
        buffWrite.append("\n\n").append(linha);

        buffWrite.close();
    }


    public static void comprovanteSaque(String path, Usuario usuario, Conta numConta, double vlrSaque) throws IOException {

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "******************Saque******************";
        buffWrite.append(linha).append("\n\n\n");

        linha = "Nome do Titular: " + numConta.getNomeCompletoCliente();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "CPF do Titular: " + usuario.getCpf();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "Agência: " + usuario.getAgencia();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "Conta: " + numConta.getNumeroDaConta();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "Saque: R$" + vlrSaque;
        buffWrite.append("\t").append(linha).append("\n");

        linha = "******************Fim do Saque******************";
        buffWrite.append("\n\n").append(linha);

        buffWrite.close();
    }

    public static void comprovanteTransferencia(String path, Usuario usuario, Conta numConta, double vlrTransferencia, Conta numContaDestino) throws IOException {

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "*********************Transferência*********************";
        buffWrite.append(linha).append("\n\n\n");

        linha = "Nome do Titular (Conta Origem): " + numConta.getNomeCompletoCliente();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "CPF do Titular (Conta Origem): " + usuario.getCpf();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "Agência (Origem): " + usuario.getAgencia();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "Conta (Origem): " + numConta.getNumeroDaConta();
        buffWrite.append("\t").append(linha).append("\n\n");

        linha = "Nome do Titular (Conta Destino): " + numContaDestino.getNomeCompletoCliente();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "CPF do Titular (Conta Destino): " + numContaDestino.getCpfTitular();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "Conta (Destino): " + numContaDestino.getNumeroDaConta();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "Agência (Destino): " + numContaDestino.getAgencia();
        buffWrite.append("\t").append(linha).append("\n");

        linha = "Valor Transferido: R$" + vlrTransferencia;
        buffWrite.append("\t").append(linha).append("\n");

        linha = "********************Fim da Transferência*********************";
        buffWrite.append("\n\n").append(linha);


        buffWrite.close();
    }


    public static String getPathBasico() {
        return PATH_BASICO;
    }

    public static String getEXTENSAO() {
        return EXTENSAO;
    }

    public static void logoPinguinP() {
        System.out.println("" +
                "\n\n\n\n\n\n        ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢰⣶⣶⣶⣶⣶⣦⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⣤⣶⣶⣦⣄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⣤⡆⢸⣿⡇⠄⠄⢸⣿⡇⠄⣶⣶⣶⣶⣶⣄⢰⣶⣦⣴⣶⣶⣦⠄⢠⣶⣶⣶⣶⣶⠄⣴⣶⣶⣶⣶⣦⡀⠄⠄⠄⠄⠄⠄⠄⢸⣿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣦⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⣴⣾⡿⠟⠉⠁⢸⣿⡿⠿⠿⢿⣷⡄⢀⣠⣤⣤⣼⣿⣿⢸⣿⣿⠄⠄⣿⣿⡇⢸⣿⠄⠄⠄⠄⢸⣿⣿⠄⠄⢸⣿⡇⠄⠄⠄⠄⣿⡟⠛⢻⣿⠄⣿⡟⠛⢻⣿⢸⣿⣟⣛⣛⠄⠄⠄⠄⠄⠄⠄⠄⣠⡾⠋⠁⢀⣿⣿⣷⣌⣹⣿⣿⣿⣤⣀⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠙⠻⠿⢿⣦⡄⢸⣿⣇⣀⣀⣸⣿⡇⢸⣿⣏⣉⣹⣿⣿⢸⣿⣿⠄⠄⣿⣿⡇⢸⣿⣀⣀⣀⣀⠸⣿⣿⣀⣀⣼⣿⠇⠄⠄⠄⠄⣿⣇⣀⣸⣿⠄⣿⣇⣀⣸⣿⢈⣛⣛⣛⣿⡧⠄⠄⠄⠄⠄⠄⣸⠟⠄⠄⠄⠾⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣶⡀⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠉⠃⠘⠛⠛⠛⠛⠛⠋⠁⠄⠙⠛⠋⠉⠛⠛⠘⠛⠛⠄⠄⠛⠛⠃⠈⠛⠛⠛⠛⠛⠄⠉⠛⠛⠛⠛⠋⠄⠄⠄⠄⠄⠛⠛⠋⠙⠛⠄⠙⠛⠛⠛⠉⠘⠛⠛⠛⠛⠁⠄⠄⠄⠄⠄⣰⡟⠄⣀⣤⠄⠄⠄⠉⠙⠛⢿⣿⠁⠄⠄⠄⠄⠉⠓⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸⣿⢣⣾⡟⠃⡄⠄⠄⠄⠄⠄⠈⠻⣦⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢠⣿⡟⣼⡿⢣⡞⠁⠄⠄⠄⠄⠄⠄⠄⠛⣿⡀⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢰⣶⡆⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢰⣶⣶⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣶⡖⠄⠄⠄⠄⠄⠄⠄⠄⠄⢠⣿⣿⣿⣿⠁⡞⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⣷⡄⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⣶⣶⣤⣶⣶⣶⡄⢰⣾⣿⡇⢰⣶⣦⣶⣶⣶⣆⠄⢰⣶⣶⣶⣶⣶⡆⢰⣶⡆⠄⠄⣶⣶⢰⣶⣿⣷⠄⣶⣦⣴⣶⣶⣦⡀⣴⣶⣶⣶⣶⣶⠄⠄⠄⣼⣿⠃⢰⣦⣀⡀⠄⠄⠄⠄⠄⣸⣿⣿⣿⡇⣼⡇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠙⣷⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⣿⣿⡏⠉⢹⣿⣿⠈⢹⣿⡇⢸⣿⡏⠉⠉⣿⣿⠄⣿⣿⠉⠉⢹⣿⡇⢸⣿⡇⠄⠄⣿⣿⠈⢹⣿⣿⠄⣿⣿⠉⠉⣿⣿⡇⣿⣿⣭⣭⣭⣭⠄⠄⣾⣿⠃⠄⠈⠉⠛⠿⣶⣦⠄⠄⢰⣿⣿⣿⣿⣧⣿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢹⡄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⣿⣿⣧⣤⣼⣿⡿⠄⢸⣿⡇⢸⣿⡇⠄⠄⣿⣿⠄⢿⣿⣦⣤⣼⣿⡇⢸⣿⣧⣤⣤⣿⣿⠄⢸⣿⣿⠄⣿⣿⠄⠄⣿⣿⡇⣤⣍⣉⣉⣿⣿⠇⣰⣿⡟⠄⠄⢠⣴⣿⡿⠛⠋⠄⠄⣿⣿⣿⣿⣿⢸⡇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣧⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⣿⣿⡟⠛⠛⠋⠄⠄⠘⠛⠃⠘⠛⠃⠄⠄⠛⠛⠄⢠⣉⣉⣉⣼⣿⡇⠄⠙⠛⠋⠁⠛⠛⠄⠈⠛⠋⠄⠛⠛⠄⠄⠙⠛⠁⠉⠙⠛⠛⠛⠋⠐⠛⠋⠄⠄⠄⠈⠁⠄⠄⠄⠄⠄⠘⠛⠛⠛⠛⠛⠘⠃⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠛⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠙⠛⠃⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠛⠛⠛⠛⠉⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "        ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n\n\n");

    }
}


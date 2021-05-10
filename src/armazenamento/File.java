
package armazenamento;


import Users.Cliente;
import Users.Diretor;
import Users.Gerente;
import Users.Presidente;
import Users.Usuario;
import banco.Conta;
import banco.ContaCorrente;
import banco.ContaPoupanca;
import enumm.ContaTipoEnum;
import enumm.UsuarioTipoEnum;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class File {

        static final String PATH_BASICO = "./temp/";
        static final String EXTENSAO = ".txt";

        static Map<Usuario, String> mapUsuario = new HashMap<>();
        static Map<Conta, String> mapConta = new HashMap<>();

        public static Map<Usuario, String> getMap() {
            return mapUsuario;
        }

        public static Map<Usuario, String> hashMapFromFileTextUsuario(String path) {



            try {
                BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO+path));
                String linha = "";

                while (true) {
                    linha = buffRead.readLine();
                    if (linha != null) {
                        String[] pp = linha.split(";");
                        
                        if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.DIRETOR.getTipo())) {
                            Diretor d = new Diretor(pp[0], Integer.parseInt(pp[1]), pp[2], pp[3], pp[4], Integer.parseInt(pp[5]),Integer.parseInt(pp[6]), Double.parseDouble(pp[7]));
                            System.out.println(d);
                            String cpf = pp[2];
                            mapUsuario.put(d, cpf);
                        }
                        else if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.CLIENTE.getTipo())) {
                            //String tipo, String nome, Integer id, String cpf, String senha, Integer agencia, Integer numeroConta
                            Cliente cli = new Cliente(pp[0], Integer.parseInt(pp[1]),pp[2], pp[3], pp[4], Integer.parseInt(pp[5]), Integer.parseInt(pp[6]));
                            //String tipo, String nome, Integer id, String cpf, String senha, Integer agencia, Integer numeroConta
                            System.out.println(cli);
                            String cpf = pp[4];
                            mapUsuario.put(cli, cpf);
                            File.comprovanteDeposito(PATH_BASICO+cli.getNome()+"_"+cli.getCpf()+EXTENSAO, cli, cli.getNumeroConta(), 1250.00);
                        }
                        else if(pp[0].equalsIgnoreCase(UsuarioTipoEnum.GERENTE.getTipo())){
                            Gerente ger = new Gerente(pp[0], Integer.parseInt(pp[1]), pp[2], pp[3], pp[4], Integer.parseInt(pp[5]), Integer.parseInt(pp[6]), Double.parseDouble(pp[7]),Integer.parseInt(pp[8]));
                            //String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta, double salario, int idAgencia
                        }
                        else if (pp[0].equalsIgnoreCase(UsuarioTipoEnum.PRESIDENTE.getTipo())){
                            Presidente pre = new Presidente(pp[0], Integer.parseInt(pp[1]), pp[2], pp[3], pp[4], Integer.parseInt(pp[5]), Integer.parseInt(pp[6]), Double.parseDouble(pp[7]));
                            //String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta, double salario
                            mapUsuario.put(pre, "presidente");
                        }    

                    } else
                        break;
                }
                buffRead.close();
               
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return mapUsuario;
        }
         public static Map<Conta, String> hashMapFromFileTextContas(String path){
            try {
                    BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO+path));
                String linha = "";
                while (true) {
                    linha = buffRead.readLine();
                    if (linha != null) {
                        String[] pp = linha.split(";");
                        if(pp[0].equalsIgnoreCase(ContaTipoEnum.CORRENTE.getTipo())) {
                            ContaCorrente cc = new ContaCorrente(Integer.parseInt(pp[0]),pp[1], pp[2], Double.parseDouble(pp[3]), Integer.parseInt(pp[4]), Integer.parseInt(pp[5]), Double.parseDouble(pp[6]), Double.parseDouble(pp[7]));
                            System.out.println(cc);
                            mapConta.put(cc, "corrente");
                        }
                        else if(pp[0].equalsIgnoreCase(ContaTipoEnum.POUPANCA.getTipo())) {
                            ContaPoupanca cp = new ContaPoupanca(Integer.parseInt(pp[0]), pp[1], pp[2], Double.parseDouble(pp[3]), Integer.parseInt(pp[4]), pp[5]);
                            System.out.println(cp);
                            mapConta.put(cp, "poupanca");
                        }
                    } else
                        break;
                }
         
            }catch (Exception e) {
                 e.printStackTrace();
            }
            return mapConta;     
         }

        public static void escritor(String path) throws IOException {

            Scanner in = new Scanner(System.in);
            System.out.println("Digite o nome do arquivo: ");
            String nome = in.next();

            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO+nome+EXTENSAO));
            String linha = "";
            System.out.println("Escreva algo: ");
            linha = in.next();
            buffWrite.append(linha).append("\n");
            buffWrite.close();
        }

        public static void comprovanteDeposito(String path, Usuario usuario, Integer NumConta, double vlrDeposito) throws IOException {

            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
            String linha = "**********Deposito**********";
            buffWrite.append(linha).append("\n");

            linha = "Agencia: "+usuario.getAgencia();
            buffWrite.append(linha).append("\n");

            linha = "Conta: "+NumConta;
            buffWrite.append(linha).append("\n");

            linha = "Depósito: R$"+vlrDeposito;
            buffWrite.append(linha).append("\n");

            linha = "**********Fim do Deposito**********";
            buffWrite.append(linha).append("\n");

            buffWrite.close();
        }
        
        
        public static void comprovanteSaque(String path, Usuario usuario, Conta numConta, double vlrSaque) throws IOException {

            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
            String linha = "**********Saque**********";
            buffWrite.append(linha).append("\n");

            linha = "Agencia: "+usuario.getAgencia();
            buffWrite.append(linha).append("\n");

            linha = "Conta: "+numConta.getNumeroDaConta(); // averiguar parametro
            buffWrite.append(linha).append("\n");

            linha = "Saque: R$"+vlrSaque;
            buffWrite.append(linha).append("\n");

            linha = "**********Fim do Saque**********";
            buffWrite.append(linha).append("\n");

            buffWrite.close();
        }
        
        public static void comprovanteTransferencia(String path, Usuario usuario, Conta numConta, double vlrTransferencia, int numContaDestino) throws IOException {

            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
            String linha = "**********Transferência**********";
            buffWrite.append(linha).append("\n");

            linha = "Agencia: "+usuario.getAgencia();
            buffWrite.append(linha).append("\n");

            linha = "Conta: "+numConta.getNumeroDaConta(); // averiguar parametro
            buffWrite.append(linha).append("\n");

            linha = "Valor Transferido: R$"+vlrTransferencia;
            buffWrite.append(linha).append("\n");
            
            linha = "Conta: "+numContaDestino;
            buffWrite.append(linha).append("\n");

            linha = "**********Fim da Transferência**********";
            buffWrite.append(linha).append("\n");

            buffWrite.close();
        }


    public static String getPathBasico() {
        return PATH_BASICO;
    }

    public static String getEXTENSAO() {
        return EXTENSAO;
    }
}



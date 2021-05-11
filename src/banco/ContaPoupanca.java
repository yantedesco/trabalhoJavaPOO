
package banco;

public class ContaPoupanca extends Conta{

	public ContaPoupanca() {}

	
	public ContaPoupanca(int numeroDaConta, String nomeCompletoCliente, String cpfTitular, double saldo, int agencia, String tipoConta) {
		super(numeroDaConta, nomeCompletoCliente, cpfTitular, saldo, agencia, tipoConta);

	}


	@Override
    public String toString() {
        return "Conta Poupança: \nTipo Conta: " + getTipoConta() +
				"\nNumero da Conta =  " + getNumeroDaConta() + 
				"\nAgencia= " + getAgencia()+
				"\nNome Completo do Cliente=   "+ getNomeCompletoCliente() +   
				"\nCPF   do  Titular= " + getCpfTitular() + 
		        "\nSaldo da Conta poupança= R$"+ getSaldo() + "\n";
    }
}



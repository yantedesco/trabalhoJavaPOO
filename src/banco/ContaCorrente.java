
package banco;

public class ContaCorrente extends Conta {

	
	public ContaCorrente() {}

	public ContaCorrente(String tipoConta, int numeroDaConta,String nomeCompletoCliente,String cpfTitular,double saldo,int agencia) {
		super(tipoConta, numeroDaConta, nomeCompletoCliente, cpfTitular, saldo, agencia);
	}




	@Override
	public String toString() {
		return "Conta Corrente: \nTipo Conta: " + getTipoConta() +
				"\nNumero da Conta =  " + getNumeroDaConta() + 
				"\nAgencia= " + getAgencia()+
				"\nNome Completo do Cliente=   "+ getNomeCompletoCliente() +   
				"\nCPF   do  Titular= " + getCpfTitular() + 
		        "\nSaldo da Conta corrente= R$"+ getSaldo() + "\n";
	}
	
	
	
	
}

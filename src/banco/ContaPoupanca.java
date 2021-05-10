
package banco;

public class ContaPoupanca extends Conta{

	private String tipoConta;
	
	
	
	
	
	public ContaPoupanca() {         	}

	public ContaPoupanca(int numeroDaConta, String nomeCompletoCliente, String cpfTitular, double saldo, int agencia, String tipoConta) {
		super(numeroDaConta, nomeCompletoCliente, cpfTitular, saldo, agencia);
		this.tipoConta=tipoConta;
		
		
		
		 
	}
	
	
        
        public String getTipoConta() {
		return tipoConta;
	}

	
	
	
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	

	

	@Override
    public String toString() {
        return "Conta Poupança: \nTipo Conta: " + tipoConta +  
				"\nNumero da Conta =  " + getNumeroDaConta() + 
				"\nAgencia= " + getAgencia()+
				"\nNome Completo do Cliente=   "+ getNomeCompletoCliente() +   
				"\nCPF   do  Titular= " + getCpfTitular() + 
		        "\nSaldo da Conta poupança= R$"+ getSaldo() + "\n";
    }
}




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
        return "ContaPoupanca{" +
                "numeroDaConta=" + getNumeroDaConta() +
                ", nomeCompletoCliente='" + getNomeCompletoCliente() + '\'' +
                ", cpfTitular='" + getCpfTitular() + '\'' +
                ", saldo=" + getSaldo() +
                ", agencia=" + getAgencia() +
                '}';
    }
}




package banco;


	public abstract class Conta {
	
	private int numeroDaConta;
	private String nomeCompletoCliente;
	private String cpfTitular;
    private double saldo;
    private int agencia;
    
    public Conta() {}
    
    public Conta(int numeroDaConta,String nomeCompletoCliente,String cpfTitular,double saldo,int agencia) {   
    	this.numeroDaConta=numeroDaConta;
    	this.nomeCompletoCliente=nomeCompletoCliente;
    	this.cpfTitular=cpfTitular;
    	this.saldo=saldo;
    	this.agencia=agencia;
    	
    }
    
    
    
   //*****************************************************************************************************************
                  //            saque
    
    
    public boolean sacar(double valor) {
		if(this.saldo < valor) {
			return false;
		}
		else {
			this.saldo = this.saldo - valor;
			this.saldo= this.saldo - 0.10;    // taxa cobrada por saque
			return true;
		}
	}
    
//********************************************************************************************************************
                               //   TRANSFERENCIA
       //   os 0,20 centavos que cobra da transferencia sera retidado via taxa deposito e saque
	
	public boolean transfere(Conta destino, double valor) {
		
		boolean retirou = this.sacar(valor);
		if (retirou) {
			destino.depositar(valor);
			return true;
		} 
		else {
			System.out.println(" O valor não Pode ser Transferido !!!!!   ");
			System.out.println(" Saldo está insuficiente " );
			return false;
		}
	}
	
	
	//********************************************************************************************************************
	                             //  DEPOSITO
	
	
	public double depositar(double valor) {
		this.saldo = this.saldo + valor;
		this.saldo= this.saldo - 0.10;  // taxa cobrada por deposito
		return this.saldo;
	}

	
	//********************************************************************************************************************

	public int getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(int numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public String getNomeCompletoCliente() {
		return nomeCompletoCliente;
	}

	public void setNomeCompletoCliente(String nomeCompletoCliente) {
		this.nomeCompletoCliente = nomeCompletoCliente;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
    
    
    
    
}
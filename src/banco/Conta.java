
package banco;


	public abstract class Conta {
	
	private int numeroDaConta;
	private int agencia;
	private String nomeCompletoCliente;
	private String cpfTitular;
    private double saldo;
    private static int totalMovimentacoes;
    private double tarifa = 15;
    protected double taxaMovimentacao=0.10;
    
    public Conta() {      }
    
    
    
    public static int getTotalMovimentacoes() {
		return totalMovimentacoes;
	}



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
    	if(valor<=0) {
			System.out.println("Valor invalido para Saque ");
			return false;
		}
    	
       else if(this.saldo < valor) {
			
			System.out.println("Seu saldo é insuficiente!!!!");
			return false;
		}
		else {
			totalMovimentacoes++;
			this.saldo = this.saldo - valor;
			this.saldo= this.saldo - taxaMovimentacao;    // taxa cobrada por saque
			return true;
		}
	}
    
//********************************************************************************************************************
                               //   TRANSFERENCIA
       //   os 0,20 centavos que cobra da transferencia sera retidado via taxa deposito e saque
	
	public boolean transfere(Conta destino, double valor) {
		
		boolean retirou = this.sacar(valor);
		if (retirou) {
			
		   this.saldo=this.saldo-taxaMovimentacao;
			
			destino.depositar(valor);
		 
			return true;
		} 
		else {
			System.out.println(" O valor não Pode ser Transferido !!!!!   ");
			System.out.println(" Por favor revise o valor desejado e tente novamente " );
			return false;
		}
	}
	
	
	//********************************************************************************************************************
	                             //  DEPOSITO
	
	
	public double depositar(double valor) {
		totalMovimentacoes++;
		if(valor<=0) {
			System.out.println("Deposito co envelope vazio é proibido !!!"+ valor);
			System.out.println("Depositos vazios geram despesas e convencionalmente será cobrado tarifa de deposito");
			return this.saldo - taxaMovimentacao;
			}
		else {
		
		this.saldo = this.saldo + valor;
		this.saldo= this.saldo -taxaMovimentacao;  // taxa cobrada por deposito
		return this.saldo;
		
		}
	}

	
	//********************************************************************************************************************

	
	
	
	
	

	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	
	
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

package banco;

import exceptions.ContaException;

	public abstract class Conta {
	
	private int numeroDaConta;
	private int agencia;
	private String nomeCompletoCliente;
	private String cpfTitular;
    private double saldo;
    private static int totalMovimentacoes;
    private double tarifa = 15;
    protected double taxaMovimentacao=0.10;
    public String tipoConta;


	public Conta() {}

	public Conta(String tipoConta, int numeroDaConta,String nomeCompletoCliente,String cpfTitular,double saldo,int agencia) {
		this.tipoConta = tipoConta;
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

			System.out.println("Seu saldo é insuficiente!!!");
			return false;
		}
		else {
			totalMovimentacoes++;
			this.saldo = this.saldo - valor;
			this.saldo= this.saldo - taxaMovimentacao;    // taxa cobrada por saque
			System.out.println("Saque realizado com sucesso!!!");
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

			System.out.println("Transferência realizada com sucesso!!!");
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
			System.out.println("Deposito com envelope vazio é proibido !!!"+ valor);
			System.out.println("Depositos vazios geram despesas e convencionalmente será cobrado tarifa de deposito");
			return this.saldo - taxaMovimentacao;
			}
		else {

		this.saldo = this.saldo + valor;
		this.saldo= this.saldo -taxaMovimentacao;  // taxa cobrada por deposito
		System.out.println("Depósito realizado com sucesso!!!");
		return this.saldo;

		}
	}


	//********************************************************************************************************************




		public String getTipoConta() {
			return tipoConta;
		}

		public static int getTotalMovimentacoes() {
		return totalMovimentacoes;
	}




	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	
	
	public int getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(int numeroDaConta) throws ContaException {
		if(numeroDaConta<=0)
			throw new ContaException("Numero da conta não pode ser negativo ou igual a zero");
			this.numeroDaConta = numeroDaConta;
	}

	public String getNomeCompletoCliente() {
		return nomeCompletoCliente;
	}

	public void setNomeCompletoCliente(String nomeCompletoCliente) throws ContaException {
		if(nomeCompletoCliente == null)
		throw new ContaException("Nome completo não pode ser nulo. Favor preencher o campo corretamente");
		this.nomeCompletoCliente = nomeCompletoCliente;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(String cpfTitular) throws ContaException {
		if(cpfTitular == null)
		throw new ContaException("CPF não pode ser nulo. Favor preencher todos os campos");
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

	public void setAgencia(int agencia) throws ContaException {
		if(agencia<=0)
		throw new ContaException("Numero da agencia não pode ser negativo ou igual a zero");
		this.agencia = agencia;
	}




}
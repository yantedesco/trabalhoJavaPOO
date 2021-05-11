
package banco;

import exceptions.ContaException;

import java.text.DecimalFormat;

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
			System.out.println("Valor inválido para saque.");
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
		
		if (this.numeroDaConta == destino.numeroDaConta) {
			System.out.println("Transferência não realizada!");
			System.out.println("A conta destino é igual à conta origem.");
			return false;
			   }
		else {
			   if(valor<=0) {
				   System.out.println("Valor inválido para transferência.");
				   System.out.println("Por favor, revise o valor desejado e tente novamente.");
				   return false;
			   } else if (this.saldo < valor) {
					System.out.println("Seu saldo é insuficiente!!!");
					System.out.println("Transferência não realizada");
					return false;
			       } else {
			    	   this.saldo = this.saldo - valor;
			    	   this.saldo = this.saldo - taxaMovimentacao;
			    	   destino.saldo = destino.saldo + valor;
			    	   this.saldo = this.saldo - taxaMovimentacao;
			    	   System.out.println("Transferência realizada com sucesso!!!");
			        return true;
			        }
		}
	}		   



	//********************************************************************************************************************
	                             //  DEPOSITO


	public double depositar(double valor) {
		totalMovimentacoes++;
		if(valor<=0) {
			System.out.println("Depósito com envelope vazio é proibido!!! Depósito com R$ "+ valor + " é inválido.");
			System.out.println("Depósitos vazios geram despesas e, convencionalmente, será cobrada tarifa de depósito.");
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
			throw new ContaException("Número da conta não pode ser negativo ou igual a zero");
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
		new DecimalFormat("#,##0.00").format(saldo);
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
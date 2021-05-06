
package banco;

public class ContaCorrente extends Conta {
    
    private int tipoConta;
    private double investimento;
    private double tarifa;
	
	
	public ContaCorrente() {  }
	
	   
	
	public ContaCorrente(int numeroDaConta, String nomeCompletoCliente, String cpfTitular, double saldo, int agencia,int tipoConta,double investimento,double tarifa) {
		super(numeroDaConta, nomeCompletoCliente, cpfTitular, saldo, agencia);
		
		this.tipoConta=tipoConta;
		this.investimento=investimento;
	    this.tarifa=tarifa;
	}



	public int getTipoConta() {
		return tipoConta;
	}



	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}



	public double getInvestimento() {
		return investimento;
	}



	public void setInvestimento(double investimento) {
		this.investimento = investimento;
	}



	public double getTarifa() {
		return tarifa;
	}



	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}



	@Override
	public String toString() {
		return "ContaCorrente \n\n"+"Tipo Conta= " + tipoConta +  "   , Numero da Conta =  " + getNumeroDaConta() + "  , Agencia= " + getAgencia()
		+"   , Nome Completo do Cliente=   "+ getNomeCompletoCliente() +   "  , CPF   do  Titular= " + getCpfTitular() + 
		" , Investimentos=  " + investimento + ", tarifa=" + tarifa	+ "\n\n";
	}
	
	
	
	
}

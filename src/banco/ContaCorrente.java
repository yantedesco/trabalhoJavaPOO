
package banco;

public class ContaCorrente extends Conta {
    
    private int tipoConta;
    
   
    
	
	public ContaCorrente() {  }
	
	   
	
	public ContaCorrente(int numeroDaConta, String nomeCompletoCliente, String cpfTitular, double saldo, int agencia,int tipoConta,double investimento,double tarifa) {
		super(numeroDaConta, nomeCompletoCliente, cpfTitular, saldo, agencia);
		
		this.tipoConta=tipoConta;
		
	    
	}



	public int getTipoConta() {
		return tipoConta;
	}



	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}






	@Override
	public String toString() {
		return "Conta Corrente \n\n"+
				"Tipo Conta= " + tipoConta +  
				"  , Numero da Conta =  " + getNumeroDaConta() + 
				"  , Agencia= " + getAgencia()+
				"  , Nome Completo do Cliente=   "+ getNomeCompletoCliente() +   
				"  , CPF   do  Titular= " + getCpfTitular() + 
		        "  , Saldo da Conta corrente= R$"+ getSaldo() + "\n\n";
	}
	
	
	
	
}

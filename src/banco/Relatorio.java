package banco;



public class Relatorio extends Conta {
	private static double valorSimulado;
	
	
	public Relatorio() {           }
	
	
	
	public static double simulaPoupanca(double valor, int dias) {
        double rend = 0.00533333;
        return rend / 30 * valor * dias;
        
       
        
	}
	
	
	public void tributacao() {
	
	double totalM = (getTotalMovimentacoes()*taxaMovimentacao) ;
	
	double totalT = totalM  +  super.getTarifa();     
	
	System.out.println("O valor da tarifa cobrada é de  R$"+getTarifa());
	System.out.println("O valor total das taxas de movimentaçãoo é de R$"+totalM);
	System.out.println("O total das tributa�oes até agora é de = R$"+totalM);
	
	}
	
	
	
	
}

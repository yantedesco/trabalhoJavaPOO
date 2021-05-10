package banco;
public class Relatorio extends Conta {
	
	public Relatorio() {}
	
	
	public void simulaPoupanca(double valor, int dias) {
        double rend = 0.00533333;
        double rendimento = rend / 30 * valor * dias;
		System.out.println("O rendimento estimado de R$ " + valor + " em " + dias + " dias é de R$ " + rendimento);
	}

	public void tributacao(Conta conta) {
		double totalM = (Conta.getTotalMovimentacoes() * taxaMovimentacao) ;
		double totalT = totalM + super.getTarifa();

		System.out.println("O valor da tarifa cobrada é de  R$"+getTarifa());
		System.out.println("O valor total das taxas de movimentaçãoo é de R$"+totalM);
		System.out.println("O total das tributa�oes até agora é de = R$"+totalM);

	}
}

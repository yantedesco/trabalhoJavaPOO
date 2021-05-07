package banco;

public class SeguroDeVida extends Conta {
	private boolean seguroDeVida;
	private double tributoSeguro;
	
	public boolean seguro (double valorSegurado) {
		double novoSaldo;
		if (seguroDeVida){
			this.tributoSeguro = (valorSegurado * 0.2);
			novoSaldo = super.getSaldo() - this.tributoSeguro;
			super.setSaldo(novoSaldo);
			return true;
		}
		else {
			return false;
		}
	}
}
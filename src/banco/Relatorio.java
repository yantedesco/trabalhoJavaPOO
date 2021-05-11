package banco;

import Users.Usuario;
import armazenamento.File;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Relatorio extends Conta {
	
	public Relatorio() {}
	
	
	public void simulaPoupanca(double valor, int dias) {
        double rend = 0.00533333;
        double rendimento = rend / 30 * valor * dias;
		System.out.println("O rendimento estimado de R$ " + valor + " em " + dias + " dias é de R$ " + new DecimalFormat("#,##0.00").format(rendimento));
	}

	public void tributacao(Conta conta) {
		double totalM = (conta.getTotalMovimentacoes() * taxaMovimentacao) ;
		double totalT = totalM + super.getTarifa();

		System.out.println("O valor da tarifa cobrada é de R$ " + new DecimalFormat("#,##0.00").format(getTarifa()));
		System.out.println("O valor total das taxas de movimentações é de R$ " + new DecimalFormat("#,##0.00").format(totalM));
		System.out.println("O total das tributações até agora é de = R$ "+ new DecimalFormat("#,##0.00").format(totalT));

	}
	
	public void capitalTotal() {
		double totalSoma = 0; 
		double totalM = (Conta.getTotalMovimentacoes() * taxaMovimentacao);
		double totalT = totalM + super.getTarifa();
		for (Conta conta: File.getMapConta().values()) {
			totalSoma = totalSoma + conta.getSaldo() + totalT;
			
		}
		System.out.println("O capital total do Banco dos Pinguins é de R$ " + new DecimalFormat("#,##0.00").format(totalSoma));
		
	}


	public void nomesOrdemAlfabetica() {
		List<Usuario> mapValues = new ArrayList<>(File.getMapUsuario().values());

		mapValues.sort(Comparator.comparing(Usuario::getNome));

		for (Usuario p : mapValues) {
			System.out.println("Nome: " + p.getNome() + " | CPF: " + p.getCpf() + " | Agência: " + p.getAgencia());
		}

	}
}

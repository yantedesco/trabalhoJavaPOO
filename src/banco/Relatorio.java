package banco;

import Users.Usuario;
import armazenamento.File;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Relatorio extends Conta {
	
	public Relatorio() {}
	
	
	public void simulaPoupanca(double valor, int dias) {
        double rend = 0.00533333;
        double rendimento = rend / 30 * valor * dias;
		System.out.println("O rendimento estimado de R$ " + valor + " em " + dias + " dias é de R$ " + rendimento);
	}

	public void tributacao(Conta conta) {
		double totalM = (conta.getTotalMovimentacoes() * taxaMovimentacao) ;
		double totalT = totalM + super.getTarifa();

		System.out.println("O valor da tarifa cobrada é de  R$"+getTarifa());
		System.out.println("O valor total das taxas de movimentações é de R$"+totalM);
		System.out.println("O total das tributações até agora é de = R$"+totalM);

	}
	
	public void capitalTotal() {
		double totalSoma = 0; 
		double totalM = (Conta.getTotalMovimentacoes() * taxaMovimentacao);
		double totalT = totalM + super.getTarifa();
		for (Conta conta: File.getMapConta().values()) {
			totalSoma = totalSoma + conta.getSaldo() + totalT;
			
		}
		System.out.println("O capital total do Banco dos Pinguins é de R$ " + totalSoma);
		
	}


	public void nomesOrdemAlfabetica() {
		List<Usuario> mapValues = new ArrayList<>(File.getMapUsuario().values());

		mapValues.sort(Comparator.comparing(Usuario::getNome));

		for (Usuario p : mapValues) {
			System.out.println("Nome: " + p.getNome() + " | CPF: " + p.getCpf() + " | Agência: " + p.getAgencia());
		}

	}
}

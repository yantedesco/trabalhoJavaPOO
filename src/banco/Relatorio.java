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


}

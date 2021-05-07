package Users;


public class Presidente extends Funcionario {    
    
	public Presidente() {}
	
    public Presidente (String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta, double salario) {
    	super(nome, id, cpf, tipo, senha, agencia, numeroConta, salario);
    }

}

package Users;


public class Diretor extends Funcionario{
	
	public Diretor() {}
    
    public Diretor (String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta, double salario) {
    	super(nome, id, cpf, tipo, senha, agencia, numeroConta, salario);
    }
	
}

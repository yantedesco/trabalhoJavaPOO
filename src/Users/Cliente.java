package Users;


public class Cliente extends Usuario{
	
	public Cliente() {}
	
	public Cliente (String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta) {
		super(nome, id, cpf, tipo, senha, agencia, numeroConta);
	}
    
}

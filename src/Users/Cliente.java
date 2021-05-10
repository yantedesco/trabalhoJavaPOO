package Users;


public class Cliente extends Usuario{
	
	public Cliente() {}

	@Override
	public String toString() {
		return "Cliente{" +
				"nome='" + nome + '\'' +
				", id=" + getId() +
				", cpf='" + getCpf() + '\'' +
				", tipo='" + getTipo() + '\'' +
				", senha='" + getSenha() + '\'' +
				", agencia=" + getAgencia() +
				", numeroConta=" + getNumeroConta() +
				'}';
	}

	public Cliente (String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta) {
		super(nome, id, cpf, tipo, senha, agencia, numeroConta);
	}
    
}

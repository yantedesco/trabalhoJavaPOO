package Users;


public abstract class Usuario {
	protected String nome;
	private int id;
	private String cpf;
	private String tipo;
	private String senha;
	private int agencia;
	private int numeroConta;
	
	public Usuario () {}
	
	public Usuario (String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta) {
		this.nome = nome;
		this.id = id;
		this.cpf = cpf;
		this.tipo = tipo;
		this.senha = senha;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	
}


package Users;


public abstract class Funcionario extends Usuario{
	private double salario;
    
    
    public Funcionario() {}
    
	public Funcionario(String nome, int id, String cpf, String tipo, String senha, int agencia) {
		this.nome = nome;
		this.id = id;
		this.cpf = cpf;
		this.tipo = tipo;
		this.senha = senha;
		this.agencia = agencia;	
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
}

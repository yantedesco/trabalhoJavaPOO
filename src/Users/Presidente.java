package Users;


public class Presidente extends Funcionario {    
    
	public Presidente() {}
	
    public Presidente (String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta, double salario) {
    	super(nome, id, cpf, tipo, senha, agencia, numeroConta, salario);
    }

    @Override
    public String toString() {
        return "Presidente{" +
                "salario=" + getSalario() +
                ", nome='" + nome + '\'' +
                ", nome='" + getNome() + '\'' +
                ", id=" + getId() +
                ", cpf='" + getCpf() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                ", senha='" + getSenha() + '\'' +
                ", agencia=" + getAgencia() +
                ", numeroConta=" + getNumeroConta() +
                '}';
    }
}

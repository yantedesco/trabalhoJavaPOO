package Users;


public class Diretor extends Funcionario{
	
	public Diretor() {}
    
    public Diretor (String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta, double salario) {
    	super(nome, id, cpf, tipo, senha, agencia, numeroConta, salario);
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "nome='" + nome + '\'' +
                ", salario=" + getSalario() +
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

package Users;


public class Gerente extends Funcionario {
        private int idAgencia;
        
        public Gerente () {}
        
        public Gerente (String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta, double salario, int idAgencia) {
        	super(nome, id, cpf, tipo, senha, agencia, numeroConta, salario);
        	this.idAgencia = idAgencia;
        	
        }

		public int getIdAgencia() {
			return idAgencia;
		}

		public void setIdAgencia(int idAgencia) {
			this.idAgencia = idAgencia;
		}

	@Override
	public String toString() {
		return "Gerente{" +
				"nome='" + getNome() + '\'' +
				", salario=" + getSalario() +
				", idAgencia=" + idAgencia +
				", nome='" + nome + '\'' +
				", id=" + getId() +
				", cpf='" + getCpf() + '\'' +
				", tipo='" + getTipo() + '\'' +
				", senha='" + getSenha() + '\'' +
				", agencia=" + getAgencia() +
				", numeroConta=" + getNumeroConta() +
				'}';
	}
}
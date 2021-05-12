package Users;

public abstract class Usuario {
    protected String nome;
    private int id;
    private String cpf;
    private String tipo;
    private String senha;
    private int agencia;
    private int numeroConta;

    public Usuario() {
    }

    public Usuario(String nome, int id, String cpf, String tipo, String senha, int agencia, int numeroConta) {
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

    public int getId() {
        return id;
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

    public String getSenha() {
        return senha;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }
}

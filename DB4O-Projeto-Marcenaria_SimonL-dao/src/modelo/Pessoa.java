package modelo;

public class Pessoa {
	private String cpf;
	private String nome;
	private int tel;
	private int cep;
	private String sexo;
	private int idade;
	
	public Pessoa(String cpf, String nome, int telefone, int cep, String sexo, int idade) {
		this.cpf = cpf;
		this.nome = nome;
		this.tel = telefone;
		this.cep = cep;
		this.sexo = sexo.toLowerCase();
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int getTel() {
		return tel;
	}
	public void settel(int tel) {
		this.tel = tel;
	}
	
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return "cpf=(" + cpf + "), nome=" + nome;
	}
}
package modelo;

public class Cliente extends Pessoa {	
	private double saldo = 0;
	
	public Cliente(String cpf, String nome, int telefone, int cep, String sexo, int idade) {
		super(cpf, nome, telefone, cep, sexo.toLowerCase(), idade);
	}
	
	
	public double getSaldo() {
		return saldo;
	}

	public void creditar(double valor) {
		saldo += valor;
	}
	
	public void debitar(double valor) {
		saldo -= valor;
	}

	
	@Override
	public String toString() {
		return "Cliente("+getCpf()+"), Nome="+getNome()+", Idade"+getIdade()+", Saldo="+saldo;
	}
}
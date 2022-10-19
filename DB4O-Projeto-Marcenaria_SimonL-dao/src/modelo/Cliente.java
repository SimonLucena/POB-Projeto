package modelo;

import java.util.ArrayList;

public class Cliente extends Pessoa {	
	private double saldo = 0;
	private ArrayList<Pedido> pedido = new ArrayList<>();
	
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
	
	public ArrayList<Pedido> getPedidos() {
		return pedido;
	}
}
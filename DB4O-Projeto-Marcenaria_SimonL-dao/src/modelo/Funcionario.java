package modelo;

import java.util.ArrayList;

public class Funcionario extends Pessoa{
	private int id;
	private double salario;
	private double horas;
	private String funcao;
	private ArrayList<Pedido> pedido = new ArrayList<>();

	public Funcionario(String cpf, String nome, int telefone, int cep, String sexo, int idade, double salario, double horas, String funcao) {
		super(cpf, nome, telefone, cep, sexo.toLowerCase(), idade);
		this.salario = salario;
		this.horas = horas;
		this.funcao = funcao.toLowerCase();
	}


	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getHoras() {
		return horas;
	}
	public void setHoras(double horas) {
		this.horas = horas;
	}

	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}



	@Override
	public String toString() {
		return "Funcionário("+id+"), Nome="+getNome()+", Idade="+getIdade()+", Salario="+salario+", Horas="+horas+", Função="+funcao;
	}
	
	public ArrayList<Pedido> getPedidos() {
		return pedido;
	}
}

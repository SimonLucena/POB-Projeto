package modelo;

import java.util.ArrayList;

public class Modelo {
	private int id;
	private String nome;
	private int codigoManual;
	private double preco;
	private ArrayList<Pedido> pedido = new ArrayList<>();
	
	public Modelo(int id, String nome, int codigoManual, double preco) {
		this.id = id;
		this.nome = nome;
		this.codigoManual = codigoManual;
		this.preco = preco;
	}
	
	public Pedido localizar(int id){
		for(Pedido e : pedido){
			if(e.getId() == id)
				return e;
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigoManual() {
		return codigoManual;
	}

	public void setCodigoManual(int codigoManual) {
		this.codigoManual = codigoManual;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Modelo("+getNome()+"), Preço="+getPreco()+", Número do Manual="+getCodigoManual();
	}
	
	public ArrayList<Pedido> getPedidos() {
		return pedido;
	}
}

package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int id;
	private Cliente cliente;
	private Funcionario vendedor;
	private Funcionario tecnico;
	private List<Modelo> produto = new ArrayList<>();;
	
	public Pedido(int id, Cliente cliente, Funcionario vendedor, Funcionario tecnico, List<Modelo> produto) {
		this.id = id;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.tecnico = tecnico;
		this.produto = produto;
	}
	
	public int getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public Funcionario getTecnico() {
		return tecnico;
	}

	public void setTecnico(Funcionario tecnico) {
		this.tecnico = tecnico;
	}

	public List<Modelo> getProduto() {
		return produto;
	}

	public void adicionar(Modelo produto) {
		this.produto.add(produto);
	}
	
	public void remover(Modelo produto) {
		this.produto.remove(produto);
	}
	
	@Override
	public String toString() {
		String texto = "Pedido("+id+"): "+getCliente().getNome()+", "+getVendedor().getNome()+", "+getTecnico().getNome()+", ";
		for(Modelo a: produto) 
			texto += a.getNome() + ", "; 
		
		return texto.substring(0, texto.length()-2);
	}
}

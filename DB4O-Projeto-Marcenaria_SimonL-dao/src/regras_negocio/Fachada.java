/**********************************
 * IFPB - SI
 * Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/

package regras_negocio;

import java.util.List;

import daodb4o.DAO;
import daodb4o.DAOCliente;
import daodb4o.DAOFuncionario;
import daodb4o.DAOModelo;
import daodb4o.DAOPedido;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Modelo;
import modelo.Pedido;
import modelo.Pessoa;

public class Fachada {
	private Fachada() {}		

	private static DAOCliente DAOCliente = new DAOCliente();  
	private static DAOFuncionario DAOFuncionario = new DAOFuncionario(); 
	private static DAOModelo DAOModelo = new DAOModelo();  
	private static DAOPedido DAOPedido = new DAOPedido(); 

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}
	
	public static List<Modelo> listarModelos() 	{
		DAO.begin();
		List<Modelo> result = DAOModelo.readAll();
		DAO.commit();
		return result;
	}
	public static List<Cliente> listarCliente() {
		DAO.begin();
		List<Cliente> result = DAOCliente.readAll();
		DAO.commit();
		return result;
	}
	public static List<Funcionario> listarFuncionarios() {
		DAO.begin();
		List<Funcionario> result = DAOFuncionario.readAll();
		DAO.commit();
		return result;
	}
	public static List<Pedido> listarPedido() {
		DAO.begin();
		List<Pedido> result = DAOPedido.readAll();
		DAO.commit();
		return result;
	}
	/*------------------------------------------------------------*/
	public static Cliente localizarCliente(String cpf) {
		DAO.begin();
		Cliente p = DAOCliente.read(cpf);
		DAO.commit();
		return p;
	}
	public static Funcionario localizarFuncionario(String cpf) {
		DAO.begin();
		Funcionario p = DAOFuncionario.read(cpf);
		DAO.commit();
		return p;
	}
	public static Modelo localizarModelo(int id) 	{
		DAO.begin();
		Modelo ev = DAOModelo.read(id);
		DAO.commit();
		return ev;
	}
	public static Pedido localizarPedido(int id) 	{
		DAO.begin();
		Pedido ev = DAOPedido.read(id);
		DAO.commit();
		return ev;
	}
	/*------------------------------------------------------------*/
	//Cliente
	public static Cliente criarCliente(String cpf, String nome, int telefone, int cep, String sexo, int idade) throws Exception {
		nome = nome.trim();
		
		DAO.begin();
		//localizar cliente no cliente, usando o cpf 
		Cliente p = DAOCliente.read(cpf);
		if (p!=null) {
			DAO.rollback();
			throw new Exception("Nao criou participante " + cpf + " - ja cadastrado(a)");
		}

		//criar objeto Cliente 
		p = new Cliente (cpf, nome, telefone, cep, sexo, idade);

		//criar cliente no repositorio
		DAOCliente.create(p);
		DAO.commit();
		return p;	
	}	
	//Funcionario
	public static Funcionario criarFuncionario(String cpf, String nome, int telefone, int cep, String sexo, int idade, int id, double salario, double horas, String funcao) throws Exception {
		nome = nome.trim();

		DAO.begin();
		//localizar funcionario no repositorio, usando o nome 
		Funcionario p = DAOFuncionario.read(cpf);
		if (p!=null) {
			DAO.rollback();
			throw new Exception("Nao criou funcionario " + cpf + " - ja cadastrado(a)");
		}
		//a funcao e obrigatoria 
		if (funcao.isEmpty()) {
			DAO.rollback();
			throw new Exception("Nao criou funcionario " + cpf + " - funcao e obrigatoria");
		}
		//criar objeto Funcionario 
		p = new Funcionario (cpf, nome, telefone, cep, sexo, idade, salario, horas, funcao);

		//criar Funcionario no reposit�rio
		DAOFuncionario.create(p);
		DAO.commit();
		return p;	
	}
	//Modelo
	public static Evento criarEvento (String data, String descricao, double preco) throws Exception {
		data = data.trim();
		descricao = descricao.trim();

		DAO.begin();
		//localizar Evento no repositorio, usando a data 
		Evento ev = DAOModelo.readByData(data);
		if (ev!=null) {
			DAO.rollback();
			throw new Exception("N�o criou evento: " + descricao + " - ja existe evento na data "+data);
		}
		if (preco <0) {
			DAO.rollback();
			throw new Exception("N�o criou evento: " + descricao + " - preco nao pode ser negativo " + preco);
		}

		//gerar id no repositorio
		ev = new Evento(descricao, data, preco);	

		//adicionar evento no reposit�rio
		DAOModelo.create(ev);
		//gravar reposit�rio
		DAO.commit();
		return ev;
	}
	//Pedido
	public static Pedido criarPedido (String data, String descricao, double preco) throws Exception {
		data = data.trim();
		descricao = descricao.trim();

		DAO.begin();
		//localizar Evento no repositorio, usando a data 
		Evento ev = DAOModelo.readByData(data);
		if (ev!=null) {
			DAO.rollback();
			throw new Exception("N�o criou evento: " + descricao + " - ja existe evento na data "+data);
		}
		if (preco <0) {
			DAO.rollback();
			throw new Exception("N�o criou evento: " + descricao + " - preco nao pode ser negativo " + preco);
		}

		//gerar id no repositorio
		ev = new Evento(descricao, data, preco);	

		//adicionar evento no reposit�rio
		DAOModelo.create(ev);
		//gravar reposit�rio
		DAO.commit();
		return ev;
	}

	public static void 	adicionarParticipanteEvento(String nome, int id) throws Exception {
		nome = nome.trim();

		DAO.begin();
		//localizar participante no repositorio, usando o nome 
		Participante p = DAOCliente.read(nome);
		if(p == null)  {
			DAO.rollback();
			throw new Exception("N�o adicionou participante " + nome + " - inexistente");
		}

		//localizar evento no repositorio, usando id 
		Evento ev = DAOModelo.read(id);
		if(ev == null)  {
			DAO.rollback();
			throw new Exception("N�o adicionou participante "+nome+ " - evento " + id + " inexistente");
		}

		//localizar o participante dentro do evento, usando o nome
		Participante paux = ev.localizar(nome);
		if(paux != null) {
			DAO.rollback(); 
			throw new Exception("N�o adicionou participante " + nome + " - j� participa do evento " + id);
		}
		//adicionar o participante ao evento
		ev.adicionar(p);
		//adicionar o evento ao participante
		p.adicionar(ev);

		//atualizar objetos no banco
		DAOModelo.update(ev);
		DAOCliente.update(paux);
		DAO.commit();
	}

	public static void 	removerParticipanteEvento(String nome, int id) throws Exception {
		nome = nome.trim();

		DAO.begin();
		//localizar participante no repositorio, usando o nome 
		Participante p = DAOCliente.read(nome);
		if(p == null)  {
			DAO.rollback();
			throw new Exception("N�o removeu participante " + nome + " - inexistente");
		}

		//localizar evento no repositorio, usando id 
		Evento ev = DAOModelo.read(id);
		if(ev == null)  {
			DAO.rollback();
			throw new Exception("N�o removeu participante " + nome +" -  evento " + id + " inexistente");
		}

		//localizar o participante dentro do evento, usando o nome
		Participante paux = ev.localizar(nome);
		if(paux == null)  {
			DAO.rollback();
			throw new Exception("N�o removeu participante " + nome + " - nao participa do evento " + id);
		}
		//remover o participante do evento
		ev.remover(p);
		//remover o evento do participante
		p.remover(ev);

		//atualizar objetos no banco
		DAOModelo.update(ev);
		DAOCliente.update(p);
		DAO.commit();
	}

	public static void apagarEvento(String data) throws Exception	{
		data = data.trim();

		DAO.begin();
		//localizar evento no repositorio, usando id 
		Evento ev = DAOModelo.readByData(data);
		if (ev == null) {
			DAO.rollback();
			throw new Exception("N�o deletou evento " + data + " - inexistente");
		}
		
		//Remover este evento de todos os participantes e atualizar participante 
		for(Participante p : ev.getParticipantes()) {
			p.remover(ev);
			DAOCliente.update(p);
		}
		
		//apagar evento no banco
		DAOModelo.delete(ev);
		DAO.commit();
	}

	public static void adiarEvento(String data, String novadata) throws Exception	{
		data = data.trim();
		novadata = novadata.trim();

		DAO.begin();
		//localizar evento no repositorio, usando data 
		Evento ev = DAOModelo.readByData(data);
		if (ev == null) {
			DAO.rollback();
			throw new Exception("N�o adiou evento - " + data +"  inexistente ");
		}
		//localizar evento no repositorio, usando novadata
		Evento aux = DAOModelo.readByData(novadata);
		if (aux != null) {
			DAO.rollback();
			throw new Exception("N�o adiou evento de " + data + " - ja tem evento na nova data " + novadata);
		}
		//alterar a data do evento
		ev.setData(novadata);

		//atualizar no banco
		DAOModelo.update(ev);
		DAO.commit();
	}

	public static void 	apagarParticipante(String nome) throws Exception {
		nome = nome.trim();

		DAO.begin();
		//localizar participante no repositorio, usando o nome 
		Participante p = DAOCliente.read(nome);
		if(p == null)  {
			DAO.rollback();
			throw new Exception("N�o deletou participante " + nome + " - inexistente");
		}
		//participante nao pode ser deletado caso participe de algum evento
		if(!p.getEventos().isEmpty())  {
			DAO.rollback();
			throw new Exception("N�o deletou participante " + nome + " - ja tem evento");
		}
		//apagar no banco
		DAOCliente.delete(p);
		DAO.commit();
	}

	
	/*
	 * CONSULTAS
	 */
	
	public static List<Evento> consultarEventosNParticipantes(int n){
		return DAOModelo.consultarEventosNParticipantes(n);
	}
	
	public static int consultarTotalConvidados() {
		return DAOFuncionario.consultarTotalConvidados();
	}

	public static int consultarTotalIdosos() {
		return DAOCliente.consultarTotalIdosos();
	}
}

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
		Funcionario f = DAOFuncionario.read(cpf);
		if (f!=null) {
			DAO.rollback();
			throw new Exception("Nao criou funcionario " + cpf + " - ja cadastrado(a)");
		}
		//a funcao e obrigatoria 
		if (funcao.isEmpty()) {
			DAO.rollback();
			throw new Exception("Nao criou funcionario " + cpf + " - funcao e obrigatoria");
		}
		//criar objeto Funcionario 
		f = new Funcionario (cpf, nome, telefone, cep, sexo, idade, salario, horas, funcao);

		//criar Funcionario no reposit???rio
		DAOFuncionario.create(f);
		DAO.commit();
		return f;
	}
	//Modelo
	public static Modelo criarModelo (int id, String nome, int codigoManual, double preco) throws Exception {
		nome = nome.trim();

		DAO.begin();
		//localizar Evento no repositorio, usando o id 
		Modelo mod = DAOModelo.read(id);
		if (mod!=null) {
			DAO.rollback();
			throw new Exception("N???o criou modelo: " + nome + " - ja existe modelo");
		}
		if (preco <0) {
			DAO.rollback();
			throw new Exception("N???o criou modelo: " + nome + " - preco nao pode ser negativo " + preco);
		}

		//gerar id no repositorio
		mod = new Modelo(id, nome, 	codigoManual, preco);	

		//adicionar evento no reposit???rio
		DAOModelo.create(mod);
		//gravar reposit???rio
		DAO.commit();
		return mod;
	}
	//Pedido
	public static Pedido criarPedido (int id, String cpf, String cpfFuncionario1, String cpfFuncionario2, ArrayList<int> idModelo) throws Exception {
		DAO.begin();
		//localizar Evento no repositorio, usando a data 
		Pedido pe = DAOPedido.read(id);
		if (pe!=null) {
			DAO.rollback();
			throw new Exception("N???o criou pedido: " + id + " - ja existe pedido");
		}

		//gerar id no repositorio
		pe = new Pedido(id, cliente, vendedor, tecnico, produto);	

		//adicionar evento no reposit???rio
		DAOPedido.create(pe);
		//gravar reposit???rio
		DAO.commit();
		return pe;
	}

	public static void apagarModelo(int id) throws Exception	{
		DAO.begin();
		//localizar evento no repositorio, usando id 
		Modelo mo = DAOModelo.read(id);
		if (mo == null) {
			DAO.rollback();
			throw new Exception("N???o deletou evento " + id + " - inexistente");
		}
		
		//Remover este Modelo de todos os Pedidos e atualizar Pedidos 
		for(Pedido pe : mo.getPedidos()) {
			pe.remover(mo);
			DAOPedido.update(pe);
		}
		
		//apagar modelo no banco
		DAOModelo.delete(mo);
		DAO.commit();
	}
	
	public static void apagarPedido(int id) throws Exception	{
		DAO.begin();
		//localizar evento no repositorio, usando id 
		Pedido pe = DAOPedido.read(id);
		if (pe == null) {
			DAO.rollback();
			throw new Exception("N???o deletou Pedido " + id + " - inexistente");
		}
		
		//apagar modelo no banco
		DAOPedido.delete(pe);
		DAO.commit();
	}

	public static void 	apagarCliente(String nome) throws Exception {
		nome = nome.trim();

		DAO.begin();
		//localizar participante no repositorio, usando o nome 
		Cliente p = DAOCliente.read(nome);
		if(p == null)  {
			DAO.rollback();
			throw new Exception("N???o deletou Cliente " + nome + " - inexistente");
		}
		//participante nao pode ser deletado caso participe de algum Pedido
		if(!p.getPedidos().isEmpty())  {
			DAO.rollback();
			throw new Exception("N???o deletou Cliente " + nome + " - Cliente em Pedido");
		}
		//apagar no banco
		DAOCliente.delete(p);
		DAO.commit();
	}
	
	public static void 	apagarFuncionario(String nome) throws Exception {
		nome = nome.trim();

		DAO.begin();
		//localizar Funcionario no repositorio, usando o nome 
		Funcionario f = DAOFuncionario.read(nome);
		if(f == null)  {
			DAO.rollback();
			throw new Exception("N???o deletou Cliente " + nome + " - inexistente");
		}
		//Funcionario nao pode ser deletado caso participe de algum Pedido
		if(!f.getPedidos().isEmpty())  {
			DAO.rollback();
			throw new Exception("N???o deletou Funcionario " + nome + " - Funcionario em Pedido");
		}
		//apagar no banco
		DAOFuncionario.delete(f);
		DAO.commit();
	}
}

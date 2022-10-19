package appconsole;
import regras_negocio.Fachada;

public class Cadastrar {

	public Cadastrar() {
		System.out.println("cadastrando...");
		try {
			Fachada.inicializar();
			System.out.println("criar Pessoas");
			Fachada.criarCliente("58264731950", "Teste Cliente", 963258741, 52036, "feminino", 35);
			Fachada.criarCliente("05206246450", "Teste Cliente2", 986526888, 58032, "masculino", 20);
			Fachada.criarFuncionario("01234567895", "Teste Vendedor", 982548666, 58052, "masculino", 23, 1, 1258.00, 8, "vendedor");
			Fachada.criarFuncionario("98765432105", "Teste Técnico", 984652155, 58032, "feminino", 26, 2, 1377.00, 8, "tecnico");


			System.out.println("adicionar Modelo");
			Fachada.criarModelo(1, "Cadeira érgométrica de Carvalho", 5227, 75.99);
						
			System.out.println("adicionar Pedido");
			
			Fachada.criarPedido(1, cliente, funcionario1, funcionario2, modelo);
			
		} catch (Exception e) {
			System.out.println("--->"+e.getMessage());
		}		

		Fachada.finalizar();
	}

	public static void main (String[] args) 
	{
		new Cadastrar();
	}
}



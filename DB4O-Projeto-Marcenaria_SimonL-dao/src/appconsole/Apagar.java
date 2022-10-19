package appconsole;
import regras_negocio.Fachada;

public class Apagar {

	public Apagar() {
		System.out.println("apagando...");
		try {
			Fachada.inicializar();
			
			Fachada.apagarModelo(1);	
			System.out.println("apagou modelo");
			
			Fachada.apagarPedido(2);
			System.out.println("apagou pedido");
			
		} catch (Exception e) {
			System.out.println("--->"+e.getMessage());
		}		

		Fachada.finalizar();
	}

	public static void main (String[] args) 
	{
		new Apagar();
	}
}



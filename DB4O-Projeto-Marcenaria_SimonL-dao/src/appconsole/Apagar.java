package appconsole;
import regras_negocio.Fachada;

public class Apagar {

	public Apagar() {
		System.out.println("apagando...");
		try {
			Fachada.inicializar();
			
			Fachada.apagarEvento("01/08/2022");	
			System.out.println("apagou palestra");
			
			Fachada.apagarParticipante("fake");
			System.out.println("apagou fake");
			
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



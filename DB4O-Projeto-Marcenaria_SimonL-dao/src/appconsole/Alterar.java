package appconsole;
import regras_negocio.Fachada;

public class Alterar {

	public Alterar() {
		System.out.println("alterando...");
		try {
			Fachada.inicializar();

			Fachada.removerParticipanteEvento("fake", 1);
			Fachada.removerParticipanteEvento("fake", 2);
			Fachada.removerParticipanteEvento("fake", 3);
			Fachada.removerParticipanteEvento("fake", 4);
			System.out.println("removeu fake dos eventos");
			
			Fachada.adiarEvento("01/07/2022", "02/07/2022");
			System.out.println("adiou data do show para 02");

		} catch (Exception e) {
			System.out.println("--->"+e.getMessage());
		}		
		Fachada.finalizar();
	}

	public static void main (String[] args) 
	{
		new Alterar();
	}
}



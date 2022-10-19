package appconsole;
import modelo.Evento;
import modelo.Participante;
import regras_negocio.Fachada;

public class Listar {

	public Listar() {
		try {
			Fachada.inicializar();
		
			System.out.println("\n---------listagem de participantes -----");
			for(Participante p : Fachada.listarParticipantes("")) 
				System.out.println(p);
			
			System.out.println("\n---------listagem de convidados -----");
			for(Participante p : Fachada.listarConvidados()) 
				System.out.println(p);

			System.out.println("\n---------listagem de eventos ");
			for(Evento e : Fachada.listarEventos()) 
				System.out.println(e);
		} catch (Exception e) {
			System.out.println("--->"+e.getMessage());
		}	

		Fachada.finalizar();
	}

	public static void main (String[] args) 
	{
		new Listar();
	}
}



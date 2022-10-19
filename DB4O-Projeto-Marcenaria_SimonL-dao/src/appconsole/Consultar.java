package appconsole;
import modelo.Evento;
import modelo.Participante;
import regras_negocio.Fachada;

public class Consultar {

	public Consultar() {
		try {
			Fachada.inicializar();
			Evento evento = Fachada.localizarEvento(1);
			System.out.println("localizou evento:\n" + evento);
			
			System.out.println("\n---------participantes com nome z -----");
			for(Participante p : Fachada.listarParticipantes("z")) 
				System.out.println(p);
			
			System.out.println("\n---------eventos com 5 participantes");
			for(Evento e : Fachada.consultarEventosNParticipantes(5)) 
				System.out.println(e);
			System.out.println("\n---------eventos com 0 participantes");
			for(Evento e : Fachada.consultarEventosNParticipantes(0)) 
				System.out.println(e);
			
			System.out.println("\n---------total de convidados: " + Fachada.consultarTotalConvidados()); 
			System.out.println("\n---------total de participantes idosos (idade >= 60) "+Fachada.consultarTotalIdosos());
		
			
		} catch (Exception e) {
			System.out.println("--->"+e.getMessage());
		}	

		Fachada.finalizar();
	}

	public static void main (String[] args) 
	{
		new Consultar();
	}
}



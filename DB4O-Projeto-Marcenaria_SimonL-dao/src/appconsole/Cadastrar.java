package appconsole;
import regras_negocio.Fachada;

public class Cadastrar {

	public Cadastrar() {
		System.out.println("cadastrando...");
		try {
			Fachada.inicializar();
			System.out.println("criar eventos");
			Fachada.criarEvento("01/06/2022","festa",100.0);
			Fachada.criarEvento("01/07/2022","show",200.0);
			Fachada.criarEvento("01/08/2022","palestra",500.0);
			Fachada.criarEvento("01/09/2022","comicio",0.0);

			
			System.out.println("criar participantes");
			Fachada.criarParticipante("zezinho@gmail.com", "zezinho",  150);
			Fachada.criarParticipante("zezao@gmail.com", "zezao",  30);
			Fachada.criarParticipante("antonio@gmail.com", "antonio",  30);
			Fachada.criarConvidado("joao@gmail.com", "joao",  70, "globo");
			Fachada.criarConvidado("maria@gmail.com", "maria",  50, "sbt");
			Fachada.criarParticipante("fake@gmail.com", "fake",  70);

			System.out.println("adicionar participantes");
			Fachada.adicionarParticipanteEvento("zezinho", 1);
			Fachada.adicionarParticipanteEvento("zezao", 1);
			Fachada.adicionarParticipanteEvento("antonio", 1);
			Fachada.adicionarParticipanteEvento("joao", 1);
			Fachada.adicionarParticipanteEvento("maria", 1);
			Fachada.adicionarParticipanteEvento("fake", 1);
			
			Fachada.adicionarParticipanteEvento("zezinho", 2);
			Fachada.adicionarParticipanteEvento("zezao", 2);
			Fachada.adicionarParticipanteEvento("antonio", 2);
			Fachada.adicionarParticipanteEvento("joao", 2);
			Fachada.adicionarParticipanteEvento("maria", 2);
			Fachada.adicionarParticipanteEvento("fake", 2);
			
			Fachada.adicionarParticipanteEvento("zezinho", 3);
			Fachada.adicionarParticipanteEvento("zezao", 3);
			Fachada.adicionarParticipanteEvento("antonio", 3);
			Fachada.adicionarParticipanteEvento("joao", 3);
			Fachada.adicionarParticipanteEvento("maria",3);
			Fachada.adicionarParticipanteEvento("fake", 3);
			
			Fachada.adicionarParticipanteEvento("fake", 4);
			
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



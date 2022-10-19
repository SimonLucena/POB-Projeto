/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package daodb4o.Antigo;


import java.util.List;

import com.db4o.query.Query;

import daodb4o.DAO;
import modelo.Convidado;
import modelo.Participante;

public class DAOParticipante  extends DAO<Participante>{

	//nome � usado como campo unico 
	public Participante read (Object chave) {
		String nome = (String) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Participante.class);
		q.descend("nome").constrain(nome);
		List<Participante> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}


	public List<Participante> readAll(String texto){
		manager.ext().purge();  	//limpar cache do manager
		Query q = manager.query();
		q.constrain(Participante.class);
		q.descend("nome").constrain(texto).like();	//nome like texto
		return q.execute();
	}

	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS
	 * 
	 **********************************************************/

	public int consultarTotalIdosos() {
		Query q = manager.query();
		q.constrain(Convidado.class);
		q.descend("idade").constrain(60).smaller().not();
		return q.execute().size();
	}
	//	
	//	public List<Pessoa>  readByNTelefones(int n) {
	//		Query q = manager.query();
	//		q.constrain(Pessoa.class);
	//		q.constrain(new Filtro(n));
	//		List<Pessoa> result = q.execute(); 
	//		return result;
	//	}
	//

}


/*-------------------------------------------------*/
//@SuppressWarnings("serial")
//class Filtro  implements Evaluation {
//	private int n;
//	public Filtro (int n) {this.n=n;}
//	public void evaluate(Candidate candidate) {
//		Pessoa p = (Pessoa) candidate.getObject();
//		candidate.include( p.getTelefones().size()==n );
//	}
//}


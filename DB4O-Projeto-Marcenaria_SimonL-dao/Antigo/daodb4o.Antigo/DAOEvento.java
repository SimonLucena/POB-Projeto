/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package daodb4o.Antigo;


import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import daodb4o.DAO;
import modelo.Evento;

public class DAOEvento  extends DAO<Evento>{
	public Evento read (Object chave) {
		int id = (Integer) chave;
		Query q = manager.query();
		q.constrain(Evento.class);
		q.descend("id").constrain(id);
		List<Evento> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public Evento readByData (Object chave) {
		String data = (String) chave;
		Query q = manager.query();
		q.constrain(Evento.class);
		q.descend("data").constrain(data);
		List<Evento> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public void create(Evento evento) {
		int novoid = super.gerarId();
		evento.setId(novoid);
		super.create(evento);
	}


	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS 
	 * 
	 **********************************************************/

	public List<Evento> consultarEventosNParticipantes(int n){
		Query q = manager.query();
		q.constrain(Evento.class);
		q.constrain(new Filtro(n));
		return q.execute();
	}
}

@SuppressWarnings("serial")
class Filtro  implements Evaluation {
	private int n;
	public Filtro (int n) {
		this.n=n;
	}

	public void evaluate(Candidate candidate) {
		Evento e = (Evento) candidate.getObject();
		candidate.include( e.getParticipantes().size()==n );
	}
}
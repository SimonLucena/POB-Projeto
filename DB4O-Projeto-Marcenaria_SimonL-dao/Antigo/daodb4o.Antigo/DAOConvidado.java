/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import daodb4o.DAO;
import modelo.Convidado;

public class DAOConvidado  extends DAO<Convidado>{
	//nome � usado como campo unico 
	public Convidado read (Object chave) {
		String nome = (String) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Convidado.class);
		q.descend("nome").constrain(nome);
		List<Convidado> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	
	public int consultarTotalConvidados() {
		Query q = manager.query();
		q.constrain(Convidado.class);
		return q.execute().size();
	}
}


/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package daodb4o;

import java.util.List;
import com.db4o.query.Query;
import modelo.Cliente;

public class DAOCliente  extends DAO<Cliente>{
	//nome � usado como campo unico 
	public Cliente read (Object chave) {
		String nome = (String) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("nome").constrain(nome);
		List<Cliente> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	
	public int consultarTotalConvidados() {
		Query q = manager.query();
		q.constrain(Cliente.class);
		return q.execute().size();
	}
}


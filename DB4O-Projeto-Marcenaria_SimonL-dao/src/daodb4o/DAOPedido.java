/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package daodb4o;

import java.util.List;
import com.db4o.query.Query;
import modelo.Pedido;
import modelo.Modelo;

public class DAOPedido  extends DAO<Pedido>{
	//id � usado como campo unico 
	public Pedido read (Object chave) {
		int id = (int) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("id").constrain(id);
		List<Pedido> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	public Pedido readByModelo (Object chave) {
		int id = (int) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Modelo.class);
		q.descend("id").constrain(id);
		List<Pedido> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	public int consultarTotalConvidados() {
		Query q = manager.query();
		q.constrain(Pedido.class);
		return q.execute().size();
	}
}


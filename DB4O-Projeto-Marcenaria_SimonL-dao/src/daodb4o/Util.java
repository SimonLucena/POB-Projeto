/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

package daodb4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Modelo;
import modelo.Pedido;
import modelo.Pessoa;

public class Util {
	public static ObjectContainer conectarDb4oLocal(){
		//---------------------------------------
		//configurar e conectar/criar banco local
		//---------------------------------------
		
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  // mensagens na tela 0(desliga),1,2,3...
		
		// habilitar cascata na alteração, remoção e leitura
		config.common().objectClass(Cliente.class).cascadeOnDelete(false);;
		config.common().objectClass(Cliente.class).cascadeOnUpdate(true);;
		config.common().objectClass(Cliente.class).cascadeOnActivate(true);
		config.common().objectClass(Funcionario.class).cascadeOnDelete(false);;
		config.common().objectClass(Funcionario.class).cascadeOnUpdate(true);;
		config.common().objectClass(Funcionario.class).cascadeOnActivate(true);
		config.common().objectClass(Pedido.class).cascadeOnDelete(false);;
		config.common().objectClass(Pedido.class).cascadeOnUpdate(true);;
		config.common().objectClass(Pedido.class).cascadeOnActivate(true);;
		config.common().objectClass(Modelo.class).cascadeOnDelete(false);;
		config.common().objectClass(Modelo.class).cascadeOnUpdate(true);;
		config.common().objectClass(Modelo.class).cascadeOnActivate(true);
		config.common().objectClass(Pessoa.class).cascadeOnDelete(false);;
		config.common().objectClass(Pessoa.class).cascadeOnUpdate(true);;
		config.common().objectClass(Pessoa.class).cascadeOnActivate(true);
		
		// criar indices (opcional) sobre campos de busca
		config.common().objectClass(Pessoa.class).objectField("cpf").indexed(true);
		config.common().objectClass(Pedido.class).objectField("id").indexed(true);
		config.common().objectClass(Modelo.class).objectField("id").indexed(true);
		
		// nivel de profundidade do grafo para leitura e atualização
		config.common().objectClass(Cliente.class).updateDepth(5);
		config.common().objectClass(Cliente.class).minimumActivationDepth(5);
		config.common().objectClass(Funcionario.class).updateDepth(5);
		config.common().objectClass(Funcionario.class).minimumActivationDepth(5);
		config.common().objectClass(Pedido.class).updateDepth(5);
		config.common().objectClass(Pedido.class).minimumActivationDepth(5);
		config.common().objectClass(Modelo.class).updateDepth(5);
		config.common().objectClass(Modelo.class).minimumActivationDepth(5);
		
		//conexao local
		ObjectContainer manager = Db4oEmbedded.openFile(config, "banco.db4o");
		return manager;
	}

	
	public static ObjectContainer conectarDb4oRemoto(){		
		//---------------------------------------
		//configurar e conectar/criar banco remoto
		//---------------------------------------

		ClientConfiguration config = Db4oClientServer.newClientConfiguration( ) ;
		config.common().messageLevel(0);  // 0,1,2,3...

		// habilitar cascata na alteração, remoção e leitura
				config.common().objectClass(Cliente.class).cascadeOnDelete(false);;
				config.common().objectClass(Cliente.class).cascadeOnUpdate(true);;
				config.common().objectClass(Cliente.class).cascadeOnActivate(true);
				config.common().objectClass(Funcionario.class).cascadeOnDelete(false);;
				config.common().objectClass(Funcionario.class).cascadeOnUpdate(true);;
				config.common().objectClass(Funcionario.class).cascadeOnActivate(true);
				config.common().objectClass(Pedido.class).cascadeOnDelete(false);;
				config.common().objectClass(Pedido.class).cascadeOnUpdate(true);;
				config.common().objectClass(Pedido.class).cascadeOnActivate(true);;
				config.common().objectClass(Modelo.class).cascadeOnDelete(false);;
				config.common().objectClass(Modelo.class).cascadeOnUpdate(true);;
				config.common().objectClass(Modelo.class).cascadeOnActivate(true);
				config.common().objectClass(Pessoa.class).cascadeOnDelete(false);;
				config.common().objectClass(Pessoa.class).cascadeOnUpdate(true);;
				config.common().objectClass(Pessoa.class).cascadeOnActivate(true);
				
				// criar indices (opcional) sobre campos de busca
				config.common().objectClass(Pessoa.class).objectField("cpf").indexed(true);
				config.common().objectClass(Pedido.class).objectField("id").indexed(true);
				config.common().objectClass(Modelo.class).objectField("id").indexed(true);
				
				// nivel de profundidade do grafo para leitura e atualização
				config.common().objectClass(Cliente.class).updateDepth(5);
				config.common().objectClass(Cliente.class).minimumActivationDepth(5);
				config.common().objectClass(Funcionario.class).updateDepth(5);
				config.common().objectClass(Funcionario.class).minimumActivationDepth(5);
				config.common().objectClass(Pedido.class).updateDepth(5);
				config.common().objectClass(Pedido.class).minimumActivationDepth(5);
				config.common().objectClass(Modelo.class).updateDepth(5);
				config.common().objectClass(Modelo.class).minimumActivationDepth(5);
		
		//Conexão cliente/servidor
		ObjectContainer manager = Db4oClientServer.openClient(config,"localhost",34000,"usuario1","senha1");
		//ObjectContainer manager = Db4oClientServer.openClient(config,"34.207.139.216",34000,"usuario1","senha1");
		return manager;
	}

}


package armazenamento;

import Users.Usuario;

import java.io.Serializable;
import java.util.Comparator;
 
 //Custom comparator
 //If you want to save to the collection, you must implement serialization and deserialization
public class Comparador implements Comparator,Serializable{
 

	private static final long serialVersionUID = 1L;

	@Override
	public int compare(Object user1, Object user2) {
		Usuario usuario1 = (Usuario)user1; //Rewrite the comparison method --- forced conversion to User type
		Usuario usuario2 = (Usuario)user2;
		return usuario1.getCpf().compareTo(usuario2.getCpf());//Compare two bank accounts
	}
 
}

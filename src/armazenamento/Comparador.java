
package armazenamento;
 
import java.io.Serializable;
import java.util.Comparator;
 
 //Custom comparator
 //If you want to save to the collection, you must implement serialization and deserialization
public class Comparador implements Comparator,Serializable{
 
	
	private static final long serialVersionUID = 1L;
	@Override
	public int compare(Object user1, Object user2) {
		if(Usuario.getCpf()==(User)arg0; //Rewrite the comparison method --- forced conversion to User type
                   User user2 = (User)arg1;
		 return user1.getAccount().compareTo(user2.getAccount());//Compare two bank accounts
	}
 
}

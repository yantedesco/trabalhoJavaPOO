
package armazenamento;

import Users.Usuario;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.TreeSet;


public class File {
    
    public static void leitor(String path, Usuario user) throws IOException {
		
	BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO+path));
	String linha = "";
			
        while(true){
            linha = buffRead.readLine();
            if (linha != null) {
            String[] pp = linha.split(";");
            System.out.print("\n");

            }
            else{
                
                buffRead.close();
                break;
            }
        }				
				
    }
    

        TreeSet<Usuario> listaUsuarios = Data.getData().getlistaUsuarios(); //Get the container from the Data database
        //The file class is only for use and cannot be arbitrarily realized
	 
        
        
    
}

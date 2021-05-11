
package sistema;


import armazenamento.File;
import banco.Relatorio;

public class Principal {



    public static void main(String[] args) {
    	

        SistemaInterno sistema = new SistemaInterno();

        File.hashMapFromFileTextUsuario(File.getPathBasico() +
                "text"+ File.getEXTENSAO());
        
        File.hashMapFromFileTextContas(File.getPathBasico() +
                "contas"+ File.getEXTENSAO());
        
        System.out.println(File.getMapConta());
        
        Relatorio r1 = new Relatorio();
    	r1.capitalTotal();
        
        // sistema.menuPrincipal();
//        sistema.menuPrincipal();
        //Olá



    }

}

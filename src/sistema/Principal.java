
package sistema;


import armazenamento.File;

import java.io.IOException;

public class Principal {



    public static void main(String[] args) throws InterruptedException, IOException {
    	


        File.hashMapFromFileTextUsuario(File.getPathBasico() +
                "lista"+ File.getEXTENSAO());

        File.hashMapFromFileTextContas(File.getPathBasico() +
                "contas"+ File.getEXTENSAO());

//        System.out.println(File.getMapConta());
//        System.out.println("\n");
//         System.out.println(File.getMapUsuario());
//        
        SistemaInterno sistema = new SistemaInterno();
//        Relatorio r1 = new Relatorio();
//    	  r1.capitalTotal();

//    	  r1.nomesOrdemAlfabetica();

        sistema.menuPrincipal();
//        sistema.menuPrincipal();
        //Olá



    }

}
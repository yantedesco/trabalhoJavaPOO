
package sistema;


import armazenamento.File;

public class Principal {



    public static void main(String[] args) {

        SistemaInterno sistema = new SistemaInterno();

        File.hashMapFromFileTextUsuario(File.getPathBasico() +
                "text"+ File.getEXTENSAO());
       // sistema.menuPrincipal();
        sistema.menuPrincipal();
        //Olá



    }

}

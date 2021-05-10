
package sistema;


import Users.Usuario;
import armazenamento.File;

public class Principal {

    static Usuario usuario;

    public static void map(Usuario usuario) {
        File.getMap().get(usuario);
    }
    public static void main(String[] args) {

        SistemaInterno sistema = new SistemaInterno();

        map(usuario);
        sistema.menuPrincipal(usuario);

        //Olá



    }

}

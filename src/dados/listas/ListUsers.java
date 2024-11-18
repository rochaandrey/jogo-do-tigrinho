package dados.listas;

import negocio.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListUsers {

    private static final List<Usuario> usersList = new ArrayList<>();

    public static void addList(Usuario usuario){
        usersList.add(usuario);
    }

    public static int usuarioExist(Usuario usuario){
        for (Usuario value : usersList) {
            if (value.equals(usuario)) {
                return usersList.indexOf(usuario);
            }
        }
        return -1;
    }

    public static Usuario userByINDEX(int i){
        return usersList.get(i);
    }


}

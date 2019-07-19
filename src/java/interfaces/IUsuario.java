/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Usuario;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author USUARIOWIN10
 */
public interface IUsuario {

    public abstract boolean guardarUsuario(Usuario usuario);

    public abstract ArrayList<Usuario> listarUsuario();

    public abstract boolean ActualizarUsuario(Usuario usuario);
    
    public abstract boolean eliminarUsuario(Usuario usuario);
}

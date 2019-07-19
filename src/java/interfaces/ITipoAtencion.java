/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Tipoatencion;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author USUARIOWIN10
 */
public interface ITipoAtencion {

    public abstract boolean guardarTipoAtencion(Tipoatencion tipoatencion);

    public abstract ArrayList<Tipoatencion> listarTipoAtencion();

    public abstract boolean ActualizarTipoAtencion(Tipoatencion tipoatencion);

    public abstract boolean eliminarTipoAtencion(Tipoatencion tipoatencion);
}

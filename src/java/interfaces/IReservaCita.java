/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Reservacita;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author USUARIOWIN10
 */
public interface IReservaCita {

    public abstract boolean guardarReservacita(Reservacita reservaCita);

    public abstract ArrayList<Reservacita> listarReservacita();

    public abstract boolean ActualizarReservacita(Reservacita reservaCita);
    
    public abstract boolean eliminarReservacita(Reservacita reservaCita);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Tiporeserva;
import interfaces.ITipoReserva;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIOWIN10
 */
public class TipoReservaDao implements ITipoReserva {

    @Override
    public boolean guardarTiporeserva(Tiporeserva tiporeserva) {
//Construir una nueva session y una nueva transaccion
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la tiporeserva
        try {
            sesion.save(tiporeserva);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARDAR::" + e);
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Tiporeserva> listarTiporeserva() {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Tiporeserva> milista = new ArrayList<>();
        //Create la consulta hacia la base de datos
        Query query = sesion.createQuery("from Tiporeserva");
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Tiporeserva>) query.list();
        sesion.close();
        return milista;
    }

    @Override
    public boolean ActualizarTiporeserva(Tiporeserva tiporeserva) {
        boolean resp = true;
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.update(tiporeserva);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error en actualizar::" + e);
        } finally {
            if (sesion != null) {
                sesion.close();
            }

        }
        return resp;
    }

    @Override
    public boolean eliminarTiporeserva(Tiporeserva tiporeserva) {

        Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(tiporeserva);
            sesion.getTransaction().commit();

        } catch (Exception e) {
            resp = false;
            System.out.println("ERROR EN ELIMINAR::" + e);
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();

            }

        }
        return resp;
    }

}

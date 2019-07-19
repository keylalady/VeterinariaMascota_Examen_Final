/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Atencion;
import entidades.Mascotaporcliente;
import interfaces.IAtencion;
import interfaces.IMascotaporcliente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIOWIN10
 */


//<p:calendar id="time" value="#{atencionBeans.atencion.horaAtencion}" pattern="HH:mm" timeOnly="true"  />

public class AtencionDao implements IAtencion {

    @Override
    public boolean guardarAtencion(Atencion atencion) {
        //Construir una nueva session y una nueva transaccion
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();

        //Rgistrar en la base de datos la mascotaporcliente
        try {
            sesion.save(atencion);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARFDAR::" + e);
            respuesta = false;
        }

        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Atencion> listarAtencion() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Atencion> milista = new ArrayList<>();
        //Create la consulta hacia la base de datos
        Query query = sesion.createQuery("from Atencion");
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Atencion>) query.list();
        sesion.close();
        return milista;

    }

    @Override
    public boolean ActualizarAtencion(Atencion atencion) {

        boolean resp = true;
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.update(atencion);
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
    public boolean eliminarAtencion(Atencion atencion) {
        Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(atencion);
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

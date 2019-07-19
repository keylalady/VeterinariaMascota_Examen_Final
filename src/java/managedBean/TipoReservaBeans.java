/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.TipoReservaDao;
import entidades.Cliente;
import entidades.Tiporeserva;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author USUARIOWIN10
 */
@ManagedBean
@ViewScoped
public class TipoReservaBeans {

    //private Date date9;
    private Tiporeserva tiporeserva;
     private boolean banderaSelect = false;

    //constructor
    public TipoReservaBeans() {
        this.tiporeserva = new Tiporeserva();
    }
 

    public String guardarTipoReserva() {
        TipoReservaDao dao = new TipoReservaDao();
        boolean respuesta = dao.guardarTiporeserva(tiporeserva);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroTipoReserva";

    }

 
    public String actualizarTipoReserva() {
        try {
            TipoReservaDao dao = new TipoReservaDao();
            boolean resp = dao.ActualizarTiporeserva(tiporeserva);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            dao.ActualizarTiporeserva(tiporeserva);
        } catch (Exception e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroTipoReserva";
    }

    public ArrayList<Tiporeserva> listarTipoReserva() {
        ArrayList<Tiporeserva> milista = new ArrayList<>();
        TipoReservaDao dao = new TipoReservaDao();
        milista = dao.listarTiporeserva();
        return milista;

    }

    public String limpiar() {
        banderaSelect=false;
        return "/RegistroTipoReserva.xhtml";
    }

    public String eliminar(Tiporeserva data) {
        TipoReservaDao madao = new TipoReservaDao();
        boolean respuesta = madao.eliminarTiporeserva(data);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }

        return "/RegistroTipoReserva.xhtml";
    }
    public void selectBandera() {
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

    public Tiporeserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }
    
}

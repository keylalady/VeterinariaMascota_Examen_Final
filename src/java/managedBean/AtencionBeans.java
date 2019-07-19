/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.AtencionDao;
import Dao.ClienteDao;
import Dao.MascotaDao;
import Dao.PersonalDao;
import Dao.TipoAtencionDao;
import entidades.Atencion;
import entidades.Mascotaporcliente;
import entidades.MascotaporclienteId;
import entidades.Personal;
import entidades.Tipoatencion;
import java.util.ArrayList;
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
public class AtencionBeans {

    private boolean banderaSelect = false;
    private Atencion atencion;
    private Personal personal;

    private Tipoatencion tipoatencion;

    private Mascotaporcliente mascotaporcliente;
    private MascotaporclienteId mascotaporclienteid;

    private ArrayList listaPersonal;
    private ArrayList listaMascotas;
    private ArrayList listaClientes;
    private ArrayList listaTipatencion;

    private int idPersonal;
    private int idMascota;
    private int idcliente;
    private int idTipoAtencion;

    //Constructor
    public AtencionBeans() {
        atencion = new Atencion();
        listaPersonal = new ArrayList();
        listaMascotas = new ArrayList();
        listaClientes = new ArrayList();
        listaTipatencion = new ArrayList();
        tipoatencion = new Tipoatencion();
        mascotaporcliente = new Mascotaporcliente();
        mascotaporclienteid = new MascotaporclienteId();

        personal = new Personal();
        listarCombox();

    }

    public void listarCombox() {
        PersonalDao personaldao = new PersonalDao();
        MascotaDao mascotadao = new MascotaDao();
        ClienteDao clientedao = new ClienteDao();
        TipoAtencionDao tipoatenciodao = new TipoAtencionDao();

        listaPersonal = personaldao.listarPersonal();
        listaMascotas = mascotadao.listarMascotas();
        listaClientes = clientedao.listarCliente();
        listaTipatencion = tipoatenciodao.listarTipoAtencion();
    }

    public String guardarAtencion() {
        AtencionDao dao = new AtencionDao();
        personal.setIdPersonal(idPersonal);
        tipoatencion.setIdTipoAtencion(idTipoAtencion);
        mascotaporclienteid.setClienteIdcliente(idcliente);
        mascotaporclienteid.setMascotaIdMascota(idMascota);
        mascotaporcliente.setId(mascotaporclienteid);
        atencion.setPersonal(personal);
        atencion.setTipoatencion(tipoatencion);
        atencion.setMascotaporcliente(mascotaporcliente);

        boolean respuesta = dao.guardarAtencion(atencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroAtencion";

    }

    public String actualizarAtencion() {
        try {
            AtencionDao dao = new AtencionDao();
            boolean resp = dao.ActualizarAtencion(atencion);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            dao.ActualizarAtencion(atencion);
        } catch (Exception e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroAtencion";
    }

    public ArrayList<Atencion> listarAtencion() {
        ArrayList<Atencion> milista = new ArrayList<>();
        AtencionDao dao = new AtencionDao();
        milista = dao.listarAtencion();
        return milista;

    }

    public String limpiar() {
        banderaSelect = false;
        return "/RegistroAtencion.xhtml";
    }

    public String eliminar(Atencion data) {
        AtencionDao madao = new AtencionDao();
        boolean respuesta = madao.eliminarAtencion(data);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }

        return "/RegistroAtencion.xhtml";
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

    public Atencion getAtencion() {
        return atencion;
    }

    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Tipoatencion getTipoatencion() {
        return tipoatencion;
    }

    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }

    public ArrayList getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public ArrayList getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public ArrayList getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList getListaTipatencion() {
        return listaTipatencion;
    }

    public void setListaTipatencion(ArrayList listaTipatencion) {
        this.listaTipatencion = listaTipatencion;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdTipoAtencion() {
        return idTipoAtencion;
    }

    public void setIdTipoAtencion(int idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
    }

    public Mascotaporcliente getMascotaporcliente() {
        return mascotaporcliente;
    }

    public void setMascotaporcliente(Mascotaporcliente mascotaporcliente) {
        this.mascotaporcliente = mascotaporcliente;
    }

}

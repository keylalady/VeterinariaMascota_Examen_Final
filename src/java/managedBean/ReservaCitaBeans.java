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
import Dao.ReservaCitaDao;
import Dao.TipoAtencionDao;
import Dao.TipoReservaDao;
import Dao.UsuarioDao;
import entidades.Atencion;
import entidades.Cliente;
import entidades.Reservacita;
import entidades.Tiporeserva;
import entidades.Usuario;
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
public class ReservaCitaBeans {

    private boolean banderaSelect = false;

    private Reservacita reservacita;
    private Usuario usuario;
    private Cliente cliente;
    private Tiporeserva tiporeserva;
    
    private ArrayList listaTipoReserva;
    private ArrayList listaUsuario;
    private ArrayList listaClientes;

    private int idTiporeserva;
    private int idcliente;
    private int idUsuario;

    //Constructor
    public ReservaCitaBeans() {
        this.reservacita = new Reservacita();
        listaTipoReserva = new ArrayList();
        listaUsuario = new ArrayList();
        listaClientes = new ArrayList();
        usuario = new Usuario();
        cliente = new Cliente();
        tiporeserva= new Tiporeserva();
        listarCombox();

    }

    public void listarCombox() {

        TipoReservaDao tiporeservadao = new TipoReservaDao();
        UsuarioDao usuariodao = new UsuarioDao();
        ClienteDao clientedao = new ClienteDao();
        listaTipoReserva = tiporeservadao.listarTiporeserva();
        listaUsuario = usuariodao.listarUsuario();
        listaClientes = clientedao.listarCliente();
    }

    public String guardarReservaCita() {
        ReservaCitaDao dao = new ReservaCitaDao();
        usuario.setIdUsuario(idUsuario);
        cliente.setIdcliente(idcliente);
        tiporeserva.setIdTipoReserva(idTiporeserva);
       
        reservacita.setUsuario(usuario);
        reservacita.setTiporeserva(tiporeserva);
        reservacita.setCliente(cliente);

        boolean respuesta = dao.guardarReservacita(reservacita);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroReservaCita";

    }

    public String actualizarReservaCita() {
        try {
            ReservaCitaDao dao = new ReservaCitaDao();
            boolean resp = dao.ActualizarReservacita(reservacita);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            dao.ActualizarReservacita(reservacita);
        } catch (Exception e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroReservaCita";
    }

    public ArrayList<Reservacita> listarReservaCita() {
        ArrayList<Reservacita> milista = new ArrayList<>();
        ReservaCitaDao dao = new ReservaCitaDao();
        milista = dao.listarReservacita();
        return milista;

    }
    public String limpiar() {
        banderaSelect=false;
        return "/RegistroReservaCita.xhtml";
    }
      public String eliminar(Reservacita data) {
        ReservaCitaDao madao = new ReservaCitaDao();
        boolean respuesta = madao.eliminarReservacita(data);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }

        return "/RegistroReservaCita.xhtml";
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

    public Reservacita getReservacita() {
        return reservacita;
    }

    public void setReservacita(Reservacita reservacita) {
        this.reservacita = reservacita;
    }

    public ArrayList getListaTipoReserva() {
        return listaTipoReserva;
    }

    public void setListaTipoReserva(ArrayList listaTipoReserva) {
        this.listaTipoReserva = listaTipoReserva;
    }

    public ArrayList getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public ArrayList getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }

    public int getIdTiporeserva() {
        return idTiporeserva;
    }

    public void setIdTiporeserva(int idTiporeserva) {
        this.idTiporeserva = idTiporeserva;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    

}

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
import Dao.UsuarioDao;
import entidades.Atencion;
import entidades.Cliente;
import entidades.Personal;
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
public class UsuarioBeans {

    private boolean banderaSelect = false;

    private Usuario usuario;
    private Cliente cliente;
    private Personal personal;
    private ArrayList listaPersonal;
    private ArrayList listaClientes;

    private int idPersonal;
    private int idcliente;

    //Constructor
    public UsuarioBeans() {
        usuario = new Usuario();
        listaPersonal = new ArrayList();
        listaClientes = new ArrayList();
        personal= new Personal();
        cliente = new Cliente();
        listarCombox();

    }

    public void listarCombox() {
       
        PersonalDao personaldao = new PersonalDao();
        ClienteDao clientedao = new ClienteDao();
        listaPersonal = personaldao.listarPersonal();
        listaClientes = clientedao.listarCliente();
         
    }

    public String guardarUsuario() {
        UsuarioDao dao = new UsuarioDao();
        personal.setIdPersonal(idPersonal);
        cliente.setIdcliente(idcliente);
        
        usuario.setPersonal(personal);
        usuario.setCliente(cliente);
        
     

        boolean respuesta = dao.guardarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroUsuario";

    }

    public String actualizarUsuario() {
        try {
            UsuarioDao dao = new UsuarioDao();
            boolean resp = dao.ActualizarUsuario(usuario);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            dao.ActualizarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroUsuario";
    }

    public ArrayList<Usuario> listarUsuario() {
        ArrayList<Usuario> milista = new ArrayList<>();
        UsuarioDao dao = new UsuarioDao();
        milista = dao.listarUsuario();
        return milista;

    }
    public String limpiar() {
        banderaSelect=false;
        return "/RegistroUsuario.xhtml";
    }
      public String eliminar(Usuario usuario) {
        UsuarioDao madao = new UsuarioDao();
        boolean respuesta = madao.eliminarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }

        return "/RegistroUsuario.xhtml";
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public ArrayList getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }


}

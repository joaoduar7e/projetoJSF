/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Estado;
import facade.EstadoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Joao Duarte
 */

@ManagedBean
@SessionScoped
public class EstadoControle implements Serializable{

    private Estado estado;
    @EJB
    private EstadoFacade estadoFacade;

    public void novo(){
        estado = new Estado();
    }
    
    public void salvar() {
        if (estado.getSigla().length() != 2) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "A sigla deve conter 2 caracteres!",
                            null));
        } else {
            estadoFacade.salvar(estado);
        }
    }
    
    public void editar(Estado est){
        estado = est;
    }

    public void remover(Estado est) {
        estadoFacade.remover(est);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getListaEstados() {
        return estadoFacade.listaTodos();
    }

}

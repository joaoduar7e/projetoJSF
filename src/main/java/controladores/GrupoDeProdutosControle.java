/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.GrupoDeProdutos;
import entidades.GrupoDeProdutos;
import facade.GrupoDeProdutosFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author joao
 */

@ManagedBean
@SessionScoped
public class GrupoDeProdutosControle implements Serializable{

    private GrupoDeProdutos grupodeprodutos = new GrupoDeProdutos();
    @EJB
    private GrupoDeProdutosFacade GrupoDeProdutosFacade;

    public void novo(){
        grupodeprodutos = new GrupoDeProdutos();
    }
    
    public void salvar() {
      GrupoDeProdutosFacade.salvar(grupodeprodutos);
        }
    
    
    public void editar(GrupoDeProdutos grupoprod){
        grupodeprodutos = grupoprod;
    }

    public void remover(GrupoDeProdutos grupoprod) {
        GrupoDeProdutosFacade.remover(grupoprod);
    }

    public GrupoDeProdutos getGrupoDeProdutos() {
        return grupodeprodutos;
    }

    public void setGrupoDeProdutos(GrupoDeProdutos GrupoDeProdutos) {
        this.grupodeprodutos = GrupoDeProdutos;
    }

    public List<GrupoDeProdutos> getListaGrupoDeProdutos() {
        return GrupoDeProdutosFacade.listaTodos();
    }

}

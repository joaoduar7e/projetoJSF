/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import converter.ConverterGenerico;
import entidades.GrupoDeProdutos;
import entidades.Produto;
import facade.ProdutoFacade;
import facade.GrupoDeProdutosFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jaimedias
 */
@ManagedBean
@SessionScoped
public class ProdutoControle implements Serializable{

    private Produto produto;
    @EJB
    private ProdutoFacade produtoFacade;
    @EJB
    private GrupoDeProdutosFacade grupoDeProdutosFacade;
    private ConverterGenerico grupoDeProdutosConverter;

    public ConverterGenerico getGrupoDeProdutosConverter() {
        if(grupoDeProdutosConverter == null){
            grupoDeProdutosConverter = new ConverterGenerico(grupoDeProdutosFacade);
        }
        return grupoDeProdutosConverter;
    }

    public void setGrupoDeProdutosConverter(ConverterGenerico grupoDeProdutosConverter) {
        this.grupoDeProdutosConverter = grupoDeProdutosConverter;
    }
    
    public List<GrupoDeProdutos> getListaGrupoDeProdutos(){
        return grupoDeProdutosFacade.listaTodos();
    }
    
    public void novo() {
        produto = new Produto();
    }

    public void salvar() {
        produtoFacade.salvar(produto);
    }

    public void editar(Produto prod) {
        produto = prod;
    }

    public void remover(Produto prod) {
        produtoFacade.remover(prod);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListaProdutos() {
        return produtoFacade.listaTodos();
    }

}

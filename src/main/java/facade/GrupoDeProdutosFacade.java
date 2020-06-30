/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;


import entidades.GrupoDeProdutos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Joao Duarte
 */

    @Stateless
    public class GrupoDeProdutosFacade extends AbstractFacade<GrupoDeProdutos> {

    @PersistenceContext(unitName = "alucadastroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoDeProdutosFacade() {
        super(GrupoDeProdutos.class);
    }
    
}

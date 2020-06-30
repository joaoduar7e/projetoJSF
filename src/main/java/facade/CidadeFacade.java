/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Aluno;
import entidades.Cidade;
import entidades.Estado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Joao Duarte
 */
@Stateless
public class CidadeFacade extends AbstractFacade<Cidade> {

    @PersistenceContext(unitName = "alucadastroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CidadeFacade() {
        super(Cidade.class);
    }
        public List<Cidade> listaCidadeFiltrando(String filtro) {
        Query q = getEntityManager().createQuery("from Cidade where nome like :parametro");
        q.setParameter("parametro", "%"+filtro+"%");
        return q.getResultList();
    }
    
}

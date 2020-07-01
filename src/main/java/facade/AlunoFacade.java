/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Aluno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DELL
 */
@Stateless
public class AlunoFacade extends AbstractFacade<Aluno>{
    @PersistenceContext(unitName = "alucadastroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlunoFacade() {
        super(Aluno.class);
    }
    
        public List<Aluno> listaPessoaFiltrando(String filtro) {
        Query q = getEntityManager().createQuery("from Pessoa where nome like :parametro");
        q.setParameter("parametro", "%"+filtro+"%");
        return q.getResultList();
    }

}




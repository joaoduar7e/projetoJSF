/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Aluno;
import facade.AlunoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class AlunoControle {
    
    private Aluno aluno = new Aluno();
    @EJB
    private AlunoFacade alunoFacade;
    
    public void novo(){
    aluno = new Aluno();
    }

    public List<Aluno> getListaAlunos(){
        return alunoFacade.listaTodos();
    }
    
    public Aluno getAluno(){
    return aluno;    
    
    }
    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }
    
    public void editar(Aluno alu){
    aluno = alu;
    }

    public void excluir(Aluno alu){
    alunoFacade.remover(alu);
    }


    public void salvar(){
      alunoFacade.salvar(aluno);
      aluno = new Aluno();
}
}

//
//    public String salvar() {
//        if (aluno.getRa().length() != 9) {
//            FacesContext.getCurrentInstance().addMessage(
//                    null, new FacesMessage(
//                            FacesMessage.SEVERITY_ERROR,
//                            "O Telefone deve conter 9 caracteres!",
//                            null));
//            return  "alunoedita";
//        } else {
//            alunoFacade.salvar(aluno);
//            aluno = new Aluno();
//            return "alunolista";
//        }

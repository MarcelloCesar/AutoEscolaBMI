/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoescolabmi;

import model.Aluno;
import model.Veiculo;
import model.Instrutor;
import java.util.List;
import java.util.LinkedList;

/*
 *
 * @author Gideon
 */
public class BaseDados {
    private List<Aluno> lstAlunos;    
    private List<Veiculo> lstVeiculos;
    private List<Instrutor> lstInstrutor;
    
    public BaseDados(){
        this.lstAlunos    = new LinkedList<>();
        this.lstAlunos    = org.jdesktop.observablecollections.ObservableCollections.observableList(this.lstAlunos);
        this.lstVeiculos  = new LinkedList<>();
        this.lstVeiculos  = org.jdesktop.observablecollections.ObservableCollections.observableList(this.lstVeiculos);
        this.lstInstrutor = new LinkedList<>();
        this.lstInstrutor = org.jdesktop.observablecollections.ObservableCollections.observableList(this.lstInstrutor);
    }    
    
    public boolean addAluno(Aluno aluno){
        return this.lstAlunos.add(aluno);
    }
    
    public List<Aluno> getListaAlunos(){
        return this.lstAlunos;
    }
    
    public boolean addVeiculo(Veiculo veiculo){
        return this.lstVeiculos.add(veiculo);
    }
    
    public List<Veiculo> getListaVeiculos(){
        return this.lstVeiculos;
    }
    
    public boolean addInstrutor(Instrutor instrutor){
        return this.lstInstrutor.add(instrutor);
    } 
    
    public List<Instrutor> getListaInstrutores(){
        return this.lstInstrutor;
    }
}

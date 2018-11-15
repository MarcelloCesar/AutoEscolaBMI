/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoescolabmi;

/**
 *
 * @author Gideon
 */
public class AreaDeTrabalho extends javax.swing.JDesktopPane{
    private CadastroVeiculo   cadastroVeiculo;
    private CadastroAluno     cadastroAluno;
    private CadastroInstrutor cadastroInstrutor;
    private ListagemAluno     listagemAluno;
    private ListagemInstrutor listagemInstrutor;    
    private ListagemVeiculo   listagemVeiculo;

    
    public void abrirCadastroVeiculo(){
        if(this.cadastroVeiculo == null){
            this.cadastroVeiculo = new CadastroVeiculo(this);
            this.add(cadastroVeiculo);
            this.cadastroVeiculo.setVisible(true);
        }
    }
    
    public void fecharCadastroVeiculo(){
        this.cadastroVeiculo = null;
    }
    
    public void abrirListagemVeiculo(){
        if(this.listagemVeiculo == null){
            this.listagemVeiculo = new ListagemVeiculo(this);
            this.add(listagemVeiculo);
            this.listagemVeiculo.setVisible(true);
        }
    }
    
    public void fecharListagemVeiculo(){
        this.listagemVeiculo = null;
    }
    
    public CadastroVeiculo getCadastroVeiculo(){
        return this.cadastroVeiculo;
    }
    
    public void abrirCadastroAluno(){
        if(this.cadastroAluno == null){
            this.cadastroAluno = new CadastroAluno(this);
            this.add(cadastroAluno);
            this.cadastroAluno.setVisible(true);
        }
    }
    
    public void fecharCadastroAluno(){
        this.cadastroAluno = null;
    }
    
    public void abrirListagemAluno(){
        if(this.listagemAluno == null){
            this.listagemAluno = new ListagemAluno(this);
            this.add(listagemAluno);
            this.listagemAluno.setVisible(true);
        }
    }
    
    public void fecharListagemAluno(){
        this.listagemAluno = null;
    }
    
    public CadastroAluno getCadastroAluno(){
        return this.cadastroAluno;
    } 
        
    public void abrirCadastroInstrutor(){
        if(this.cadastroInstrutor == null){
            this.cadastroInstrutor = new CadastroInstrutor(this);
            this.add(cadastroInstrutor);
            this.cadastroInstrutor.setVisible(true);
        }
    }    
    
    public CadastroInstrutor getCadastroInstrutor(){
        return this.cadastroInstrutor;
    } 
    
    public void fecharCadastroInstrutor(){
        this.cadastroInstrutor = null;
    }
    
    public void abrirListagemInstrutor(){
        if(this.listagemInstrutor == null){
            this.listagemInstrutor = new ListagemInstrutor(this);
            this.add(listagemInstrutor);
            this.listagemInstrutor.setVisible(true);
        }
    }
    
    public void fecharListagemInstrutor(){
        this.listagemInstrutor = null;
    }
}

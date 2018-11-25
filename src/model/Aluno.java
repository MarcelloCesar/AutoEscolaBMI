/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;

/**
 *
 * @author Marcello
 */
public class Aluno {
   private Pessoa ator;
   private String codMatricula;
   private String codCategoria;
   private Date dataMatricula;

    public Aluno(){
        this.ator = new Pessoa();
    }
    
    public int getIdAtor() {
        return ator.getIdAtor();
    }
    
    public Pessoa getAtor(){
        return this.ator;
    }

    public void setAtor(Pessoa ator) {
        this.ator = ator;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import Exceptions.AppException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Marcello
 */
public class Aluno extends Pessoa {
   private String codMatricula;
   private String codCategoria;
   private Date dataMatricula;
   
   public Aluno(){
       
   }
   
   public Aluno(ResultSet rs){
       this.setAlunoFromResultSet(rs);
   }
   
   public void setAlunoFromResultSet(ResultSet rs){
       try{
        try{codMatricula  = rs.getString("CODIGOMATRICULA");} catch(SQLException e){}
        try{codCategoria  = rs.getString("CODCATEGORIA");} catch(SQLException e){}
        try{dataMatricula = rs.getDate("DATAMATRICULA");} catch(SQLException e){}
       } catch (Exception e ){
           new AppException().saveLog(this.getClass().toString() +" "+  e.getMessage());
       }
   }
   
    public Aluno (Pessoa p){
        super(p);
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

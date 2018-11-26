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
public class Pessoa {
    private Integer idAtor;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataInclusao;
    private Date dataNascimento;
        
    protected Pessoa(Pessoa p){
        idAtor = p.getIdAtor();
        nome   = p.getNome();
        cpf    = p.getCpf();
        rg     = p.getRg();
        dataInclusao   = p.getDataInclusao();
        dataNascimento = p.getDataNascimento();
    }
    
    public Pessoa(ResultSet rs){
        this.setPessoaFromResultSet(rs);
    }
    
    public void setPessoaFromResultSet(ResultSet rs){
        try{
            try{idAtor = rs.getInt("IDATOR");} catch(SQLException e){}
            try{nome   = rs.getString("NOME");} catch(SQLException e){}
            try{cpf    = rs.getString("CPF");} catch(SQLException e){}
            try{rg     = rs.getString("RG");} catch(SQLException e){}
            try{dataInclusao   = rs.getDate("DATAINCLUSAO");} catch(SQLException e){}
            try{dataNascimento = rs.getDate("DATANASCIMENTO");} catch(SQLException e){}
        } catch (Exception e){
            new AppException().saveLog(this.getClass().toString() +" "+  e.getMessage());
        }
    }
    
    public Pessoa(){
        this.idAtor = null;
    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(Integer idAtor) {
        this.idAtor = idAtor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }    
}

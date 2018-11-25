/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.query;

import Exceptions.SelectQueryException;
import autoescolabmi.AutoEscolaBmi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Marcello
 */
public class SelectQuery extends Query{
    private final String clausulaSelect;
    private LinkedList<String> campos;
    private LinkedList<String> camposWhere;
    private LinkedList<String> valuesWhere;
    
    private SelectQuery(Connection conn){
        this.connection     = conn;
        this.clausulaSelect = "SELECT ";
        this.campos         = new LinkedList<>();
        this.camposWhere    = new LinkedList<>();
        this.valuesWhere    = new LinkedList<>();
    }
    
    public SelectQuery(Connection conn, String tabela){
        this(conn);
        this.nomeTabela = tabela;       
    }
    
    public void addCampo(String campo){
        this.campos.add(campo);
    }
    
    public void setCampos(LinkedList<String> campos){
        this.campos = campos;
    }
    
    public void addCampoWhere(String campo, String value){
        this.camposWhere.add(campo);
        this.valuesWhere.add(value);
    }
    
    private String getCamposTabela(){
        String camposTabela;
        if(this.campos.size() <= 0){
            camposTabela = " * ";
        } else {
            camposTabela = this.campos.get(0);        
            if(this.campos.size() > 1){
                for(int i=1; i<campos.size(); i++){
                    camposTabela += ", " + this.campos.get(i);
                }
            } 
        }
        
        return camposTabela;
    }
    
    private String getCamposWhereTabela() throws SelectQueryException{
        if (this.valuesWhere.size() != this.camposWhere.size()){
            throw new SelectQueryException(SelectQueryException.QUANTIDADE_CAMPOS_WHERE_VALORES);
        }
        
        String camposTabela = "";
        if(this.camposWhere.size() > 0){
            camposTabela = " WHERE " + this.camposWhere.get(0) + " = ?";        
            if(this.camposWhere.size() > 1){
                for(int i=1; i<camposWhere.size(); i++){
                    camposTabela += " AND " + this.camposWhere.get(i) + " = ?";
                }
            }
        } 
        
        return camposTabela;
    }
    
    private PreparedStatement prepare(String query) throws SelectQueryException{    
        PreparedStatement stmt;
        try{
            stmt = this.prepareStatement(connection, query);
            
            if(this.valuesWhere.size() > 0){
                for(int i=0; i<valuesWhere.size(); i++){
                    stmt.setString(i+1, this.valuesWhere.get(i));
                }
            }
        } catch(SQLException exc){
            throw new SelectQueryException(SelectQueryException.ERRO_PREPARAR_QUERY);
        }        
        return stmt;
    }
    
    @Override
    public PreparedStatement getStatement() throws SelectQueryException{
        if(this.nomeTabela.equals("")){
            throw new SelectQueryException(SelectQueryException.TABELA_NAO_INFORMADA);
        }  
        
        String clausula          = this.clausulaSelect;
        String camposTabela      = this.getCamposTabela();
        String camposTabelaWhere = this.getCamposWhereTabela();
        this.query = clausula + camposTabela + " FROM " + this.nomeTabela + camposTabelaWhere;
        
        return this.prepare(this.query);
    }       
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.query;

import Exceptions.UpdateQueryException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Marcello
 */
public class UpdateQuery extends Query{
    private final String clausulaUpdate;
    private LinkedList<String> campos;
    private LinkedList<String> values;
    private LinkedList<String> camposWhere;
    private LinkedList<String> valuesWhere;

    private UpdateQuery(Connection conn){
        this.connection     = conn;
        this.clausulaUpdate = "UPDATE ";
        this.campos         = new LinkedList<>();
        this.valuesWhere    = new LinkedList<>();
        this.camposWhere    = new LinkedList<>();
        this.values         = new LinkedList<>();
    }
    
    public UpdateQuery(Connection conn, String tabela){
        this(conn);
        this.nomeTabela = tabela;
    }
    
    public void addValue(String campo, String valor){
        this.campos.add(campo);
        this.values.add(valor);
    }
    
    public void addWhere(String campo, String valor){
        this.camposWhere.add(campo);
        this.valuesWhere.add(valor);
    }
    
    private String getCamposTabela() throws UpdateQueryException{
        if(this.campos.size() <= 0){
            throw new UpdateQueryException(UpdateQueryException.CAMPOS_NAO_INFORMADOS);
        } else if (this.values.size() != this.campos.size()){
            throw new UpdateQueryException(UpdateQueryException.QUANTIDADE_CAMPOS_VALORES);
        }
        String camposTabela = " SET " + this.campos.get(0) + " = ?";        
        if(this.campos.size() > 1){
            for(int i=1; i<campos.size(); i++){
                camposTabela += ", " + this.campos.get(i) + " = ?";
            }
        } 
        
        return camposTabela;
    }
    
    private String getCamposWhereTabela() throws UpdateQueryException{
        if (this.valuesWhere.size() != this.camposWhere.size()){
            throw new UpdateQueryException(UpdateQueryException.QUANTIDADE_CAMPOS_WHERE_VALORES);
        }
        String camposTabela = "";
        if(this.camposWhere.size() > 0){
            camposTabela = " WHERE " + this.campos.get(0) + " = ?";        
            if(this.camposWhere.size() > 1){
                for(int i=1; i<camposWhere.size(); i++){
                    camposTabela += " AND " + this.camposWhere.get(i) + " = ?";
                }
            }
        } 
        
        return camposTabela;
    }
    
    private PreparedStatement prepare(String query) throws UpdateQueryException{    
        PreparedStatement stmt;
        int cont = 1;
        try{
            stmt = this.prepareStatement(connection, query);
            
            stmt.setString(cont, this.values.get(0));            
            if(this.values.size() > 1){
                for(int i=1; i<values.size(); i++, cont++){
                    stmt.setString(cont+1, this.values.get(i));
                }
            }    
            
            if(this.valuesWhere.size() > 0){
                for(int i=0; i<valuesWhere.size(); i++, cont++){
                    stmt.setString(cont+1, this.valuesWhere.get(i));
                }
            }
        } catch(SQLException exc){
            throw new UpdateQueryException(UpdateQueryException.ERRO_PREPARAR_QUERY, exc.getMessage());
        }        
        return stmt;
    }
    
    @Override
    public PreparedStatement getStatement() throws UpdateQueryException{
        if(this.nomeTabela.equals("")){
            throw new UpdateQueryException(UpdateQueryException.TABELA_NAO_INFORMADA);
        }  
        
        String clausula          = this.clausulaUpdate + this.nomeTabela;
        String camposTabela      = this.getCamposTabela();
        String camposTabelaWhere = this.getCamposWhereTabela();
        this.query = clausula + camposTabela + camposTabelaWhere;
        
        return this.prepare(this.query);
    }       
}


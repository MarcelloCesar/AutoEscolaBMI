/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.query;

import Exceptions.InsertQueryException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcello
 */
public class InsertQuery extends Query {
    private final String clausulaInsert;
    private LinkedList<String> campos;
    private LinkedList<String> values;
    
    private InsertQuery(Connection conn){
        this.connection = conn;
        this.clausulaInsert = "INSERT INTO ";
        this.campos = new LinkedList<>();
        this.values = new LinkedList<>();
    }
    
    public InsertQuery(Connection conn, String tabela){
        this(conn);
        this.nomeTabela = tabela;
    }
    
    public void addValue(String campo, String valor){
        this.campos.add(campo);
        this.values.add(valor);
    }
    
    private String getCamposTabela() throws InsertQueryException{
        if(this.campos.size() <= 0){
            throw new InsertQueryException(InsertQueryException.CAMPOS_NAO_INFORMADOS);
        }
        String camposTabela = "(" + this.campos.get(0);        
        if(this.campos.size() > 1){
            for(int i=1; i<campos.size(); i++){
                camposTabela += ", " + this.campos.get(i);
            }
        }
        camposTabela += ") ";   
        
        return camposTabela;
    }
    
    private String getValoresTabela() throws InsertQueryException{
        if(this.values.size() <= 0){
            throw new InsertQueryException(InsertQueryException.VALORES_NAO_INFORMADOS);
        } else if (this.values.size() != this.campos.size()){
            throw new InsertQueryException(InsertQueryException.QUANTIDADE_CAMPOS_VALORES);
        }
        String valoresTabela = " VALUES (?";
        if(this.values.size() > 1){
            for(int i=1; i<campos.size(); i++){
                valoresTabela += ", ?";
            }
        }
        valoresTabela += ");";
        
        return valoresTabela;
    }
    
    private PreparedStatement prepare(String query) throws InsertQueryException{    
        PreparedStatement stmt;
        try{
            stmt = this.prepareStatement(connection, query);
            
            stmt.setString(1, this.values.get(0));            
            if(this.values.size() > 1){
                for(int i=1; i<values.size(); i++){
                    stmt.setString(i+1, this.values.get(i));
                }
            }                       
        } catch(SQLException exc){
            throw new InsertQueryException(InsertQueryException.ERRO_PREPARAR_QUERY, exc.getMessage());
        }        
        return stmt;
    }
    
    @Override
    public PreparedStatement getStatement() throws InsertQueryException{
        if(this.nomeTabela.equals("")){
            throw new InsertQueryException(InsertQueryException.TABELA_NAO_INFORMADA);
        }        
        String clausula      = this.clausulaInsert + this.nomeTabela;        
        String camposTabela  = this.getCamposTabela();
        String valoresTabela = this.getValoresTabela();
        this.query = clausula + camposTabela + valoresTabela + this.extraQuery;
        
        return this.prepare(this.query);
    }
}

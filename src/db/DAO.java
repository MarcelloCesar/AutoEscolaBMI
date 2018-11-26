/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<E> {

    public abstract boolean inserir(E e) throws Exception;
    public abstract boolean alterar(E e) throws Exception;
    public abstract boolean excluir(E e) throws Exception;    
    //public abstract E find(E e) throws Exception;
    public abstract List<E> listar();
    
    protected Connection conn; 
    protected String tabelaBanco;
    
    public DAO() throws Exception{
        String url = "jdbc:mysql://127.0.0.1:3307/autoescolabmi";
        String user = "root";
        String password = "usbw";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user, password);
            conn.setTransactionIsolation(conn.TRANSACTION_READ_UNCOMMITTED);
        }catch(SQLException e){
            throw new Exception("Erro ao conectar ao banco de dados: " + e.getMessage());
        }catch(ClassNotFoundException e){
            throw new Exception("Erro ao carregar driver do banco de dados");
        }
    }
    
    public void disableAutoCommit() throws SQLException{        
        this.conn.setAutoCommit(false);        
    }
    
    public void commitWork() throws SQLException{
        this.conn.commit();
    }
    
    public void rollBackTransaction() throws SQLException{
        this.conn.rollback();
    }
}

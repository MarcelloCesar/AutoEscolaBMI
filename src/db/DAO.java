/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<E> {

    public abstract boolean inserir(E e) throws Exception;
    public abstract boolean alterar(E e) throws Exception;
    public abstract boolean excluir(E e) throws Exception;
    //public abstract E find(E e) throws Exception;
    public abstract List<E> listar();
    
    protected Connection conn; 
    
    public DAO() throws Exception{
        String url = "jdbc:mysql://localhost:3307/autoescolabmi";
        String user = "root";
        String password = "usbw";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user, password);
        }catch(SQLException e){
            throw new Exception("Erro ao conectar ao banco de dados: " + e.getMessage());
        }catch(ClassNotFoundException e){
            throw new Exception("Erro ao carregar driver do banco de dados");
        }
    }
    
    protected boolean executeUpdate(PreparedStatement stmt) throws Exception{
        try{
            stmt.executeUpdate();
        } catch (SQLException exc){
            
        }
        return false;
    }
    
    
}

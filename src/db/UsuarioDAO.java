/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO extends DAO<Usuario> {
    
    public UsuarioDAO() throws Exception{
        super();
        this.tabelaBanco = "ACESSO";
    }
    
    @Override
    public boolean inserir(Usuario e) throws Exception{
        String sql = " "+
                     " INSERT INTO ACESSO (IDATOR, LOGIN, SENHA, HORARIOINICIO, HORARIOFIM, DATAINICIO, DATAFIM) " +
                     " VALUES ( ?, ?, ?, ?, ?, ?, ?)";
                
        PreparedStatement stmt = conn.prepareStatement(sql,
                                        Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, e.getId());
        stmt.setString(2, e.getLogin());
        stmt.setString(3, e.getSenha());
        stmt.setTime(4, e.getHorarioInicio());
        stmt.setTime(5, e.getHorarioFim());
        stmt.setDate(6, new java.sql.Date(e.getDataInicio().getTime()));
        stmt.setDate(7, new java.sql.Date(e.getDataFim().getTime()));            
        stmt.executeUpdate();
        
        return true;
    }   
    
    @Override
    public boolean alterar(Usuario e) throws Exception{
        String sql = " "+
                     " UPDATE ACESSO ACESSO (IDATOR, LOGIN, SENHA, HORARIOINICIO, HORARIOFIM, DATAINICIO, DATAFIM) " +
                     " UPDATE ACESSO          " +
                     " SET LOGIN         = ?, " + 
                     "     SENHA         = ?, " + 
                     "     HORARIOINICIO = ?, " + 
                     "     HORARIOFIM    = ?, " + 
                     "     DATAINICIO    = ?, " + 
                     "     DATAFIM       = ?  " + 
                     " WHERE IDATOR      = ?  " ;               
                
        

        PreparedStatement stmt = conn.prepareStatement(sql,
                                        Statement.RETURN_GENERATED_KEYS);


        stmt.setString(1, e.getLogin());
        stmt.setString(2, e.getSenha());
        stmt.setTime(3, e.getHorarioInicio());
        stmt.setTime(4, e.getHorarioFim());
        stmt.setDate(5, new java.sql.Date(e.getDataInicio().getTime()));
        stmt.setDate(6, new java.sql.Date(e.getDataFim().getTime()));            
        stmt.setInt(7, e.getId());
        stmt.executeUpdate();
        return true;
    }
    
    @Override 
    public boolean excluir(Usuario e) throws Exception{
        String sql = " "+
                     " DELETE FROM ACESSO " + 
                     " WHERE IDATOR = ?";
        

        PreparedStatement stmt = conn.prepareStatement(sql,
                                        Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, e.getId());
        stmt.executeUpdate();

        return true;
    }
    
    @Override 
    public List<Usuario> listar(){
        return null;
    }  
    
    public Usuario procurarLogin(String login) throws Exception{
        String sql = " "
                + " SELECT IDATOR, "
                + "        LOGIN, "
                + "        SENHA, "
                + "        HORARIOINICIO, "
                + "        HORARIOFIM, "
                + "        DATAINICIO, "
                + "        DATAFIM "                
                + " FROM ACESSO "
                + " WHERE ACESSO.LOGIN = ? ";
        
        
        Usuario usuario = null;
        PreparedStatement stmt   = conn.prepareStatement(sql);
        stmt.setString(1, login);
        ResultSet result = stmt.executeQuery();      
        
        
        result.last();
        if(result.getRow() > 1){
            throw new Exception ("Encontradas inconsistências na unicidade do login");
        }
        
        result.first();
        if(result.getRow() == 1){
            usuario = new Usuario();
            usuario.setId(result.getInt("IDATOR"));
            usuario.setDataFim(result.getDate("DATAFIM"));
            usuario.setDataInicio(result.getDate("DATAINICIO"));
            usuario.setLogin(result.getString("LOGIN"));
            usuario.setSenha(result.getString("SENHA"));
            usuario.setHorarioFim(result.getTime("HORARIOFIM"));
            usuario.setHorarioInicio(result.getTime("HORARIOINICIO"));           
        }
        return usuario;        
    }   
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.query.InsertQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Log;

/**
 *
 * @author Marcello
 */
public class LogDAO extends DAO<Log>{

    public LogDAO() throws Exception{
        super();
        this.tabelaBanco = "LOG";
    }
    
    @Override
    public boolean inserir(Log e) throws Exception {
        InsertQuery insert = new InsertQuery(this.conn, this.tabelaBanco);
        insert.addValue("MENSAGEM", e.getMensagem());
        insert.execute();
        e.setNumero(insert.getGeneratedId());
        
        return true;
    }

    @Override
    public boolean alterar(Log e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Log e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Log> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

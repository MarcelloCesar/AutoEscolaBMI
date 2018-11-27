/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.query.InsertQuery;
import db.query.SelectQuery;
import db.query.UpdateQuery;
import java.sql.ResultSet;
import java.util.List;
import model.Email;

/**
 *
 * @author Marcello
 */
public class EmailDAO extends DAO<Email>{

    public EmailDAO() throws Exception{
        this.tabelaBanco = "EMAIL";
    }
    
    @Override
    public boolean inserir(Email e) throws Exception {
        InsertQuery insert = new InsertQuery(this.conn, this.tabelaBanco);
        insert.addValue("IDATOR", String.valueOf(e.getIdAtor()));
        insert.addValue("PRIORIDADEEMAIL", String.valueOf(e.getPrioridade()));
        insert.addValue("EMAILATIVO",e.getAtivo());
        insert.addValue("EMAIL", e.getEmail());
        
        return insert.execute(); 
    }

    @Override
    public boolean alterar(Email e) throws Exception {
        UpdateQuery update = new UpdateQuery(this.conn, this.tabelaBanco);
        update.addValue("EMAILATIVO", String.valueOf(e.getAtivo()));
        update.addValue("EMAIL", e.getEmail());
        update.addWhere("IDATOR", String.valueOf(e.getIdAtor()));
        update.addWhere("PRIORIDADEEMAIL", String.valueOf(e.getPrioridade()));
        return update.execute();
    }

    public int buscaUltimaPrioridade() throws Exception{
        SelectQuery select = new SelectQuery(this.conn, this.tabelaBanco);
        select.addCampo("COALESCE(MAX(PRIORIDADEEMAIL), 0) + 1");
        
        ResultSet result = select.executeQuery();
        result.next();
        return result.getInt(1);        
    }
    
    public int desativarEmail(int idAtor) throws Exception{
        UpdateQuery update = new UpdateQuery (this.conn, this.tabelaBanco);
        update.addValue("EMAILATIVO", "F");
        update.addWhere("IDATOR", String.valueOf(idAtor));
        return update.executeUpdate();
    }

    @Override
    public boolean excluir(Email e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Email> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

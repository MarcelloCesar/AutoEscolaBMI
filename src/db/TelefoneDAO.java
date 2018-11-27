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
import model.Telefone;

/**
 *
 * @author Marcllo
 */
public class TelefoneDAO extends DAO<Telefone>{

    public TelefoneDAO() throws Exception{
        this.tabelaBanco = "TELEFONE";
    };
    
    @Override
    public boolean inserir(Telefone e) throws Exception {
        InsertQuery insert = new InsertQuery(this.conn, this.tabelaBanco);
        insert.addValue("IDATOR", String.valueOf(e.getIdAtor()));
        insert.addValue("PRIORIDADETELEFONE", String.valueOf(e.getPrioridade()));
        insert.addValue("TELEFONEATIVO",e.getAtivo());
        insert.addValue("NUMERO", e.getNumero());
        
        return insert.execute();        
    }

    @Override
    public boolean alterar(Telefone e) throws Exception {
        UpdateQuery update = new UpdateQuery(this.conn, this.tabelaBanco);
        update.addValue("TELEFONEATIVO", String.valueOf(e.getAtivo()));
        update.addValue("NUMERO", e.getNumero());
        update.addWhere("IDATOR", String.valueOf(e.getIdAtor()));
        update.addWhere("PRIORIDADETELEFONE", String.valueOf(e.getPrioridade()));
        return update.execute();
    }

    @Override
    public boolean excluir(Telefone e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Telefone> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int buscaUltimaPrioridade() throws Exception{
        SelectQuery select = new SelectQuery(this.conn, this.tabelaBanco);
        select.addCampo("COALESCE(MAX(PRIORIDADETELEFONE), 0) + 1");
        
        ResultSet result = select.executeQuery();
        result.next();
        return result.getInt(1);        
    }
    
    public int desativarTelefones(int idAtor) throws Exception{
        UpdateQuery update = new UpdateQuery (this.conn, this.tabelaBanco);
        update.addValue("TELEFONEATIVO", "F");
        update.addWhere("IDATOR", String.valueOf(idAtor));
        return update.executeUpdate();
    }
    
}

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
import model.Responsavel;

/**
 *
 * @author Lab04
 */
public class ResponsavelDAO extends DAO<Responsavel>{

    public ResponsavelDAO() throws Exception{
        this.tabelaBanco = "RESPONSAVEL";
    }
    
    @Override
    public boolean inserir(Responsavel e) throws Exception {
        InsertQuery insert = new InsertQuery(this.conn, this.tabelaBanco);
        insert.addValue("IDATOR", String.valueOf(e.getIdAtor()));
        insert.addValue("RESPONSAVELPRIORIDADE", String.valueOf(e.getPrioridade()));
        insert.addValue("RESPONSAVELATIVO", String.valueOf(e.getAtivo()));
        insert.addValue("ATORRESPONSAVEL", String.valueOf(e.getResponsavel().getIdAtor()));
        
        return insert.execute();
    }

    @Override
    public boolean alterar(Responsavel e) throws Exception {
        UpdateQuery update = new UpdateQuery(this.conn, this.tabelaBanco);
        update.addValue("RESPONSAVELATIVO", String.valueOf(e.getAtivo()));
        update.addValue("ATORRESPONSAVEL", String.valueOf(e.getResponsavel().getIdAtor()));
        update.addWhere("IDATOR", String.valueOf(e.getIdAtor()));
        update.addWhere("RESPONSAVELPRIORIDADE", String.valueOf(e.getPrioridade()));
        return update.execute();
    }
    
    public int buscaUltimaPrioridade() throws Exception{
        SelectQuery select = new SelectQuery(this.conn, this.tabelaBanco);
        select.addCampo("COALESCE(MAX(RESPONSAVELPRIORIDADE), 0) + 1");
        
        ResultSet result = select.executeQuery();
        result.next();
        return result.getInt(1);        
    }
    
    public int desativarResp(int idAtor) throws Exception{
        UpdateQuery update = new UpdateQuery (this.conn, this.tabelaBanco);
        update.addValue("RESPONSAVELATIVO", "F");
        update.addWhere("IDATOR", String.valueOf(idAtor));
        return update.executeUpdate();
    }

    @Override
    public boolean excluir(Responsavel e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Responsavel> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

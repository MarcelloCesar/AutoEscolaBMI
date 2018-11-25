/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.query.InsertQuery;
import db.query.SelectQuery;
import db.query.UpdateQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import model.Aluno;

public class AlunoDAO extends DAO<Aluno> {    
    
    public AlunoDAO() throws Exception{
        super();
        this.tabelaBanco = "MATRICULA";
    }
    
    @Override    
    public List<Aluno> listar(){return new LinkedList<>();}
    
    @Override
    public boolean inserir(Aluno aluno) throws Exception{
        InsertQuery insert = new InsertQuery(this.conn, this.tabelaBanco);
        insert.addValue("IDATOR", String.valueOf(aluno.getIdAtor()));
        insert.addValue("CODIGOMATRICULA", aluno.getCodMatricula());
        insert.addValue("CODCATEROGIA", aluno.getCodCategoria());
        insert.addValue("DATAMATRICULA", String.valueOf(new Date().getTime()));
        
        return insert.execute();
    }
    
    @Override
    public boolean alterar(Aluno aluno) throws Exception{
        UpdateQuery update = new UpdateQuery(this.conn, this.tabelaBanco);
        update.addValue("IDATOR", String.valueOf(aluno.getAtor().getIdAtor()));
        update.addValue("CODCATEGORIA", aluno.getCodCategoria());
        update.addWhere("CODMATRICULA", aluno.getCodMatricula());
        
        return update.execute();
    }
    
    @Override
    public boolean excluir(Aluno aluno) throws Exception{
        return false;
    }
    
    public int buscaUltimaMatricula() throws Exception{
        SelectQuery select = new SelectQuery(this.conn, this.tabelaBanco);
        select.addCampo("COALESCE(MAX(CODIGOMATRICULA), 0) + 1");
        
        ResultSet result = select.executeQuery();
        result.next();
        return result.getInt(1);        
    }
}
